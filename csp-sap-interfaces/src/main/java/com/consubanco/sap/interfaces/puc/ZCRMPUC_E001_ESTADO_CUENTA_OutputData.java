/**
 * 
 */
package com.consubanco.sap.interfaces.puc;

import java.io.Serializable;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMPUC_E001_ESTADO_CUENTA_OutputData implements Serializable, IProxyOutputData {
	static final long serialVersionUID = 2539082200809553985L;

	private boolean success = false;
	private String message = "";
	private String creditId;
	private String formDate;
	private String account;
	private String numPay;
	private String typeCurrency;
	private String payPeriod;
	private String ordInterestAmount;
	private String borrowerName;
	private String dependency;
	private String dispoAmount;
	private String totalAmount;
	private String periodDiscount;
	private String ordInterestRate;
	private String comission;
	private String totalComi;
	private String currency;
	private String payDate;
	private String address;
	private String addressCSB;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
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
	 * @return the creditId
	 */
	public String getCreditId() {
		return creditId;
	}
	/**
	 * @param creditId the creditId to set
	 */
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	/**
	 * @return the formDate
	 */
	public String getFormDate() {
		return formDate;
	}
	/**
	 * @param formDate the formDate to set
	 */
	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the numPay
	 */
	public String getNumPay() {
		return numPay;
	}
	/**
	 * @param numPay the numPay to set
	 */
	public void setNumPay(String numPay) {
		this.numPay = numPay;
	}
	/**
	 * @return the typeCurrency
	 */
	public String getTypeCurrency() {
		return typeCurrency;
	}
	/**
	 * @param typeCurrency the typeCurrency to set
	 */
	public void setTypeCurrency(String typeCurrency) {
		this.typeCurrency = typeCurrency;
	}
	/**
	 * @return the payPeriod
	 */
	public String getPayPeriod() {
		return payPeriod;
	}
	/**
	 * @param payPeriod the payPeriod to set
	 */
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	/**
	 * @return the ordInterestAmount
	 */
	public String getOrdInterestAmount() {
		return ordInterestAmount;
	}
	/**
	 * @param ordInterestAmount the ordInterestAmount to set
	 */
	public void setOrdInterestAmount(String ordInterestAmount) {
		this.ordInterestAmount = ordInterestAmount;
	}
	/**
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}
	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	/**
	 * @return the dependency
	 */
	public String getDependency() {
		return dependency;
	}
	/**
	 * @param dependency the dependency to set
	 */
	public void setDependency(String dependency) {
		this.dependency = dependency;
	}
	/**
	 * @return the dispoAmount
	 */
	public String getDispoAmount() {
		return dispoAmount;
	}
	/**
	 * @param dispoAmount the dispoAmount to set
	 */
	public void setDispoAmount(String dispoAmount) {
		this.dispoAmount = dispoAmount;
	}
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the periodDiscount
	 */
	public String getPeriodDiscount() {
		return periodDiscount;
	}
	/**
	 * @param periodDiscount the periodDiscount to set
	 */
	public void setPeriodDiscount(String periodDiscount) {
		this.periodDiscount = periodDiscount;
	}
	/**
	 * @return the ordInterestRate
	 */
	public String getOrdInterestRate() {
		return ordInterestRate;
	}
	/**
	 * @param ordInterestRate the ordInterestRate to set
	 */
	public void setOrdInterestRate(String ordInterestRate) {
		this.ordInterestRate = ordInterestRate;
	}
	/**
	 * @return the comission
	 */
	public String getComission() {
		return comission;
	}
	/**
	 * @param comission the comission to set
	 */
	public void setComission(String comission) {
		this.comission = comission;
	}
	/**
	 * @return the totalComi
	 */
	public String getTotalComi() {
		return totalComi;
	}
	/**
	 * @param totalComi the totalComi to set
	 */
	public void setTotalComi(String totalComi) {
		this.totalComi = totalComi;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the payDate
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the addressCSB
	 */
	public String getAddressCSB() {
		return addressCSB;
	}
	/**
	 * @param addressCSB the addressCSB to set
	 */
	public void setAddressCSB(String addressCSB) {
		this.addressCSB = addressCSB;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ZCRMPUC_E001_ESTADO_CUENTA_OutputData [success=" + success + ", message=" + message + ", creditId="
				+ creditId + ", formDate=" + formDate + ", account=" + account + ", numPay=" + numPay
				+ ", typeCurrency=" + typeCurrency + ", payPeriod=" + payPeriod + ", ordInterestAmount="
				+ ordInterestAmount + ", borrowerName=" + borrowerName + ", dependency=" + dependency + ", dispoAmount="
				+ dispoAmount + ", totalAmount=" + totalAmount + ", periodDiscount=" + periodDiscount
				+ ", ordInterestRate=" + ordInterestRate + ", comission=" + comission + ", totalComi=" + totalComi
				+ ", currency=" + currency + ", payDate=" + payDate + ", address=" + address + ", addressCSB="
				+ addressCSB + "]";
	}

	

}
