import java.sql.ResultSet;
import java.sql.SQLException;


public interface ShopInterface {

	 public void insertShop() throws SQLException;
	 
	 public void continueWithBrand() throws SQLException;
	 
	 public void editShop(int idShop) throws SQLException;
	 
	 public void deleteShop() throws SQLException;
	 
	 public void deleteShopSector(int idSector) throws SQLException;
	 
	 public ResultSet selectShop() throws SQLException;
	 
	 public void showShop() throws SQLException;
	 
	 public void listShop() throws SQLException;
}
