package com.consupago.sap.interfaces.proxy.dispersionnostro.lcom;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMLCOM_E002_READLCOM_XSTATUS_OutputData implements
IProxyOutputData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Solicitudes_OutputData> solicitudList;
	private String messageError;



	



	public ArrayList<Solicitudes_OutputData> getSolicitudList() {
		return solicitudList;
	}







	public void setSolicitudList(ArrayList<Solicitudes_OutputData> solicitudList) {
		this.solicitudList = solicitudList;
	}







	public String getMessageError() {
		return messageError;
	}







	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}







	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
