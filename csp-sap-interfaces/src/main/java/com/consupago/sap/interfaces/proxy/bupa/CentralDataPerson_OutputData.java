/**
 * 
 */
package com.consupago.sap.interfaces.proxy.bupa;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class CentralDataPerson_OutputData implements Serializable,
		IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String primerNombre = null;
	
	private String segundoNombre = null;

	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private Date fechaNacimiento = null;
	
	
	
	/**
* 
*/
	public CentralDataPerson_OutputData() {
		super();
	}

	
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
