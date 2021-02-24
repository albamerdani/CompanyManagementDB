import java.sql.ResultSet;
import java.sql.SQLException;


public interface BrandInterface {
	
	 public void insertBrand() throws SQLException;
	 
	 public void editBrand(int idBrand) throws SQLException;
	 
	 public void deleteBrand() throws SQLException;
	 
	 public void deleteBrandShop(int idShop) throws SQLException;
	 
	 public ResultSet selectBrand() throws SQLException;
	 
	 public void showBrand() throws SQLException;
	 
	 public void listBrand() throws SQLException;

}
