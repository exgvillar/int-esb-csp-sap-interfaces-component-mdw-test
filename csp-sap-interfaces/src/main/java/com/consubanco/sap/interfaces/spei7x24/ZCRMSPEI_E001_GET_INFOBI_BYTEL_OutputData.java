/**
 * 
 */
package com.consubanco.sap.interfaces.spei7x24;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.spei7x24.model.ET_INFOBI_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMSPEI_E001_GET_INFOBI_BYTEL_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4935652833821927883L;

	private boolean exito;
	private String message;
	private List<ET_INFOBI_Model> details;

	/**
	 * 
	 */
	public ZCRMSPEI_E001_GET_INFOBI_BYTEL_OutputData() {
		super();
	}

	/**
	 * @return the exito
	 */
	public boolean isExito() {
		return exito;
	}

	/**
	 * @param exito
	 *            the exito to set
	 */
	public void setExito(boolean exito) {
		this.exito = exito;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the details
	 */
	public List<ET_INFOBI_Model> getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(List<ET_INFOBI_Model> details) {
		this.details = details;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
