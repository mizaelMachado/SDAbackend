package model;

public class Cop {
	
	private String office;
	private int identifier;
	private String departament;
	private int cpf;
	
	
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Cop(int cpf ,String office,int identifier,String departament) {
		this.cpf =cpf;
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
