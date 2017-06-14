package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WhiskyController {
    @FXML protected TextField searchName;
    @FXML protected TextField insertName;
    @FXML protected TextField insertAge;
    @FXML protected TextField insertMalt;
    @FXML protected TextArea insertDescription;

    @FXML
    protected void insertWhisky(ActionEvent event) {
    }

    @FXML
    protected void searchWhisky(ActionEvent event) {

    }

    @FXML
    protected void toggleSQLwindow(ActionEvent event) {
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/DBView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


//        setupGui();


        primaryStage.setTitle("SQL Window");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();

    }

}
