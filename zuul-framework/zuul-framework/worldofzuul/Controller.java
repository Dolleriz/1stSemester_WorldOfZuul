package worldofzuul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public Button btnBeginTargeting;

    @FXML
    public void buttonClicked(ActionEvent event)throws IOException
    {

        Stage appStage;
        Parent root;
        if(event.getSource()==btnBeginTargeting)
        {
            appStage=(Stage)btnBeginTargeting.getScene().getWindow();
            root= FXMLLoader.load(getClass().getResource("changescenetest.fxml"));
            Scene scene=new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        }

    }

}
