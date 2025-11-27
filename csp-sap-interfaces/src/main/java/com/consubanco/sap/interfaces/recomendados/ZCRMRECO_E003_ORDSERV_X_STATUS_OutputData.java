package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_E003_ORDSERV_X_STATUS_OutputData implements Serializable,
	IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String message = null;
	
	private List<ORDEN_SERVICIO_Model> listServiceOrder = null;

	
	
	public ZCRMRECO_E003_ORDSERV_X_STATUS_OutputData() {
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
	 * @return the listServiceOrder
	 */
	public List<ORDEN_SERVICIO_Model> getListServiceOrder() {
		return listServiceOrder;
	}



	/**
	 * @param listServiceOrder the listServiceOrder to set
	 */
	public void setListServiceOrder(List<ORDEN_SERVICIO_Model> listServiceOrder) {
		this.listServiceOrder = listServiceOrder;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
