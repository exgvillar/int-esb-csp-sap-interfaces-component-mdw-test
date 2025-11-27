/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_APPLICATION_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E008_NOTIFICATIONS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String role = null;
	
	private int attentionTimeMinsMin = 0;
	
	private int attentionTimeMinsMax = 0;
	
	private String email = null;
	
	private ArrayList<ZM_APPLICATION_Model> applications = null;
	
	private String message = null;
	
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E008_NOTIFICATIONS_OutputData() {
		super();
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the attentionTimeMinsMin
	 */
	public int getAttentionTimeMinsMin() {
		return attentionTimeMinsMin;
	}

	/**
	 * @param attentionTimeMinsMin the attentionTimeMinsMin to set
	 */
	public void setAttentionTimeMinsMin(int attentionTimeMinsMin) {
		this.attentionTimeMinsMin = attentionTimeMinsMin;
	}

	/**
	 * @return the attentionTimeMinsMax
	 */
	public int getAttentionTimeMinsMax() {
		return attentionTimeMinsMax;
	}

	/**
	 * @param attentionTimeMinsMax the attentionTimeMinsMax to set
	 */
	public void setAttentionTimeMinsMax(int attentionTimeMinsMax) {
		this.attentionTimeMinsMax = attentionTimeMinsMax;
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
	 * @return the applications
	 */
	public ArrayList<ZM_APPLICATION_Model> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(ArrayList<ZM_APPLICATION_Model> applications) {
		this.applications = applications;
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
