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
public class ZES_ATRIBORI_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean cnca;
	private boolean segundaDispo;
	private boolean lcom;
	private boolean creditoNuevo;
	private int numDispo;
	private boolean interCompania;
	
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
	 * @return the segundaDispo
	 */
	public boolean isSegundaDispo() {
		return segundaDispo;
	}
	/**
	 * @param segundaDispo the segundaDispo to set
	 */
	public void setSegundaDispo(boolean segundaDispo) {
		this.segundaDispo = segundaDispo;
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
	 * @return the creditoNuevo
	 */
	public boolean isCreditoNuevo() {
		return creditoNuevo;
	}
	/**
	 * @param creditoNuevo the creditoNuevo to set
	 */
	public void setCreditoNuevo(boolean creditoNuevo) {
		this.creditoNuevo = creditoNuevo;
	}
	/**
	 * @return the numDispo
	 */
	public int getNumDispo() {
		return numDispo;
	}
	/**
	 * @param numDispo the numDispo to set
	 */
	public void setNumDispo(int numDispo) {
		this.numDispo = numDispo;
	}
	/**
	 * @return the interCompania
	 */
	public boolean isInterCompania() {
		return interCompania;
	}
	/**
	 * @param interCompania the interCompania to set
	 */
	public void setInterCompania(boolean interCompania) {
		this.interCompania = interCompania;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	} 
	
	

}
