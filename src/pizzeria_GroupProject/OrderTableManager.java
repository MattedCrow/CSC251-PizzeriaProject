package pizzeria_GroupProject;

import java.sql.*;

public class OrderTableManager {
    // Create a named constant for the URL
    public final String DB_URL = "jdbc:derby://localhost:1527/Pizza;create=true";
    
    /**
     * Be sure to go into services and create/connect to the database "Pizza" prior to running
     * the code- otherwise, the database will not be able to be viewed
     * 
     * Directions -> Services, Right Click "Java DB", "Create Database...",
     * name it "Pizza", no username, no password, "Ok", and you should be done
     */
    
    
    // Field for database connection
    private Connection conn;
    
    /**
     * Constructor
     */
    public OrderTableManager() throws SQLException {
        // Create a connection to database
        conn = DriverManager.getConnection(DB_URL);
    }
    
    public void insert(String size, String crustStyle,
            String toppingList, double cost) throws SQLException {
        String query = "INSERT INTO ordertable VALUES" + "(" + "'" + size +
                "', " + "'" + crustStyle + "', " + "'" + toppingList +
                "', " + "'" + cost + "'" + ")";
        
        // Create a statement object
        Statement stmt = conn.createStatement();
        
        // Send statement to the DBMS
        try {
            stmt.execute("CREATE TABLE ordertable (size varchar(255), " +
                    "crustStyle varchar(255), " +
                    "toppingList varchar(255), " +
                    "cost varchar(255))");
        }
        catch ( SQLException e ) {
        
        }
        stmt.execute(query);
        
        // Close statement
        conn.close();
        stmt.close();
    }
    
}
