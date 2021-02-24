import java.sql.ResultSet;
import java.sql.SQLException;


public interface CountryInterface {
	
	public void insertCountry() throws SQLException;
	
	 public int selectCountryByName(String country) throws SQLException;
	 
	 public String selectCountryById(int idCountry) throws SQLException;
	 
	 public ResultSet selectCountry() throws SQLException;
	 
	 public void listCountry() throws SQLException;

}
