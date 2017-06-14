package Controllers;

import DatabaseHandler.DbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.System.err;


public class DBController {
    DbHandler db = DatabaseHandler.DbHandler.getInstance();
    private String errors;
    private final String SUCCESS_STRING = "Database fields are now set.";

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
        errors = "";

        validateUsername(usernameField.getText().trim());
        validatePassword(passwordField.getText().trim());
        validateIP(ipField.getText().trim());
        validatePort(portField.getText().trim());
        validateDB(dbField.getText().trim());
        validateTable(tableField.getText().trim());





        err.format("Validation: %s\n", errors.isEmpty());
        if (errors.isEmpty()){
            errorField.setText(SUCCESS_STRING);
            return true;
        }else{
            errorField.setText(errors);
            return false;
        }
    }

    private void validateIP(String ip){
//        err.format("Regex test: %s\n",ipField.getText().matches("^(\\d{1,3}\\.){3}\\d{1,3}$"));
        if(ip.isEmpty())
            errors += "IP is empty.\n";
        else if(!ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$")){
            errors += "IP is invalid.\n";
        }
        else
        {
            db.setIp(ip);
        }
    }

    private void validatePort(String port){
        if(port.isEmpty())
            errors += "Port is empty.\n";
        else{
            try {
                Integer.parseInt(port);
            }catch (NumberFormatException nfe){
                errors += "Port is not a number.\n";
            }
        }
    }
    private void validateUsername(String username){
        if (username.isEmpty())
            errors += "Username is empty.\n";
    }

    private void validatePassword(String password){
        if(password.isEmpty())
            errors += "Password is empty.\n";
    }

    private void validateDB(String db){
        if(db.isEmpty())
            errors += "DB is empty.\n";
    }
    private void validateTable(String table){
        if(table.isEmpty())
            errors += "Table is empty.\n";
    }
}
