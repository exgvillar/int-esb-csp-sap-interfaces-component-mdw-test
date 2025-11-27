/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 * 
 */
public class SolicitudOrganizacion_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ctaEmpresarial;
	private String ownerDesc;
	private String ownerId;
	private String ownerSigla;
	private String branchDesc;
	private String branchId;
	private String branchSigla;

	private String distributorDesc;
	private String distributorId;
	private String distributorSigla;
	private String ownerRfc;
	private String dispersionH2h;
	private String branchidBP;
	private String branchEntFederativa;

	public String getCtaEmpresarial() {
		return ctaEmpresarial;
	}

	public void setCtaEmpresarial(String ctaEmpresarial) {
		this.ctaEmpresarial = ctaEmpresarial;
	}

	public String getOwnerDesc() {
		return ownerDesc;
	}

	public void setOwnerDesc(String ownerDesc) {
		this.ownerDesc = ownerDesc;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerSigla() {
		return ownerSigla;
	}

	public void setOwnerSigla(String ownerSigla) {
		this.ownerSigla = ownerSigla;
	}

	public String getBranchDesc() {
		return branchDesc;
	}

	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchSigla() {
		return branchSigla;
	}

	public void setBranchSigla(String branchSigla) {
		this.branchSigla = branchSigla;
	}

	public String getDistributorDesc() {
		return distributorDesc;
	}

	public void setDistributorDesc(String distributorDesc) {
		this.distributorDesc = distributorDesc;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorSigla() {
		return distributorSigla;
	}

	public void setDistributorSigla(String distributorSigla) {
		this.distributorSigla = distributorSigla;
	}

	public String getOwnerRfc() {
		return ownerRfc;
	}

	public void setOwnerRfc(String ownerRfc) {
		this.ownerRfc = ownerRfc;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getDispersionH2h() {
		return dispersionH2h;
	}

	public void setDispersionH2h(String dispersionH2h) {
		this.dispersionH2h = dispersionH2h;
	}

	public String getBranchidBP() {
		return branchidBP;
	}

	public void setBranchidBP(String branchidBP) {
		this.branchidBP = branchidBP;
	}

	public String getBranchEntFederativa() {
		return branchEntFederativa;
	}

	public void setBranchEntFederativa(String branchEntFederativa) {
		this.branchEntFederativa = branchEntFederativa;
	}

}
