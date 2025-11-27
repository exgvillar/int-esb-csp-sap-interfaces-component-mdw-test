/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.recaptures;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_INC_RECAP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5319418574383104181L;

	private ArrayList<ZM_INC_RECAP_Model> incidences = null;
	
	private boolean success = false;
	
	private String message = null;
	
	/**
	 * 
	 */
	public ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData() {
		super();
	}

	/**
	 * @return the incidences
	 */
	public ArrayList<ZM_INC_RECAP_Model> getIncidences() {
		return incidences;
	}

	/**
	 * @param incidences the incidences to set
	 */
	public void setIncidences(ArrayList<ZM_INC_RECAP_Model> incidences) {
		this.incidences = incidences;
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

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
