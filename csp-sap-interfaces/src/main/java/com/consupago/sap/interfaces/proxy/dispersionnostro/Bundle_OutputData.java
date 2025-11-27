/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class Bundle_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoria;
	private String descripcion;
	private String id;
	private Producto_OutputData producto;
	



	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public Producto_OutputData getProducto() {
		return producto;
	}




	public void setProducto(Producto_OutputData producto) {
		this.producto = producto;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
