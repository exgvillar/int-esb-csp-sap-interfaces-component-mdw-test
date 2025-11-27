/**
 * 
 */
package com.consubanco.sap.interfaces.sic.formalization;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMSIC_E008_LISTADO_SOLFORM_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String requestId = null;
	
	private String accountId = null;
	
	private Date createDate = null;
	
	private String createTime = null;
	
	
	/**
	 * 
	 */
	public ZCRMSIC_E008_LISTADO_SOLFORM_OutputData() {
		super();
	}

	
	
	


	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}






	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}






	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}







	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}






	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
