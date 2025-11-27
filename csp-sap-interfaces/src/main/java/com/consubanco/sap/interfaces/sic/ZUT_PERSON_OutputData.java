/**
 * 
 */
package com.consubanco.sap.interfaces.sic;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZUT_PERSON_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String businessPartnerId = null;
	
	private String rfc = null;
	
	private String relationType = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
	
	private String position = null;
	
	private String degree = null;
	
	private String email = null;
	
	private String nss = null;
	
	private String curp = null;
	
	private ArrayList<ZUT_ADDRESS_OutputData> address = null;
	

	
	
	/**
	 * 
	 */
	public ZUT_PERSON_OutputData() {
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
	 * @return the relationType
	 */
	public String getRelationType() {
		return relationType;
	}



	/**
	 * @param relationType the relationType to set
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}



	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}



	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}



	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}



	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}



	/**
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}



	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}



	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}



	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}



	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}



	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}



	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}



	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}



	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
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
	 * @return the address
	 */
	public ArrayList<ZUT_ADDRESS_OutputData> getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(ArrayList<ZUT_ADDRESS_OutputData> address) {
		this.address = address;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
