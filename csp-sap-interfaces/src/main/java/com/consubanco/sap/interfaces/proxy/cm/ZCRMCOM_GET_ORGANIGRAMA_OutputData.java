/**
 * 
 */
package com.consubanco.sap.interfaces.proxy.cm;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.proxy.cm.models.ZM_EMPLOYEE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMCOM_GET_ORGANIGRAMA_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String branchId = null;
	
	private ArrayList<ZM_EMPLOYEE_Model> employees = null;
	
	private String message = null;
	
	
	/**
	 * 
	 */
	public ZCRMCOM_GET_ORGANIGRAMA_OutputData() {
		super();
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the employees
	 */
	public ArrayList<ZM_EMPLOYEE_Model> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(ArrayList<ZM_EMPLOYEE_Model> employees) {
		this.employees = employees;
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
