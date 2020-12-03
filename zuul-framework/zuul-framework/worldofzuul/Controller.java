package worldofzuul;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    Game_GUI myGame = new Game_GUI();

    @FXML
    public Button livingRoom, garbageArea, bathroom, entrance,
            kitchen, yourRoom, outside, parentsRoom;
    public Button help;
    public Sprites sprites;
    public Canvas trash;
    public Button scan;


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
    public void viewInventory(Event event) throws IOException {

    }

    @FXML
    public void drawTrash(Event event) throws IOException {
        GraphicsContext gc = trash.getGraphicsContext2D();
        for (int i = 0; i < myGame.currentRoom.roomInventory.inventory.size(); i++) {
            Sprites currentSprite = myGame.currentRoom.roomInventory.inventory.get(i).getSprite();
            double px = 440 * Math.random() + 50;
            double py = 500 * Math.random() + 50;
            currentSprite.setPosition(px, py);
            scan.setDisable(true);
            currentSprite.render(gc);

        }
    }
}
