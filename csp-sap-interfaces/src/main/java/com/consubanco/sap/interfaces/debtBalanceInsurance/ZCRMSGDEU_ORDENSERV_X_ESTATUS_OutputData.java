/**
 * 
 */
package com.consubanco.sap.interfaces.debtBalanceInsurance;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.debtBalanceInsurance.model.ZTL_SSD_APP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMSGDEU_ORDENSERV_X_ESTATUS_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5733394777292678952L;

	private ArrayList<ZTL_SSD_APP_Model> ssdApplicationsList;
	
	private String messages = null;
	
	/**
	 * 
	 */
	public ZCRMSGDEU_ORDENSERV_X_ESTATUS_OutputData() {
		super();
	}

	/**
	 * @return the ssdApplicationsList
	 */
	public ArrayList<ZTL_SSD_APP_Model> getSsdApplicationsList() {
		return ssdApplicationsList;
	}

	/**
	 * @param ssdApplicationsList the ssdApplicationsList to set
	 */
	public void setSsdApplicationsList(
			ArrayList<ZTL_SSD_APP_Model> ssdApplicationsList) {
		this.ssdApplicationsList = ssdApplicationsList;
	}

	/**
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
