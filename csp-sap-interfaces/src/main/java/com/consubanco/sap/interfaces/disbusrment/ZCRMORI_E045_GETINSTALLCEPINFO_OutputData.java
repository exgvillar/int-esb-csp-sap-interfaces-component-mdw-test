/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMORI_E045_GETINSTALLCEPINFO_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean applyInstallCEP = false;
	
	private String convenioId = null;
	
	private String convenioDesc = null;
	
	private String bp = null;
	
	private String rfc = null;
	
	private String curp = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
	
	private String nss = null;
	
	private String folioCartaInstruccion = null;

	public ZCRMORI_E045_GETINSTALLCEPINFO_OutputData(){
		
	}
	
	

	/**
	 * @return the applyInstallCEP
	 */
	public boolean isApplyInstallCEP() {
		return applyInstallCEP;
	}



	/**
	 * @param applyInstallCEP the applyInstallCEP to set
	 */
	public void setApplyInstallCEP(boolean applyInstallCEP) {
		this.applyInstallCEP = applyInstallCEP;
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
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}



	/**
	 * @param bp the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
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
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}



	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
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
	 * @return the folioCartaInstruccion
	 */
	public String getFolioCartaInstruccion() {
		return folioCartaInstruccion;
	}



	/**
	 * @param folioCartaInstruccion the folioCartaInstruccion to set
	 */
	public void setFolioCartaInstruccion(String folioCartaInstruccion) {
		this.folioCartaInstruccion = folioCartaInstruccion;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
