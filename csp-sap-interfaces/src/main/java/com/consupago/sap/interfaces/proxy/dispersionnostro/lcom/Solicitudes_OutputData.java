/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro.lcom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 *
 */
public class Solicitudes_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numDoc;
	private String tipDoc;
	private String category;
	private String clientId;
	private String nombre1;
	private String nombre2;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String status;
	private String statusDesc;
	private Date fecNac;
	private String rfc;
	private Date fecSol;
	private String frecPago;
	private String idConvenio;
	private String descConvenio;
	private String idEmpresa;

	private String descEmpresa;
	private double monto;
	private double montoLiqu;
	private String producto;
	private String descProducto;
	private String plazo;
	private String porcInt;
	private String credSus;

	private ArrayList<OrdenesServicios_OutputData> ordenServicioList;




	public String getNumDoc() {
		return numDoc;
	}




	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}




	public String getTipDoc() {
		return tipDoc;
	}




	public void setTipDoc(String tipDoc) {
		this.tipDoc = tipDoc;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getClientId() {
		return clientId;
	}




	public void setClientId(String clientId) {
		this.clientId = clientId;
	}




	public String getNombre1() {
		return nombre1;
	}




	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}




	public String getNombre2() {
		return nombre2;
	}




	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}




	public String getApellidoPaterno() {
		return apellidoPaterno;
	}




	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}




	public String getApellidoMaterno() {
		return apellidoMaterno;
	}




	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	



	public String getStatusDesc() {
		return statusDesc;
	}




	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}




	




	public Date getFecNac() {
		return fecNac;
	}




	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}




	public String getRfc() {
		return rfc;
	}




	public void setRfc(String rfc) {
		this.rfc = rfc;
	}




	public Date getFecSol() {
		return fecSol;
	}




	public void setFecSol(Date fecSol) {
		this.fecSol = fecSol;
	}




	public String getFrecPago() {
		return frecPago;
	}




	public void setFrecPago(String frecPago) {
		this.frecPago = frecPago;
	}




	public String getIdConvenio() {
		return idConvenio;
	}




	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}




	public String getDescConvenio() {
		return descConvenio;
	}




	public void setDescConvenio(String descConvenio) {
		this.descConvenio = descConvenio;
	}




	public String getIdEmpresa() {
		return idEmpresa;
	}




	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}




	public String getDescEmpresa() {
		return descEmpresa;
	}




	public void setDescEmpresa(String descEmpresa) {
		this.descEmpresa = descEmpresa;
	}






	public double getMonto() {
		return monto;
	}




	public void setMonto(double monto) {
		this.monto = monto;
	}




	


	public double getMontoLiqu() {
		return montoLiqu;
	}




	public void setMontoLiqu(double montoLiqu) {
		this.montoLiqu = montoLiqu;
	}




	public String getProducto() {
		return producto;
	}




	public void setProducto(String producto) {
		this.producto = producto;
	}




	public String getDescProducto() {
		return descProducto;
	}




	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}




	public String getPlazo() {
		return plazo;
	}




	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}




	public String getPorcInt() {
		return porcInt;
	}




	public void setPorcInt(String porcInt) {
		this.porcInt = porcInt;
	}




	public String getCredSus() {
		return credSus;
	}




	public void setCredSus(String credSus) {
		this.credSus = credSus;
	}







	public ArrayList<OrdenesServicios_OutputData> getOrdenServicioList() {
		return ordenServicioList;
	}




	public void setOrdenServicioList(
			ArrayList<OrdenesServicios_OutputData> ordenServicioList) {
		this.ordenServicioList = ordenServicioList;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
