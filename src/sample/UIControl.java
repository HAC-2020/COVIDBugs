package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UIControl {

    @FXML
    private Button locationBtn;

    @FXML
    void locationButton(ActionEvent event) {

    }

    public void changeToLocationScene(ActionEvent event) throws IOException {
        Parent locationParent = FXMLLoader.load(getClass().getResource("locationUI.fxml"));
        Scene locationScene = new Scene(locationParent);

        //This line gets stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(locationScene);
        window.show();
    }
}