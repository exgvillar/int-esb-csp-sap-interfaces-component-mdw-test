package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Credit implements Serializable {
	private static final long serialVersionUID = 4627738791195865924L;
	private String vatrate;
	private String totalTaxAmt;
	private String totalPrincipalAmt;
	private String totalPaymentsNbr;
	private String totalInterestAmt;
	private String taxPaymentAmt;
	private String substitutionAmt;
	private String regionCrm;
	private String referenceNbr;
	private String promoterCrm;
	private String productCrm;
	private String principalPaymentAmt;
	private String payrollNbr;
	private String paymentUnitCrm;
	private String paymentFrequencyCrm;
	private String payerNbr;
	private String oldCreditCrm;
	private String interestRatePct;
	private String interestPaymentAmt;
	private String fundingDt;
	private String fundingAmt;
	private String formalizationDt;
	private String firstPaymentExpectedDt;
	private String fieldReference3;
	private String fieldReference2;
	private String fieldReference1;
	private String employeeTypeDesc;
	private String distribuidorCrm;
	private String disbursementDt;
	private String dependenciaCrm;
	private String creditCrm;
	private String companyCd;
	private String budgetNbr;
	private String branchCrm;
	private String bankReferenceNbr;
	private String accountSpreadMethodCrm;
	private String accounId;
	private String cat;
	private String intercompania;
	private String autoservicio;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getVatrate() {
		return vatrate;
	}

	public void setVatrate(String vatrate) {
		this.vatrate = vatrate;
	}

	public String getTotalTaxAmt() {
		return totalTaxAmt;
	}

	public void setTotalTaxAmt(String totalTaxAmt) {
		this.totalTaxAmt = totalTaxAmt;
	}

	public String getTotalPrincipalAmt() {
		return totalPrincipalAmt;
	}

	public void setTotalPrincipalAmt(String totalPrincipalAmt) {
		this.totalPrincipalAmt = totalPrincipalAmt;
	}

	public String getTotalPaymentsNbr() {
		return totalPaymentsNbr;
	}

	public void setTotalPaymentsNbr(String totalPaymentsNbr) {
		this.totalPaymentsNbr = totalPaymentsNbr;
	}

	public String getTotalInterestAmt() {
		return totalInterestAmt;
	}

	public void setTotalInterestAmt(String totalInterestAmt) {
		this.totalInterestAmt = totalInterestAmt;
	}

	public String getTaxPaymentAmt() {
		return taxPaymentAmt;
	}

	public void setTaxPaymentAmt(String taxPaymentAmt) {
		this.taxPaymentAmt = taxPaymentAmt;
	}

	public String getSubstitutionAmt() {
		return substitutionAmt;
	}

	public void setSubstitutionAmt(String substitutionAmt) {
		this.substitutionAmt = substitutionAmt;
	}

	public String getRegionCrm() {
		return regionCrm;
	}

	public void setRegionCrm(String regionCrm) {
		this.regionCrm = regionCrm;
	}

	public String getReferenceNbr() {
		return referenceNbr;
	}

	public void setReferenceNbr(String referenceNbr) {
		this.referenceNbr = referenceNbr;
	}

	public String getPromoterCrm() {
		return promoterCrm;
	}

	public void setPromoterCrm(String promoterCrm) {
		this.promoterCrm = promoterCrm;
	}

	public String getProductCrm() {
		return productCrm;
	}

	public void setProductCrm(String productCrm) {
		this.productCrm = productCrm;
	}

	public String getPrincipalPaymentAmt() {
		return principalPaymentAmt;
	}

	public void setPrincipalPaymentAmt(String principalPaymentAmt) {
		this.principalPaymentAmt = principalPaymentAmt;
	}

	public String getPayrollNbr() {
		return payrollNbr;
	}

	public void setPayrollNbr(String payrollNbr) {
		this.payrollNbr = payrollNbr;
	}

	public String getPaymentUnitCrm() {
		return paymentUnitCrm;
	}

	public void setPaymentUnitCrm(String paymentUnitCrm) {
		this.paymentUnitCrm = paymentUnitCrm;
	}

	public String getPaymentFrequencyCrm() {
		return paymentFrequencyCrm;
	}

	public void setPaymentFrequencyCrm(String paymentFrequencyCrm) {
		this.paymentFrequencyCrm = paymentFrequencyCrm;
	}

	public String getPayerNbr() {
		return payerNbr;
	}

	public void setPayerNbr(String payerNbr) {
		this.payerNbr = payerNbr;
	}

	public String getOldCreditCrm() {
		return oldCreditCrm;
	}

	public void setOldCreditCrm(String oldCreditCrm) {
		this.oldCreditCrm = oldCreditCrm;
	}

	public String getInterestRatePct() {
		return interestRatePct;
	}

	public void setInterestRatePct(String interestRatePct) {
		this.interestRatePct = interestRatePct;
	}

	public String getInterestPaymentAmt() {
		return interestPaymentAmt;
	}

	public void setInterestPaymentAmt(String interestPaymentAmt) {
		this.interestPaymentAmt = interestPaymentAmt;
	}

	public String getFundingDt() {
		return fundingDt;
	}

	public void setFundingDt(String fundingDt) {
		this.fundingDt = fundingDt;
	}

	public String getFundingAmt() {
		return fundingAmt;
	}

	public void setFundingAmt(String fundingAmt) {
		this.fundingAmt = fundingAmt;
	}

	public String getFormalizationDt() {
		return formalizationDt;
	}

	public void setFormalizationDt(String formalizationDt) {
		this.formalizationDt = formalizationDt;
	}

	public String getFirstPaymentExpectedDt() {
		return firstPaymentExpectedDt;
	}

	public void setFirstPaymentExpectedDt(String firstPaymentExpectedDt) {
		this.firstPaymentExpectedDt = firstPaymentExpectedDt;
	}

	public String getFieldReference3() {
		return fieldReference3;
	}

	public void setFieldReference3(String fieldReference3) {
		this.fieldReference3 = fieldReference3;
	}

	public String getFieldReference2() {
		return fieldReference2;
	}

	public void setFieldReference2(String fieldReference2) {
		this.fieldReference2 = fieldReference2;
	}

	public String getFieldReference1() {
		return fieldReference1;
	}

	public void setFieldReference1(String fieldReference1) {
		this.fieldReference1 = fieldReference1;
	}

	public String getEmployeeTypeDesc() {
		return employeeTypeDesc;
	}

	public void setEmployeeTypeDesc(String employeeTypeDesc) {
		this.employeeTypeDesc = employeeTypeDesc;
	}

	public String getDistribuidorCrm() {
		return distribuidorCrm;
	}

	public void setDistribuidorCrm(String distribuidorCrm) {
		this.distribuidorCrm = distribuidorCrm;
	}

	public String getDisbursementDt() {
		return disbursementDt;
	}

	public void setDisbursementDt(String disbursementDt) {
		this.disbursementDt = disbursementDt;
	}

	public String getDependenciaCrm() {
		return dependenciaCrm;
	}

	public void setDependenciaCrm(String dependenciaCrm) {
		this.dependenciaCrm = dependenciaCrm;
	}

	public String getCreditCrm() {
		return creditCrm;
	}

	public void setCreditCrm(String creditCrm) {
		this.creditCrm = creditCrm;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getBudgetNbr() {
		return budgetNbr;
	}

	public void setBudgetNbr(String budgetNbr) {
		this.budgetNbr = budgetNbr;
	}

	public String getBranchCrm() {
		return branchCrm;
	}

	public void setBranchCrm(String branchCrm) {
		this.branchCrm = branchCrm;
	}

	public String getBankReferenceNbr() {
		return bankReferenceNbr;
	}

	public void setBankReferenceNbr(String bankReferenceNbr) {
		this.bankReferenceNbr = bankReferenceNbr;
	}

	public String getAccountSpreadMethodCrm() {
		return accountSpreadMethodCrm;
	}

	public void setAccountSpreadMethodCrm(String accountSpreadMethodCrm) {
		this.accountSpreadMethodCrm = accountSpreadMethodCrm;
	}

	public String getAccounId() {
		return accounId;
	}

	public void setAccounId(String accounId) {
		this.accounId = accounId;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getIntercompania() {
		return intercompania;
	}

	public void setIntercompania(String intercompania) {
		this.intercompania = intercompania;
	}

	public String getAutoservicio() {
		return autoservicio;
	}

	public void setAutoservicio(String autoservicio) {
		this.autoservicio = autoservicio;
	}


}
