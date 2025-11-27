/**
 * 
 */
package com.consubanco.sap.interfaces.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class Persona_Model implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String bp;
	private String clientId;
	private String rfc;
	private String curp;
	private String name1;
	private String name2;
	private String apePat;
	private String apeMat;
	private String email;
	

	/**
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}

	/**
	 * @param bp
	 *            the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * @param name1
	 *            the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * @param name2
	 *            the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * @return the apePat
	 */
	public String getApePat() {
		return apePat;
	}

	/**
	 * @param apePat
	 *            the apePat to set
	 */
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	/**
	 * @return the apeMat
	 */
	public String getApeMat() {
		return apeMat;
	}

	/**
	 * @param apeMat
	 *            the apeMat to set
	 */
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
