/**
 * 
 */
package com.consubanco.sap.interfaces.sic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.sic.model.ZFM_SIC_CONVENIOS_MOVS_model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_SIC_CONVENIOS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String agreementId = null;
	
	private String agreementDesc = null;
	
	private String installationType = null;
	
	private ArrayList<String> movementTypes = null;
	
	private boolean isLocked = false;
	
	private Date startDate = null;
	
	private Date endDate = null;
	
	private String consolidationFileType = null;
	
	private ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes = null;
 	
	
	
	/**
	 * 
	 */
	public ZFM_SIC_CONVENIOS_OutputData() {
		super();
	}

	
	

	/**
	 * @return the agreementId
	 */
	public String getAgreementId() {
		return agreementId;
	}




	/**
	 * @param agreementId the agreementId to set
	 */
	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}




	/**
	 * @return the agreementDesc
	 */
	public String getAgreementDesc() {
		return agreementDesc;
	}




	/**
	 * @param agreementDesc the agreementDesc to set
	 */
	public void setAgreementDesc(String agreementDesc) {
		this.agreementDesc = agreementDesc;
	}




	/**
	 * @return the installationType
	 */
	public String getInstallationType() {
		return installationType;
	}




	/**
	 * @param installationType the installationType to set
	 */
	public void setInstallationType(String installationType) {
		this.installationType = installationType;
	}




	/**
	 * @return the movementTypes
	 */
	public ArrayList<String> getMovementTypes() {
		return movementTypes;
	}




	/**
	 * @param movementTypes the movementTypes to set
	 */
	public void setMovementTypes(ArrayList<String> movementTypes) {
		this.movementTypes = movementTypes;
	}




	/**
	 * @return the isLocked
	 */
	public boolean isLocked() {
		return isLocked;
	}




	/**
	 * @param isLocked the isLocked to set
	 */
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}




	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}




	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}




	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}





	/**
	 * @return the consolidationFileType
	 */
	public String getConsolidationFileType() {
		return consolidationFileType;
	}




	/**
	 * @param consolidationFileType the consolidationFileType to set
	 */
	public void setConsolidationFileType(String consolidationFileType) {
		this.consolidationFileType = consolidationFileType;
	}




	/**
	 * @return the attributes
	 */
	public ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> getAttributes() {
		return attributes;
	}




	/**
	 * @param attibutes the attributes to set
	 */
	public void setAttibutes(ArrayList<ZFM_SIC_CONVENIOS_MOVS_model> attributes) {
		this.attributes = attributes;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
