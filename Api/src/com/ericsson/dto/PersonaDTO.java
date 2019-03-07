package com.ericsson.dto;

public class PersonaDTO {

	private int id_persona;
	private String nombre;
	
	public PersonaDTO(int id_persona, String nombre) {
		super();
		this.id_persona = id_persona;
		this.nombre = nombre;
	}
	
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
