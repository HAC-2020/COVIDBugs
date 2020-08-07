package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LocationUI {


    @FXML
    private ImageView X_Image;

    @FXML
    void exitButton(ActionEvent event) {
            System.exit(0);
    }
}
