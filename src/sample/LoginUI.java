package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.HomepageUI;
import java.io.IOException;

public class LoginUI {

    double xOffset, yOffset;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label invalidForm;


    @FXML
    private ImageView X_Image;

    @FXML
    void exitButton(ActionEvent event) {
            System.exit(0);

    }

    @FXML
    void goToMainScreen(ActionEvent event) throws IOException {
        if(!(email.getText().equals("admin")
                && password.getText().equals("admin"))) {
            invalidForm.setText("Please check your details and try again.");
            return;
        }

        Parent loginRoot = FXMLLoader.load(getClass().getResource("BuyerSellerUI.fxml"));
        Scene homepageScene = new Scene(loginRoot);

        loginRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        //This line gets stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        loginRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.setX(mouseEvent.getScreenX() - xOffset);
                window.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        window.setScene(homepageScene);
        window.show();
        Platform.runLater(() -> loginRoot.requestFocus());
    }
}
