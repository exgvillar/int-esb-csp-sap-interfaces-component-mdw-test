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
public class Convenio_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Bundle_OutputData bundle;
	private String categoria;
	private String descripcion;
	private String id;
	private String codigoBrms;
	


	public Bundle_OutputData getBundle() {
		return bundle;
	}



	public void setBundle(Bundle_OutputData bundle) {
		this.bundle = bundle;
	}



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



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}



	public String getCodigoBrms() {
		return codigoBrms;
	}



	public void setCodigoBrms(String codigoBrms) {
		this.codigoBrms = codigoBrms;
	}
	
}
