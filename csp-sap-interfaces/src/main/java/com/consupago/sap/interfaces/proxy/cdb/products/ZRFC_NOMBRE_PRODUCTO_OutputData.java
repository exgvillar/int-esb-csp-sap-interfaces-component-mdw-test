/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.products;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_NOMBRE_PRODUCTO_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String productName = null;
	
	private double iva = 0;

	/**
* 
*/
	public ZRFC_NOMBRE_PRODUCTO_OutputData() {
		super();
	}

	

	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}




	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	


	/**
	 * @return the iva
	 */
	public double getIva() {
		return iva;
	}




	/**
	 * @param iva the iva to set
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
