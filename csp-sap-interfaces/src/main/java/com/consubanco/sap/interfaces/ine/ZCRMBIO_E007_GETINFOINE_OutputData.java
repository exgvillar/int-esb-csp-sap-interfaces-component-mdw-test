package com.consubanco.sap.interfaces.ine;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMBIO_E007_GETINFOINE_OutputData implements Serializable, IProxyOutputData{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7116852167122148665L;

	
	private String message;
	private boolean success;
	private ZMInfoINE infoIne;
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
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	/**
	 * @return the infoIne
	 */
	public ZMInfoINE getInfoIne() {
		return infoIne;
	}
	/**
	 * @param infoIne the infoIne to set
	 */
	public void setInfoIne(ZMInfoINE infoIne) {
		this.infoIne = infoIne;
	}
}
