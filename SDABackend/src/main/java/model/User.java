package model;

public class User {
	
	private int cpf;
	private String name;
	private String email;
	private String password;

	
	
	public User(int cpf, String name, String email, String password) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
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
}
