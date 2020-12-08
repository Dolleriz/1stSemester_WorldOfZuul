package worldofzuul;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;

public class Controller {
    Game_GUI myGame = new Game_GUI();

    @FXML
    public Button livingRoom, garbageArea, bathroom, entrance,
            kitchen, yourRoom, outside, parentsRoom;
    public Button help;
    public Sprites sprites;

    public ImageView zero, one, two, three, four, five, six, seven, eight, nine;
    public Button scan;
    public ImageView PI1, PI2, PI3, PI4, PI5;
    public ImageView[] playerInventoryArray = {PI1, PI2, PI3, PI4, PI5};

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
    }

    @FXML
    public void showPlayerInventory() {
        playerInventoryArray[0] = PI1;
        playerInventoryArray[1] = PI2;
        playerInventoryArray[2] = PI3;
        playerInventoryArray[3] = PI4;
        playerInventoryArray[4] = PI5;
        for (int i = 0; i < myGame.playerInventory.inventory.size(); i++) {
            playerInventoryArray[i].setImage(myGame.playerInventory.inventory.get(i).getSprite().getImage());
        }
    }

    public void drawTrash(ImageView a, int inventoryIndex) {
        a.setImage(myGame.currentRoom.roomInventoryGUI[inventoryIndex].getSprite().getImage());
        scan.setDisable(true);
    }

    @FXML
    public void scanRoom(Event event) throws IOException {
        drawTrash(zero, 0);
        drawTrash(one, 1);
        drawTrash(two, 2);
        drawTrash(three, 3);
        drawTrash(four, 4);
        drawTrash(five, 5);
        drawTrash(six, 6);
        drawTrash(seven, 7);
        drawTrash(eight, 8);
        drawTrash(nine, 9);
    }

    @FXML
    public void pickUp(Event event) {
        if (myGame.playerInventory.inventory.size() == 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("En verden af Skrald");
            alert.setHeaderText(null);
            alert.setContentText("Din taske er fuld. Du må tømme tasken før du kan samle mere skrald op.");
            alert.showAndWait();
        } else {

            if (event.getTarget().equals(zero)) {
                myGame.pickup(zero, 0);
            }
            if (event.getTarget().equals(one)) {
                myGame.pickup(one, 1);
            }
            if (event.getTarget().equals(two)) {
                myGame.pickup(two, 2);
            }
            if (event.getTarget().equals(three)) {
                myGame.pickup(three, 3);
            }
            if (event.getTarget().equals(four)) {
                myGame.pickup(four, 4);
            }
            if (event.getTarget().equals(five)) {
                myGame.pickup(five, 5);
            }
            if (event.getTarget().equals(six)) {
                myGame.pickup(six, 6);
            }
            if (event.getTarget().equals(seven)) {
                myGame.pickup(seven, 7);
            }
            if (event.getTarget().equals(eight)) {
                myGame.pickup(eight, 8);
            }
            if (event.getTarget().equals(nine)) {
                myGame.pickup(nine, 9);
            }
        }
        showPlayerInventory();
    }
}

