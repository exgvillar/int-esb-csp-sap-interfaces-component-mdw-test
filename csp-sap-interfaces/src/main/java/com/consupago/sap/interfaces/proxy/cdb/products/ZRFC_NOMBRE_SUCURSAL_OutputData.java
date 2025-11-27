/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.products;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_NOMBRE_SUCURSAL_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String branchName = null;

	/**
* 
*/
	public ZRFC_NOMBRE_SUCURSAL_OutputData() {
		super();
	}

	

	
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}




	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
