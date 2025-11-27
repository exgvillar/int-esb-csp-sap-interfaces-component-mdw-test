package com.consubanco.sap.interfaces.ine;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMBIO_E006_VALIDATEINE_OutputData implements Serializable, IProxyOutputData {

	private boolean success;
	private String message;
	private String taskBiometricsID;
	private String ineValidity;
	private boolean isValid;
	private List<ZMFile> files;
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
	 * @return the taskBiometricsID
	 */
	public String getTaskBiometricsID() {
		return taskBiometricsID;
	}
	/**
	 * @param taskBiometricsID the taskBiometricsID to set
	 */
	public void setTaskBiometricsID(String taskBiometricsID) {
		this.taskBiometricsID = taskBiometricsID;
	}
	/**
	 * @return the ineValidity
	 */
	public String getIneValidity() {
		return ineValidity;
	}
	/**
	 * @param ineValidity the ineValidity to set
	 */
	public void setIneValidity(String ineValidity) {
		this.ineValidity = ineValidity;
	}
	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}
	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	/**
	 * @return the files
	 */
	public List<ZMFile> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<ZMFile> files) {
		this.files = files;
	}
	

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
