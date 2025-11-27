/**
 * 
 */
package com.consupago.sap.interfaces.proxy.applications;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZES_ATRIBORI_Model;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_TELEFONOS_Model;

/**
 * @author
 * 
 */
public class ZCRMORI_GETSOLICITUDES_RESERVA_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idConvenio;
	private String idSolicitud;
	private String idBrms;
	private String descConvenio;
	private String idStatus;
	private String descStatus;
	private Date fechaStatus;
	private String bpId;
	private String rfcSolicitante;
	private String nombre1;
	private String nombre2;
	private String apPaterno;
	private String apMaterno;
	private String folioReserva;
	private Date fechaReserva;
	private String idProducto;
	private String descProducto;
	private String cateProducto;
	private String descCateProducto;
	private ZES_ATRIBORI_Model originationDetail;
	private ArrayList<ZTT_TELEFONOS_Model> phones;

	private String message;
	
	/**
	 * @return the idConvenio
	 */
	public String getIdConvenio() {
		return idConvenio;
	}

	/**
	 * @param idConvenio the idConvenio to set
	 */
	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}

	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	/**
	 * @return the idBrms
	 */
	public String getIdBrms() {
		return idBrms;
	}

	/**
	 * @param idBrms the idBrms to set
	 */
	public void setIdBrms(String idBrms) {
		this.idBrms = idBrms;
	}

	/**
	 * @return the descConvenio
	 */
	public String getDescConvenio() {
		return descConvenio;
	}

	/**
	 * @param descConvenio the descConvenio to set
	 */
	public void setDescConvenio(String descConvenio) {
		this.descConvenio = descConvenio;
	}

	/**
	 * @return the idStatus
	 */
	public String getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the descStatus
	 */
	public String getDescStatus() {
		return descStatus;
	}

	/**
	 * @param descStatus the descStatus to set
	 */
	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}

	/**
	 * @return the fechaStatus
	 */
	public Date getFechaStatus() {
		return fechaStatus;
	}

	/**
	 * @param fechaStatus the fechaStatus to set
	 */
	public void setFechaStatus(Date fechaStatus) {
		this.fechaStatus = fechaStatus;
	}

	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}

	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	/**
	 * @return the rfcSolicitante
	 */
	public String getRfcSolicitante() {
		return rfcSolicitante;
	}

	/**
	 * @param rfcSolicitante the rfcSolicitante to set
	 */
	public void setRfcSolicitante(String rfcSolicitante) {
		this.rfcSolicitante = rfcSolicitante;
	}

	/**
	 * @return the nombre1
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * @param nombre1 the nombre1 to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @return the folioReserva
	 */
	public String getFolioReserva() {
		return folioReserva;
	}

	/**
	 * @param folioReserva the folioReserva to set
	 */
	public void setFolioReserva(String folioReserva) {
		this.folioReserva = folioReserva;
	}

	/**
	 * @return the fechaReserva
	 */
	public Date getFechaReserva() {
		return fechaReserva;
	}

	/**
	 * @param fechaReserva the fechaReserva to set
	 */
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the descProducto
	 */
	public String getDescProducto() {
		return descProducto;
	}

	/**
	 * @param descProducto the descProducto to set
	 */
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	/**
	 * @return the cateProducto
	 */
	public String getCateProducto() {
		return cateProducto;
	}

	/**
	 * @param cateProducto the cateProducto to set
	 */
	public void setCateProducto(String cateProducto) {
		this.cateProducto = cateProducto;
	}

	/**
	 * @return the descCateProducto
	 */
	public String getDescCateProducto() {
		return descCateProducto;
	}

	/**
	 * @param descCateProducto the descCateProducto to set
	 */
	public void setDescCateProducto(String descCateProducto) {
		this.descCateProducto = descCateProducto;
	}

	/**
	 * @return the originationDetail
	 */
	public ZES_ATRIBORI_Model getOriginationDetail() {
		return originationDetail;
	}

	/**
	 * @param originationDetail the originationDetail to set
	 */
	public void setOriginationDetail(ZES_ATRIBORI_Model originationDetail) {
		this.originationDetail = originationDetail;
	}

	/**
	 * @return the phones
	 */
	public ArrayList<ZTT_TELEFONOS_Model> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(ArrayList<ZTT_TELEFONOS_Model> phones) {
		this.phones = phones;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
	

}
