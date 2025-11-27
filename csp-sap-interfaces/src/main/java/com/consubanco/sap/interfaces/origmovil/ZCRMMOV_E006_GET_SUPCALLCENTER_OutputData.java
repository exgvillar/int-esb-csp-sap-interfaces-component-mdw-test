/**
 * 
 */
package com.consubanco.sap.interfaces.origmovil;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 * 
 */
public class ZCRMMOV_E006_GET_SUPCALLCENTER_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private Date fechaInicio = null;

	private Date fechaFin = null;

	private String bpId = null;

	private String nombre = null;

	/**
	 * 
	 */
	public ZCRMMOV_E006_GET_SUPCALLCENTER_OutputData() {
		super();
	}

	

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}



	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}



	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}



	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
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



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
