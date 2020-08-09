package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageUI {

    double xOffset, yOffset;

    @FXML
    public TextField search_Text;

    @FXML
    private Pane paneStore_One;

    @FXML
    private Label firstShopName;

    @FXML
    private Label secondShopName;

    @FXML
    private Label firstShop_Distance;

    @FXML
    private Label secondShop_Distance;

    @FXML
    void goTo_AddStore(ActionEvent event) throws IOException {
        Parent homepageRoot = FXMLLoader.load(getClass().getResource("AddStoreUI.fxml"));
        Scene homepageScene = new Scene(homepageRoot);

        homepageRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        homepageRoot.setOnMouseDragged(mouseEvent -> {
            window.setX(mouseEvent.getScreenX() - xOffset);
            window.setY(mouseEvent.getScreenY() - yOffset);
        });

        window.setScene(homepageScene);
        window.show();
        Platform.runLater(() -> homepageRoot.requestFocus());
    }

    @FXML
    void goTo_Settings(ActionEvent event) throws IOException {
        Parent homepageRoot = FXMLLoader.load(getClass().getResource("SettingsUI.fxml"));
        Scene homepageScene = new Scene(homepageRoot);

        homepageRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        homepageRoot.setOnMouseDragged(mouseEvent -> {
            window.setX(mouseEvent.getScreenX() - xOffset);
            window.setY(mouseEvent.getScreenY() - yOffset);
        });

        window.setScene(homepageScene);
        window.show();
        Platform.runLater(() -> homepageRoot.requestFocus());
    }

    @FXML
    void changeShopName(MouseEvent event) {
        firstShopName.setText("New Shop1");
    }

    @FXML
    void searchingShop(InputMethodEvent event) {
        System.out.println(firstShopName);
        if(! search_Text.getText().equals(firstShopName)){
                paneStore_One.setVisible(false);
        }
    }

    @FXML
    void goTo_FirstShop(MouseEvent event) throws IOException {
        System.out.println("DAD");
        Parent homepageRoot = FXMLLoader.load(getClass().getResource("firstShopUI.fxml"));
        Scene homepageScene = new Scene(homepageRoot);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepageScene);
        window.show();
        Platform.runLater(() -> homepageRoot.requestFocus());
    }

    @FXML
    void goTo_Profile(ActionEvent event) {

    }

    @FXML
    void goTo_Saved(ActionEvent event) {

    }

    @FXML
    void goTo_Cart(ActionEvent event) {

    }

    @FXML
    void goTo_Home(ActionEvent event) {

    }



}



