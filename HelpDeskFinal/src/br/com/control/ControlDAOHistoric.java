package br.com.control;

import java.util.ArrayList;

import br.com.dao.HistoricDAO;
import br.com.object.Historic;

public class ControlDAOHistoric {
	
	private HistoricDAO historic;

	
	public String create(Historic h){
		try {
			historic.create(h);
			return "Historico adicionado";
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public ArrayList<Historic> request(){
		try {
			return historic.request();
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public ArrayList<Historic> request(String column,String cvalue){
		try {
			return historic.request(column, cvalue);
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public String update(Historic oldHist, Historic newHist, String column){
		try {
			switch (column) {
			case "log":
				String log = historic.request(oldHist.getIdHistoric());
				if(log == null){
					return log;
				}else{
					historic.update("log", log+newHist.getLog(), "idHistoric", oldHist.getIdHistoric());
					return "Historico atualizado.";
				}
			case "idExpert":
				historic.update("idExpert", newHist.getIdExpert(), "idHistoric", oldHist.getIdHistoric());
				return "Historico atualizado.";
			}
			return null;
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public String delete(String key, String kvalue){
		try {
			historic.delete(key, kvalue);
			return "Historico deletado";
		} catch (RuntimeException e) {
			// TODO: handle exception
			return null;
		}
		
	}
}
