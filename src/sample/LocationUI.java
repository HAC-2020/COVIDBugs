package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LocationUI {


    @FXML
    private ImageView X_Image;

    @FXML
    void exitButton(ActionEvent event) {
            System.exit(0);
    }

    @FXML
    void goToMainScreen(ActionEvent event) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("HomepageUI.fxml"));
        Scene homepageScene = new Scene(homepage);

        //This line gets stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepageScene);
        window.show();
    }
}
