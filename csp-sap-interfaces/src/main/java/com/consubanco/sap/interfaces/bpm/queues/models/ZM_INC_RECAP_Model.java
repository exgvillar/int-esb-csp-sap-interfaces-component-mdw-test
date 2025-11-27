/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZM_INC_RECAP_Model implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8368574627111906248L;
	                              
	private String folioApplication = null;
	
	private int incidenceNumber = 0;
	
	private String cause = null;
	
	private String motive = null;
	
	private String generalDescription = null;
	
	private boolean resolve = false;
	
	
	/**
	 * 
	 */
	public ZM_INC_RECAP_Model() {
		super();
	}

	/**
	 * @return the folioApplication
	 */
	public String getFolioApplication() {
		return folioApplication;
	}

	/**
	 * @param folioApplication the folioApplication to set
	 */
	public void setFolioApplication(String folioApplication) {
		this.folioApplication = folioApplication;
	}

	/**
	 * @return the incidenceNumber
	 */
	public int getIncidenceNumber() {
		return incidenceNumber;
	}

	/**
	 * @param incidenceNumber the incidenceNumber to set
	 */
	public void setIncidenceNumber(int incidenceNumber) {
		this.incidenceNumber = incidenceNumber;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}

	/**
	 * @return the motive
	 */
	public String getMotive() {
		return motive;
	}

	/**
	 * @param motive the motive to set
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}

	/**
	 * @return the generalDescription
	 */
	public String getGeneralDescription() {
		return generalDescription;
	}

	/**
	 * @param generalDescription the generalDescription to set
	 */
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	/**
	 * @return the resolve
	 */
	public boolean isResolve() {
		return resolve;
	}

	/**
	 * @param resolve the resolve to set
	 */
	public void setResolve(boolean resolve) {
		this.resolve = resolve;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
