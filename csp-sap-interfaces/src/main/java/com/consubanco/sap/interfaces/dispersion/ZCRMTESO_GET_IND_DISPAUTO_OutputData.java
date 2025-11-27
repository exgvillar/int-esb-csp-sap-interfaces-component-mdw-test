/**
 * 
 */
package com.consubanco.sap.interfaces.dispersion;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_GET_IND_DISPAUTO_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean dispersionOnlineOpen = false;
	
	private Date fechaActualizacion = null;
	
	
	/**
	 * 
	 */
	public ZCRMTESO_GET_IND_DISPAUTO_OutputData() {
		super();
	}

	
	
	


	/**
	 * @return the dispersionOnlineOpen
	 */
	public boolean isDispersionOnlineOpen() {
		return dispersionOnlineOpen;
	}






	/**
	 * @param dispersionOnlineOpen the dispersionOnlineOpen to set
	 */
	public void setDispersionOnlineOpen(boolean dispersionOnlineOpen) {
		this.dispersionOnlineOpen = dispersionOnlineOpen;
	}






	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}



	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
