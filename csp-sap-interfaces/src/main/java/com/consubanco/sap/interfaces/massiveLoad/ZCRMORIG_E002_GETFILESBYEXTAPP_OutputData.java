/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

import java.io.Serializable;
import java.util.ArrayList;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consubanco.sap.interfaces.massiveLoad.model.ZTT_File_Model;

/**
 * @author hsanchez
 *
 */
public class ZCRMORIG_E002_GETFILESBYEXTAPP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String opportunityId = null;
	
	private String caseId = null;
	
	private String sourceChannel = null;
	
	private ArrayList<ZTT_File_Model> files = null;

	/**
	 * 
	 */
	public ZCRMORIG_E002_GETFILESBYEXTAPP_OutputData() {
		super();
	}

	/**
	 * @return the opportunityId
	 */
	public String getOpportunityId() {
		return opportunityId;
	}

	/**
	 * @param opportunityId the opportunityId to set
	 */
	public void setOpportunityId(String opportunityId) {
		this.opportunityId = opportunityId;
	}

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the sourceChannel
	 */
	public String getSourceChannel() {
		return sourceChannel;
	}

	/**
	 * @param sourceChannel the sourceChannel to set
	 */
	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	/**
	 * @return the files
	 */
	public ArrayList<ZTT_File_Model> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(ArrayList<ZTT_File_Model> files) {
		this.files = files;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
