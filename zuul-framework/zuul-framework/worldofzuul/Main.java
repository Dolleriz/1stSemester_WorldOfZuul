package worldofzuul;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    

    @Override
    public void start(Stage stage) throws Exception {

        //these lines make the game (GUI version) work, pls no change kthxbye
        FXMLLoader loader= new FXMLLoader(getClass().getResource("outside.fxml"));
        Stage root = loader.load();
        root.show();
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
