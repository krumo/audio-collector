package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by krumo on 2016/3/16.
 */
public class DBconnector {
    private String url;
    private String serverName;
    private String portNumber;
    private String databaseName;
    private String userName;
    private String password;
    public DBconnector(){
        url = "jdbc:mysql://";
        serverName = "localhost";
        portNumber = "3306";
        databaseName = "record";
        userName = "root";
        password = "root";
    }
    private String getConnectionUrl() {
        System.out.println(url + serverName + ":" + portNumber + "/" + databaseName);
        return url + serverName + ":" + portNumber + "/" + databaseName;
    }
    public Connection getConnection() {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(getConnectionUrl(),userName,password);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return con;
    }
}
