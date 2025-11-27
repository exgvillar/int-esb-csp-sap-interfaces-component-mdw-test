/**
 * 
 */
package com.consupago.sap.interfaces.proxy.applications.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author
 *
 */
public class ZTT_TELEFONOS_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String numTel;
	private String numExt;
	private String tipAdd;
	private String tipTel;
	
	/**
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}
	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	/**
	 * @return the numExt
	 */
	public String getNumExt() {
		return numExt;
	}
	/**
	 * @param numExt the numExt to set
	 */
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	/**
	 * @return the tipAdd
	 */
	public String getTipAdd() {
		return tipAdd;
	}
	/**
	 * @param tipAdd the tipAdd to set
	 */
	public void setTipAdd(String tipAdd) {
		this.tipAdd = tipAdd;
	}
	/**
	 * @return the tipTel
	 */
	public String getTipTel() {
		return tipTel;
	}
	/**
	 * @param tipTel the tipTel to set
	 */
	public void setTipTel(String tipTel) {
		this.tipTel = tipTel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

	
	
	
}
