package worldofzuul;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.util.Scanner;

public class Game_GUI {
    private Parser parser;
    private Room currentRoom;
    private TrashCanRoom garbageArea;
    private RegularRoom outside, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
    private PlayerScore playerScore = new PlayerScore(0);

    PlayerInventory playerInventory = new PlayerInventory(5);

    public Game_GUI() {
        createRooms();
        showPlayerInventory();
        parser = new Parser();
    }

    private void createRooms() {
        outside = new RegularRoom("udenfor. " +
                "\nMod øst er dit hus, prop fyldt med affald der skal sorteres. " +
                "\nMod nord er skraldespandene");

        garbageArea = new TrashCanRoom("ved skraldespandene, Foran dig er der et sæt skraldespande." +
                "\nHver skraldespand har et nummer:" +
                "\n1. Plastik.\n2. Metal og glas.\n3. Madaffald.\n4. Papir og pap.\n5. Restaffald." +
                "\nDu burde nu have en masse affald i din taske, som skal sorteres. Ellers, kom i gang!");


        entrance = new RegularRoom("i indgangen. Væggene er dekoreret med kedelige malerier og familiefotos. " +
                "\nDu vender mod væggen der har billederne hængende.Udenfor er mod vest og stuen er mod øst");

        livingRoom = new RegularRoom("i stuen. Et stort tæppe dækker gulvet, og i et hjørne ser du et TV og en sofa. " +
                "\nVæggene er dekoreret med familiefotos. " +
                "\nMod nord er køkkenet, mod vest er indgangen og mod øst er dine forældresværelse");

        kitchen = new RegularRoom("i køkkenet." +
                "\nI midten af rummet er et spisebord." +
                "\nEt helt almindelig og uspecial køkken." +
                "\nMod syd er stuen, mod vest er dit værelse og mod øst er badeværelset");

        bedRoom = new RegularRoom("på dit værelse!" +
                "\nProp fyldt med alt det legetøj, som du elsker. Måske er der noget affald i nærheden..." +
                "\nMod øst er køkkenet");

        bathRoom = new RegularRoom("på badeværelset." +
                "\nEgentlig et ret lille badeværelse for en børnefamilie." +
                "\nMod vest er køkkenet og mod syd er dine forældresværelse");

        parentsRoom = new RegularRoom("i dine forældresværelse." +
                "\nStor redt seng, hvor hver side af sengen har et natbord." +
                "\nMod nord er badeværelset og mod vest er stuen");

        outside.setExit("øst", entrance);
        outside.setExit("nord", garbageArea);

        garbageArea.setExit("syd", outside);

        entrance.setExit("vest", outside);
        entrance.setExit("øst", livingRoom);

        livingRoom.setExit("øst", parentsRoom);
        livingRoom.setExit("nord", kitchen);
        livingRoom.setExit("vest", entrance);

        kitchen.setExit("vest", bedRoom);
        kitchen.setExit("øst", bathRoom);
        kitchen.setExit("syd", livingRoom);

        bedRoom.setExit("øst", kitchen);

        bathRoom.setExit("vest", kitchen);
        bathRoom.setExit("syd", parentsRoom);

        parentsRoom.setExit("vest", livingRoom);
        parentsRoom.setExit("nord", bathRoom);

        currentRoom = outside;
    }

    @FXML
    public TableView<Trash> showPlayerInventory(){
        TableView<Trash> playerInventory_GUI = new TableView<>
                (FXCollections.observableArrayList(playerInventory.inventory));
        return playerInventory_GUI;
    }

