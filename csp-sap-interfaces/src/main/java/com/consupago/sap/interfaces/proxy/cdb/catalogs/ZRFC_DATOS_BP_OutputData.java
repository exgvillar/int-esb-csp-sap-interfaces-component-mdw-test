/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_DATOS_BP_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	
	private String businessPartnerId = null;
	
	private String firstName = null;
	
	private String secondName = null;
	
	private String lastName = null;
	
	private String maidenName = null;
	
	private Date birthDate = null;
	
	private String rfc = null;
	
	private String curp = null;
	
	private String ife = null;
	
	private String text = null;

	
	
	
	/**
	 * 
	 */
	public ZRFC_DATOS_BP_OutputData() {
		super();
	}

	
	

	/**
	 * @return the businessPartnerId
	 */
	public String getBusinessPartnerId() {
		return businessPartnerId;
	}




	/**
	 * @param businessPartnerId the businessPartnerId to set
	 */
	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}




	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}




	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @return the maidenName
	 */
	public String getMaidenName() {
		return maidenName;
	}




	/**
	 * @param maidenName the maidenName to set
	 */
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}




	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}




	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}




	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}




	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}




	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}




	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}




	/**
	 * @return the ife
	 */
	public String getIfe() {
		return ife;
	}




	/**
	 * @param ife the ife to set
	 */
	public void setIfe(String ife) {
		this.ife = ife;
	}




	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}




	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
