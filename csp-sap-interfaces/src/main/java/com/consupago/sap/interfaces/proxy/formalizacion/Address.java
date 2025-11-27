package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class Address implements Serializable {
	private static final long serialVersionUID = -1754541539540424112L;
	private String addressstreet;
	private String addressstateCrm;
	private String addresspostalCode;
	private String addressmunicipio;
	private String addressinternalNbr;
	private String addressexternalNbr;
	private String addresscolonia;
	private String addressciudad;
	private String addressaddressTypeNm;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getAddressstreet() {
		return addressstreet;
	}

	public void setAddressstreet(String addressstreet) {
		this.addressstreet = addressstreet;
	}

	public String getAddressstateCrm() {
		return addressstateCrm;
	}

	public void setAddressstateCrm(String addressstateCrm) {
		this.addressstateCrm = addressstateCrm;
	}

	public String getAddresspostalCode() {
		return addresspostalCode;
	}

	public void setAddresspostalCode(String addresspostalCode) {
		this.addresspostalCode = addresspostalCode;
	}

	public String getAddressmunicipio() {
		return addressmunicipio;
	}

	public void setAddressmunicipio(String addressmunicipio) {
		this.addressmunicipio = addressmunicipio;
	}

	public String getAddressinternalNbr() {
		return addressinternalNbr;
	}

	public void setAddressinternalNbr(String addressinternalNbr) {
		this.addressinternalNbr = addressinternalNbr;
	}

	public String getAddressexternalNbr() {
		return addressexternalNbr;
	}

	public void setAddressexternalNbr(String addressexternalNbr) {
		this.addressexternalNbr = addressexternalNbr;
	}

	public String getAddresscolonia() {
		return addresscolonia;
	}

	public void setAddresscolonia(String addresscolonia) {
		this.addresscolonia = addresscolonia;
	}

	public String getAddressciudad() {
		return addressciudad;
	}

	public void setAddressciudad(String addressciudad) {
		this.addressciudad = addressciudad;
	}

	public String getAddressaddressTypeNm() {
		return addressaddressTypeNm;
	}

	public void setAddressaddressTypeNm(String addressaddressTypeNm) {
		this.addressaddressTypeNm = addressaddressTypeNm;
	}
}
