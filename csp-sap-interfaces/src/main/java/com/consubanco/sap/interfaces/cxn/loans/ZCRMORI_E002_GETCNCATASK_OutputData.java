package com.consubanco.sap.interfaces.cxn.loans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.PRODUCT_CATALOG_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_E002_GETCNCATASK_OutputData implements Serializable, IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8619761707521857723L;
	private String success;
	private String message;	
	private String taskId;
	private String customerBp;
	private String promotorBp;
	private String nss;
	private GENERIC_CATALOG_Model enterprise;	
	private GENERIC_CATALOG_Model distributor;
	private GENERIC_CATALOG_Model branch;
	private PRODUCT_CATALOG_Model product;
	private Double requestAmount = 0.0;
	private int term;
	private GENERIC_CATALOG_Model status;
	private List<I_LOANS_Model> loans = new ArrayList<I_LOANS_Model>();	
	private List<I_FILES_Model> files = new ArrayList<I_FILES_Model>();	
	
	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
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
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the customerBp
	 */
	public String getCustomerBp() {
		return customerBp;
	}
	/**
	 * @param customerBp the customerBp to set
	 */
	public void setCustomerBp(String customerBp) {
		this.customerBp = customerBp;
	}
	/**
	 * @return the promotorBp
	 */
	public String getPromotorBp() {
		return promotorBp;
	}
	/**
	 * @param promotorBp the promotorBp to set
	 */
	public void setPromotorBp(String promotorBp) {
		this.promotorBp = promotorBp;
	}
	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}
	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	/**
	 * @return the enterprise
	 */
	public GENERIC_CATALOG_Model getEnterprise() {
		return enterprise;
	}
	/**
	 * @param enterprise the enterprise to set
	 */
	public void setEnterprise(GENERIC_CATALOG_Model enterprise) {
		this.enterprise = enterprise;
	}
	/**
	 * @return the distributor
	 */
	public GENERIC_CATALOG_Model getDistributor() {
		return distributor;
	}
	/**
	 * @param distributor the distributor to set
	 */
	public void setDistributor(GENERIC_CATALOG_Model distributor) {
		this.distributor = distributor;
	}
	/**
	 * @return the branch
	 */
	public GENERIC_CATALOG_Model getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(GENERIC_CATALOG_Model branch) {
		this.branch = branch;
	}
	/**
	 * @return the product
	 */
	public PRODUCT_CATALOG_Model getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(PRODUCT_CATALOG_Model product) {
		this.product = product;
	}
	/**
	 * @return the requestAmount
	 */
	public Double getRequestAmount() {
		return requestAmount;
	}
	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(Double requestAmount) {
		this.requestAmount = requestAmount;
	}
	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}
	/**
	 * @return the status
	 */
	public GENERIC_CATALOG_Model getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GENERIC_CATALOG_Model status) {
		this.status = status;
	}
	/**
	 * @return the loans
	 */
	public List<I_LOANS_Model> getLoans() {
		return loans;
	}
	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<I_LOANS_Model> loans) {
		this.loans = loans;
	}
	/**
	 * @return the files
	 */
	public List<I_FILES_Model> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<I_FILES_Model> files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
