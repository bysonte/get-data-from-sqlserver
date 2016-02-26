package com.bysonte.DAO;

import java.util.ArrayList;
import java.util.List;

import com.bysonte.DTO.Persona;
import com.bysonte.sql.server.MSSqlManager;

public class GetPersonasDAO {
	public static String connectionString = "jdbc:sqlserver://192.168.1.58:4545;databaseName=adt_test";
	public static String username = "testadt";
	public static String passwd = "123456";

	public void getPersonasFromSQLDB(){
		List<Persona> persona = new ArrayList<Persona>();
		
		MSSqlManager mssqlmanager = new MSSqlManager(connectionString, username, passwd);
	
		persona = mssqlmanager.executeTraerPersonas();
		
		for (Persona persona2 : persona) {
			System.out.println(persona2);
		}
	}
	
	public static void main(String [] args) {
		GetPersonasDAO per = new GetPersonasDAO();
		per.getPersonasFromSQLDB();
	}
}
