/**
 * 
 */
package com.consubanco.sap.interfaces.sic.requests;

import java.io.Serializable;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_SIC_DATOS_DINAMICOS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String documentId = null;
	
	private String documentDesc = null;
	
	private String fieldId = null;
	
	private String fieldDesc = null;
	
	private String value = null;
	
	private String numberRN = null;  // número de consecutivo del recibo de nómina

	
	
	/**
	 * 
	 */
	public ZFM_SIC_DATOS_DINAMICOS_OutputData() {
		super();
	}

	

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}



	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}



	/**
	 * @return the documentDesc
	 */
	public String getDocumentDesc() {
		return documentDesc;
	}



	/**
	 * @param documentDesc the documentDesc to set
	 */
	public void setDocumentDesc(String documentDesc) {
		this.documentDesc = documentDesc;
	}



	/**
	 * @return the fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}



	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}



	/**
	 * @return the fieldDesc
	 */
	public String getFieldDesc() {
		return fieldDesc;
	}



	/**
	 * @param fieldDesc the fieldDesc to set
	 */
	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}



	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}



	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}



	/**
	 * @return the numberRN
	 */
	public String getNumberRN() {
		return numberRN;
	}



	/**
	 * @param numberRN the numberRN to set
	 */
	public void setNumberRN(String numberRN) {
		this.numberRN = numberRN;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
