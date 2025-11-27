/**
 * 
 */
package com.consubanco.sap.interfaces.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class ZESCRMRECO_E003_Recommended extends Persona_Model implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	private Direccion_Model direccion;
	private String solcotizacion;
	private String claveConvenio;
	private String descConvenio;

	/**
	 * @return the direccion
	 */
	public Direccion_Model getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(Direccion_Model direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the solcotizacion
	 */
	public String getSolcotizacion() {
		return solcotizacion;
	}

	/**
	 * @param solcotizacion
	 *            the solcotizacion to set
	 */
	public void setSolcotizacion(String solcotizacion) {
		this.solcotizacion = solcotizacion;
	}

	/**
	 * @return the claveConvenio
	 */
	public String getClaveConvenio() {
		return claveConvenio;
	}

	/**
	 * @param claveConvenio
	 *            the claveConvenio to set
	 */
	public void setClaveConvenio(String claveConvenio) {
		this.claveConvenio = claveConvenio;
	}

	/**
	 * @return the descConvenio
	 */
	public String getDescConvenio() {
		return descConvenio;
	}

	/**
	 * @param descConvenio
	 *            the descConvenio to set
	 */
	public void setDescConvenio(String descConvenio) {
		this.descConvenio = descConvenio;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
