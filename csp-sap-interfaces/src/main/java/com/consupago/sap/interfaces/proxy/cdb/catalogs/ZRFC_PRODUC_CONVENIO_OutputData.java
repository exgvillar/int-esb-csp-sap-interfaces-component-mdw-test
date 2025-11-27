/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_PRODUC_CONVENIO_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3740797158051212965L;

	private String productId = null;
	
	private String productText = null;
	
	private double iva = 0;
	
	private String categoria = null;
		
	/**
	 * 
	 */
	public ZRFC_PRODUC_CONVENIO_OutputData() {
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



	/**
	 * @return the productText
	 */
	public String getProductText() {
		return productText;
	}



	/**
	 * @param productText the productText to set
	 */
	public void setProductText(String productText) {
		this.productText = productText;
	}



	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}



	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	


	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}



	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	/**
	 * @param iva the iva to set
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
