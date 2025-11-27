/**
 * 
 */
package com.consubanco.sap.interfaces.common.formatF02.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_PEPS_INGRESO_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

	private String cveIngreso = null;
	
	private String descIngreso = null;
	
	/*
	 * sí es C entonces es checknox y mandar X (SI)/ "" (NO
	 * sí es S es string
	 */
	private String tipoValor = null;
	
	private String valor = null;
	
	
	/**
	 * 
	 */
	public ZTL_PEPS_INGRESO_Model() {
		super();
	}

	
	

	/**
	 * @return the cveIngreso
	 */
	public String getCveIngreso() {
		return cveIngreso;
	}




	/**
	 * @param cveIngreso the cveIngreso to set
	 */
	public void setCveIngreso(String cveIngreso) {
		this.cveIngreso = cveIngreso;
	}




	/**
	 * @return the descIngreso
	 */
	public String getDescIngreso() {
		return descIngreso;
	}




	/**
	 * @param descIngreso the descIngreso to set
	 */
	public void setDescIngreso(String descIngreso) {
		this.descIngreso = descIngreso;
	}




	/**
	 * @return the tipoValor
	 */
	public String getTipoValor() {
		return tipoValor;
	}




	/**
	 * @param tipoValor the tipoValor to set
	 */
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}




	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}




	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
