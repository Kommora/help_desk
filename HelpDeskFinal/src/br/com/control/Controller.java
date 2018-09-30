package br.com.control;

import java.util.ArrayList;

import br.com.object.Historic;
import br.com.object.Message;
import br.com.object.Order;
import br.com.object.User;

@SuppressWarnings("all")
public class Controller {
	
	private ControlDAOOrder order;
	private ControllerDAOUser user;
	private ControlDAOMessage msg;
	private ControlDAOHistoric hist;
	
	public Controller() {
		this.order = new ControlDAOOrder();
		this.user = new ControllerDAOUser();
		this.msg = new ControlDAOMessage();
		this.hist = new ControlDAOHistoric();
	}
	
	public void createUser(User u){
		String aux = user.insertDAO(u);
		if(aux == null){
			System.out.println("deu merda.");
		}else if(aux.equals("tipo de usuario invalido")){
				System.out.println(aux);
		}else{
			System.out.println("Cadastrado.");
		}
	}
	
	public User loginUser(String email, String password){
            return user.requestDAOByLogin(email,password);
	}
	
	public ArrayList<User> allUser(){
		return user.requestAll();
	}
	
	public void updateUser(User u, User novo, String column){
		if(user.update(u, novo, column).equals("atualizado")){
			System.out.println("Atualizado.");
		}else{
			System.out.println("Não atualizado.");
		}
	}
	
	public void createOrder(Order o){
		order.create(o);
		
	}
	
	public ArrayList<Order> allOrder(){
		return order.request();
	}
	
	public ArrayList<Order> orderByStatus(String status){
		return order.request(status);
	}
	
	public Order requestOrder(String column, String cvalue){
		return order.request(column, cvalue);
	}
	
	public void updateOrder(Order o, Order novo, String column){
		String aux = order.update(o, novo);
		if(aux.equals("Atualizado")){
			System.out.println(aux);
		}else{
			System.out.println("Não atualizado.");
		}
	}
	
	
	public void createMsg(Message m){
		String aux = msg.create(m);
		if(aux == null){
			System.out.println("Mensagem não enviada.");
		}else{
			System.out.println("Mensagem enviada.");
		}
	}
	
	public ArrayList<Message> allMsg(){
		return msg.request();
	}
	
	public Message requestMsg(Message m){
		return msg.request(m);
	}
	
	
	public void createHist(Historic h){
		String aux = hist.create(h);
		if(aux == null){
			System.out.println("deu merda.");
		}else{
			System.out.println(aux);
		}
	}
	
	public ArrayList<Historic> allHist(){
		return hist.request();
	}

	public ArrayList<Historic> requestHist(String column, String cvalue){
		return hist.request(column, cvalue);
	}
	
	public void updateHist(Historic h, Historic novo, String column){
		String aux = hist.update(h, novo, column);
		if(aux == null){
			System.out.println("Não atualizado.");
		}else{
			System.out.println(aux);
		}
	}
	
	

}
