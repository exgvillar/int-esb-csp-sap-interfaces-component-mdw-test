package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMCSB_P002_GETBP_FROM_FP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String bpId;
	private String nameBP;
	private String pictureB64;
	

	public ZCRMCSB_P002_GETBP_FROM_FP_OutputData() {
		
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
	 * @return the nameBP
	 */
	public String getNameBP() {
		return nameBP;
	}


	/**
	 * @param nameBP the nameBP to set
	 */
	public void setNameBP(String nameBP) {
		this.nameBP = nameBP;
	}


	/**
	 * @return the pictureB64
	 */
	public String getPictureB64() {
		return pictureB64;
	}


	/**
	 * @param pictureB64 the pictureB64 to set
	 */
	public void setPictureB64(String pictureB64) {
		this.pictureB64 = pictureB64;
	}
	


}
