package worldofzuul;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public Button btnBeginTargeting;

    @FXML
    public void buttonClicked(ActionEvent event)throws IOException
    {

        Stage appStage;
        Stage root;
        //Following code allows for a scene change on a fxid button press.
        //Use the if statement as some sort of template, but do not change the original for the sake of preservation.
        //I have some sort of an idea how it all work, so hit me up if you have any questions - Johan B.
        if(event.getSource()==btnBeginTargeting)
        {
            appStage=(Stage)btnBeginTargeting.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("changescenetest.fxml"));
            Scene scene= root.getScene(); //  new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

    }

}
