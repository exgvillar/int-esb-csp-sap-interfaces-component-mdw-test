/**
 * 
 */
package com.consupago.sap.interfaces.proxy.calendar;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private Date fechaCalculada = null;
	
	
	
	/**
	 * 
	 */
	public Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData() {
		super();
	}

	
	


	/**
	 * @return the fechaCalculada
	 */
	public Date getFechaCalculada() {
		return fechaCalculada;
	}





	/**
	 * @param fechaCalculada the fechaCalculada to set
	 */
	public void setFechaCalculada(Date fechaCalculada) {
		this.fechaCalculada = fechaCalculada;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
