package worldofzuul;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        //these lines make the game (GUI version) work, it loads the first stage which is our outside room
        //furthermore it introduces the game and it's name.
        FXMLLoader loader= new FXMLLoader(getClass().getResource("outside.fxml"));
        Stage root = loader.load();
        root.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("En verden af Skrald");
        alert.setHeaderText(null);
        alert.setContentText("Velkommen til En Verden af Affald! \nDette er et nyt spændende affaldsindsamlingsspil." +
                "\nTryk på hjælp, hvis du ikke ved hvad du skal!");

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
        //Game myGame = new Game();

        //myGame.play();

    }
}
