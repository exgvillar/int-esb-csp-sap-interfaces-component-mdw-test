/**
 * 
 */
package com.consubanco.sap.interfaces.bt.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZESCRMBT_E002_INCIDENCIAS_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3658252031347301828L;

	private int idIncidencia;
	private String idSolicitud;
	private String idCausa;
	private String idMotivo;
	private String descInt;
	private String descExt;
	private String phone;

	/**
	 * @return the idIncidencia
	 */
	public int getIdIncidencia() {
		return idIncidencia;
	}

	/**
	 * @param idIncidencia
	 *            the idIncidencia to set
	 */
	public void setIdIncidencia(int idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud
	 *            the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	/**
	 * @return the idCausa
	 */
	public String getIdCausa() {
		return idCausa;
	}

	/**
	 * @param idCausa
	 *            the idCausa to set
	 */
	public void setIdCausa(String idCausa) {
		this.idCausa = idCausa;
	}

	/**
	 * @return the idMotivo
	 */
	public String getIdMotivo() {
		return idMotivo;
	}

	/**
	 * @param idMotivo
	 *            the idMotivo to set
	 */
	public void setIdMotivo(String idMotivo) {
		this.idMotivo = idMotivo;
	}

	/**
	 * @return the descInt
	 */
	public String getDescInt() {
		return descInt;
	}

	/**
	 * @param descInt
	 *            the descInt to set
	 */
	public void setDescInt(String descInt) {
		this.descInt = descInt;
	}

	/**
	 * @return the descExt
	 */
	public String getDescExt() {
		return descExt;
	}

	/**
	 * @param descExt
	 *            the descExt to set
	 */
	public void setDescExt(String descExt) {
		this.descExt = descExt;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
