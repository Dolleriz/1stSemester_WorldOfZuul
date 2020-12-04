package worldofzuul;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.util.Scanner;

public class Game_GUI {

    Room currentRoom;
    TrashCanRoom garbageArea;
    RegularRoom outside, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
    PlayerScore playerScore = new PlayerScore(0);
    Inventory playerInventory = new Inventory(5);

    public Game_GUI() {
        createRooms();
        showPlayerInventory();
    }

    void createRooms() {
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
    public void showPlayerInventory() {
        new TableView<>
                (FXCollections.observableArrayList(playerInventory.inventory));
    }


    void pickup(ImageView a, int inventoryIndex) {

            playerInventory.inventory.add(currentRoom.roomInventory.inventory.get(inventoryIndex));
            //System.out.println(currentRoom.roomInventory.inventory.get(inventoryIndex));
            currentRoom.roomInventory.inventory.remove(inventoryIndex);
            a.setImage(null);
        }


    void throwout(Command command) {

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
                } else if (trash.equalsIgnoreCase("papir-og-pap")) {
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.PAPER) {
                            playerScore.increasePlayerScore(1);
                            playerInventory.inventory.remove(i);
                        }

                    }
                } else if (trash.equalsIgnoreCase("restaffald")) {
                    for (int i = 0; i < playerInventory.inventory.size(); i++) {
                        if (playerInventory.inventory.get(i).getType() == Trashtype.RESIDUAL_WASTE) {
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


    void trashDescription(Command command) {

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


    void printPlayerInventory(Inventory playerInventory) {
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
