package com.bolsadeideas.springboot.web.app.models;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String email;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public String getNombre() {  return nombre;  }
	public String getApellido() {  return apellido; }
	public String getEmail() { return email; }
	
	public boolean setNombre(String nombre) {
		if (!nombre.isEmpty()) {
			this.nombre = nombre;
			return true;
		}else
			return false;
	}
	
	public boolean setApellido(String apellido) {
		if (!apellido.isEmpty()) {
			this.apellido = apellido;
			return true;
		}else
			return false;
	}
	
	public boolean setEmail(String email) {
		if (!email.isEmpty()) {
			this.email = email;
			return true;
		}else
			return false;
	}
	

}
