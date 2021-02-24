import java.sql.ResultSet;
import java.sql.SQLException;


public interface SectorInterface {

	public void insertSector() throws SQLException;
	
	public void continueWithShop() throws SQLException;
	
	public void editSector(int idSector) throws SQLException;
	
	public void deleteSector() throws SQLException;
	 
	public void deleteSectorDep(int idDep) throws SQLException;
	 
	public ResultSet selectSector() throws SQLException;
	
	public void showSector() throws SQLException;
	
	public void listSector() throws SQLException;
}
