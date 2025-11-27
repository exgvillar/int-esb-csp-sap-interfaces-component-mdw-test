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
public class ZESCRMRECO_E003_Recommender extends Persona_Model implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	private Direccion_Model direccion;
	private boolean cliente;

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
	 * @return the cliente
	 */
	public boolean isCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
