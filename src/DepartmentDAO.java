import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class DepartmentDAO implements DepInterface{

	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void insertDep() throws SQLException {
    	CompanyDAO compDao = new CompanyDAO();
		preparedStatement = connect.prepareStatement("insert into  menage_companies.department values ('', ?, ?, ?, ?)");
        
		System.out.println("Put a name for the department:");
		String name = input.next();
		System.out.println("Put a description for the department:");
		String description = input.next();
		System.out.println("Put 0 (false) or 1 (true) for the validity of the department:");
		int validity = input.nextInt();
        int idCompany = compDao.selectCompanyByName();
        
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idCompany);
		preparedStatement.executeUpdate();
		
	  	System.out.println("\nDepartment is added!");
	  	
	  	continueWithSector();
	}
    
    
    @Override
    public void continueWithSector() throws SQLException {
		
		System.out.println("\nDo you want to add sectors? Type 'y/Y' for Yes or 'n/N' for No: ");
		String choose = input.next();
		
		if(choose.equals("y") || choose.equals("Y")) {
			SectorDAO sectorDAO = new SectorDAO();
			System.out.println("\nHow much sectors do you want to create? Put a number: ");
			int nr = input.nextInt();
			int i;
			for(i = 0; i<nr; i++) {
				sectorDAO.insertSector();
			}
		}
		else if(choose.equals("n") || choose.equals("N")) {
			System.out.println("\nYou have not add sectors!");
		}
		else {
			System.out.println("\nYou have not choosed correctly! Please press the right button:");
			continueWithSector();
		}

	}
    
    
    @Override
    public void editDep(int idDep) throws SQLException {
    	
		preparedStatement = connect.prepareStatement("update  menage_companies.department set `Name`=?, `Description`=?, `Validity`=? where IdDep = ?");
            	
		System.out.println("Change name for the department:");
		String name = input.next();
		System.out.println("Change description for the department:");
		String description = input.next();
		System.out.println("Change validity. Put 0 (false) or 1 (true) for the validity of the department:");
		int validity = input.nextInt();
           
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, description);
		preparedStatement.setInt(3, validity);
		preparedStatement.setInt(4, idDep);
		preparedStatement.executeUpdate();
		System.out.println("\nValues are changed!");
	}
    
    
    @Override
    public void deleteDep() throws SQLException {
    	
		System.out.println("Put a number for the id of the department that you want to delete:");
		int id = input.nextInt();
		
		SectorDAO sectDao = new SectorDAO();
		sectDao.deleteSectorDep(id);
		preparedStatement = connect.prepareStatement("delete from menage_companies.department where IdDep = ?; ");
		
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("\nDepartment is deleted!");
	}
    
    
    
    @Override
    public void deleteDepCompany(int idCompany) throws SQLException {
		preparedStatement = connect.prepareStatement("delete from menage_companies.department where IdCompany = ?; ");
		preparedStatement.setInt(1, idCompany);
		preparedStatement.executeUpdate();
		System.out.println("\nDepartments are deleted!");
	}
    
    
    public void deleteDepCompanyValidity(int idCompany) throws SQLException {
    	
    	preparedStatement = connect.prepareStatement("update menage_companies.department set `Validity`= 0 where IdCompany = ?");
		preparedStatement.setInt(1, idCompany);
		preparedStatement.executeUpdate();
		System.out.println("Company is deleted!");
	}
    
    
    
    @Override
    public ResultSet selectDep() throws SQLException {
		preparedStatement = connect.prepareStatement("select* from menage_companies.department;");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
    
    @Override
	public void showDep() throws SQLException {
		preparedStatement = connect.prepareStatement("select* from menage_companies.department where IdDep = ?;");
		
		System.out.println("Put a number for the id of the department that you want to show data:");
		int id = input.nextInt();
		preparedStatement.setInt(1, id);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		String name = rs.getString("Name");
		String description = rs.getString("Description");
		int validity = rs.getInt("Validity");
		int idCompany = rs.getInt("IdCompany");

		System.out.println("Name of Department: " + name);
		System.out.println("Description of Department: " + description);
		System.out.println("Validity of Department: " + validity);
		System.out.println("Id of Company of that Department: " + idCompany);
	}
    
    
    @Override
    public void listDep() throws SQLException {
    	ResultSet resultSet = selectDep();
		while (resultSet.next()) {

			int idDep = resultSet.getInt("IdDep");
			String name = resultSet.getString("Name");
			String description = resultSet.getString("Description");
			int idComp = resultSet.getInt("IdCompany");
                    
			System.out.println("ID: " + idDep);
			System.out.println("Name of Department: " + name);
			System.out.println("Description: " + description);
			System.out.println("ID of Company: " + idComp);
			System.out.println();
		}
	}
}
