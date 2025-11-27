/**
 * 
 */
package com.consupago.sap.interfaces.proxy.imss.pensionados;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_E003_GET_PRODSIMSSPENS_OutputData implements Serializable,
		IProxyOutputData {

	private static final long serialVersionUID = 1635133723102290826L;
	private Integer productId;
	private String productName;
	private Integer empresaId;
	private String empresaName;
	private ArrayList<String> categoriasName;
	private Boolean isLcom;
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public String getEmpresaName() {
		return empresaName;
	}

	public void setEmpresaName(String empresaName) {
		this.empresaName = empresaName;
	}

	public ArrayList<String> getCategoriasName() {
		return categoriasName;
	}

	public void setCategoriasName(ArrayList<String> categoriasName) {
		this.categoriasName = categoriasName;
	}

	public Boolean getIsLcom() {
		return isLcom;
	}

	public void setIsLcom(Boolean isLcom) {
		this.isLcom = isLcom;
	}

}
