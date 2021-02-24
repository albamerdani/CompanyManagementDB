
public class Sector {
	
	private int idSector;
	private String nameOfSector;
	private String descriptionSector;
	private boolean validitySector;

	
	
	public Sector() {
		
	}
	
	
	public Sector(int idSector, String nameOfSector, String descriptionSector) {
		this.idSector = idSector;
		this.nameOfSector = nameOfSector;
		this.descriptionSector = descriptionSector;
		this.validitySector = true;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getNameOfSector() {
		return nameOfSector;
	}

	public void setNameOfSector(String nameOfSector) {
		this.nameOfSector = nameOfSector;
	}

	public String getDescriptionSector() {
		return descriptionSector;
	}

	public void setDescriptionSector(String descriptionSector) {
		this.descriptionSector = descriptionSector;
	}

	public boolean getValiditySector() {
		return validitySector;
	}

	public void setValiditySector(boolean validitySector) {
		this.validitySector = validitySector;
	}

}
