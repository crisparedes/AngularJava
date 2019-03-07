package com.ericsson.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ericsson.dto.*;
import com.google.gson.Gson;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class wsRestful {

	static List<ProductoDTO> productos= new ArrayList<ProductoDTO>();

	@GET
	@Path("/productos")
	public Response getProductos() {

		Gson gson = new Gson();
		String jsonProductos = gson.toJson(productos);

		return Response.ok(jsonProductos,MediaType.APPLICATION_JSON)
				.build();
	}


	@GET
	@Path("/productos/{id_producto}")
	public Response getProducto(@PathParam("id_producto") int id_producto){
		
		Gson gson = new Gson();
		
		ProductoDTO producto = null;
		
		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getId_producto()==id_producto) {
				producto=productos.get(i);
				break;
			}
		}
		
		String jsonProductos = gson.toJson(producto);
		return Response.ok(jsonProductos,MediaType.APPLICATION_JSON)
				.build();
	}

	@POST
	@Path("/productos")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducto(String producto) {

		Gson gson = new Gson();

		productos.add(gson.fromJson(producto, ProductoDTO.class) );
		return Response.ok(producto,MediaType.APPLICATION_JSON)
				.build();
	}

	@PUT
	@Path("/productos/{id_producto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProducto(@PathParam("id_producto") int id_producto, String producto) {

		Gson gson = new Gson();
		ProductoDTO p= gson.fromJson(producto, ProductoDTO.class);
		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getId_producto()==id_producto) {
				
				productos.set(i, new ProductoDTO(id_producto,p.getDescripcion() ));

				break;
			}
		}
		return Response.ok(producto,MediaType.APPLICATION_JSON)
				.build();
	}


	@DELETE
	@Path("/productos/{id_producto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProducto(@PathParam("id_producto") int id_producto) {


		for(int i=0;i<productos.size();i++) {
			if(productos.get(i).getId_producto()==id_producto) {
				
				productos.remove(i);
				break;
			}
		}
		return Response.ok(id_producto,MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	//--vendedor--
	@GET
	@Path("/vendedor")
	public Response getVendedor() {

		List<PersonaDTO> personas= new ArrayList<PersonaDTO>();

		personas.add( new PersonaDTO(1,"Casa Instrumental"));
		personas.add( new PersonaDTO(2,"Super Bocinas"));
		personas.add( new PersonaDTO(3,"Domisol"));
		personas.add( new PersonaDTO(1,"Guatemusica"));

		Gson gson = new Gson();
		String jsonPersonas = gson.toJson(personas);

		return Response.ok(jsonPersonas,MediaType.APPLICATION_JSON).build();
	}



}