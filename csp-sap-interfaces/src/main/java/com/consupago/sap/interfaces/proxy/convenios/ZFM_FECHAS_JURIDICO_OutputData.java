/**
 * 
 */
package com.consupago.sap.interfaces.proxy.convenios;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZFM_FECHAS_JURIDICO_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private Date fechaSuscripcion = null;
	
	private Date fechaTermino= null;
	
	/**
* 
*/
	public ZFM_FECHAS_JURIDICO_OutputData() {
		super();
	}

	


	/**
	 * @return the fechaSuscripcion
	 */
	public Date getFechaSuscripcion() {
		return fechaSuscripcion;
	}




	/**
	 * @param fechaSuscripcion the fechaSuscripcion to set
	 */
	public void setFechaSuscripcion(Date fechaSuscripcion) {
		this.fechaSuscripcion = fechaSuscripcion;
	}




	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}




	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
