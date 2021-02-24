import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class RoleDAO implements RoleInterface{

	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void insertRole() throws SQLException{
    	
		preparedStatement = connect.prepareStatement("insert into  menage_companies.role values ('', ?)");

		System.out.println("Put a role for users: ");
		String role = input.next();
		preparedStatement.setString(1, role);
		preparedStatement.executeUpdate();	
	  	System.out.println("Role is added!");
    }
 
    
    
    @Override
    public int selectRoleByName(String role) throws SQLException{
    	preparedStatement = connect.prepareStatement("select IdRole from  menage_companies.role where Role = ?");
    	preparedStatement.setString(1, role);
		ResultSet rs = preparedStatement.executeQuery();
		int idRole = rs.getInt("IdRole");
	         
		return idRole;
    }
 
 
    @Override
	public ResultSet selectRoleById(int idRole) throws SQLException{
		preparedStatement = connect.prepareStatement("select* from  menage_companies.role where IdRole = ?");
		preparedStatement.setInt(1, idRole);
		ResultSet rs = preparedStatement.executeQuery();
		//String role = rs.getString("Role");
		
		return rs;
	}
 
 
    @Override
	public ResultSet selectRole() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from  menage_companies.role");
		ResultSet rs = preparedStatement.executeQuery();
	         
		return rs;
	}
	 
 

    @Override
 	public void listRole() throws SQLException {
		ResultSet resultSet = selectRole();
		
		while (resultSet.next()) {
			
			int idRole = resultSet.getInt("IdRole");
			String role = resultSet.getString("Role");

			System.out.println("ID Role: " + idRole);
			System.out.println("Role of User: " + role);
			System.out.println();
		}
 	}
}