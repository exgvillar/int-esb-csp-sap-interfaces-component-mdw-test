/**
 * 
 */
package com.consubanco.sap.interfaces.sic.requests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.sic.ZUT_PERSON_OutputData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_SIC_ORIG_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String requestId = null;
	
	private Date requestDate = null;
	
	private double requestAmount = 0;
	
	private double disburmentAmount = 0;
	
	private int paymentNumber = 0;
	
	private boolean newRequest = false;
	
	private boolean cnca = false;
	
	private boolean secondDisp = false;
	
	private int numberDisposition = 0;
	
	private boolean liqCompetitor = false;
	
	private double promotionAmount = 0;
	
	private double notarial = 0;
	
	private double commissionOpening = 0;
	
	private double netCredit = 0;

	private double payAmount = 0; //descuento de la empresa
	
	private String frecuency = null;
	
	private String frecuencyInstallation = null;
	
	private ArrayList<ZUT_LIQS_OutputData> liquidations = null;
	
	private ZUT_PERSON_OutputData client = null;

	
	
	/**
	 * 
	 */
	public ZFM_SIC_ORIG_OutputData() {
		super();
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



	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}



	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}



	/**
	 * @return the requestAmount
	 */
	public double getRequestAmount() {
		return requestAmount;
	}



	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}



	/**
	 * @return the disburmentAmount
	 */
	public double getDisburmentAmount() {
		return disburmentAmount;
	}



	/**
	 * @param disburmentAmount the disburmentAmount to set
	 */
	public void setDisburmentAmount(double disburmentAmount) {
		this.disburmentAmount = disburmentAmount;
	}



	/**
	 * @return the paymentNumber
	 */
	public int getPaymentNumber() {
		return paymentNumber;
	}



	/**
	 * @param paymentNumber the paymentNumber to set
	 */
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}



	/**
	 * @return the newRequest
	 */
	public boolean isNewRequest() {
		return newRequest;
	}



	/**
	 * @param newRequest the newRequest to set
	 */
	public void setNewRequest(boolean newRequest) {
		this.newRequest = newRequest;
	}



	/**
	 * @return the cnca
	 */
	public boolean isCnca() {
		return cnca;
	}



	/**
	 * @param cnca the cnca to set
	 */
	public void setCnca(boolean cnca) {
		this.cnca = cnca;
	}



	/**
	 * @return the secondDisp
	 */
	public boolean isSecondDisp() {
		return secondDisp;
	}



	/**
	 * @param secondDisp the secondDisp to set
	 */
	public void setSecondDisp(boolean secondDisp) {
		this.secondDisp = secondDisp;
	}



	/**
	 * @return the numberDisposition
	 */
	public int getNumberDisposition() {
		return numberDisposition;
	}



	/**
	 * @param numberDisposition the numberDisposition to set
	 */
	public void setNumberDisposition(int numberDisposition) {
		this.numberDisposition = numberDisposition;
	}



	/**
	 * @return the liqCompetitor
	 */
	public boolean isLiqCompetitor() {
		return liqCompetitor;
	}



	/**
	 * @param liqCompetitor the liqCompetitor to set
	 */
	public void setLiqCompetitor(boolean liqCompetitor) {
		this.liqCompetitor = liqCompetitor;
	}



	/**
	 * @return the promotionAmount
	 */
	public double getPromotionAmount() {
		return promotionAmount;
	}



	/**
	 * @param promotionAmount the promotionAmount to set
	 */
	public void setPromotionAmount(double promotionAmount) {
		this.promotionAmount = promotionAmount;
	}



	/**
	 * @return the notarial
	 */
	public double getNotarial() {
		return notarial;
	}



	/**
	 * @param notarial the notarial to set
	 */
	public void setNotarial(double notarial) {
		this.notarial = notarial;
	}



	/**
	 * @return the commissionOpening
	 */
	public double getCommissionOpening() {
		return commissionOpening;
	}



	/**
	 * @param commissionOpening the commissionOpening to set
	 */
	public void setCommissionOpening(double commissionOpening) {
		this.commissionOpening = commissionOpening;
	}



	/**
	 * @return the netCredit
	 */
	public double getNetCredit() {
		return netCredit;
	}



	/**
	 * @param netCredit the netCredit to set
	 */
	public void setNetCredit(double netCredit) {
		this.netCredit = netCredit;
	}



	/**
	 * @return the payAmount
	 */
	public double getPayAmount() {
		return payAmount;
	}



	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}



	/**
	 * @return the frecuency
	 */
	public String getFrecuency() {
		return frecuency;
	}



	/**
	 * @param frecuency the frecuency to set
	 */
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	
	


	/**
	 * @return the frecuencyInstallation
	 */
	public String getFrecuencyInstallation() {
		return frecuencyInstallation;
	}



	/**
	 * @param frecuencyInstallation the frecuencyInstallation to set
	 */
	public void setFrecuencyInstallation(String frecuencyInstallation) {
		this.frecuencyInstallation = frecuencyInstallation;
	}



	/**
	 * @return the liquidations
	 */
	public ArrayList<ZUT_LIQS_OutputData> getLiquidations() {
		return liquidations;
	}



	/**
	 * @param liquidations the liquidations to set
	 */
	public void setLiquidations(ArrayList<ZUT_LIQS_OutputData> liquidations) {
		this.liquidations = liquidations;
	}



	/**
	 * @return the client
	 */
	public ZUT_PERSON_OutputData getClient() {
		return client;
	}



	/**
	 * @param client the client to set
	 */
	public void setClient(ZUT_PERSON_OutputData client) {
		this.client = client;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
