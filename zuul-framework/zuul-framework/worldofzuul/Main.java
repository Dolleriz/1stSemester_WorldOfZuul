package worldofzuul;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    

    @Override
    public void start(Stage stage) throws Exception {

        //these lines make the game (GUI version) work, pls no change kthxbye
        FXMLLoader loader= new FXMLLoader(getClass().getResource("outside.fxml"));
        Stage root = loader.load();
        root.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("En verden af Skrald");
        alert.setHeaderText(null);
        alert.setContentText("Velkommen til En Verden af Affald! \nDette er et nyt spændende affaldsindsamlingsspil." +
                "\nTryk på hjælp, hvis du ikke ved hvad du skal!");

        alert.showAndWait();
        //Scene scene = new Scene(root, 750, 750);
        //stage.setTitle("World of Trash");
        //stage.setScene(scene);
        //stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        Game myGame = new Game();

        myGame.play();

    }
}
