import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.regex.*;

public class UserDAO implements UserInterface{

	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void insertUser() throws SQLException{
   
    	RoleDAO roleDao = new RoleDAO();
		preparedStatement = connect.prepareStatement("insert into  menage_companies.user values ('', ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
		System.out.println("Put firstname for the user: ");
		String firstname = input.next();
		System.out.println("Put lastname for the user: ");
		String lastname = input.next();
		System.out.println("Put gender for the user: ");
		String gender = input.next();
		System.out.println("Put email for the user: ");
		String email = input.next();
		//addValidEmail(email, preparedStatement);
		System.out.println("Put cel number for the user: ");
		String cel = input.next();
		System.out.println("Put address for the user: ");
		String address = input.next();
		System.out.println("Put username for the user: ");
		String username = input.next();
		System.out.println("Put password for the user: ");
		String password = input.next();
		System.out.println("Put a role for the user: ");
		String role = input.next();
		int idRole = roleDao.selectRoleByName(role);
          	   
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setString(3, gender);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, cel);
		preparedStatement.setString(6, address);
		preparedStatement.setString(7, username);
		preparedStatement.setString(8, password);
		preparedStatement.setInt(9, idRole);	   	
		preparedStatement.executeUpdate();
		
	  	System.out.println("User is added!");
	}
            
    
    @Override        
	public void editUser(int idUser) throws SQLException{
            	
		preparedStatement = connect.prepareStatement("update  menage_companies.user set `Email`=?, `Cel`=?, `Address`=?, `Username`=?, `Password`=? where IdUser = ?");
        
		System.out.println("Change email for the user: ");
		String email = input.next();
		System.out.println("Change cel number for the user: ");
		String cel = input.next();
		System.out.println("Change address for the user: ");
		String address = input.next();
		System.out.println("Change username for the user: ");
		String username = input.next();
		System.out.println("Change password for the user: ");
		String password = input.next();
           
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, cel);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, username);
		preparedStatement.setString(5, password);
		preparedStatement.setInt(6, idUser);
		preparedStatement.executeUpdate();
		
	  	System.out.println("Values are changed!");
	}
	
	
    @Override
	public void deleteUser() throws SQLException{
    	
		preparedStatement = connect.prepareStatement("delete from menage_companies.user where IdUser = ?; ");

		System.out.println("Put a number for the id of the user that you want to delete:");
		int id = input.nextInt();
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		
	  	System.out.println("User is deleted!");
	}
	
	
	
    @Override
	public void showUser() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.user where IdUser = ?;");
		
		System.out.println("Put a number for the id of the user that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		String firstname = rs.getString("FirstName");
		String lastname = rs.getString("LastName");
		String gender = rs.getString("Gender");
		String email = rs.getString("Email");
		String cel = rs.getString("Cel");
		String address = rs.getString("Address");
		String username = rs.getString("Username");
		String password = rs.getString("Password");
		
		int idRole = rs.getInt("IdRole");
		RoleDAO roleDao = new RoleDAO();
		String role = roleDao.selectRoleById(idRole).getString("Role");

		System.out.println("Firstname of User: " + firstname);
		System.out.println("Lastname of User: " + lastname);
		System.out.println("Gender of User: " + gender);
		System.out.println("Email of User: " + email);
		System.out.println("Cel of User: " + cel);
		System.out.println("Address of User: " + address);
		System.out.println("Username of User: " + username);
		System.out.println("Password of User: " + password);
		System.out.println("Role of User: " + role);
	}
	
	
    @Override
	public ResultSet selectUser() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.user;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
	
    @Override
	public void listUser() throws SQLException {
		ResultSet resultSet = selectUser();
		while (resultSet.next()) {
                	
			int idUser = resultSet.getInt("IdUser");
			String firstname = resultSet.getString("FirstName");
			String lastname = resultSet.getString("LastName");
			String gender = resultSet.getString("Gender");
			String email = resultSet.getString("Email");
			String cel = resultSet.getString("Cel");
			String address = resultSet.getString("Address");
			String username = resultSet.getString("Username");
			String password = resultSet.getString("Password");
			
			int idRole = resultSet.getInt("IdRole");
			RoleDAO roleDao = new RoleDAO();
			String role = roleDao.selectRoleById(idRole).getString("Role");

			System.out.println("ID of User: " + idUser);
			System.out.println("Firstname of User: " + firstname);
			System.out.println("Lastname of User: " + lastname);
			System.out.println("Gender of User: " + gender);
			System.out.println("Email of User: " + email);
			System.out.println("Cel of User: " + cel);
			System.out.println("Address of User: " + address);
			System.out.println("Username of User: " + username);
			System.out.println("Password of User: " + password);
			System.out.println("Role of User: " + role);
			System.out.println();
		}
		
		/*
		@Override
		public boolean isValidEmail(String email){
			
			String pattern = "[a-zA-Z]+[0-9]*[.-_]?@[a-z]+[.][a-z]+";
			boolean isMatch = Pattern.matches(pattern, email);
			
			if(isMatch) {
				return true;
			}
			return false;	
		}
		
		
		@Override
		public void addValidEmail(String email, PreparedStatement preparedStatement) throws SQLException{
			if(isValidEmail(email)){
				preparedStatement.setString(4, email);
			}
			else {
				System.out.println("Your email is not valid! Please put a valid email: ");
				email = input.next();
				addValidEmail(email);
			}
		}*/
	}       
}
