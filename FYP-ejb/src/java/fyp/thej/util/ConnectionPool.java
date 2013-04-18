/*
 * Advance Web Technology ECWI604 - Course Work 2
 */

package fyp.thej.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

/**
 *
 * ConnectionPool
 * Dec 27, 2012 11:02:54 PM
 * Thejanee Walgamage <2008061>
 */
public class ConnectionPool {

   private Hashtable<Connection,Boolean> connections = new Hashtable<Connection,Boolean>();  
    private HashMap<String , String> props = null;
   
    public ConnectionPool( int initialConnections)   
    throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {  
        String url = "jdbc:mysql://localhost:3306/easycontact";
      //  String dbName = "employees";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";
        
        props = new HashMap();  
        props.put("connection.driver", driver);  
        props.put("connection.url", url);  
        props.put("user", userName);  
        props.put("password", password);  
        initializePool(props, initialConnections);  
    }  
      
    public Connection getConnection() throws SQLException {  
        Connection con = null;  
        Enumeration cons = connections.keys();  
        synchronized (connections) {  
            while (cons.hasMoreElements()) {  
                con = (Connection) cons.nextElement();  
                Boolean b = connections.get(con);  
                  
                if (b == Boolean.FALSE) {  
                    try {  
                        con.setAutoCommit(con.getAutoCommit());     
                    } catch (SQLException sqle) {  
                        connections.remove(con);  
                        con = getNewConnection();  
                    }  
                    connections.put(con, Boolean.TRUE);  
                    return con;  
                }  
            }  
        }  
        con = getNewConnection();  
        connections.put(con, Boolean.TRUE);  
        return con;  
    }  
      
    public void returnConnection(Connection returned) {  
        if (connections.containsKey(returned)) {  
            connections.put(returned, Boolean.FALSE);         
        }  
    }  
      
    private void initializePool(HashMap props, int initialConnections)  
    throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {  
        Class.forName((String)props.get("connection.driver")).newInstance();  
        
        for (int i = 0; i < initialConnections; i++) {  
            Connection con = getNewConnection();  
            connections.put(con, Boolean.FALSE);  
        }  
    }  
      
    private Connection getNewConnection() throws SQLException {
       Connection con =  DriverManager.getConnection(props.get("connection.url"), props.get("user"), props.get("password"));
        return  con;   
    }  

    
    
}
