/**
 * 
 */
package com.consubanco.sap.interfaces.commons.employees;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_E015_GET_EMPLEOSBP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean success = false;
	
	private String message = null;
	
	private ArrayList<ZTL_EMPLEOBP_Model> employees = null;
		
	
	/**
	 * 
	 */
	public ZCRMORI_E015_GET_EMPLEOSBP_OutputData() {
		super();
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
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

	/**
	 * @return the employees
	 */
	public ArrayList<ZTL_EMPLEOBP_Model> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(ArrayList<ZTL_EMPLEOBP_Model> employees) {
		this.employees = employees;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
