/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZWRKQUEUE_UNASIGN_SOLS_Model implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3586182300971070374L;

	private String bpId;
	private Integer numSol;

	public ZWRKQUEUE_UNASIGN_SOLS_Model() {
		super();
	}

	/**
	 * 
	 * @param bpId
	 * @param numSol
	 */
	public ZWRKQUEUE_UNASIGN_SOLS_Model(String bpId, Integer numSol) {
		super();
		this.bpId = bpId;
		this.numSol = numSol;
	}

	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}

	/**
	 * @param bpId
	 *            the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	/**
	 * @return the numSol
	 */
	public Integer getNumSol() {
		return numSol;
	}

	/**
	 * @param numSol
	 *            the numSol to set
	 */
	public void setNumSol(Integer numSol) {
		this.numSol = numSol;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
