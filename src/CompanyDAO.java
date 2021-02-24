import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class CompanyDAO implements CompanyInterface{
	
	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);

    @Override
    public void insertCompany() throws SQLException {
    	preparedStatement = connect.prepareStatement("insert into  menage_companies.company values ('', ?, ?, ?, ?, ?)");
         	  
    	System.out.println("Put a name for the company:");
    	String name = input.next();
    	System.out.println("Put a Nipt for the company");
    	String nipt = input.next();
    	System.out.println("Put an address for the company:");
    	String address = input.next();
    	System.out.println("Put a description for the company:");
    	String description = input.next();
    	System.out.println("Put 0 (false) or 1 (true) for the validity of the company:");
    	int validity = input.nextInt();
         	   
    	preparedStatement.setString(1, name);
    	preparedStatement.setString(2, nipt);
    	preparedStatement.setString(3, address);
    	preparedStatement.setString(4, description);
    	preparedStatement.setInt(5, validity);
    	preparedStatement.executeUpdate();
    	
    	System.out.println("Company is added!");
    	
    	continueWithDep();
	}
    
    
    @Override
    public void continueWithDep() throws SQLException {
		
		System.out.println("Do you want to add departments? Type 'y or Y' for 'Yes' or 'n or N' for 'No': ");
		String choose = input.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			DepartmentDAO depDAO = new DepartmentDAO();
			System.out.println("How much departments do you want to create: ");
			int nr = input.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				depDAO.insertDep();
			}
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("You add only the company!");
		}
		else {
			System.out.println("You have not choosed correctly! Please press the right button:");
			continueWithDep();
		}

	}
	
            
            
    @Override
    public void editCompany(int id) throws SQLException {
            	
    	preparedStatement = connect.prepareStatement("update menage_companies.company set `Name`=?, `Address`=?, `Description`=?, `Validity`=? where IdCompany = ?");
            	
    	System.out.println("Change name for the company:");
    	String name = input.next();
    	System.out.println("Change address for the company:");
    	String address = input.next();
    	System.out.println("Change description for the company:");
    	String description = input.next();
    	System.out.println("Change validity for the company. Put 0 (false) or 1 (true) for the validity of the company:");
    	int validity = input.nextInt();
    	
    	preparedStatement.setString(1, name);
    	preparedStatement.setString(2, address);
    	preparedStatement.setString(3, description);
    	preparedStatement.setInt(4, validity);
    	preparedStatement.setInt(5, id);
    	preparedStatement.executeUpdate();
    	System.out.println("Values are changed!");
    }
    
    
    @Override
    public void deleteCompany() throws SQLException {
    	
		preparedStatement = connect.prepareStatement("delete from menage_companies.company where IdCompany = ? ; ");

		System.out.println("Put a number for the id of the company that you want to delete:");
		int id = input.nextInt();
		
		DepartmentDAO depDao = new DepartmentDAO();
		depDao.deleteDepCompany(id);
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("Company is deleted!");
	}
    
    
    public void deleteCompanyValidity() throws SQLException {
    	
    	preparedStatement = connect.prepareStatement("update menage_companies.company set `Validity`=0 where IdCompany = ?");

		System.out.println("Put a number for the id of the company that you want to delete:");
		int id = input.nextInt();
		
		DepartmentDAO depDao = new DepartmentDAO();
		depDao.deleteDepCompanyValidity(id);
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("Company is deleted!");
	}
    
    
    @Override
    public ResultSet selectCompany() throws SQLException {
		preparedStatement = connect.prepareStatement("select* from menage_companies.company;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
    
    
    
    public int selectCompanyByName() throws SQLException{	//problem
    	preparedStatement = connect.prepareStatement("select `IdCompany` from  menage_companies.company where Name = ?");
    	System.out.println("Put the name of the Company that you want:");
		String nameCompany = input.next();
		preparedStatement.setString(1, nameCompany);
		ResultSet rs = preparedStatement.executeQuery();
		int idCompany = rs.getInt("IdCompany");

		return idCompany;
    }
	
    
    @Override
	public void showCompany() throws SQLException {		//problem 
		preparedStatement = connect.prepareStatement("select* from menage_companies.company where IdCompany = ?");
		
		System.out.println("Put a number for the id of the company that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		String name = rs.getString("Name");
		String nipt = rs.getString("Nipt");
		String address = rs.getString("Address");
		String description = rs.getString("Description");
		int validity = rs.getInt("Validity");

		System.out.println("Name of Company: " + name);
		System.out.println("Nipt of Company: " + name);
		System.out.println("Address of Company: " + name);
		System.out.println("Description of Company: " + description);
		System.out.println("Validity of Company: " + validity);
	}

    
    @Override
    public void listCompany() throws SQLException {
		ResultSet resultSet = selectCompany();
		while (resultSet.next()) {
                	
			int idCompany = resultSet.getInt("IdCompany");
			String name = resultSet.getString("Name");
			String nipt = resultSet.getString("Nipt");
			String address = resultSet.getString("Address");
			String description = resultSet.getString("Description");
                    
			System.out.println("ID of Company: " + idCompany);
			System.out.println("Name of Company: " + name);
			System.out.println("NIPT of Company: " + nipt);
			System.out.println("Address of Company: " + address);
			System.out.println("Description of Company: " + description);
			System.out.println();
		}
	}
            
            
}
