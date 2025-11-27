/**
 * 
 */
package com.consubanco.sap.interfaces.commons.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo - Tw @adrixmnt
 *
 */
public class ZESCRMORI_TableIds implements Serializable {

	private String partner = "";
	private String type = "";
	private String idnumber = "";
	private static final long serialVersionUID = 1L;

	/**
	 * @return the partner
	 */
	public String getPartner() {
		return partner;
	}

	/**
	 * @param partner
	 *           the partner to set
	 */
	public void setPartner(String partner) {
		this.partner = partner;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the idnumber
	 */
	public String getIdnumber() {
		return idnumber;
	}

	/**
	 * @param idnumber
	 *           the idnumber to set
	 */
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
