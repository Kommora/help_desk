package br.com.object;

public class Order {

	private Integer idOrder;
	private String idUser;
	private String idExpert;
	private String details;
	private String status;
	private String priority;
	private String problem;
	private String dateIni;
	private String dateFin;
	
	public Order(){}

	public Order(Integer idOrder, String idUser, String idExpert, String details, String status, String priority,
			String problem, String dateIni, String dateFin) {
		super();
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.idExpert = idExpert;
		this.details = details;
		this.status = status;
		this.priority = priority;
		this.problem = problem;
		this.dateIni = dateIni;
		this.dateFin = dateFin;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
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
