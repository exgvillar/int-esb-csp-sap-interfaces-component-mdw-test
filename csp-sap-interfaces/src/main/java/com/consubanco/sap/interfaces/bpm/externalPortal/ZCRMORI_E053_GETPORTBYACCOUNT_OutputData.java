/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.externalPortal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author consubanco
 *
 */
public class ZCRMORI_E053_GETPORTBYACCOUNT_OutputData implements
		IProxyOutputData {

	private String accountId;
	private String contract;

	public ZCRMORI_E053_GETPORTBYACCOUNT_OutputData() {
		super();
	}

	public ZCRMORI_E053_GETPORTBYACCOUNT_OutputData(String accountId,
			String contract) {
		super();
		this.accountId = accountId;
		this.contract = contract;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the contract
	 */
	public String getContract() {
		return contract;
	}

	/**
	 * @param contract
	 *            the contract to set
	 */
	public void setContract(String contract) {
		this.contract = contract;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
