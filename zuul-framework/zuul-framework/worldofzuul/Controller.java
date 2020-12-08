package worldofzuul;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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

    public ImageView plastic, metal, paper, food, residual;

    public ImageView zero, one, two, three, four, five, six, seven, eight, nine;
    public ImageView[] roomInventoryArray = new ImageView[10];

    public ImageView PI1, PI2, PI3, PI4, PI5;
    public ImageView[] playerInventoryArray = new ImageView[5];
    @FXML
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
        }

        if (event.getSource() == kitchen) {
            appStage = (Stage) kitchen.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == bathroom) {
            appStage = (Stage) bathroom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("bathroom.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == parentsRoom) {
            appStage = (Stage) parentsRoom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("parents_bedroom.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == garbageArea) {
            appStage = (Stage) garbageArea.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("garbageArea.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == outside) {
            appStage = (Stage) outside.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("outside.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == entrance) {
            appStage = (Stage) entrance.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("entrance.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == yourRoom) {
            appStage = (Stage) yourRoom.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("your_room.fxml"));
            Scene scene = root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

        if (event.getSource() == help) {
            Alert help = new Alert(Alert.AlertType.INFORMATION);
            help.setTitle("Hjælp");
            help.setHeaderText(null);
            help.setContentText("Hjælp bruh.");
            help.showAndWait();
        }
        showPlayerInventory();
    }

    @FXML
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

        for (int i = 0; i < myGame.currentRoom.roomInventoryGUI.length; i++) {
            if (myGame.currentRoom.roomInventoryGUI[i] != null) {
                roomInventoryArray[i].setImage(myGame.currentRoom.roomInventoryGUI[i].getSprite().getImage());
            }
        }
        scan.setDisable(true);
        showPlayerInventory();
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
    public void throwout (Event event){
        if (event.getTarget() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("En verden af Skrald");
            alert.setHeaderText(null);
            alert.setContentText("Denne plads er tom, vælg en anden plads.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < myGame.playerInventory.inventory.size(); i++) {
                if (event.getTarget().equals(playerInventoryArray[i])) {
                    myGame.playerInventory.inventory.remove(myGame.playerInventory.inventory.get(i));
                    playerInventoryArray[i].setImage(null);
                }
            }
        }

        /*for (int i = 0; i < myGame.playerInventory.inventory.size(); i++) {
            if (event.getTarget().equals(plastic) || event.getSource().equals(Trashtype.PLASTIC)) {
                myGame.playerInventory.inventory.remove(myGame.playerInventory.inventory.get(i));
                myGame.playerScore.increasePlayerScore(1);
            } */

        showPlayerInventory();
        myGame.playerScore.increasePlayerScore(1);
        updatePlayerScore();
    }

    @FXML
    public void updatePlayerScore() {
        playerScoreLabel.setText("Score: " + myGame.playerScore.getPlayerScore());
    }
}

