/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bt.model.ZTL_PHONE_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMBT_E001_BUSCA_TEL_BP_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	 private String bp = null;
	 
	 private String interlocutorFunction = null;
	 
	 private ArrayList<ZTL_PHONE_Model> phones = null;
	 
	/**
	 * 
	 */
	public ZCRMBT_E001_BUSCA_TEL_BP_OutputData() {
		super();
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getInterlocutorFunction() {
		return interlocutorFunction;
	}

	public void setInterlocutorFunction(String interlocutorFunction) {
		this.interlocutorFunction = interlocutorFunction;
	}

	public ArrayList<ZTL_PHONE_Model> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<ZTL_PHONE_Model> phones) {
		this.phones = phones;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
