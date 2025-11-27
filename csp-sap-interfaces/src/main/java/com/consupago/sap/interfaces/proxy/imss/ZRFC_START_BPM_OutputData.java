/**
 * 
 */
package com.consupago.sap.interfaces.proxy.imss;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_START_BPM_OutputData implements Serializable,
		IProxyOutputData {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6034065064168095639L;

	private String folioSolicitud = null;
	
	private String idCliente = null;

		
	/**
* 
*/
	public ZRFC_START_BPM_OutputData() {
		super();
	}

	
	
	/**
	 * @return the folioSolicitud
	 */
	public String getFolioSolicitud() {
		return folioSolicitud;
	}



	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}



	/**
	 * @return the idCliente
	 */
	public String getIdCliente() {
		return idCliente;
	}



	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
