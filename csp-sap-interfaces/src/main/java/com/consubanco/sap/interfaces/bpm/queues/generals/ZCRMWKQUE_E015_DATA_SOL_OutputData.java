/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_COMPETITOR_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E015_DATA_SOL_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	 private String folioApplication = null;
	 
	 private String convenioId = null;
	 
	 private String convenioDesc = null;
	 
	 private String convenioBrmsId = null;
	 
	 private int convenioRate = 0;
	 
	 private String productId = null;
	 
	 private String productDesc = null;
	 
	 private int productRate = 0;
	 
	 private String productCategoryId = null;
	 
	 private String productCategoryDesc = null; 
	 
	 private int productCategoryRate = 0;
	 
	 private String dependenceId = null;
	 
	 private String branchId = null;
	 
	 private double requestAmount = 0;
	 
	 private String promoterBp = null;
	 
	 private String promoterName1 = null;
	 
	 private String promoterName2 = null;
	 
	 private String promoterLastName1 = null;
	 
	 private String promoterLastName2 = null;
	 
	 private ArrayList<ZM_COMPETITOR_Model> competitorsList = null;
	 
	 private boolean secondDisposition = false;
		
	 private boolean lcom = false;
	
	 private boolean newCredit = false;
	
	 private boolean intercompany = false;
	 
	 private boolean cnca = false;
	 
	 private String sourceChannelId = null;
	 
	 private String sourceChannelDesc = null;
	 
	 private String taskCRMId = null;
	 
	 private String taskCRMDesc = null;
	 
	 private boolean result = false;
	
	 private String message = null;
		
	/**
	 * 
	 */
	public ZCRMWKQUE_E015_DATA_SOL_OutputData() {
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
	 * @return the convenioDesc
	 */
	public String getConvenioDesc() {
		return convenioDesc;
	}


	/**
	 * @param convenioDesc the convenioDesc to set
	 */
	public void setConvenioDesc(String convenioDesc) {
		this.convenioDesc = convenioDesc;
	}


	/**
	 * @return the convenioBrmsId
	 */
	public String getConvenioBrmsId() {
		return convenioBrmsId;
	}


	/**
	 * @param convenioBrmsId the convenioBrmsId to set
	 */
	public void setConvenioBrmsId(String convenioBrmsId) {
		this.convenioBrmsId = convenioBrmsId;
	}


	/**
	 * @return the convenioRate
	 */
	public int getConvenioRate() {
		return convenioRate;
	}


	/**
	 * @param convenioRate the convenioRate to set
	 */
	public void setConvenioRate(int convenioRate) {
		this.convenioRate = convenioRate;
	}


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
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}


	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	/**
	 * @return the productRate
	 */
	public int getProductRate() {
		return productRate;
	}


	/**
	 * @param productRate the productRate to set
	 */
	public void setProductRate(int productRate) {
		this.productRate = productRate;
	}


	/**
	 * @return the productCategoryId
	 */
	public String getProductCategoryId() {
		return productCategoryId;
	}


	/**
	 * @param productCategoryId the productCategoryId to set
	 */
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}


	/**
	 * @return the productCategoryDesc
	 */
	public String getProductCategoryDesc() {
		return productCategoryDesc;
	}


	/**
	 * @param productCategoryDesc the productCategoryDesc to set
	 */
	public void setProductCategoryDesc(String productCategoryDesc) {
		this.productCategoryDesc = productCategoryDesc;
	}


	/**
	 * @return the productCategoryRate
	 */
	public int getProductCategoryRate() {
		return productCategoryRate;
	}


	/**
	 * @param productCategoryRate the productCategoryRate to set
	 */
	public void setProductCategoryRate(int productCategoryRate) {
		this.productCategoryRate = productCategoryRate;
	}


	/**
	 * @return the dependenceId
	 */
	public String getDependenceId() {
		return dependenceId;
	}


	/**
	 * @param dependenceId the dependenceId to set
	 */
	public void setDependenceId(String dependenceId) {
		this.dependenceId = dependenceId;
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
	 * @return the promoterBp
	 */
	public String getPromoterBp() {
		return promoterBp;
	}


	/**
	 * @param promoterBp the promoterBp to set
	 */
	public void setPromoterBp(String promoterBp) {
		this.promoterBp = promoterBp;
	}

	/**
	 * @return the promoterName1
	 */
	public String getPromoterName1() {
		return promoterName1;
	}


	/**
	 * @param promoterName1 the promoterName1 to set
	 */
	public void setPromoterName1(String promoterName1) {
		this.promoterName1 = promoterName1;
	}


	/**
	 * @return the promoterName2
	 */
	public String getPromoterName2() {
		return promoterName2;
	}


	/**
	 * @param promoterName2 the promoterName2 to set
	 */
	public void setPromoterName2(String promoterName2) {
		this.promoterName2 = promoterName2;
	}


	/**
	 * @return the promoterLastName1
	 */
	public String getPromoterLastName1() {
		return promoterLastName1;
	}


	/**
	 * @param promoterLastName1 the promoterLastName1 to set
	 */
	public void setPromoterLastName1(String promoterLastName1) {
		this.promoterLastName1 = promoterLastName1;
	}


	/**
	 * @return the promoterLastName2
	 */
	public String getPromoterLastName2() {
		return promoterLastName2;
	}


	/**
	 * @param promoterLastName2 the promoterLastName2 to set
	 */
	public void setPromoterLastName2(String promoterLastName2) {
		this.promoterLastName2 = promoterLastName2;
	}


	/**
	 * @return the competitorsList
	 */
	public ArrayList<ZM_COMPETITOR_Model> getCompetitorsList() {
		return competitorsList;
	}


	/**
	 * @param competitorsList the competitorsList to set
	 */
	public void setCompetitorsList(ArrayList<ZM_COMPETITOR_Model> competitorsList) {
		this.competitorsList = competitorsList;
	}


	/**
	 * @return the secondDisposition
	 */
	public boolean isSecondDisposition() {
		return secondDisposition;
	}


	/**
	 * @param secondDisposition the secondDisposition to set
	 */
	public void setSecondDisposition(boolean secondDisposition) {
		this.secondDisposition = secondDisposition;
	}


	/**
	 * @return the lcom
	 */
	public boolean isLcom() {
		return lcom;
	}


	/**
	 * @param lcom the lcom to set
	 */
	public void setLcom(boolean lcom) {
		this.lcom = lcom;
	}


	/**
	 * @return the newCredit
	 */
	public boolean isNewCredit() {
		return newCredit;
	}


	/**
	 * @param newCredit the newCredit to set
	 */
	public void setNewCredit(boolean newCredit) {
		this.newCredit = newCredit;
	}


	/**
	 * @return the intercompany
	 */
	public boolean isIntercompany() {
		return intercompany;
	}


	/**
	 * @param intercompany the intercompany to set
	 */
	public void setIntercompany(boolean intercompany) {
		this.intercompany = intercompany;
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
	 * @return the sourceChannelId
	 */
	public String getSourceChannelId() {
		return sourceChannelId;
	}


	/**
	 * @param sourceChannelId the sourceChannelId to set
	 */
	public void setSourceChannelId(String sourceChannelId) {
		this.sourceChannelId = sourceChannelId;
	}


	/**
	 * @return the sourceChannelDesc
	 */
	public String getSourceChannelDesc() {
		return sourceChannelDesc;
	}


	/**
	 * @param sourceChannelDesc the sourceChannelDesc to set
	 */
	public void setSourceChannelDesc(String sourceChannelDesc) {
		this.sourceChannelDesc = sourceChannelDesc;
	}


	/**
	 * @return the taskCRMId
	 */
	public String getTaskCRMId() {
		return taskCRMId;
	}


	/**
	 * @param taskCRMId the taskCRMId to set
	 */
	public void setTaskCRMId(String taskCRMId) {
		this.taskCRMId = taskCRMId;
	}


	/**
	 * @return the taskCRMDesc
	 */
	public String getTaskCRMDesc() {
		return taskCRMDesc;
	}


	/**
	 * @param taskCRMDesc the taskCRMDesc to set
	 */
	public void setTaskCRMDesc(String taskCRMDesc) {
		this.taskCRMDesc = taskCRMDesc;
	}


	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
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
