/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recommender.model.Persona_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMRECO_E001_SEARCHREC_OutputData extends Persona_Model implements
		Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2478634869505821594L;

	private String company;
	private boolean blocked;
	private boolean locked;
	private boolean uifList;

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the blocked
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked
	 *            the blocked to set
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked
	 *            the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the uifList
	 */
	public boolean isUifList() {
		return uifList;
	}

	/**
	 * @param uifList
	 *            the uifList to set
	 */
	public void setUifList(boolean uifList) {
		this.uifList = uifList;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
