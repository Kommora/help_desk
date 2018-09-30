package br.com.control;

import java.util.ArrayList;

import br.com.dao.MessageDAO;
import br.com.object.Message;

public class ControlDAOMessage {
	
	private MessageDAO message;
	
	public ControlDAOMessage() {
		this.message = new MessageDAO();
	}

	public String create(Message msg){
		try {
			message.create(msg);
			return "Mensagem enviada com sucesso.";
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public ArrayList<Message> request(){
		try {
			return message.request();
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public Message request(Message msg){
		try {
			return message.request("idOrder", msg.getIdOrder());
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public String update(String colum,String cvalue,String key,String kvalue){
		try {
			message.update(colum, cvalue, key, kvalue);
			return "Mensagem atualizada.";
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public String delete(String key, String kvalue){
		try {
			message.delete(key, kvalue);
			return "Mensagem deletada";
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
