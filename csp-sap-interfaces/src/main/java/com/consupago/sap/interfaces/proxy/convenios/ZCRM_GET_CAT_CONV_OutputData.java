/**
 * 
 */
package com.consupago.sap.interfaces.proxy.convenios;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRM_GET_CAT_CONV_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private String convenioId = null;
	
	private String convenioDescription = null;
	
	private String financialProductId = null;
	
	private String financialProductDescription = null;
	
	private String frecuencyFinancialProduct = null;
	
	private int plazoMinimoFinancialProduct = 0;
	
	private int plazoMaximoFinancialProduct = 0;
	
	private double montoMinimoFinancialProduct = 0;
	
	private double montoMaximoFinancialProduct = 0;
	
	
	/**
* 
*/
	public ZCRM_GET_CAT_CONV_OutputData() {
		super();
	}

	

	/**
	 * @return the convenioId
	 */
	public String getConvenioId() {
		return convenioId;
	}



	/**
	 * @param convenioId the convenioId to set
	 */
	public void setConvenioId(String convenioId) {
		this.convenioId = convenioId;
	}



	/**
	 * @return the convenioDescription
	 */
	public String getConvenioDescription() {
		return convenioDescription;
	}



	/**
	 * @param convenioDescription the convenioDescription to set
	 */
	public void setConvenioDescription(String convenioDescription) {
		this.convenioDescription = convenioDescription;
	}



	/**
	 * @return the financialProductId
	 */
	public String getFinancialProductId() {
		return financialProductId;
	}



	/**
	 * @param financialProductId the financialProductId to set
	 */
	public void setFinancialProductId(String financialProductId) {
		this.financialProductId = financialProductId;
	}



	/**
	 * @return the financialProductDescription
	 */
	public String getFinancialProductDescription() {
		return financialProductDescription;
	}



	/**
	 * @param financialProductDescription the financialProductDescription to set
	 */
	public void setFinancialProductDescription(String financialProductDescription) {
		this.financialProductDescription = financialProductDescription;
	}



	/**
	 * @return the frecuencyFinancialProduct
	 */
	public String getFrecuencyFinancialProduct() {
		return frecuencyFinancialProduct;
	}



	/**
	 * @param frecuencyFinancialProduct the frecuencyFinancialProduct to set
	 */
	public void setFrecuencyFinancialProduct(String frecuencyFinancialProduct) {
		this.frecuencyFinancialProduct = frecuencyFinancialProduct;
	}



	/**
	 * @return the plazoMinimoFinancialProduct
	 */
	public int getPlazoMinimoFinancialProduct() {
		return plazoMinimoFinancialProduct;
	}



	/**
	 * @param plazoMinimoFinancialProduct the plazoMinimoFinancialProduct to set
	 */
	public void setPlazoMinimoFinancialProduct(int plazoMinimoFinancialProduct) {
		this.plazoMinimoFinancialProduct = plazoMinimoFinancialProduct;
	}



	/**
	 * @return the plazoMaximoFinancialProduct
	 */
	public int getPlazoMaximoFinancialProduct() {
		return plazoMaximoFinancialProduct;
	}



	/**
	 * @param plazoMaximoFinancialProduct the plazoMaximoFinancialProduct to set
	 */
	public void setPlazoMaximoFinancialProduct(int plazoMaximoFinancialProduct) {
		this.plazoMaximoFinancialProduct = plazoMaximoFinancialProduct;
	}



	/**
	 * @return the montoMinimoFinancialProduct
	 */
	public double getMontoMinimoFinancialProduct() {
		return montoMinimoFinancialProduct;
	}



	/**
	 * @param montoMinimoFinancialProduct the montoMinimoFinancialProduct to set
	 */
	public void setMontoMinimoFinancialProduct(double montoMinimoFinancialProduct) {
		this.montoMinimoFinancialProduct = montoMinimoFinancialProduct;
	}



	/**
	 * @return the montoMaximoFinancialProduct
	 */
	public double getMontoMaximoFinancialProduct() {
		return montoMaximoFinancialProduct;
	}



	/**
	 * @param montoMaximoFinancialProduct the montoMaximoFinancialProduct to set
	 */
	public void setMontoMaximoFinancialProduct(double montoMaximoFinancialProduct) {
		this.montoMaximoFinancialProduct = montoMaximoFinancialProduct;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
