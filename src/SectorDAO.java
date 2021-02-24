import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class SectorDAO implements SectorInterface{
	
	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
   
    @Override
    public void insertSector() throws SQLException {
    	
		preparedStatement = connect.prepareStatement("select IdDep from  menage_companies.department where Name = ?");
		System.out.println("Put a name for the department where you want to add a sector:");
		String nameDep = input.next();
		preparedStatement.setString(1, nameDep);
		ResultSet rs = preparedStatement.executeQuery();
		int idDep = rs.getInt("IdDep");
            	
		preparedStatement = connect.prepareStatement("insert into  menage_companies.sector values ('', ?, ?, ?, ?)");
          	  
		System.out.println("Put a name for the sector:");
		String name = input.next();
		System.out.println("Put a description for the sector:");
		String description = input.next();
		System.out.println("Put 0 (false) or 1 (true) for the validity of the sector:");
		int validity = input.nextInt();
          	   
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idDep);
		preparedStatement.executeUpdate();
		
	  	System.out.println("\nSector is added!");
	  	
	  	continueWithShop();
	}
    
    
    @Override
    public void continueWithShop() throws SQLException {
		
		System.out.println("\nDo you want to add shops? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = input.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			ShopDAO shopDAO = new ShopDAO();
			System.out.println("\nHow much shops do you want to add? Put a number: ");
			int nr = input.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				shopDAO.insertShop();
			}
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add shops!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithShop();
		}
	}
    
    
    @Override
    public void editSector(int idSector) throws SQLException {
     	
		preparedStatement = connect.prepareStatement("update  menage_companies.sector set `Name`=?, `Description`=?, `Validity`=? where IdSector = ?");
         	
		System.out.println("Change name for the sector:");
		String name = input.next();
		System.out.println("Change description for the sector:");
		String description = input.next();
		System.out.println("Change validity. Put 0 (false) or 1 (true) for the validity of the sector:");
		int validity = input.nextInt();

		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idSector);
		preparedStatement.executeUpdate();
		System.out.println("\nValues are changed!");
	}
    
    
    @Override
    public void deleteSector() throws SQLException {
    	
		System.out.println("Put a number for the id of the sector that you want to delete:");
		int id = input.nextInt();
		
		ShopDAO shopDao = new ShopDAO();
    	shopDao.deleteShopSector(id);

		preparedStatement = connect.prepareStatement("delete from menage_companies.sector where IdSector = ?; ");

		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();	
		System.out.println("\nSector is deleted!");
	}
    
    
    @Override
    public void deleteSectorDep(int idDep) throws SQLException {
		preparedStatement = connect.prepareStatement("delete from menage_companies.sector where IdDep = ?; ");
		preparedStatement.setInt(1, idDep);
		preparedStatement.executeUpdate();
		System.out.println("\nSectors are deleted!");
	}
    
    
    public void deleteSectorDepValidity(int idDep) throws SQLException {
    	preparedStatement = connect.prepareStatement("update  menage_companies.sector set `Validity`= 0 where IdDep = ?");
		preparedStatement.setInt(1, idDep);
		preparedStatement.executeUpdate();
		System.out.println("\nSectors are deleted!");
	}
    
    
    
    @Override
    public ResultSet selectSector() throws SQLException {
		preparedStatement = connect.prepareStatement("select* from menage_companies.sector;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
    
    @Override
	public void showSector() throws SQLException {
		preparedStatement = connect.prepareStatement("select* from menage_companies.sector where IdSector = ?;");
		
		System.out.println("Put a number for the id of the sector that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		String name = rs.getString("Name");
		int idDep = rs.getInt("IdDep");
		String description = rs.getString("Description");
		int validity = rs.getInt("Validity");

		System.out.println("Name of Sector:" + name);
		System.out.println("IdDep of Sector:" + idDep);
		System.out.println("Description of Brand:" + description);
		System.out.println("Validity of Brand:" + validity);
	}
    
    
    @Override
    public void listSector() throws SQLException {
    	ResultSet resultSet = selectSector();
    	
		while (resultSet.next()) {
                	
			int idSector = resultSet.getInt("IdSector");
			String name = resultSet.getString("Name");
			String description = resultSet.getString("Description");
			int idDep = resultSet.getInt("IdDep");
                    
			System.out.println("ID: " + idSector);
			System.out.println("Name of Sector: " + name);
			System.out.println("Description: " + description);
			System.out.println("ID of Department: " + idDep);
			System.out.println();
		}
	}

}
