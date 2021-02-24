import java.sql.ResultSet;
import java.sql.SQLException;


public interface RoleInterface {
	
	public void insertRole() throws SQLException;
	
	public int selectRoleByName(String role) throws SQLException;
	
	public ResultSet selectRoleById(int idRole) throws SQLException;
	
	public ResultSet selectRole() throws SQLException;
	
 	public void listRole() throws SQLException;

}
