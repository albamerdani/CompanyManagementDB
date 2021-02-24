import java.sql.*;
import java.util.Scanner;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;

public class ConnectionDB {

	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
    
    public Connection connect() {
    	
    	try {
        	String url="jdbc:mysql://localhost:3306/menage_companies";
        	String username="root";
        	String password="";
            // MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
            // the connection with the DB
            connect = DriverManager.getConnection(url, username,password);
    	}
        catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            System.out.println("You are not connected!");
        }
        catch(SQLException sqle) {
            sqle.printStackTrace();
            System.out.println("You are not connected!");
        }
    	return connect;   
    }
    
	
	private void writeMetaData(ResultSet resultSet, int nr) throws SQLException {

		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(nr));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}
	
	

	//Close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
