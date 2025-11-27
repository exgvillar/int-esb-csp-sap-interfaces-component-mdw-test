/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author jcontreras
 *
 */
public class Interlocutores_OutputData implements Serializable {
	private static final long serialVersionUID = -2018781277647630170L;

	private String interlocFuncId;
	private String interlocFuncDesc;
	private String interlocBPId;
	private String interlocNom1;
	private String interlocNom2;
	private String interlocApPat;
	private String interlocApMat;
	private String interlocEstat;
	

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}


	public String getInterlocFuncId() {
		return interlocFuncId;
	}


	public void setInterlocFuncId(String interlocFuncId) {
		this.interlocFuncId = interlocFuncId;
	}


	public String getInterlocFuncDesc() {
		return interlocFuncDesc;
	}


	public void setInterlocFuncDesc(String interlocFuncDesc) {
		this.interlocFuncDesc = interlocFuncDesc;
	}


	public String getInterlocBPId() {
		return interlocBPId;
	}


	public void setInterlocBPId(String interlocBPId) {
		this.interlocBPId = interlocBPId;
	}


	public String getInterlocNom1() {
		return interlocNom1;
	}


	public void setInterlocNom1(String interlocNom1) {
		this.interlocNom1 = interlocNom1;
	}


	public String getInterlocNom2() {
		return interlocNom2;
	}


	public void setInterlocNom2(String interlocNom2) {
		this.interlocNom2 = interlocNom2;
	}


	public String getInterlocApPat() {
		return interlocApPat;
	}


	public void setInterlocApPat(String interlocApPat) {
		this.interlocApPat = interlocApPat;
	}


	public String getInterlocApMat() {
		return interlocApMat;
	}


	public void setInterlocApMat(String interlocApMat) {
		this.interlocApMat = interlocApMat;
	}


	public String getInterlocEstat() {
		return interlocEstat;
	}


	public void setInterlocEstat(String interlocEstat) {
		this.interlocEstat = interlocEstat;
	}

}