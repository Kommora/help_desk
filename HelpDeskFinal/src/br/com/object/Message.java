package br.com.object;

public class Message {
	
	private int idMsg;
	private String msg;
	private int idOrder;
	private String idUser;
	private String idExpert;
	private String date;
        private String remetente;
	
	public Message(){}

	public Message(int idMsg, String msg, int idOrder, String idUser, String idExpert, String date) {
		this.idMsg = idMsg;
		this.msg = msg;
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.idExpert = idExpert;
		this.date = date;
	}

	public int getIdMsg() {
		return idMsg;
	}

	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdExpert() {
		return idExpert;
	}

	public void setIdExpert(String idExpert) {
		this.idExpert = idExpert;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
        
        public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
}
