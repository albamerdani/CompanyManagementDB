import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class BrandDAO implements BrandInterface{

	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
   
    @Override
    public void insertBrand() throws SQLException{
    	
		preparedStatement = connect.prepareStatement("insert into  menage_companies.brands values ('', ?, ?, ?, ?)");
        
		System.out.println("Put a name for the brand:");
		String name = input.next();
		System.out.println("Put a descripiton for the brand:");
		String description = input.next();
		System.out.println("Put 0 (false) or 1 (true) for the validity of the brand:");
		int validity = input.nextInt();
		System.out.println("Put an id for the shop of the brand:");
		int idShop = input.nextInt();
          	   
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idShop);
		preparedStatement.executeUpdate();
		
	  	System.out.println("\nBrand is added!");
	}
               
    
    
    @Override     
	public void editBrand(int idBrand) throws SQLException{
			
		preparedStatement = connect.prepareStatement("update  menage_companies.brands set `Name`=?, `Description`=?, `Validity`=? where IdBrand = ?");
        
		System.out.println("Change name for the brand:");
		String name = input.next();
		System.out.println("Change descripiton for the brand:");
		String description = input.next();
		System.out.println("Put 0 (false) or 1 (true) for the validity of the brand:");
		int validity = input.nextInt();
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idBrand);
		preparedStatement.executeUpdate();
		
		System.out.println("\nValues are changed!");
	}
	
	
    @Override
	public void deleteBrand() throws SQLException{
    	
		preparedStatement = connect.prepareStatement("delete from menage_companies.brands where IdBrand = ?; ");

		System.out.println("Put a number for the id of the brand that you want to delete:");
		int id = input.nextInt();
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		
		System.out.println("\nBrand is deleted!");
	}
	
	
    @Override
	public void deleteBrandShop(int idShop) throws SQLException{
		preparedStatement = connect.prepareStatement("delete from menage_companies.brands where IdShop = ?; ");
		preparedStatement.setInt(1, idShop);
		preparedStatement.executeUpdate();
		
		System.out.println("\nBrands are deleted!");
	}
    
    public void deleteBrandShopValidity(int idShop) throws SQLException{
    	preparedStatement = connect.prepareStatement("update  menage_companies.brands set `Validity`= 0 where IdShop = ?");
		preparedStatement.setInt(1, idShop);
		preparedStatement.executeUpdate();
		
		System.out.println("\nBrands are deleted!");
	}
	
	
    
    @Override
	public ResultSet selectBrand() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.brands;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
    
    
    @Override
	public void showBrand() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from menage_companies.brands where IdBrand = ?;");
		
		System.out.println("Put a number for the id of the brand that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		String name = rs.getString("Name");
		String description = rs.getString("Description");
		int validity = rs.getInt("Validity");
		int idShop = rs.getInt("IdShop");
		
		System.out.println("Name of Brand:" + name);
		System.out.println("Description of Brand:" + description);
		System.out.println("Validity of Brand:" + validity);
		System.out.println("IdShop of Brand:" + idShop);
	}
	
	
    
    @Override
	public void listBrand() throws SQLException {
		ResultSet resultSet = selectBrand();

		while (resultSet.next()) {
                	
			int idBrand = resultSet.getInt("IdBrand");
			String name = resultSet.getString("Name");
			String description = resultSet.getString("Description");
			int idShop = resultSet.getInt("IdShop");
                    
			System.out.println("ID: " + idBrand);
			System.out.println("Name of Brand: " + name);
			System.out.println("Description: " + description);
			System.out.println("ID of Shop: " + idShop);
			System.out.println();
		}
	}
}
