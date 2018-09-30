package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.object.*;

public class OrderDAO {

	private Connection con;

	public OrderDAO(){
		this.con = new ConnectionFactory().getConnection();
	}

	public void create(Order order){
		String sql = "insert into orders(idUser,idExpert,details,priority,status,problem,dateIni,dateFinal)"
				+ "values(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			//stmt.setInt(1, order.getIdOrder());
			stmt.setString(1, order.getIdUser());
			stmt.setString(2, order.getIdExpert());
			stmt.setString(3, order.getDetails());
			stmt.setString(4, order.getPriority());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getProblem());
			stmt.setString(7, order.getDateIni());
			stmt.setString(8, order.getDateFin());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Order> request(){
		try {
			String sql = "select * from orders";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Order> or = new ArrayList<>();
			while(rs.next()){
				Order order = new Order();
				order.setIdOrder(rs.getInt("idOrder"));
				order.setIdUser(rs.getString("idUser"));
				order.setIdExpert(rs.getString("idExpert"));
				order.setDetails(rs.getString("details"));
				order.setPriority(rs.getString("priority"));
				order.setStatus(rs.getString("status"));
				order.setProblem(rs.getString("problem"));
				order.setDateIni(rs.getString("dateIni"));
				order.setDateFin(rs.getString("dateFinal"));
				or.add(order);
			}
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public Order request(String column,String cvalue){
		try {
			String sql = "select * from orders where "+column+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, cvalue);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Order order = new Order();
			order.setIdOrder(rs.getInt("idOrder"));
			order.setIdUser(rs.getString("idUser"));
			order.setIdExpert(rs.getString("idExpert"));
			order.setDetails(rs.getString("details"));
			order.setPriority(rs.getString("priority"));
			order.setStatus(rs.getString("status"));
			order.setProblem(rs.getString("problem"));
			order.setDateIni(rs.getString("dateIni"));
			order.setDateFin(rs.getString("dateFin"));
			stmt.close();
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Order> request(String status){
		try {
			String sql = "select * from orders where status=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, status);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Order> or = new ArrayList<>();
			while(rs.next()){
				Order order = new Order();
				order.setIdOrder(rs.getInt("idOrder"));
				order.setIdUser(rs.getString("idUser"));
				order.setIdExpert(rs.getString("idExpert"));
				order.setDetails(rs.getString("details"));
				order.setPriority(rs.getString("priority"));
				order.setStatus(rs.getString("status"));
				order.setProblem(rs.getString("problem"));
				order.setDateIni(rs.getString("dateIni"));
				order.setDateFin(rs.getString("dateFin"));
				or.add(order);
			}
			stmt.close();
			return or;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void update(Order order, int idOrder){
		try {
			String sql = "update orders set idOrder=?,idUser=?,idExpert=?,"
					+ "details=?,priority=?,status=?,problem=?,"
					+ "dateIni=?,dateFinal=? where idOrder=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setInt(1, order.getIdOrder());
			stmt.setString(2, order.getIdUser());
			stmt.setString(3, order.getIdExpert());
			stmt.setString(4, order.getDetails());
			stmt.setString(5, order.getPriority());
			stmt.setString(6, order.getStatus());
			stmt.setString(7, order.getProblem());
			stmt.setString(8, order.getDateIni());
			stmt.setString(9, order.getDateFin());
			stmt.setInt(10, order.getIdOrder());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(String colum,String cvalue,String key,String kvalue){
		try {
			String sql = "update orders set "+colum+"=? where "+key+"=?";
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
			String sql = "delete from orders where "+key+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			//stmt.setString(1, key);
			stmt.setString(1, kvalue);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
