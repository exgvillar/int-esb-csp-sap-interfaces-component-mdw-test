/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author juribe
 * 
 */
public class ZCRMTESO_TASA_AMORT_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productId;
	private String creditAmount;
	private String plazo;
	private String productFrequency;
	private String requestId;
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the creditAmount
	 */
	public String getCreditAmount() {
		return creditAmount;
	}
	/**
	 * @param creditAmount the creditAmount to set
	 */
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	/**
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}
	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	/**
	 * @return the productFrequency
	 */
	public String getProductFrequency() {
		return productFrequency;
	}
	/**
	 * @param productFrequency the productFrequency to set
	 */
	public void setProductFrequency(String productFrequency) {
		this.productFrequency = productFrequency;
	}
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
