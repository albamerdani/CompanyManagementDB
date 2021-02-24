
public class Role {
	
	private int idRole;
	private String role;
	
	public Role() {
		this.idRole = 1;
		this.role = "administrator";
	}
	
	public Role(int idRole, String role) {
		this.idRole = idRole;
		this.role = role;
	}
	
	
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
