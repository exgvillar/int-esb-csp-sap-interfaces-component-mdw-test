package com.consupago.sap.interfaces.proxy.common.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZGET_DISTRIBUIDOR_OutputData implements Serializable, IProxyOutputData {

	private static final long serialVersionUID = 8156477956436074978L;
	private String zObjidempresa;
	private String zEmpresa;
	private String zidEmpresa;
	private String zbpEmpresa;
	private String zObjiddistrib;
	private String zDistrib;
	private String zidDistrib;
	private String zbpDistrib;
	private String zObjidsucursal;
	private String zSucursal;
	private String zidSucursal;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getzObjidempresa() {
		return zObjidempresa;
	}

	public void setzObjidempresa(String zObjidempresa) {
		this.zObjidempresa = zObjidempresa;
	}

	public String getzEmpresa() {
		return zEmpresa;
	}

	public void setzEmpresa(String zEmpresa) {
		this.zEmpresa = zEmpresa;
	}

	public String getZidEmpresa() {
		return zidEmpresa;
	}

	public void setZidEmpresa(String zidEmpresa) {
		this.zidEmpresa = zidEmpresa;
	}

	public String getZbpEmpresa() {
		return zbpEmpresa;
	}

	public void setZbpEmpresa(String zbpEmpresa) {
		this.zbpEmpresa = zbpEmpresa;
	}

	public String getzObjiddistrib() {
		return zObjiddistrib;
	}

	public void setzObjiddistrib(String zObjiddistrib) {
		this.zObjiddistrib = zObjiddistrib;
	}

	public String getzDistrib() {
		return zDistrib;
	}

	public void setzDistrib(String zDistrib) {
		this.zDistrib = zDistrib;
	}

	public String getZidDistrib() {
		return zidDistrib;
	}

	public void setZidDistrib(String zidDistrib) {
		this.zidDistrib = zidDistrib;
	}

	public String getZbpDistrib() {
		return zbpDistrib;
	}

	public void setZbpDistrib(String zbpDistrib) {
		this.zbpDistrib = zbpDistrib;
	}

	public String getzObjidsucursal() {
		return zObjidsucursal;
	}

	public void setzObjidsucursal(String zObjidsucursal) {
		this.zObjidsucursal = zObjidsucursal;
	}

	public String getzSucursal() {
		return zSucursal;
	}

	public void setzSucursal(String zSucursal) {
		this.zSucursal = zSucursal;
	}

	public String getZidSucursal() {
		return zidSucursal;
	}

	public void setZidSucursal(String zidSucursal) {
		this.zidSucursal = zidSucursal;
	}

	
	
}
