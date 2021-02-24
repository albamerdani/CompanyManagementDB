import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class CountryDAO implements CountryInterface{

	ConnectionDB conn = new ConnectionDB();
	Connection connect = conn.connect();
	
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void insertCountry() throws SQLException{
    	
    	Country c = new Country();
    	
		preparedStatement = connect.prepareStatement("insert into  menage_companies.country values ('', ?, ?)");

		System.out.println("Put a name for the country: ");
		String country = input.next();
		c.setCountry(country);
		System.out.println("Put the currency of the country: ");
		String currency = input.next();
		c.setCurrency(currency);
		preparedStatement.setString(1, c.getCountry());
		preparedStatement.setString(2, c.getCurrency());
		preparedStatement.executeUpdate();	
	  	System.out.println("\nCountry is added!");
    }
 
    
    
    @Override
    public int selectCountryByName(String country) throws SQLException{
    	preparedStatement = connect.prepareStatement("select IdCountry from  menage_companies.country where Country = ?");
    	preparedStatement.setString(1, country);
		ResultSet rs = preparedStatement.executeQuery();
		int idCountry = rs.getInt("IdCountry");
	         
		return idCountry;
    }
 
 
    @Override
	public String selectCountryById(int idCountry) throws SQLException{
		preparedStatement = connect.prepareStatement("select IdRole from  menage_companies.country where IdCountry = ?");
		preparedStatement.setInt(1, idCountry);
		ResultSet rs = preparedStatement.executeQuery();
		String country = rs.getString("Country");
	         
		return country;
	}
 
 
    @Override
	public ResultSet selectCountry() throws SQLException{
		preparedStatement = connect.prepareStatement("select* from  menage_companies.country");
		ResultSet rs = preparedStatement.executeQuery();
	         
		return rs;
	}
	 
 

    @Override
 	public void listCountry() throws SQLException {
		ResultSet resultSet = selectCountry();
		
		while (resultSet.next()) {
			
			int idCountry = resultSet.getInt("IdCountry");
			String country = resultSet.getString("Country");
			String currency = resultSet.getString("Currency");

			System.out.println("ID of Country: " + idCountry);
			System.out.println("Country: " + country);
			System.out.println("Currency of country: " + currency);
			System.out.println();
		}
 	}
}
