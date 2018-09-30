package br.com.control;

import br.com.dao.UserDAO;
import br.com.object.User;
import java.util.ArrayList;



public class ControllerDAOUser {

	private UserDAO userdao;

	public ControllerDAOUser() {
		this.userdao = new UserDAO();
	}

	public String insertDAO(User user){
		try {
			switch(user.getlevel()){
			case "user":this.userdao.create(user);return ("Cadastro efetuado com sucesso");
			case "expert":this.userdao.create(user);return ("Cadastro efetuado com sucesso");
			case "admin":this.userdao.create(user);return ("Cadastro efetuado com sucesso");
			default:return ("tipo de usuario invalido");
			}

		} catch (RuntimeException e) {
			return null;
		}
	}

	public User requestDAOByLogin(String email, String password){
		try {
			return this.userdao.requestByLogin(email,password);
		} catch (RuntimeException e) {
			return null;
		}
	}
	
	public ArrayList<User> requestAll(){
		return this.userdao.request();
	}

	public String update(User oldUser,User newUser,String column){
		User aux = requestDAOByLogin(oldUser.getEmail(),oldUser.getpassword());
		if(column.equals("email") && aux!=null){
			this.userdao.update(newUser, "email", aux.getEmail());
			return ("atualizado");
		}else if(column.equals("cpf") && aux!=null){
			this.userdao.update(newUser, "cpf", aux.getCpf());
			return ("atualizado");
		}else{
			return null;
		}
	}
	public String delete(User user){
		User aux = requestDAOByLogin(user.getEmail(),user.getpassword());
		if(aux!=null){
			this.userdao.delete("email", aux.getEmail());
			return ("removido");
		}else{
			return null;
		}
	}
}
