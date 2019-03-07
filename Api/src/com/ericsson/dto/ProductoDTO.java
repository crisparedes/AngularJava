package com.ericsson.dto;

public class ProductoDTO {

	private int id_producto;
	private String descripcion;
	
	public ProductoDTO(int id_producto, String descripcion) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
	}
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
