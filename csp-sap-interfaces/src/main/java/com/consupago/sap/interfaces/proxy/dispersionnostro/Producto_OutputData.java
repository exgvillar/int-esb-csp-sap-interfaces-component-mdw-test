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
public class Producto_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoria;
	private String comisAperImp;
	private String comisAperCiento;
	private String descripcion;
	private String montoMax;
	private String montoMin;
	private String id;
	private String flagAutenticaCc;
	private String codigoBrms;
	
	
	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getComisAperImp() {
		return comisAperImp;
	}


	public void setComisAperImp(String comisAperImp) {
		this.comisAperImp = comisAperImp;
	}


	public String getComisAperCiento() {
		return comisAperCiento;
	}


	public void setComisAperCiento(String comisAperCiento) {
		this.comisAperCiento = comisAperCiento;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMontoMax() {
		return montoMax;
	}


	public void setMontoMax(String montoMax) {
		this.montoMax = montoMax;
	}


	public String getMontoMin() {
		return montoMin;
	}


	public void setMontoMin(String montoMin) {
		this.montoMin = montoMin;
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


	public String getFlagAutenticaCc() {
		return flagAutenticaCc;
	}


	public void setFlagAutenticaCc(String flagAutenticaCc) {
		this.flagAutenticaCc = flagAutenticaCc;
	}


	public String getCodigoBrms() {
		return codigoBrms;
	}


	public void setCodigoBrms(String codigoBrms) {
		this.codigoBrms = codigoBrms;
	}
	
}
