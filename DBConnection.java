package com.hsbc.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author NEHA BALASUBRAMANIAN
 *
 *DATABASE CONNECTIVITY AND STATEMENTS
 */

public class DBConnection {
	
		public Connection con;
		Statement st;
		PreparedStatement pst;

		public DBConnection() {
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Statement getStatement() {
			try {
				con = DriverManager.getConnection("jdbc:derby://localhost:1527/OP;create=true");
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st;
		}

		public PreparedStatement getPreparedStatement(String sql) {
			try {
				con = DriverManager.getConnection("jdbc:derby://localhost:1527/OP;create=true");
				pst = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pst;
		}
		
		
}
