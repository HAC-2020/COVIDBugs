package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyerSellerUI {

    double xOffset, yOffset;

    @FXML
    void goTo_Homescreen(ActionEvent event) throws IOException {
        Parent buyersellerRoot = FXMLLoader.load(getClass().getResource("HomepageUI.fxml"));
        Scene buyerSellerScene = new Scene(buyersellerRoot);

        buyersellerRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        //This line gets stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        buyersellerRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.setX(mouseEvent.getScreenX() - xOffset);
                window.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        window.setScene(buyerSellerScene);
        window.show();
        Platform.runLater(() -> buyersellerRoot.requestFocus());
    }

    @FXML
    void goTo_Seller(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }


}
