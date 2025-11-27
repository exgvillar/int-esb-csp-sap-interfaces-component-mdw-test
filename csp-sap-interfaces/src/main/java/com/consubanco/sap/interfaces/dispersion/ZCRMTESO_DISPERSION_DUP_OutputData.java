/**
 * 
 */
package com.consubanco.sap.interfaces.dispersion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_DISPERSION_DUP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean exist = false;
	
	
	
	/**
	 * 
	 */
	public ZCRMTESO_DISPERSION_DUP_OutputData() {
		super();
	}

	

	/**
	 * @return the exist
	 */
	public boolean isExist() {
		return exist;
	}



	/**
	 * @param exist the exist to set
	 */
	public void setExist(boolean exist) {
		this.exist = exist;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
