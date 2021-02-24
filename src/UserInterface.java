import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface UserInterface {
	
	 public void insertUser() throws SQLException;
	 
	 public void editUser(int idUser) throws SQLException;
	 
	 public void deleteUser() throws SQLException;
	 
	 public void showUser() throws SQLException;
	 
	 public ResultSet selectUser() throws SQLException;
	 
	 public void listUser() throws SQLException;
	 
	// public boolean isValidEmail(String email);
	 
	// public void addValidEmail(String email, PreparedStatement preparedStatement);

}
