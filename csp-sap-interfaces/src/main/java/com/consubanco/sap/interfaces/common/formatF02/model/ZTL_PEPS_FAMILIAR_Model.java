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
public class ZTL_PEPS_FAMILIAR_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

	private String nombre = null;
	
	private String ocupacion = null;
	
	private String estadoRadica = null;
	
	
	/**
	 * 
	 */
	public ZTL_PEPS_FAMILIAR_Model() {
		super();
	}

	
	


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}





	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	/**
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}





	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}





	/**
	 * @return the estadoRadica
	 */
	public String getEstadoRadica() {
		return estadoRadica;
	}





	/**
	 * @param estadoRadica the estadoRadica to set
	 */
	public void setEstadoRadica(String estadoRadica) {
		this.estadoRadica = estadoRadica;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
