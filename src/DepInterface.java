import java.sql.ResultSet;
import java.sql.SQLException;


public interface DepInterface {

	 public void insertDep() throws SQLException;
	 
	 public void continueWithSector() throws SQLException;
	 
	 public void editDep(int idDep) throws SQLException;
	 
	 public void deleteDep() throws SQLException;
	 
	 public void deleteDepCompany(int idCompany) throws SQLException;
	 
	 public ResultSet selectDep() throws SQLException;
	 
	 public void showDep() throws SQLException;
	 
	 public void listDep() throws SQLException;
	 
}
