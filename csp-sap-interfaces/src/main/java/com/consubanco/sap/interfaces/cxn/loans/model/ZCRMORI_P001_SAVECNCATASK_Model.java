package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_P001_SAVECNCATASK_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2697537670922941164L;
	private String taskId;
	private String customerBp;
	private String promotorBp;	
	private GENERIC_CATALOG_Model enterprise;	
	private GENERIC_CATALOG_Model distributor;
	private GENERIC_CATALOG_Model branch;
	private GENERIC_CATALOG_Model product;
	private Double requestAmount = 0.0;
	private int term = 0;
	private String solicitudId;
	private List<I_LOANS_Model> loans = new ArrayList<I_LOANS_Model>();
	private List<I_FILES_Model> files = new ArrayList<I_FILES_Model>();
	
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
	public GENERIC_CATALOG_Model getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(GENERIC_CATALOG_Model product) {
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
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	/**
	 * @return the solicitudId
	 */
	public String getSolicitudId() {
		return solicitudId;
	}
	/**
	 * @param solicitudId the solicitudId to set
	 */
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
}
