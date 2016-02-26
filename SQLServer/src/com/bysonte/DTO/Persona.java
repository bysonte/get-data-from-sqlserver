package com.bysonte.DTO;

public class Persona {
	private String nombre = "";
	private String apellido = "";
	private int edad = 0;
	
	public Persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString(){
		StringBuffer toString = new StringBuffer();
		toString.append("Nombre: ").append(this.nombre).append(" Apellido: ").append(this.apellido).append(" Edad: ").append(this.edad);
		
		return toString.toString();
	}
}