    public void play() {
        printWelcome();


        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Tak for spillet.  Farvel.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Velkommen til En Verden af Affald!");
        System.out.println("En Verden af Affald! er et nyt spændende affaldsindsamlingsspil.");
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp, eller ikke ved hvad du kan gøre.");
        System.out.println();
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("Jeg forstår ikke hvad du mener...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.PICKUP) {
            pickup(command);
        } else if (commandWord == CommandWord.INVENTORY) {
            printPlayerInventory(playerInventory);
        } else if (commandWord == CommandWord.THROWOUT) {
            throwout(command);
        } else if (commandWord == CommandWord.TRASHDESCRIPTION
        ) {
            trashDescription(command);
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("Du er forvirret. Der er mange steder at gå hen, og mange ting du kan gøre.");
        System.out.println();
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Gå hvorhen?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Der er ikke nogen dør!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());

            // if (currentRoom == garbageArea) { this way we get the trashcan overview listed in garbageArea.longDescription
            //   garbageArea.showTrashcans();
            // } else
            if (currentRoom == outside) {

                System.out.println("I dette rum ligger der: ");
                outside.printRoomInventory();
            } else if (currentRoom == entrance) {

                System.out.println("I dette rum ligger der: ");
                entrance.printRoomInventory();
            } else if (currentRoom == livingRoom) {

                System.out.println("I dette rum ligger der: ");
                livingRoom.printRoomInventory();
            } else if (currentRoom == kitchen) {

                System.out.println("I dette rum ligger der: ");
                kitchen.printRoomInventory();
            } else if (currentRoom == bedRoom) {

                System.out.println("I dette rum ligger der: ");
                bedRoom.printRoomInventory();
            } else if (currentRoom == bathRoom) {

                System.out.println("I dette rum ligger der: ");
                bathRoom.printRoomInventory();
            } else if (currentRoom == parentsRoom) {

                System.out.println("I dette rum ligger der: ");
                parentsRoom.printRoomInventory();
            }
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Afslut hvad?");
            return false;
        } else {
            System.out.println("Du sluttede med " + playerScore.getPlayerScore() + " point!");
            return true;
        }
    }

    private void pickup(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
            return;
        }

        int roomInventoryIndex = Integer.parseInt(command.getSecondWord());

        if (currentRoom == garbageArea) {
            System.out.println("Der er ikke noget skrald i rummet");
            return;
        }
        if (currentRoom.roomInventory.inventory.isEmpty()) {
            System.out.println("Der er ikke mere skrald i rummet");
            return;
        }
        if (playerInventory.inventory.size() == 5) {
            System.out.println("Der kan ikke være mere i tasken");
        } else {
            playerInventory.inventory.add(currentRoom.roomInventory.inventory.get(roomInventoryIndex - 1));
            currentRoom.roomInventory.inventory.remove(roomInventoryIndex - 1);
        }
    }

    private void throwout(Command command) {

        String trash = command.getSecondWord();

        if (!command.hasSecondWord()) {
            System.out.println("Hvad vil du gerne smide ud?");
            return;
        }
        if (currentRoom != garbageArea) {
            System.out.println("Du er ikke ved skraldespandene");
        } else {
            if (!playerInventory.inventory.isEmpty()) {
                if (trash.equalsIgnoreCase("plastik")) {
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.PLASTIC) {
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }
                    }
                } else if (trash.equalsIgnoreCase("metal-og-glas")) {
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.METAL_AND_GLASS) {
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }
                    }
                } else if (trash.equalsIgnoreCase("madaffald")) {
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.FOOD_WASTE) {
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }
                    }
                } else if (trash.equalsIgnoreCase("papir-og-pap")){
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.PAPER){
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }

                    }
                } else if (trash.equalsIgnoreCase("restaffald")){
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.RESIDUAL_WASTE){
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }

                    }
                }
                System.out.println("Du har nu smidt dit skrald ud!");
                printPlayerInventory(playerInventory);
                System.out.println(" ");
            }
        }
        playerScore.showPlayerScore();
    }


    private void trashDescription(Command command) {

        if (currentRoom != garbageArea) {
            System.out.println("Du er ikke ved skraldespandene");
        } else {
            Scanner inputTrash = new Scanner(System.in);
            System.out.println("Hvilken skraldespand vil du gerne vide mere om?");
            String trashcanInput = inputTrash.next();
            if (trashcanInput.equals("plastik")) {
                garbageArea.showPlastic();
            } else if (trashcanInput.equalsIgnoreCase("metal-og-glas")) {
                garbageArea.showMetalAndGlass();
            } else if (trashcanInput.equalsIgnoreCase("madaffald")) {
                garbageArea.showFoodWaste();
            } else if (trashcanInput.equalsIgnoreCase("papir")) {
                garbageArea.showPaper();
            } else if (trashcanInput.equalsIgnoreCase("restaffald")) {
                garbageArea.showResidualWaste();
            }
        }
    }


    private void printPlayerInventory(PlayerInventory playerInventory) {
        System.out.println("Du kan max have 5 stykker affald i dine lommer. " +
                "\nI dine lommer har du: " +
                "\n");

        for (int i = 0; i < playerInventory.inventory.size(); i++) {
            if (playerInventory.inventory.get(i) == null) {
                System.out.println("Der er ikke noget i denne lomme!");

            } else {
                System.out.println(playerInventory.inventory.get(i).getType().toString());
            }
        }
    }
}
