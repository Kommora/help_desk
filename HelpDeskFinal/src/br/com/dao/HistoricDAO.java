package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.object.*;

public class HistoricDAO {

	private Connection con;

	public HistoricDAO(){
		this.con = new ConnectionFactory().getConnection();
	}

	public void create(Historic h){
		String sql = "insert into historic(idHistoric,idOrder,idUser,idExpert,"
				+ "log,dateIni,dateFin)"
				+ "values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, h.getIdHistoric());
			stmt.setInt(2, h.getIdOrder());
			stmt.setString(3, h.getIdUser());
			stmt.setString(4, h.getIdExpert());
			stmt.setString(5, h.getLog());
			stmt.setString(6, h.getDateIni());
			stmt.setString(7, h.getDateFin());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Historic> request(){
		try {
			String sql = "select * from historic";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Historic> or = new ArrayList<>();
			while(rs.next()){
				Historic h = new Historic();
				h.setIdHistoric(rs.getInt("idHistoric"));
				h.setIdOrder(rs.getInt("idOrder"));
				h.setIdUser(rs.getString("idUser"));
				h.setIdExpert(rs.getString("idExpert"));
				h.setLog(rs.getString("log"));
				h.setDateIni(rs.getString("dateIni"));
				h.setDateFin(rs.getString("dateFin"));
				or.add(h);
			}
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Historic> request(String column,String cvalue){
		try {
			String sql = "select * from historic where "+column+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, cvalue);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Historic> or = new ArrayList<>();
			while(rs.next()){
				Historic h = new Historic();
				h.setIdHistoric(rs.getInt("idHistoric"));
				h.setIdOrder(rs.getInt("idOrder"));
				h.setIdUser(rs.getString("idUser"));
				h.setIdExpert(rs.getString("idExpert"));
				h.setLog(rs.getString("log"));
				h.setDateIni(rs.getString("dateIni"));
				h.setDateFin(rs.getString("dateFin"));
				or.add(h);
			}
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public String request(int cvalue){
		try {
			String sql = "select log from historic where idHistoric=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, cvalue);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String or = rs.getString("log");
			
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void update(String colum,String cvalue,String key,int kvalue){
		try {
			String sql = "update historic set "+colum+"=? where "+key+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, cvalue);
			stmt.setInt(2, kvalue);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String key,String kvalue){
		try {
			String sql = "delete from historic where "+key+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, kvalue);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
