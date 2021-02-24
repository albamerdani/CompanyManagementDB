
public class Shop {

	private int idShop;
	private Country country;
	private int quantity;
	private double price;
	private String descriptionShop;
	private boolean validityShop;	
	
	public Shop() {
	
	}

	public Shop(int idShop, int quantity, double price, String descriptionShop) {
		this.idShop = idShop;
		this.quantity = quantity;
		this.price = price;
		this.descriptionShop = descriptionShop;
		this.validityShop = true;
	}
	
	
	public int getIdShop() {
		return idShop;
	}
	
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescriptionShop() {
		return descriptionShop;
	}

	public void setDescriptionShop(String descriptionShop) {
		this.descriptionShop = descriptionShop;
	}

	public boolean getValidityShop() {
		return validityShop;
	}

	public void setValidityShop(boolean validityShop) {
		this.validityShop = validityShop;
	}
	
}
