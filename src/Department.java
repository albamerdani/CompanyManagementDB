
public class Department {

	private int idDep;
	private String nameOfDep;
	private String descriptionDep;
	private boolean validityDep;

	
	public Department() {

	}
	

	public Department(int idDep, String nameOfDep, String descriptionDep) {
		this.idDep = idDep;
		this.nameOfDep = nameOfDep;
		this.descriptionDep = descriptionDep;
		this.validityDep = true;
	}

	public int getIdDep() {
		return idDep;
	}
	
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	
	public String getNameOfDep() {
		return nameOfDep;
	}
	
	public void setNameOfDep(String nameOfDep) {
		this.nameOfDep = nameOfDep;
	}


	public String getDescriptionDep() {
		return descriptionDep;
	}


	public void setDescriptionDep(String descriptionDep) {
		this.descriptionDep = descriptionDep;
	}


	public boolean getValidityDep() {
		return validityDep;
	}


	public void setValidityDep(boolean validityDep) {
		this.validityDep = validityDep;
	}
	
}
