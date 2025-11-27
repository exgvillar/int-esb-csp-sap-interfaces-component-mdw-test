/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.liquidity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMOP1098_P009_CONSCONVCOI_OutputData implements Serializable,
		IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6759939079201780039L;
	private String productId = null;
	
	/**
* 
*/
	public ZCRMOP1098_P009_CONSCONVCOI_OutputData() {
		super();
	}

	

	




	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}








	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}








	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
