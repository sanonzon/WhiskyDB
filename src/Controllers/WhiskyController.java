package Controllers;

import DatabaseHandler.DbHandler;
import Models.WhiskyModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WhiskyController {
    @FXML protected TextField searchName;
    @FXML protected TextField insertName;
    @FXML protected TextField insertAge;
    @FXML protected TextField insertMalt;
    @FXML protected TextArea insertDescription;
    @FXML private TextArea searchWhiskyError;
    @FXML protected TextArea insertWhiskyError;
    @FXML protected TextArea resultQueryTable;
    @FXML private TableView<WhiskyModel> tableView;

    @FXML
    protected void insertWhisky(ActionEvent event) {
        insertWhiskyError.setText("");
        String name = insertName.getText().trim();
        String age = insertAge.getText().trim();
        String malt = insertMalt.getText().trim();
        String description = insertDescription.getText().trim();


        WhiskyModel wm = createWhiskyModel(name, age, malt, description);
        if (wm != null){
            try {
                DbHandler.getInstance().insertIntoTable(wm);
            } catch (SQLException e) {
                insertWhiskyError.setText(e.getMessage());
                e.printStackTrace();
            }
        }
    }



    @FXML
    protected void searchWhisky(ActionEvent event) {
        String name = searchName.getText().trim();
        if(validateSearchName(name)){
            WhiskyModel wm = new WhiskyModel();
            wm.setName("%" + name + "%");
            List<WhiskyModel> resultList = null;
            try {
                resultList = DbHandler.getInstance().selectFromTable(wm);
            } catch (SQLException e) {
                searchWhiskyError.setText(e.getMessage());
                e.printStackTrace();
            }

            // Add each whisky to tableview
            if (resultList != null && resultList.size() > 0){
                ObservableList<WhiskyModel> data = tableView.getItems();
                for (WhiskyModel w: data) {
                    System.out.println(w.toString());
                    }

//                data.addAll(resultList);

                for (WhiskyModel w : resultList ) {
                    tableView.getItems().add(w);
//                    System.out.println(String.format("Name: %s", w.getName()));
                }
            }
        }
    }



    @FXML
    protected void toggleSQLwindow(ActionEvent event) {
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Views/DBView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        primaryStage.setTitle("SQL Window");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();

    }

    private boolean validateSearchName(String name){
        return !name.isEmpty();
    }

    private WhiskyModel createWhiskyModel(String name, String age, String malt, String description){
        if (validateInsert(name, age, malt, description)) {
            insertWhiskyError.appendText("All good, creating object.");
            WhiskyModel wm = new WhiskyModel();
            wm.setName(name);
            wm.setAge(Integer.parseInt(age));
            wm.setMalt(malt);
            wm.setDescription(description);

            return wm;
        }
        return null;
    }

    private boolean validateInsert(String name, String age, String malt, String description) {
        if(name.isEmpty() || age.isEmpty() || malt.isEmpty() || description.isEmpty()){
            insertWhiskyError.setText("At least one textfield is empty!");
            return false;
        }
        else {
            try {
                Integer.parseInt(age);
            }catch (NumberFormatException e){
                return false;
            }
        }

        return true;
    }


}
