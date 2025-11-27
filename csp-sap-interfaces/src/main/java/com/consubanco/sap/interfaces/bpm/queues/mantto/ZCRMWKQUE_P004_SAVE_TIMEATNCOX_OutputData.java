/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String businessPartner = null;
	
	private ArrayList<String> convenioIdList = null;
	
	private String productCategoryId = null;
	
	private String sourceChannelId = null;
	
	private String sourceChannelDesc = null;
	
	private int attentionTime = 0;
	
	private String user = null;
	
	private boolean delete = false;

	private boolean result = false;
	
	private String message = null;
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData() {
		super();
	}
	
	/**
	 * @return the businessPartner
	 */
	public String getBusinessPartner() {
		return businessPartner;
	}

	/**
	 * @param businessPartner the businessPartner to set
	 */
	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	/**
	 * @return the convenioIdList
	 */
	public ArrayList<String> getConvenioIdList() {
		return convenioIdList;
	}

	/**
	 * @param convenioIdList the convenioIdList to set
	 */
	public void setConvenioIdList(ArrayList<String> convenioIdList) {
		this.convenioIdList = convenioIdList;
	}

	/**
	 * @return the productCategoryId
	 */
	public String getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * @param productCategoryId the productCategoryId to set
	 */
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	/**
	 * @return the sourceChannelId
	 */
	public String getSourceChannelId() {
		return sourceChannelId;
	}

	/**
	 * @param sourceChannelId the sourceChannelId to set
	 */
	public void setSourceChannelId(String sourceChannelId) {
		this.sourceChannelId = sourceChannelId;
	}

	/**
	 * @return the sourceChannelDesc
	 */
	public String getSourceChannelDesc() {
		return sourceChannelDesc;
	}

	/**
	 * @param sourceChannelDesc the sourceChannelDesc to set
	 */
	public void setSourceChannelDesc(String sourceChannelDesc) {
		this.sourceChannelDesc = sourceChannelDesc;
	}

	/**
	 * @return the attentionTime
	 */
	public int getAttentionTime() {
		return attentionTime;
	}

	/**
	 * @param attentionTime the attentionTime to set
	 */
	public void setAttentionTime(int attentionTime) {
		this.attentionTime = attentionTime;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the delete
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
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
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
