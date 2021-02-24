
public class User {
	
	private int idUser;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String cel;
	private String addressUser;
	private Role userRole;
	private String username;
	private String password;
	
	
	public User() {
		this.idUser = getIdUser();
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.gender = getGender();
		this.email = getEmail();
		this.cel = getCel();
		this.addressUser = getAddressUser();
		this.userRole = getUserRole();
		this.username = getUsername();
		this.password = getPassword();
	}
	
	
	public User(int idUser, String firstName, String lastName, String gender, String email, String cel,
			String addressUser, String username, String password, Role role) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.cel = cel;
		this.addressUser = addressUser;
		this.username = username;
		this.password = password;
		this.userRole = role;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCel() {
		return cel;
	}
	
	public void setCel(String cel) {
		this.cel = cel;
	}
	
	public String getAddressUser() {
		return addressUser;
	}
	
	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}
	
	public Role getUserRole() {
		return userRole;
	}
	
	public void setUserRole(Role role) {
		this.userRole = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}