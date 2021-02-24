import java.sql.ResultSet;
import java.sql.SQLException;


public interface CompanyInterface {

	public void insertCompany() throws SQLException;
	
	public void continueWithDep() throws SQLException;
	
	public void editCompany(int id) throws SQLException;
	
	public void deleteCompany() throws SQLException;
	
	public ResultSet selectCompany() throws SQLException;
	
	public void showCompany() throws SQLException;
	
	public void listCompany() throws SQLException;
}
