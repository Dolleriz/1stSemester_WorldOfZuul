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
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    Game_GUI myGame;

    public Controller() {
        myGame = Game_GUI.INSTANCE;
    }

    @FXML
    public Button livingRoom, garbageArea, bathroom, entrance,
            kitchen, yourRoom, outside, parentsRoom;
    public Button help;
    public Button scan;
    public Button playerInventory;

    public ImageView plastic, metal, paper, food, residual;
    public ImageView[] trashCanArray = new ImageView[5];

    public ImageView zero, one, two, three, four, five, six, seven, eight, nine;
    public ImageView[] roomInventoryArray = new ImageView[10];

    public ImageView PI1, PI2, PI3, PI4, PI5;
    public ImageView[] playerInventoryArray = new ImageView[5];

    public Label playerScoreLabel;

    @FXML
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
                    "\nHerefter holder du din museknap ned på det affald du vil sorter og og trækker det over i den skraldespand du mener er rigtig.\n" +
                    "\nTryk på krydset når du er færdig med at spille!");
            help.showAndWait();
        }

    }

    @FXML
    public void showPlayerInventory() {
        playerInventoryArray[0] = PI1;
        playerInventoryArray[1] = PI2;
        playerInventoryArray[2] = PI3;
        playerInventoryArray[3] = PI4;
        playerInventoryArray[4] = PI5;

        if (myGame.playerInventory.inventory.isEmpty()) {
            Alert emptyInv = new Alert(Alert.AlertType.ERROR);
            emptyInv.setTitle("Taske");
            emptyInv.setHeaderText(null);
            emptyInv.setContentText("Din taske er tom!");
            emptyInv.showAndWait();
        }

        for (int i = 0; i < playerInventoryArray.length; i++) {
            playerInventoryArray[i].setImage(null);
        }
        for (int i = 0; i < myGame.playerInventory.inventory.size(); i++) {
            playerInventoryArray[i].setImage(myGame.playerInventory.inventory.get(i).getSprite().getImage());
        }

    }

    @FXML
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
        //showPlayerInventory();
    }

    @FXML
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
    public void throwout(Event eventt) {

        final int inventoryIndex = findSource(eventt);
        int trashcanIndex = findTarget(eventt);
        System.out.println(inventoryIndex);
        playerInventoryArray[inventoryIndex].setOnDragDetected((MouseEvent event) -> {
            System.out.println("Drag detected");

            Dragboard db = playerInventoryArray[inventoryIndex].startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putImage(playerInventoryArray[inventoryIndex].getImage());
            db.setContent(content);
        });

        trashCanArray[trashcanIndex].setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != trashCanArray[trashcanIndex] && event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        trashCanArray[trashcanIndex].setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage()) {
                if (trashCanArray[trashcanIndex].getId().equalsIgnoreCase(myGame.playerInventory.inventory.get(inventoryIndex).getType().toString())) {
                    myGame.playerInventory.inventory.remove(inventoryIndex);
                    myGame.playerScore.increasePlayerScore(1);
                    System.out.println("yolo");
                } else {
                    myGame.playerInventory.inventory.remove(inventoryIndex);
                    myGame.playerScore.decreasePlayerScore(1);
                    System.out.println("nej");
                }
            }
            event.setDropCompleted(true);
            updatePlayerScore();
            showPlayerInventory();
            event.consume();
        });

    }

    @FXML
    public void updatePlayerScore() {
        playerScoreLabel.setText("Score: " + myGame.playerScore.getPlayerScore());
    }

    public int findSource(Event event) {
        int inventoryIndex = 0;
        playerInventoryArray[0] = PI1;
        playerInventoryArray[1] = PI2;
        playerInventoryArray[2] = PI3;
        playerInventoryArray[3] = PI4;
        playerInventoryArray[4] = PI5;
        for (int i = 0; i < playerInventoryArray.length; i++) {
            if (event.getTarget().equals(playerInventoryArray[i])) {
                inventoryIndex = i;
            }
        }
        return inventoryIndex;
    }

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
}



