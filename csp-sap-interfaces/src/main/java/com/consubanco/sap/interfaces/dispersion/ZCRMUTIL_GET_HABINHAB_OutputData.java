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
public class ZCRMUTIL_GET_HABINHAB_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean laborableDay = false;
	
	
	
	/**
	 * 
	 */
	public ZCRMUTIL_GET_HABINHAB_OutputData() {
		super();
	}

	



	/**
	 * @return the laborableDay
	 */
	public boolean isLaborableDay() {
		return laborableDay;
	}





	/**
	 * @param laborableDay the laborableDay to set
	 */
	public void setLaborableDay(boolean laborableDay) {
		this.laborableDay = laborableDay;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
