package com.consubanco.sap.interfaces.commons.sipre.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class E_SIPRE_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3726667038582527989L;
	private String taskId;
	private Date createDate;
	private String name;
	private String nss;
	private String mail;
	private String telephone;
	private String nota;
	private GenericModel branch;
	private String biometric;
	private List<E_ATTACH_FILE_Model> attachfiles = new ArrayList<E_ATTACH_FILE_Model>();
	private GenericModel status;
	private String promotorBp;
	private String customerBp;
	
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the nota
	 */
	public String getNota() {
		return nota;
	}
	/**
	 * @param nota the nota to set
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}
	/**
	 * @return the branch
	 */
	public GenericModel getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(GenericModel branch) {
		this.branch = branch;
	}
	/**
	 * @return the biometric
	 */
	public String getBiometric() {
		return biometric;
	}
	/**
	 * @param biometric the biometric to set
	 */
	public void setBiometric(String biometric) {
		this.biometric = biometric;
	}
	/**
	 * @return the attachfiles
	 */
	public List<E_ATTACH_FILE_Model> getAttachfiles() {
		return attachfiles;
	}
	/**
	 * @param attachfiles the attachfiles to set
	 */
	public void setAttachfiles(List<E_ATTACH_FILE_Model> attachfiles) {
		this.attachfiles = attachfiles;
	}	
	/**
	 * @return the status
	 */
	public GenericModel getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GenericModel status) {
		this.status = status;
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
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
