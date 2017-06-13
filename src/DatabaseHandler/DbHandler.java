package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import Models.WhiskyModel;

public class DbHandler {
    private static DbHandler ourInstance = new DbHandler();

    public static DbHandler getInstance() {
        return ourInstance;
    }

    private String username;
    private String password;
    private String ip;
    private String port;
    private String db;
    private String table;

    private DbHandler() {
        username  = "";
        password = "";
        ip = "";
        port  = "";
        db = "";
        table = "";
    }

    public void setUsername(String s) {
        username = s;
    }
    public void setPassword(String s) {
        password = s;
    }
    public void setIp(String s) {
        ip = s;
    }
    public void setPort(String s) {
        port = s;
    }
    public void setDB(String s) {
        db = s;
    }
    public void setTable(String s) {
        table = s;
    }




    public boolean insertIntoTable(WhiskyModel whisky){

        try {
            Connection connection = DriverManager.getConnection(ip,username,password);






            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public boolean selectFromTable(WhiskyModel whisky){
        return false;
    }



}
