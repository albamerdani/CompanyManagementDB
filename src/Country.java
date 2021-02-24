
public class Country {

	private int idCountry;
	private String country;
	private String currency;
	
	public Country(){
	
	}
	
	public Country(int idCountry, String country, String currency){
		this.idCountry = idCountry;
		this.country = country;
		this.currency = currency;
	}
	
	public int getIdCountry() {
		return idCountry;
	}
	
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
