/**
 * 
 */
package com.consubanco.sap.interfaces.coi.notifications;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_DET_INFO_BP_OutputData implements Serializable,
		IProxyOutputData {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private String numeroEmpleado = null;
	
	
	/**
	 * 
	 */
	public ZRFC_DET_INFO_BP_OutputData() {
		super();
	}

	
	/**
	 * @return the numeroEmpleado
	 */
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}


	/**
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
