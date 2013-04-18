/*
 * Advance Web Technology ECWI604 - Course Work 2
 */
package fyp.thej.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Document : MySqlConnector.java Created on : Dec 4, 2012, 12:09:08 PM Author :
 * Thejanee Walgamage <2008061>
 */
public class MySqlConnector {

    private static Connection conn;
    private static ConnectionPool conPool =  null;
            
    static {
        try {
            conPool =  new ConnectionPool(20);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static Connection getConn() {
//        if(conn == null){
//            connect();
//        }
//        return conn;
//    }

//    private void setConn(Connection conn) {
//        this.conn = conn;
//    }

//    private static void connect() {
//        System.out.println("MySQL Connect Example.");
//        conn = null;
//        String url = "jdbc:mysql://localhost:3306/";
//        String dbName = "employees";
//        String driver = "com.mysql.jdbc.Driver";
//        String userName = "root";
//        String password = "1234";
//        try {
//            Class.forName(driver).newInstance();
//            MySqlConnector.conn = DriverManager.getConnection(url + dbName, userName, password);
//            System.out.println("Connected to the database");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    

    public static List executeQuery(String sqlQuery) {
        ResultSet executeQuery = null;
        
       // HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<HashMap> rowList = new ArrayList<HashMap>();
        Connection con = null;
        try {
          //  MySqlConnector.connect();
           con = conPool.getConnection();
            executeQuery =con.createStatement().executeQuery(sqlQuery);

            while (executeQuery.next()) {
                HashMap<String, String> mapRes = new HashMap<String, String>();
                for (int i = 1; i <= executeQuery.getMetaData().getColumnCount(); i++) {
                    mapRes.put(executeQuery.getMetaData().getColumnName(i), executeQuery.getString(i));
                }
                rowList.add(mapRes);
            }
            conPool.returnConnection(con);
          
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
             con = null;
           
        }finally{
           con = null;
        }
        return rowList;
    }

//    public static void close() {
//        try {
//            MySqlConnector.conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Disconnected from database");
//    }
}
