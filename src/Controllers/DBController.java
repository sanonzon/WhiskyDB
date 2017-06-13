package Controllers;

import DatabaseHandler.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.System.err;


public class DBController {
    DbHandler db = DatabaseHandler.DbHandler.getInstance();


    @FXML protected TextField usernameField;
    @FXML protected TextField passwordField;
    @FXML protected TextField ipField;
    @FXML protected TextField portField;
    @FXML protected TextField dbField;
    @FXML protected TextField tableField;
    @FXML protected TextArea errorField;

    @FXML
    protected void saveDBInfo(ActionEvent event) {


        if (validateTextfields()) {

            db.setUsername(usernameField.getText());
            db.setPassword(passwordField.getText());
            db.setIp(ipField.getText());
            db.setPort(portField.getText());
            db.setDB(dbField.getText());
            db.setTable(tableField.getText());
        }

    }

    private boolean validateTextfields(){
        String errors = "";
        if (usernameField.getText().isEmpty())
            errors += "Username is empty.\n";


        if(passwordField.getText().isEmpty())
            errors += "Password is empty.\n";


        if(ipField.getText().isEmpty())
            errors += "IP is empty.\n";
        else{
            try {
                Integer.parseInt(ipField.getText());
            }catch (NumberFormatException nfe){
                errors += "IP is not a number.\n";
            }
        }

        if(portField.getText().isEmpty())
            errors += "Port is empty.\n";
        else{
            try {
                Integer.parseInt(portField.getText());
            }catch (NumberFormatException nfe){
                errors += "Port is not a number.\n";
            }
        }


        if(dbField.getText().isEmpty())
            errors += "DB is empty.\n";


        if(tableField.getText().isEmpty())
            errors += "Table is empty.\n";





        err.format("Validation: %s\n", errors.isEmpty());
        errorField.setText(errors);
        return errors.isEmpty();

    }

}
