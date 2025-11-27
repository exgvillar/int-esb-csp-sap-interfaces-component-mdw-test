/**
 * 
 */
package com.consubanco.sap.interfaces.spei7x24.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ET_INFOBI_Model implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2480783173042954622L;

	private String client;
	private String rfc;
	private String iBase;
	private String cuenta;
	private String clabe;
	private String solici;
	private String status;
	private String descstatus;

	/**
	 * 
	 */
	public ET_INFOBI_Model() {
		super();
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the iBase
	 */
	public String getiBase() {
		return iBase;
	}

	/**
	 * @param iBase
	 *            the iBase to set
	 */
	public void setiBase(String iBase) {
		this.iBase = iBase;
	}

	/**
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta
	 *            the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the clabe
	 */
	public String getClabe() {
		return clabe;
	}

	/**
	 * @param clabe
	 *            the clabe to set
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	/**
	 * @return the solici
	 */
	public String getSolici() {
		return solici;
	}

	/**
	 * @param solici
	 *            the solici to set
	 */
	public void setSolici(String solici) {
		this.solici = solici;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the descstatus
	 */
	public String getDescstatus() {
		return descstatus;
	}

	/**
	 * @param descstatus
	 *            the descstatus to set
	 */
	public void setDescstatus(String descstatus) {
		this.descstatus = descstatus;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
