package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.object.*;

public class MessageDAO {
	
	private Connection con;

	public MessageDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void create(Message m){
		String sql = "insert into message(idMsg,msg,idOrder,idUser,idExpert,"
				+ "date,remetente)"
				+ "values(?,?,?,?,?,?);";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, m.getIdMsg());
			stmt.setString(2, m.getMsg());
			stmt.setInt(3, m.getIdOrder());
			stmt.setString(4, m.getIdUser());
			stmt.setString(5, m.getIdExpert());
			stmt.setString(6, m.getDate());
                        stmt.setString(7, m.getRemetente());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Message> request(){
		try {
			String sql = "select * from message";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Message> or = new ArrayList<>();
			while(rs.next()){
				Message m = new Message();
				m.setIdMsg(rs.getInt("idMsg"));
				m.setMsg(rs.getString("msg"));
				m.setIdOrder(rs.getInt("idOrder"));
				m.setIdUser(rs.getString("idUser"));
				m.setIdExpert(rs.getString("idExpert"));
				m.setDate(rs.getString("date"));
                                m.setRemetente(rs.getString("remetente"));
				or.add(m);
			}
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public Message request(String column,int cvalue){
		try {
			String sql = "select msg from message where "+column+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, cvalue);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Message m = new Message();
			m.setIdMsg(rs.getInt("idMsg"));
			m.setMsg(rs.getString("msg"));
			m.setIdOrder(rs.getInt("idOrder"));
			m.setIdUser(rs.getString("idUser"));
			m.setIdExpert(rs.getString("idExpert"));
			m.setDate(rs.getString("date"));
			stmt.close();
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public void update(String colum,String cvalue,String key,String kvalue){
		try {
			String sql = "update message set "+colum+"=? where "+key+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, cvalue);
			stmt.setString(2, kvalue);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String key,String kvalue){
		try {
			String sql = "delete from message where "+key+"=?";
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
