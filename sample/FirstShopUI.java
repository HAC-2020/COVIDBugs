package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstShopUI {

    @FXML
    private Label secondShopName;

    @FXML
    private Label label_Add;

    @FXML
    private Pane paneStore_One;

    @FXML
    private Label secondShopName1;

    @FXML
    private Label secondShopName11;

    @FXML
    private ImageView yellowBGAdd;

    @FXML
    private Label secondShop_Distance1;

    @FXML
    private ImageView yellowMiddleBG;

    @FXML
    private ImageView minus;

    @FXML
    private Label numProductsToBuy_firstShop;


    @FXML
    private ImageView yellowBGAdd_secondShop;

    @FXML
    private ImageView yellowMiddleBG_secondShop;

    @FXML
    private ImageView minus_secondShop;

    @FXML
    private Label numProductsToBuy_secondShop;

    @FXML
    private Label label_Add_secondShop;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent shopRoot = FXMLLoader.load(getClass().getResource("HomepageUI.fxml"));
        Scene shopScene = new Scene(shopRoot);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(shopScene);
        window.show();
        Platform.runLater(() -> shopRoot.requestFocus());

    }

    @FXML
    void plusClicked(ActionEvent event) {
        System.out.println("clicked");
        System.out.println(numProductsToBuy_firstShop);
        if(numProductsToBuy_firstShop.getText().equals("0")){
            yellowBGAdd.setVisible(false);
            label_Add.setVisible(false);

            minus.setVisible(true);
            yellowMiddleBG.setVisible(true);

            minus.setOpacity(1);
            yellowMiddleBG.setOpacity(1);

            addProducts_firstShop();

            numProductsToBuy_firstShop.setVisible(true);
            numProductsToBuy_firstShop.setOpacity(1);
        }
        else {
            addProducts_firstShop();
        }


    }

    void addProducts_firstShop(){
        String numOfProducts = numProductsToBuy_firstShop.getText();
        int num = Integer.parseInt(numOfProducts);
        numProductsToBuy_firstShop.setText("" + ++num);
    }

    void addProducts_secondShop(){
        String numOfProducts = numProductsToBuy_secondShop.getText();
        int num = Integer.parseInt(numOfProducts);
        numProductsToBuy_secondShop.setText("" + ++num);
    }

    @FXML
    void minusClicked(ActionEvent event) {
        String numOfProducts = numProductsToBuy_firstShop.getText();
        int num = Integer.parseInt(numOfProducts);

        if(num > 0 && --num == 0){
            yellowMiddleBG.setVisible(false);
            minus.setVisible(false);
            numProductsToBuy_firstShop.setVisible(false);

            label_Add.setVisible(true);
            yellowBGAdd.setVisible(true);
            numProductsToBuy_firstShop.setText("" + num);
        }
        else {
            numProductsToBuy_firstShop.setText("" + num);
        }
    }

    @FXML
    void minusClicked_secondShop(ActionEvent event) {
        String numOfProducts = numProductsToBuy_secondShop.getText();
        int num = Integer.parseInt(numOfProducts);

        if(num > 0 && --num == 0){
            yellowMiddleBG_secondShop.setVisible(false);
            minus_secondShop.setVisible(false);
            numProductsToBuy_secondShop.setVisible(false);

            label_Add_secondShop.setVisible(true);
            yellowBGAdd_secondShop.setVisible(true);
            numProductsToBuy_secondShop.setText("" + num);
        }
        else {
            numProductsToBuy_secondShop.setText("" + num);
        }
    }

    @FXML
    void plusClicked_secondShop(ActionEvent event) {
        if(numProductsToBuy_secondShop.getText().equals("0")){
            yellowBGAdd_secondShop.setVisible(false);
            label_Add_secondShop.setVisible(false);

            minus_secondShop.setVisible(true);
            yellowMiddleBG_secondShop.setVisible(true);

            minus_secondShop.setOpacity(1);
            yellowMiddleBG_secondShop.setOpacity(1);

            addProducts_secondShop();

            numProductsToBuy_secondShop.setVisible(true);
            numProductsToBuy_secondShop.setOpacity(1);
        }
        else {
            addProducts_secondShop();
        }
    }



}
