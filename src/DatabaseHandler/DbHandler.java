package DatabaseHandler;

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
}
