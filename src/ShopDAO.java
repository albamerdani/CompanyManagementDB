import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class ShopDAO implements ShopInterface{
	
	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
   
    @Override
    public void insertShop() throws SQLException {
    	
		preparedStatement = connect.prepareStatement("select IdCountry from  menage_companies.country where Country = ?");
		System.out.println("Put a name for the Country where you want to be the shop:");
		String country = input.next();
		preparedStatement.setString(1, country);
		ResultSet rs = preparedStatement.executeQuery();
		int idCountry = rs.getInt("IdCountry");
            	
		preparedStatement = connect.prepareStatement("select IdSector from  menage_companies.sector where Name = ?");
		System.out.println("Put a name for the Sector where you want to add the shop:");
		String nameSector = input.next();
		preparedStatement.setString(1, nameSector);
		rs = preparedStatement.executeQuery();
		int idSector = rs.getInt("IdSector");

		preparedStatement = connect.prepareStatement("insert into  menage_companies.shops values ('', ?, ?, ?, ?, ?, ?)");
        
		System.out.println("Put a quantity for the goods in the shop:");
		int quantity= input.nextInt();
		System.out.println("Put a price for the goods in the shop:");
		double price = input.nextDouble();
		System.out.println("Put a description for the shop:");
		String description = input.next();
		System.out.println("Put 0 (false) or 1 (true) for the validity of the shop:");
		int validity = input.nextInt();
          	   
		preparedStatement.setInt(1, idCountry);
		preparedStatement.setInt(2, quantity);
		preparedStatement.setDouble(3, price);
		preparedStatement.setString(4, description);
		preparedStatement.setInt(5, validity);
		preparedStatement.setInt(6, idSector);
		preparedStatement.executeUpdate();
		
	  	System.out.println("\nShop is added!");
	  	
	  	continueWithBrand();
	}
    
    
    
    @Override
    public void continueWithBrand() throws SQLException {
		
		System.out.println("\nDo you want to add brands? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = input.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			BrandDAO brandDAO = new BrandDAO();
			System.out.println("\nHow much brands do you want to add? Put a number bigger than 3: ");
			int nr = input.nextInt();
			int i;
			if(nr < 3) {
				nr = 3;
			}
			for(i = 0; i<nr; i++) {
				brandDAO.insertBrand();
			}
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add brands!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithBrand();
		}
	}
    
    
    @Override
    public void editShop(int idShop) throws SQLException {
     	
		preparedStatement = connect.prepareStatement("update  menage_companies.shops set `Quantity`=?, `Price`=?, `Description`=?, `Validity`=? where IdShop = ?");
         	
		System.out.println("Change quantity for the goods in the shop:");
		int quantity= input.nextInt();
		System.out.println("Change price for the goods in the shop:");
		double price = input.nextDouble();
		System.out.println("Change description for the shop:");
		String description = input.next();
		System.out.println("Change validity. Put 0 (false) or 1 (true) for the validity of the shop:");
		int validity = input.nextInt();

		preparedStatement.setInt(1, quantity);
		preparedStatement.setDouble(2, price);
		preparedStatement.setString(3, description);
		preparedStatement.setInt(4, validity);
		preparedStatement.setInt(5, idShop);
		preparedStatement.executeUpdate();
		System.out.println("\nValues are changed!");
	}
    
    
    @Override
    public void deleteShop() throws SQLException {
    	
    	System.out.println("Put a number for the id of the shop that you want to delete:");
		int id = input.nextInt();

		BrandDAO brandDao = new BrandDAO();
		brandDao.deleteBrandShop(id);
		
		preparedStatement = connect.prepareStatement("delete from menage_companies.shops where IdShop = ?; ");
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("\nShop is deleted!");
	}
    
    
    
    @Override
    public void deleteShopSector(int idSector) throws SQLException {
		preparedStatement = connect.prepareStatement("delete from menage_companies.shops where IdSector = ?; ");
		preparedStatement.setInt(1, idSector);
		preparedStatement.executeUpdate();
		System.out.println("\nShops are deleted!");
	}
    
    

    public void deleteShopSectorValidity(int idSector) throws SQLException {
    	preparedStatement = connect.prepareStatement("update  menage_companies.shops set `Validity`= 0 where IdSector = ?");
		preparedStatement.setInt(1, idSector);
		preparedStatement.executeUpdate();
		System.out.println("\nShops are deleted!");
	}
    
    
    
    @Override
    public ResultSet selectShop() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.shops;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
	
    
    @Override
	public void showShop() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.shops where IdShop = ?;");
		
		System.out.println("Put a number for the id of the shop that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		int idCountry = rs.getInt("IdCountry");
		int quantity = rs.getInt("Quantity");
		double price = rs.getDouble("Price");
		String description = rs.getString("Description");
		int validity = rs.getInt("Validity");

		System.out.println("ID Country of Shop:" + idCountry);
		System.out.println("Quantity of goods in the shop:" + quantity);
		System.out.println("Price of goods in the shop:" + price);
		System.out.println("Description of shop:" + description);
		System.out.println("Validity of shop:" + validity);
	}
    
    
    
    @Override
    public void listShop() throws SQLException {
    	ResultSet resultSet = selectShop();
		while (resultSet.next()) {
                	
			int idShop = resultSet.getInt("IdShop");
			int quantity = resultSet.getInt("Quantity");
			double price = resultSet.getInt("Price");
			String description = resultSet.getString("Description");
			int idSector = resultSet.getInt("IdSector");
                    
			System.out.println("ID of Shop: " + idShop);
			System.out.println("Quantity of goods in this shop: " + quantity);
			System.out.println("Price of goods in this shop: " + price);
			System.out.println("Description: " + description);
			System.out.println("ID of Sector: " + idSector);
			System.out.println();
		}
	}



}
