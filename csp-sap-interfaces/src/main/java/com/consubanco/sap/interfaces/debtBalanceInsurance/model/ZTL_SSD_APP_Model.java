/**
 * 
 */
package com.consubanco.sap.interfaces.debtBalanceInsurance.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_SSD_APP_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7472975909450122951L;

	private String serviceOrderSSD = null;
	
	private String folioApplication = null;
	
	
	/**
	 * 
	 */
	public ZTL_SSD_APP_Model() {
		super();
	}

	/**
	 * @return the serviceOrderSSD
	 */
	public String getServiceOrderSSD() {
		return serviceOrderSSD;
	}

	/**
	 * @param serviceOrderSSD the serviceOrderSSD to set
	 */
	public void setServiceOrderSSD(String serviceOrderSSD) {
		this.serviceOrderSSD = serviceOrderSSD;
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

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
