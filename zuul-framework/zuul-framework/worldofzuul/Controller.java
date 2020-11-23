package worldofzuul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private void changeField(ActionEvent event) {
        event.consume();
        System.out.println("helloooo");
    }
}
