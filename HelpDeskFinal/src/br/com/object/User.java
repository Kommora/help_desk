package br.com.object;

public class User {

	private String name;
	private String cpf;
	private String email;
	private String password;
	private String level;
	private String phone;

	public User(){}
	
	public User(String name, String cpf, String email, String password, String level,String phone) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.level = level;
		this.phone = phone;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getlevel() {
		return level;
	}
	
	public void setlevel(String level) {
		this.level = level;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
