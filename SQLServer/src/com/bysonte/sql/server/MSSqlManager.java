package com.bysonte.sql.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bysonte.DTO.Persona;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class MSSqlManager {
	
	Connection connection = null;
	String url = "";
	String username = "";
	String password = "";

	public MSSqlManager(String connectionstring, String username, String password) {
		this.url = connectionstring;
		this.username = username;
		this.password = password;
	}

	public Connection openMSSQLConnection() {
		Connection conn = null;
		printVersion();
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver); 
			
			conn = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (Exception ex) {
			System.out.println("Connection Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		return conn;
	}

	public List<Persona> executeTraerPersonas(){
		List<Persona> listPersonas = new ArrayList<Persona>();
		Statement stmt = null;
		String query = "select * from dbo.datos";
		try{
			connection = openMSSQLConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				listPersonas.add(new Persona(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad")));
			}
			return listPersonas;
		}catch(SQLException  e){
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}finally{
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	private void printVersion() {
		SQLServerDriver drv = new SQLServerDriver(); 
		System.out.println("SQL Server Driver version:" + drv.getMajorVersion() + "." + drv.getMinorVersion());
	}
}

