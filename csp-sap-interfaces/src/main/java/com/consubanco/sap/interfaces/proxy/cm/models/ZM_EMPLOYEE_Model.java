/**
 * 
 */
package com.consubanco.sap.interfaces.proxy.cm.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZM_EMPLOYEE_Model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String businessPartner = null;
	
	private boolean responsibleEmployee = false;
	
	private String position = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;

	private String rfc = null;
	
	private String personalNumber = null;
	
	private ArrayList<ZM_AMOUNT_Model> amounts = null;
	
	private ArrayList<ZM_EMPLOYEE_Model>  subordinates = null;	
	
	
	/**
	 * 
	 */
	public ZM_EMPLOYEE_Model() {
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
	 * @return the responsibleEmployee
	 */
	public boolean isResponsibleEmployee() {
		return responsibleEmployee;
	}

	/**
	 * @param responsibleEmployee the responsibleEmployee to set
	 */
	public void setResponsibleEmployee(boolean responsibleEmployee) {
		this.responsibleEmployee = responsibleEmployee;
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
	 * @return the personalNumber
	 */
	public String getPersonalNumber() {
		return personalNumber;
	}

	/**
	 * @param personalNumber the personalNumber to set
	 */
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	/**
	 * @return the amounts
	 */
	public ArrayList<ZM_AMOUNT_Model> getAmounts() {
		return amounts;
	}

	/**
	 * @param amounts the amounts to set
	 */
	public void setAmounts(ArrayList<ZM_AMOUNT_Model> amounts) {
		this.amounts = amounts;
	}

	/**
	 * @return the subordinates
	 */
	public ArrayList<ZM_EMPLOYEE_Model> getSubordinates() {
		return subordinates;
	}

	/**
	 * @param subordinates the subordinates to set
	 */
	public void setSubordinates(ArrayList<ZM_EMPLOYEE_Model> subordinates) {
		this.subordinates = subordinates;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
