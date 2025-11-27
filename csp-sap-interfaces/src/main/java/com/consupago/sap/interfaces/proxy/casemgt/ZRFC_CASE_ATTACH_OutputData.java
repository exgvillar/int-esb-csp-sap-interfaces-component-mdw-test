/**
 * 
 */
package com.consupago.sap.interfaces.proxy.casemgt;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_CASE_ATTACH_OutputData implements Serializable,
		IProxyOutputData {

	/**
	* 
	*/
	private static final long serialVersionUID = 8153413843042941014L;

	private String caseId = null;
	
	private String guid = null;
	
	private String createdDate = null;
	
	private String createdBy = null;
	
	private String updatedDate = null;
	
	private String updatedBy = null;
	
	private String name = null;
	
	private String description = null;
	

	/**
* 
*/
	public ZRFC_CASE_ATTACH_OutputData() {
		super();
	}

	
	


	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}





	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	



	/**
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}





	/**
	 * @param guid the guid to set
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}





	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}





	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}





	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}





	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}





	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}





	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}





	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}





	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}





	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}





	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}





	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}





	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
