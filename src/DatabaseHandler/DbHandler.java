package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Models.WhiskyModel;

import javax.swing.plaf.nimbus.State;

public class DbHandler {
    private static DbHandler ourInstance = new DbHandler();

    public static DbHandler getInstance() {
        return ourInstance;
    }
    //jdbc:mysql://localhost:3306/dbname

    private String url;
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
        url = "";
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




    public boolean insertIntoTable(WhiskyModel whisky) throws SQLException {
        url = String.format("jdbc:mysql://%s:%s/%s",ip,port,db);

        String prepString = String.format("INSERT INTO %s (name, malt, age, description) VALUES (?,?,?,?)",table);
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(prepString);

            stmt.setString(1, whisky.getName());
            stmt.setString(2,whisky.getMalt());
            stmt.setInt(3, whisky.getAge());
            stmt.setString(4, whisky.getDescription());

            stmt.executeUpdate();
            connection.commit();


        }
        finally {
            if(connection != null && !connection.isClosed())
                connection.close();
            if(stmt != null && !stmt.isClosed())
                stmt.close();
        }
        return true;
    }

    public List<WhiskyModel> selectFromTable(WhiskyModel whisky) throws SQLException {
        url = String.format("jdbc:mysql://%s:%s/%s", ip, port, db);

        List<WhiskyModel> resultList = new ArrayList<>();
        String prepString = "SELECT name, malt, age, description FROM " + table + " WHERE name LIKE '%?%'";
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(prepString);

            stmt.setString(1, whisky.getName());

            ResultSet result = stmt.executeQuery();
            connection.commit();

            while(result.next()){
                WhiskyModel wm = new WhiskyModel();
                wm.setName(result.getString("name"));
                wm.setMalt(result.getString("malt"));
                wm.setAge(result.getInt("age"));
                wm.setDescription(result.getString("description"));

                resultList.add(wm);
            }
        }
        finally {
            if(connection != null && !connection.isClosed())
                connection.close();
            if(stmt != null && !stmt.isClosed())
                stmt.close();
        }

        return resultList;
    }

}
