/**
 * 
 */
package com.consubanco.sap.interfaces.debitsLetter;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMORI_E049_GETACCOUNTSBYAPP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String accountId = null;
	
	private boolean cnca = false;
	
	private boolean intercompany = false;

	public ZCRMORI_E049_GETACCOUNTSBYAPP_OutputData(){
		
	}
	

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}


	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	/**
	 * @return the cnca
	 */
	public boolean isCnca() {
		return cnca;
	}


	/**
	 * @param cnca the cnca to set
	 */
	public void setCnca(boolean cnca) {
		this.cnca = cnca;
	}


	/**
	 * @return the intercompany
	 */
	public boolean isIntercompany() {
		return intercompany;
	}


	/**
	 * @param intercompany the intercompany to set
	 */
	public void setIntercompany(boolean intercompany) {
		this.intercompany = intercompany;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
