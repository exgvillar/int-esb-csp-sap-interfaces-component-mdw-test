/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_CATALOGOFREC_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private double montoMinimo = 0;
	
	private double montoMaximo = 0;
	
	private String payFrequencyCode = null;
	
	private String payFrequencyDescription = null;
	
	private int periodsTermFrom = 0;
	
	private int periodsTermTo = 0;	
	
	private String periodsTimeUnit = null;
	
	private String periodsDefTerm = null;
	
	
	
	/**
	 * 
	 */
	public ZRFC_CATALOGOFREC_OutputData() {
		super();
	}

	
	/**
	 * @return the montoMinimo
	 */
	public double getMontoMinimo() {
		return montoMinimo;
	}


	/**
	 * @param montoMinimo the montoMinimo to set
	 */
	public void setMontoMinimo(double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}


	/**
	 * @return the montoMaximo
	 */
	public double getMontoMaximo() {
		return montoMaximo;
	}


	/**
	 * @param montoMaximo the montoMaximo to set
	 */
	public void setMontoMaximo(double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}


	/**
	 * @return the payFrequencyCode
	 */
	public String getPayFrequencyCode() {
		return payFrequencyCode;
	}


	/**
	 * @param payFrequencyCode the payFrequencyCode to set
	 */
	public void setPayFrequencyCode(String payFrequencyCode) {
		this.payFrequencyCode = payFrequencyCode;
	}


	/**
	 * @return the payFrequencyDescription
	 */
	public String getPayFrequencyDescription() {
		return payFrequencyDescription;
	}


	/**
	 * @param payFrequencyDescription the payFrequencyDescription to set
	 */
	public void setPayFrequencyDescription(String payFrequencyDescription) {
		this.payFrequencyDescription = payFrequencyDescription;
	}


	/**
	 * @return the periodsTermFrom
	 */
	public int getPeriodsTermFrom() {
		return periodsTermFrom;
	}


	/**
	 * @param periodsTermFrom the periodsTermFrom to set
	 */
	public void setPeriodsTermFrom(int periodsTermFrom) {
		this.periodsTermFrom = periodsTermFrom;
	}


	/**
	 * @return the periodsTermTo
	 */
	public int getPeriodsTermTo() {
		return periodsTermTo;
	}


	/**
	 * @param periodsTermTo the periodsTermTo to set
	 */
	public void setPeriodsTermTo(int periodsTermTo) {
		this.periodsTermTo = periodsTermTo;
	}


	/**
	 * @return the periodsTimeUnit
	 */
	public String getPeriodsTimeUnit() {
		return periodsTimeUnit;
	}


	/**
	 * @param periodsTimeUnit the periodsTimeUnit to set
	 */
	public void setPeriodsTimeUnit(String periodsTimeUnit) {
		this.periodsTimeUnit = periodsTimeUnit;
	}


	/**
	 * @return the periodsDefTerm
	 */
	public String getPeriodsDefTerm() {
		return periodsDefTerm;
	}


	/**
	 * @param periodsDefTerm the periodsDefTerm to set
	 */
	public void setPeriodsDefTerm(String periodsDefTerm) {
		this.periodsDefTerm = periodsDefTerm;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
