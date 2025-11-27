package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.recomendados.model.CONVENIO_Model;
import com.consubanco.sap.interfaces.recomendados.model.DISTRIBUIDOR_Model;
import com.consubanco.sap.interfaces.recomendados.model.SUCURSAL_Model;
import com.consubanco.sap.interfaces.recomendados.model.EMPRESA_Model;
import com.consubanco.sap.interfaces.recomendados.model.PRODUCTO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_E002_GETINFO_CLTEREFI_OutputData implements Serializable,
	IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private EMPRESA_Model empresa = null;
	
	private DISTRIBUIDOR_Model distribuidor = null;
	
	private SUCURSAL_Model sucursal = null;
	
	private CONVENIO_Model convenio = null;
	
	private PRODUCTO_Model producto = null;

	private String numeroSolicitud = null;

	
	
	public ZCRMRECO_E002_GETINFO_CLTEREFI_OutputData() {
		super();
	}

	

	/**
	 * @return the empresa
	 */
	public EMPRESA_Model getEmpresa() {
		return empresa;
	}



	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EMPRESA_Model empresa) {
		this.empresa = empresa;
	}



	/**
	 * @return the distribuidor
	 */
	public DISTRIBUIDOR_Model getDistribuidor() {
		return distribuidor;
	}



	/**
	 * @param distribuidor the distribuidor to set
	 */
	public void setDistribuidor(DISTRIBUIDOR_Model distribuidor) {
		this.distribuidor = distribuidor;
	}



	/**
	 * @return the sucursal
	 */
	public SUCURSAL_Model getSucursal() {
		return sucursal;
	}



	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(SUCURSAL_Model sucursal) {
		this.sucursal = sucursal;
	}



	/**
	 * @return the convenio
	 */
	public CONVENIO_Model getConvenio() {
		return convenio;
	}



	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(CONVENIO_Model convenio) {
		this.convenio = convenio;
	}



	/**
	 * @return the producto
	 */
	public PRODUCTO_Model getProducto() {
		return producto;
	}



	/**
	 * @param producto the producto to set
	 */
	public void setProducto(PRODUCTO_Model producto) {
		this.producto = producto;
	}



	/**
	 * @return the numeroSolicitud
	 */
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}



	/**
	 * @param numeroSolicitud the numeroSolicitud to set
	 */
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}