package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMTESO_GENERIC_OutputData implements Serializable, IProxyOutputData {
	private static final long serialVersionUID = 7389110210935581517L;
	private String eMessage;

	public String geteMessage() {
		return eMessage;
	}

	public void seteMessage(String eMessage) {
		this.eMessage = eMessage;
	}
}
