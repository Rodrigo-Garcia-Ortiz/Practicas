package com.akihabara.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	static final String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db";
	static final String USER = "userAkihabara";
	static final String PASSWORD = "curso";

	private Connection conexion;

	public DatabaseConnection() { //Constructor que crea una conexión con la base de datos

		try {
			// Cargar el driver de MySQL en memoria.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver cargado correctamente");
			
		} catch (ClassNotFoundException e) {

			System.out.println("Driver no encontrado: " + e.getMessage());
			return;
		}
		
        try {
			//Crea la conexión con la base de datos
			conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			System.out.println("Conexión establecida correctamente");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Error al conectarse: " + e.getMessage());
			
		}
	}
	
	public Connection getConexion() { //Devuelve la conexion creada
    	
    	return conexion;
    }
	
	public void cerrarConexion() { //Cierra la conexión actual
		
		try {
			
			conexion.close();
			
			System.out.println("Conexión cerrada correctamente");
			
		} catch (Exception e) {
			
			System.out.println("Error al cerrar la conexión: " + e.getMessage());
		}
	}
}
