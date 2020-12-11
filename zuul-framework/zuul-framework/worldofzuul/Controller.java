package worldofzuul;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;


//This code is want runs in our JavaFX/GUI version. Makes everthing clickable and stuff #Cheers.
public class Controller {
    Game_GUI myGame;

    public Controller() {
        myGame = Game_GUI.INSTANCE;
    }

    @FXML
    public Button livingRoom, garbageArea, bathroom, entrance,
            kitchen, yourRoom, outside, parentsRoom;
    public Button help, helpGarbage;
    public Button scan;
    public Button playerInventory;
    public Button copyright;

    public ImageView plastic, metal, paper, food, residual;
    public ImageView[] trashCanArray = new ImageView[5];

    public ImageView zero, one, two, three, four, five, six, seven, eight, nine;
    public ImageView[] roomInventoryArray = new ImageView[10];

    public ImageView PI1, PI2, PI3, PI4, PI5;
    public ImageView[] playerInventoryArray = new ImageView[5];

    public Label playerScoreLabel;

    @FXML
    //Handles what happens when you click the different buttons on the GUI. eg. changing rooms, help button etc.
    public void buttonClicked(ActionEvent event) throws IOException {

        Stage appStage;
        Stage root;

        //The following code allows for a scene change on a fxid button press.
        //Use the if statement as some sort of template, but do not change the original for the sake of preservation.
        //I have some sort of an idea how it all work, so hit me up if you have any questions - Johan B.
        if (event.getSource() == livingRoom) {
            appStage = (Stage) livingRoom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("livingRoom.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.livingRoom;
        }

        if (event.getSource() == kitchen) {
            appStage = (Stage) kitchen.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.kitchen;
        }

        if (event.getSource() == bathroom) {
            appStage = (Stage) bathroom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("bathroom.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.bathRoom;
        }

        if (event.getSource() == parentsRoom) {
            appStage = (Stage) parentsRoom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("parents_bedroom.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.parentsRoom;
        }

        if (event.getSource() == garbageArea) {
            appStage = (Stage) garbageArea.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("garbageArea.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.garbageArea;
        }

        if (event.getSource() == outside) {
            appStage = (Stage) outside.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("outside.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.outside;
        }

        if (event.getSource() == entrance) {
            appStage = (Stage) entrance.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("entrance.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.entrance;
        }

        if (event.getSource() == yourRoom) {
            appStage = (Stage) yourRoom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("your_room.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
            myGame.currentRoom = myGame.bedRoom;
        }

        if (event.getSource() == help) {
            Alert help = new Alert(Alert.AlertType.INFORMATION);
            help.setTitle("Hjælp");
            help.setHeaderText(null);
            help.setContentText("I dette spil skal du rundt i huset og samle skrald og derefter genbruge det korrekt!\n" +
                    "\nKlik på skan for at lede efter skrald i rummet og derefter klik på det skrald du vil samle op!\n" +
                    "\nNår din taske er fuld, skal du derefter gå til skraldespandene. Du bevæger dig med knapperne nederst i venstre hjørne.\n" +
                    "\nTryk på krydset når du er færdig med at spille!");
            // help.setResizable(true);
            help.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            help.showAndWait();
        }
        if (event.getSource() == helpGarbage) {
            Alert help = new Alert(Alert.AlertType.INFORMATION);
            help.setTitle("Hjælp");
            help.setHeaderText(null);
            help.setContentText("Tryk på Vis Taske for at se det affald du har samlet op.\n" +
                    "\nTryk med musen på det øverste affald i din taske, og  slip musen over \n" +
                    "den skraldespand du gerne vil smide affaldet ud i.\n");
            help.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            help.showAndWait();
        }

        if (event.getSource() == copyright) {
            Alert copyright = new Alert(Alert.AlertType.INFORMATION);
            copyright.setTitle("Om");
            copyright.setHeaderText(null);
            copyright.setContentText("'World of Zuul' Remixed og brugt under 1. år semesterprojekt for SE/ST 2020." +
                    "\nLavet af: Mikkel Dolleris, Mikkel Norman, Johan Brockstedt, Sandra Malling-Larsen og Thomas Christensen." +
                    "\n" +
                    "\n" +
                    "\n'Nerdy Guy' Lavet af Silveira Neto, brugt under CC BY-SA 2.5 licens." +
                    "\n" +
                    "\n'[16x16] Small Indoor Tileset' Lavet af Tilation, https://tilation.itch.io/" +
                    "\n" +
                    "\n'Grass Tile Set 16x16' Lavet af Bonsaiheldin,, brugt under CC BY-SA 3.0 licens; https://opengameart.org/content/grass-tileset-16x16" +
                    "\n" +
                    "\n'Recycle Bin Green Can Open Lid' lavet af Clker-Free-Vector-Images, brugt og remixed under Pixabay licens." +
                    "\n" +
                    "\n'Soda Pop Can' Lavet af Clker-Free-Vector-Images, brugt under Pixabay licens." +
                    "\n" +
                    "\n'Bitten Apple Healthy Eat' Lavet af janjf903, brugt under Pixabay licens." +
                    "\n" +
                    "\n'Bottledwater Water Bottle' Lavet af StarShopping, brugt under Pixabay licens." +
                    "\n" +
                    "\n'Bag Trash Waste' Lavet af kinska, brugt under Pixabay licens.");
            copyright.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            copyright.showAndWait();
        }

    }

    @FXML
    //Uses our showinventory button to assign it to the button since we wanted an alert on the button but
    // not with the specific code
    public void showPlayerInventoryButton() {
        showPlayerInventory();
        if (myGame.playerInventory.inventory.isEmpty()) {
            Alert emptyInv = new Alert(Alert.AlertType.ERROR);
            emptyInv.setTitle("Taske");
            emptyInv.setHeaderText(null);
            emptyInv.setContentText("Din taske er tom!");
            emptyInv.showAndWait();
        }
    }

    @FXML
    //Code behind our showInventory. It shows our inventory by using our playerInventoryArray which uses ImageViews
    //We had to assign a sprite Image to the actual playerInventory to show the image in said imageViews.
    public void showPlayerInventory() {
        playerInventoryArray[0] = PI1;
        playerInventoryArray[1] = PI2;
        playerInventoryArray[2] = PI3;
        playerInventoryArray[3] = PI4;
        playerInventoryArray[4] = PI5;

        for (int i = 0; i < playerInventoryArray.length; i++) {
            playerInventoryArray[i].setImage(null);
        }
        for (int i = 0; i < myGame.playerInventory.inventory.size(); i++) {
            playerInventoryArray[i].setImage(myGame.playerInventory.inventory.get(i).getSprite().getImage());
        }

    }

    @FXML
    //We made a scanRoom button because we change scenes and stages with every button click
    //We made the decision the make the button instead of looking for a new JavaFX fix due to time restraints
    //We made a fix roomInventory of 10 indexes. This made us able to use if/else statements to show sprites depending
    //On which room we are in.
    public void scanRoom(Event event) throws IOException, NullPointerException {
        roomInventoryArray[0] = zero;
        roomInventoryArray[1] = one;
        roomInventoryArray[2] = two;
        roomInventoryArray[3] = three;
        roomInventoryArray[4] = four;
        roomInventoryArray[5] = five;
        roomInventoryArray[6] = six;
        roomInventoryArray[7] = seven;
        roomInventoryArray[8] = eight;
        roomInventoryArray[9] = nine;

        if (myGame.currentRoom == myGame.outside) {
            for (int i = 0; i < myGame.outside.roomInventoryGUI.length; i++) {
                if (myGame.outside.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.outside.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.bathRoom) {
            for (int i = 0; i < myGame.bathRoom.roomInventoryGUI.length; i++) {
                if (myGame.bathRoom.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.bathRoom.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.bedRoom) {
            for (int i = 0; i < myGame.bedRoom.roomInventoryGUI.length; i++) {
                if (myGame.bedRoom.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.bedRoom.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.livingRoom) {
            for (int i = 0; i < myGame.livingRoom.roomInventoryGUI.length; i++) {
                if (myGame.livingRoom.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.livingRoom.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.parentsRoom) {
            for (int i = 0; i < myGame.parentsRoom.roomInventoryGUI.length; i++) {
                if (myGame.parentsRoom.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.parentsRoom.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.entrance) {
            for (int i = 0; i < myGame.entrance.roomInventoryGUI.length; i++) {
                if (myGame.entrance.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.entrance.roomInventoryGUI[i].getSprite().getImage());
                }
            }
        } else if (myGame.currentRoom == myGame.kitchen) {
            for (int i = 0; i < myGame.kitchen.roomInventoryGUI.length; i++) {
                if (myGame.kitchen.roomInventoryGUI[i] != null) {
                    roomInventoryArray[i].setImage(myGame.kitchen
                            .roomInventoryGUI[i].getSprite().getImage());
                }
            }
        }

        scan.setDisable(true);
    }

    @FXML
    //Essentially compares the target which we click upon to our roomInventory index and adds it to our playerInventory
    //And also removed is and the sprite from our roomInventory and disables said imageView.
    public void pickUp(Event event) {
        if (myGame.playerInventory.inventory.size() >= 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("En verden af Skrald");
            alert.setHeaderText(null);
            alert.setContentText("Din taske er fuld. Du må tømme tasken før du kan samle mere skrald op.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < myGame.currentRoom.roomInventoryGUI.length; i++) {
                if (event.getTarget().equals(roomInventoryArray[i])) {
                    myGame.playerInventory.inventory.add(myGame.currentRoom.roomInventoryGUI[i]);
                    myGame.currentRoom.roomInventoryGUI[i] = null;
                    roomInventoryArray[i].setImage(null);
                    roomInventoryArray[i].setDisable(true);
                }
            }
            showPlayerInventory();
        }
        updatePlayerScore();
    }

    @FXML
    //The sorting system in our Garbage Area.
    //We drag events to compare 2 strings. The type of the trash in our playerInventory and the string of a trashcan
    //If these correlate then we give 1 point and also updates the playerInventory and playerScore
    //If they don't correlate then -1 point.
    //Most of the code is dragDetection and allowing the data to be transfered/accepted.
    public void throwout(Event eventt) {
        PI1.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = PI1.startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putImage(PI1.getImage());
            db.setContent(content);
        });

        int trashcanIndex = findTarget(eventt);
        trashCanArray[trashcanIndex].setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != trashCanArray[trashcanIndex] && event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        trashCanArray[trashcanIndex].setOnDragDropped((DragEvent event) -> {
            if (trashCanArray[trashcanIndex].getId().equalsIgnoreCase(myGame.playerInventory.inventory.get(0).getType().toString())) {
                myGame.playerInventory.inventory.remove(0);
                myGame.playerScore.increasePlayerScore(1);

            } else {
                myGame.playerInventory.inventory.remove(0);
                myGame.playerScore.decreasePlayerScore(1);

            }
            event.setDropCompleted(true);
            updatePlayerScore();
            showPlayerInventory();
            if (finishedGame()) {
                Alert emptyInv = new Alert(Alert.AlertType.INFORMATION);
                emptyInv.setTitle("endGame");
                emptyInv.setHeaderText(null);
                emptyInv.setContentText("Du har nu gennemføret spillet!" +
                        "\n Du sluttede med " + myGame.playerScore.getPlayerScore() + " point!");
                emptyInv.showAndWait();
            }
            event.consume();
        });

    }

    @FXML
    //Updates our playerScore
    public void updatePlayerScore() {
        playerScoreLabel.setText("Score: " + myGame.playerScore.getPlayerScore());
    }

    //Finds the target of our drag Event. Essentially uses an array of our trashcans
    //Uses fori loop to return the correct trashCan
    //Makes us able to compare our trashType to our trashCan.
    public int findTarget(Event event) {
        int trashcanIndex = 0;
        trashCanArray[0] = paper;
        trashCanArray[1] = metal;
        trashCanArray[2] = residual;
        trashCanArray[3] = plastic;
        trashCanArray[4] = food;
        for (int i = 0; i < trashCanArray.length; i++) {
            if (event.getTarget().equals(trashCanArray[i])) {
                trashcanIndex = i;
            }
        }
        return trashcanIndex;
    }


    public boolean emptyRoom(Trash[] roomInventory) {
        boolean empty = true;
        for (int i = 0; i < roomInventory.length; i++) {
            if (roomInventory[i] != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }


    @FXML
    public boolean finishedGame() {
        if (emptyRoom(myGame.bathRoom.roomInventoryGUI) &&
                emptyRoom(myGame.bedRoom.roomInventoryGUI) &&
                emptyRoom(myGame.entrance.roomInventoryGUI) &&
                emptyRoom(myGame.kitchen.roomInventoryGUI) &&
                emptyRoom(myGame.livingRoom.roomInventoryGUI) &&
                emptyRoom(myGame.outside.roomInventoryGUI) &&
                emptyRoom(myGame.parentsRoom.roomInventoryGUI) &&
                myGame.playerInventory.inventory.isEmpty()) {
            return true;
        }
        return false;
    }
}



