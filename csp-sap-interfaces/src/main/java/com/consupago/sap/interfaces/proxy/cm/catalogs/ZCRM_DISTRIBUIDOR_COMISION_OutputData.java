/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_DISTRIBUIDOR_COMISION_OutputData implements Serializable,
		IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6411003107585036547L;

	private String siglaDistribuidor = null;
	
	private String nombreDistribuidor = null;

	
	/**
* 
*/
	public ZCRM_DISTRIBUIDOR_COMISION_OutputData() {
		super();
	}

	
	
	




	/**
	 * @return the siglaDistribuidor
	 */
	public String getSiglaDistribuidor() {
		return siglaDistribuidor;
	}








	/**
	 * @param siglaDistribuidor the siglaDistribuidor to set
	 */
	public void setSiglaDistribuidor(String siglaDistribuidor) {
		this.siglaDistribuidor = siglaDistribuidor;
	}








	/**
	 * @return the nombreDistribuidor
	 */
	public String getNombreDistribuidor() {
		return nombreDistribuidor;
	}








	/**
	 * @param nombreDistribuidor the nombreDistribuidor to set
	 */
	public void setNombreDistribuidor(String nombreDistribuidor) {
		this.nombreDistribuidor = nombreDistribuidor;
	}








	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
