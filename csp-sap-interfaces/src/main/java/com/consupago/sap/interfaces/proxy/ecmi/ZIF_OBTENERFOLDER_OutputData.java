/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ecmi;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZIF_OBTENERFOLDER_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199517694044279653L;

	private String folderECMI = null;
	
	
	/**
* 
*/
	public ZIF_OBTENERFOLDER_OutputData() {
		super();
	}

	
	

	/**
	 * @return the folderECMI
	 */
	public String getFolderECMI() {
		return folderECMI;
	}




	/**
	 * @param folderECMI the folderECMI to set
	 */
	public void setFolderECMI(String folderECMI) {
		this.folderECMI = folderECMI;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
