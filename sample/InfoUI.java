package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.HomepageUI;
import java.io.IOException;
import java.util.Locale;

public class InfoUI {

    double xOffset, yOffset;

    @FXML
    private TextField name;

    @FXML
    private ComboBox location;

    @FXML
    private Label invalidForm;

    @FXML
    private ImageView X_Image;

    @FXML
    void exitButton(ActionEvent event) {
            System.exit(0);
    }

    void addCountriesToDropdownOptions() {
        ObservableList<String> options = FXCollections.observableArrayList();
        ComboBox dropdown = new ComboBox(options);

        //gets all countries
        String[] locale1 = Locale.getISOCountries();
        //traverses all countries
        for (String x : locale1) {
            Locale temp = new Locale("", x);
            options.add(temp.getDisplayCountry());
        }

        dropdown.setItems(options);
    }

    @FXML
    void goToMainScreen(ActionEvent event) throws IOException {
        if(name.equals("")) {
            invalidForm.setText("Please enter your name.");
            return;
        }

        Parent loginRoot = FXMLLoader.load(getClass().getResource("HomepageUI.fxml"));
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
