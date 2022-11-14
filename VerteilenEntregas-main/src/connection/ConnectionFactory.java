package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static Connection connection = null;

    private static String url;
    private static String username;
    private static String password;

    public static Connection openConnection() {
        ConnectionFactory.loadDataForConnection();
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);
            
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    public static void closeConnection(Connection con){       
           try {
                if(con!=null){
                    con.close();
                }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }       
   }
   
   public static void closeConnection(Connection con, PreparedStatement stmt){       
       closeConnection(con);
           try {
                if(stmt!=null){
                    stmt.close();
                }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }       
   }
   
   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){       
       closeConnection(con, stmt);
           try {
                if(rs!=null){
                    rs.close();
                }
           } catch (SQLException ex) {
               Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
           }       
   }

    public static void loadDataForConnection() {
        String path = System.getProperty("user.dir");
        File config_file = new File(path + "/src/connection/application.properties");

        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream(config_file);
            props.load(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("jdbc.driver");
        url = props.getProperty("jdbc.url");
        username = props.getProperty("jdbc.username");

        if (username == null) {
            username = "";
        }
        password = props.getProperty("jdbc.password");
        if (password == null) {
            password = "";
        }
        if (driver != null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
