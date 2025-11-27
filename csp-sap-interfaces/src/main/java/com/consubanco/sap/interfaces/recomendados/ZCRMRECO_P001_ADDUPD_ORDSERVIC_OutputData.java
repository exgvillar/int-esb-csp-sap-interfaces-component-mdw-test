package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData implements Serializable,
	IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String message = null;
	
	private List<ORDEN_SERVICIO_Model> ordenServicioList = null;
	
	
	
	public ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData() {
		super();
	}

	

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}



	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



	/**
	 * @return the ordenServicioList
	 */
	public List<ORDEN_SERVICIO_Model> getOrdenServicioList() {
		return ordenServicioList;
	}



	/**
	 * @param ordenServicioList the ordenServicioList to set
	 */
	public void setOrdenServicioList(List<ORDEN_SERVICIO_Model> ordenServicioList) {
		this.ordenServicioList = ordenServicioList;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
