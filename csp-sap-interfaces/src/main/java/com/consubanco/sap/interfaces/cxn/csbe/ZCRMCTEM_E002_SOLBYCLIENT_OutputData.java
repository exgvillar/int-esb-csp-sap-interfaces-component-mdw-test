/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.csbe;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCTEM_E002_SOLBYCLIENT_OutputData implements Serializable,
		IProxyOutputData {


	private String requestId = null;

	private String bpId = null;
	
	private String rfc = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
	
	private Date createDate = null;
	
	private Date lastStatusDate = null;
	
	private String statusId = null;
	
	private String statusDesc = null;
	
	private double requestAmount = 0;
	
	private boolean cnca = false;
	
	private boolean secondDisposition = false;
	
	private int dispositionNumber = 0; 
	
	private boolean lcom = false;
	
	private boolean newCredit = false;
	
	private boolean intercompany = false;
	
	private double intercompanyAmount = 0;
	
	private String convenioCRM = null;
	
	private String convenioBRMS = null;
	
	private String convenioDesc = null;
	
	private String companySigla = null;
	
	private String companyDesc = null;
	
	private boolean dispersionAuth = false;
		

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

		
	
	/**
	 * 
	 */
	public ZCRMCTEM_E002_SOLBYCLIENT_OutputData() {
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
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}



	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}



	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}



	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}



	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}



	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}



	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}



	/**
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}



	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}



	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}



	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
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
	 * @return the lastStatusDate
	 */
	public Date getLastStatusDate() {
		return lastStatusDate;
	}



	/**
	 * @param lastStatusDate the lastStatusDate to set
	 */
	public void setLastStatusDate(Date lastStatusDate) {
		this.lastStatusDate = lastStatusDate;
	}



	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}



	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}



	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}



	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
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
	 * @return the dispositionNumber
	 */
	public int getDispositionNumber() {
		return dispositionNumber;
	}



	/**
	 * @param dispositionNumber the dispositionNumber to set
	 */
	public void setDispositionNumber(int dispositionNumber) {
		this.dispositionNumber = dispositionNumber;
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
	 * @return the intercompanyAmount
	 */
	public double getIntercompanyAmount() {
		return intercompanyAmount;
	}



	/**
	 * @param intercompanyAmount the intercompanyAmount to set
	 */
	public void setIntercompanyAmount(double intercompanyAmount) {
		this.intercompanyAmount = intercompanyAmount;
	}



	/**
	 * @return the convenioCRM
	 */
	public String getConvenioCRM() {
		return convenioCRM;
	}



	/**
	 * @param convenioCRM the convenioCRM to set
	 */
	public void setConvenioCRM(String convenioCRM) {
		this.convenioCRM = convenioCRM;
	}



	/**
	 * @return the convenioBRMS
	 */
	public String getConvenioBRMS() {
		return convenioBRMS;
	}



	/**
	 * @param convenioBRMS the convenioBRMS to set
	 */
	public void setConvenioBRMS(String convenioBRMS) {
		this.convenioBRMS = convenioBRMS;
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
	 * @return the companySigla
	 */
	public String getCompanySigla() {
		return companySigla;
	}



	/**
	 * @param companySigla the companySigla to set
	 */
	public void setCompanySigla(String companySigla) {
		this.companySigla = companySigla;
	}



	/**
	 * @return the companyDesc
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}



	/**
	 * @param companyDesc the companyDesc to set
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}



	/**
	 * @return the dispersionAuth
	 */
	public boolean isDispersionAuth() {
		return dispersionAuth;
	}



	/**
	 * @param dispersionAuth the dispersionAuth to set
	 */
	public void setDispersionAuth(boolean dispersionAuth) {
		this.dispersionAuth = dispersionAuth;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
