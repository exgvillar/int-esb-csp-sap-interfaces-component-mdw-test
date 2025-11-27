package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMETET_P001_PROC_600_OutputMessage implements Serializable,
		IProxyOutputData {

	private static final long serialVersionUID = -9205917597000139997L;
	private String zidSol;
	private String zMessage;
	private boolean zInd;

	public String getZidSol() {
		return zidSol;
	}

	public void setZidSol(String zidSol) {
		this.zidSol = zidSol;
	}

	public String getzMessage() {
		return zMessage;
	}

	public void setzMessage(String zMessage) {
		this.zMessage = zMessage;
	}

	public boolean iszInd() {
		return zInd;
	}

	public void setzInd(boolean zInd) {
		this.zInd = zInd;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
