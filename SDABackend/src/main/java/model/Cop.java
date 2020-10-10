package model;

public class Cop extends User {
	
	private String office;
	private int identifier;
	private String departament;
	
	
	
	public Cop(User user ,String office,int identifier,String departament) {
		super(user.getCpf(), user.getName(), user.getEmail(), user.getPassword());
		this.office = office;
		this.identifier=identifier;
		this.departament=departament;
	}
	
	public String getOffice() {
		return office;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	
	
	
		
}
