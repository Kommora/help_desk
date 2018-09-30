package br.com.control;

import java.util.ArrayList;

import br.com.dao.OrderDAO;
import br.com.object.Order;

public class ControlDAOOrder {

	private OrderDAO order;



	public ControlDAOOrder() {
		this.order = new OrderDAO();
	}

	public void create(Order or){
		try {
			order.create(or); 
						
		} catch (RuntimeException e) {
			// TODO: handle exception
			
		}
	}

	public ArrayList<Order> request(){
		try {
			return order.request();
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}

	public Order request(String column, String cvalue){
		try {
			return order.request(column, cvalue);
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}

	public ArrayList<Order> request(String status){
		try {
			return order.request(status);
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}

	public String update(Order old, Order novo){
		try {
			order.update(novo, old.getIdOrder());
			return "Atualizado.";

		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}

	}
}


