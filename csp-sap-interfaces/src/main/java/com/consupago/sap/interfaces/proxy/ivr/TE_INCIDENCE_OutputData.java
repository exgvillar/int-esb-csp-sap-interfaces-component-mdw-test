/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author haydee.sanchez
 *
 */
public class TE_INCIDENCE_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String id = null;
	
	private String causeId = null;
	
	private String cause = null;
	
	private String motiveId = null;

	private String motive = null;
	
	private String descExt = null;
		
	
	
	
	/**
	 * 
	 */
	public TE_INCIDENCE_OutputData() {
		super();
	}

	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the causeId
	 */
	public String getCauseId() {
		return causeId;
	}



	/**
	 * @param causeId the causeId to set
	 */
	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}



	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}



	/**
	 * @param cause the cause to set
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}



	/**
	 * @return the motiveId
	 */
	public String getMotiveId() {
		return motiveId;
	}



	/**
	 * @param motiveId the motiveId to set
	 */
	public void setMotiveId(String motiveId) {
		this.motiveId = motiveId;
	}



	/**
	 * @return the motive
	 */
	public String getMotive() {
		return motive;
	}



	/**
	 * @param motive the motive to set
	 */
	public void setMotive(String motive) {
		this.motive = motive;
	}



	/**
	 * @return the descExt
	 */
	public String getDescExt() {
		return descExt;
	}



	/**
	 * @param descExt the descExt to set
	 */
	public void setDescExt(String descExt) {
		this.descExt = descExt;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
