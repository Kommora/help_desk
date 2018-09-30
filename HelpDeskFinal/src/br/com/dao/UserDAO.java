package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.object.*;

public class UserDAO {

	private Connection con;

	public UserDAO(){
		this.con = new ConnectionFactory().getConnection();
	}
	public void create(User user){
		String sql = "insert into Users(cpf,name,email,password,level,phone)values(?,?,?,?,?,?);";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, user.getCpf());
			stmt.setString(2, user.getname());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getpassword());
			stmt.setString(5, user.getlevel());
			stmt.setString(6, user.getPhone());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {/*
			if(e.getMessage().startsWith("Duplicate")){
				String[] a = new String[5];
				a=e.getMessage().split(" ");
				if(e.getMessage().endsWith("'PRIMARY'")){
					throw new RuntimeException("cpf "+a[2].replaceAll("'", "")+" ja existente");
				}else{
					throw new RuntimeException(a[5].replaceAll("'", "")+" "+a[2].replaceAll("'", "")+" ja existente ");
				}
			}else if(e.getMessage().endsWith("cannot be null")){
				String[] a = new String[5];
				a=e.getMessage().split(" ");
				throw new RuntimeException(a[1].replaceAll("'", "")+" nao pode ser nulo");
			}*/
			throw new RuntimeException(e.getMessage());
		}
	}
	public  ArrayList<User> request(){
		String sql="Select * from Users";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<User> al = new ArrayList<>();
			while(rs.next()){
				User user = new User();
				user.setCpf(rs.getString("cpf"));
				user.setname(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setpassword(rs.getString("password"));
				user.setlevel(rs.getString("level"));
				user.setPhone(rs.getString("phone"));
				al.add(user);
			}
			stmt.close();
			rs.close();
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
	public User requestByLogin(String email,String password){
		String sql="Select * from Users where email=? and password=?";
		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			User user = new User();
			user.setCpf(rs.getString("cpf"));
			user.setname(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setpassword(rs.getString("password"));
			user.setlevel(rs.getString("level"));
			user.setPhone(rs.getString("phone"));
			stmt.close();
			rs.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
	public void update(User newUser,String column,String value){
		try {
			String sql = "update users set cpf=?,name=?,email=?,"
					+ "password=?,level=?,phone=? where "+column+"=?";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			stmt.setString(1, newUser.getCpf());
			stmt.setString(2, newUser.getname());
			stmt.setString(3, newUser.getEmail());
			stmt.setString(4, newUser.getpassword());
			stmt.setString(5, newUser.getlevel());
			stmt.setString(6, newUser.getPhone());
			stmt.setString(7, value);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String column,String cvalue,String key,String kvalue){
		try {
			String sql = "update users set "+column+"=? where "+key+"=?";
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
			String sql = "delete from users where "+key+"=?;";
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
