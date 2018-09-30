package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    return DriverManager.getConnection("jdbc:mysql://localhost/helpdesk","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}

}
