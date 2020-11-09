package worldofzuul;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private TrashCanRoom garbageArea;
    private RegularRoom outside, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
    private PlayerScore playerScore = new PlayerScore(0);

    PlayerInventory playerInventory = new PlayerInventory(5);

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        outside = new RegularRoom("udenfor. " +
                "\nMod øst er dit hus, prop fyldt med affald der skal sorteres. " +
                "\nMod nord er skraldespandene");

        garbageArea = new TrashCanRoom("ved skraldespandene, Foran dig er der et sæt skraldespande." +
                "\nHver skraldespand har et nummer:" +
                "\n1. Plastik.\n2. Metal.\n3. Madaffald.\n4. Pap og papir.\n5. Restaffald." +
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

            if (currentRoom == garbageArea) {
                garbageArea.showTrashcans();
            } else if (currentRoom == outside) {

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

        String trashtype = command.getSecondWord();

        if (currentRoom == garbageArea) {
            System.out.println("Der er ikke noget skrald i rummet");
            return;
        }
        if (!currentRoom.roomInventory.isInventoryFull()) {
            System.out.println("Der er ikke mere skrald i rummet");
            return;
        }
        if (currentRoom != garbageArea) {
            if (playerInventory.isInventoryFull()) {
                System.out.println("Der kan ikke være mere i tasken");
            } else {
                currentRoom.roomInventory.removeTrashFromInventory();
                String trashTypeString = command.getSecondWord();
            }
        }
    }

    private void throwout(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Smid hvad ud?");
            return;
        }

        for (int i = 0; i < playerInventory.inventory.length; i++) {

            if (currentRoom != garbageArea) {
                System.out.println("Du er ikke ved skraldespandene");
                break;
            } else if (!playerInventory.isInventoryFull()) {
                System.out.println("Du har ikke noget i denne lomme!");
            } else if (currentRoom == garbageArea || playerInventory.isInventoryFull()) {
                playerInventory.removeTrashFromInventory();
                System.out.println("Du har nu smidt dit skrald ud!");
                playerScore.increasePlayerScore(1);
                playerScore.showPlayerScore();
            }
        }
    }

    private void trashDescription(Command command) {
        if(!command.hasSecondWord()){
            System.out.println("Nævn også den skraldespand du vil have en uddybelse på!");

        }
        if (currentRoom != garbageArea) {
            System.out.println("Du er ikke ved skraldespandede");

        } else if (currentRoom == garbageArea) {
            if(command.hasSecondWord == Trashtype.PLASTIC){

            }
        }
    }

    private void printPlayerInventory(PlayerInventory playerInventory) {
        System.out.println("Du kan max have 5 stykker affald i dine lommer. " +
                "\nI dine lommer har du: " +
                "\n");

        for (int i = 0; i < playerInventory.inventory.length; i++) {
            if (playerInventory.inventory[i] == null) {
                System.out.println("Der er ikke noget i denne lomme!");

            } else {
                System.out.println(playerInventory.inventory[i].getType().toString());
            }
        }
    }
}
