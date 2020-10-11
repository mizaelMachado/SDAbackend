package model;

public class User {
	
	private int cpf;
	private String name;
	private String email;
	private String password;
	private int id_localization;
	private int id_complaint;


	
	public User(int cpf, String name, String email, String password, int id_localization,int id_complaint) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
		this.setId_complaint(id_complaint);
		this.setId_localization(id_localization);
	}
	
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [cpf=" + cpf + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}


	public int getId_localization() {
		return id_localization;
	}


	public void setId_localization(int id_localization) {
		this.id_localization = id_localization;
	}


	public int getId_complaint() {
		return id_complaint;
	}


	public void setId_complaint(int id_complaint) {
		this.id_complaint = id_complaint;
	}
}
