package br.com.object;

public class Historic {
	
	private int idHistoric;
	private int idOrder;
	private String idUser;
	private String idExpert;
	private String log;
	private String dateIni;
	private String dateFin;
	
	public Historic(){}

	public Historic(int idHistoric, int idOrder, String idUser, String idExpert, String log, String dateIni,String dateFin) {
		this.idHistoric = idHistoric;
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.idExpert = idExpert;
		this.log = log;
		this.dateIni = dateIni;
		this.dateFin = dateFin;
	}

	public int getIdHistoric() {
		return idHistoric;
	}

	public void setIdHistoric(int idHistoric) {
		this.idHistoric = idHistoric;
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

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getDateIni() {
		return dateIni;
	}

	public void setDateIni(String dateIni) {
		this.dateIni = dateIni;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
}
