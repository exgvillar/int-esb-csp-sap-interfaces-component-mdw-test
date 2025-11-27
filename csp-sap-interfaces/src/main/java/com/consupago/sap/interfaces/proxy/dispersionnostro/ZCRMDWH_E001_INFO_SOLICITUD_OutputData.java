package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMDWH_E001_INFO_SOLICITUD_OutputData implements
		IProxyOutputData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Incidencias_OutputData> incidenciaList;
	private ArrayList<CuentasClientes_OutputData> cuentaClienteList;
	
	private ArrayList<OrganizacionCuentas_OutputData> organizacionCuentaList;
	
	private ArrayList<Servicios_OutputData> servicioList;
	
	private ArrayList<Tracking_OutputData> trackingList;
	
	private Solicitud_OutputData solicitud;
	private SolicitudCliente_OutputData solicitudCliente;
	private Promotor_OutputData promotor;
	private SolicitudOrganizacion_OutputData solicitudOrganizacion;
	
	private AtributosOriginacion_OutputData atributosOriginacion;
	
	private Convenio_OutputData convenio;
	
	private ArrayList<Recomendados_OutputData> recomendadosList;
	
	private CondicionesPrecio_OutputData condicionesPrecioOutputData;
	
	private ArrayList<Interlocutores_OutputData> interlocutoresList;
	
	private ArrayList<SeguroDeudor_OutputData> seguroDeudorList;
	
	private ArrayList<OtraRetencion_OutputData> otrasRetencionesList;
	
	
	
	public ArrayList<Incidencias_OutputData> getIncidenciaList() {
		return incidenciaList;
	}



	public void setIncidenciaList(ArrayList<Incidencias_OutputData> incidenciaList) {
		this.incidenciaList = incidenciaList;
	}



	public ArrayList<CuentasClientes_OutputData> getCuentaClienteList() {
		return cuentaClienteList;
	}



	public void setCuentaClienteList(
			ArrayList<CuentasClientes_OutputData> cuentaClienteList) {
		this.cuentaClienteList = cuentaClienteList;
	}



	public ArrayList<OrganizacionCuentas_OutputData> getOrganizacionCuentaList() {
		return organizacionCuentaList;
	}



	public void setOrganizacionCuentaList(
			ArrayList<OrganizacionCuentas_OutputData> organizacionCuentaList) {
		this.organizacionCuentaList = organizacionCuentaList;
	}

	


	public ArrayList<Servicios_OutputData> getServicioList() {
		return servicioList;
	}



	public void setServicioList(ArrayList<Servicios_OutputData> servicioList) {
		this.servicioList = servicioList;
	}

	
	


	public ArrayList<Tracking_OutputData> getTrackingList() {
		return trackingList;
	}



	public void setTrackingList(ArrayList<Tracking_OutputData> trackingList) {
		this.trackingList = trackingList;
	}



	public Solicitud_OutputData getSolicitud() {
		return solicitud;
	}



	public void setSolicitud(Solicitud_OutputData solicitud) {
		this.solicitud = solicitud;
	}



	public SolicitudCliente_OutputData getSolicitudCliente() {
		return solicitudCliente;
	}



	public void setSolicitudCliente(SolicitudCliente_OutputData solicitudCliente) {
		this.solicitudCliente = solicitudCliente;
	}



	public Promotor_OutputData getPromotor() {
		return promotor;
	}



	public void setPromotor(Promotor_OutputData promotor) {
		this.promotor = promotor;
	}



	public SolicitudOrganizacion_OutputData getSolicitudOrganizacion() {
		return solicitudOrganizacion;
	}



	public void setSolicitudOrganizacion(
			SolicitudOrganizacion_OutputData solicitudOrganizacion) {
		this.solicitudOrganizacion = solicitudOrganizacion;
	}



	public AtributosOriginacion_OutputData getAtributosOriginacion() {
		return atributosOriginacion;
	}



	public void setAtributosOriginacion(
			AtributosOriginacion_OutputData atributosOriginacion) {
		this.atributosOriginacion = atributosOriginacion;
	}



	public Convenio_OutputData getConvenio() {
		return convenio;
	}



	public void setConvenio(Convenio_OutputData convenio) {
		this.convenio = convenio;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}



	public ArrayList<Recomendados_OutputData> getRecomendadosList() {
		return recomendadosList;
	}



	public void setRecomendadosList(
			ArrayList<Recomendados_OutputData> recomendadosList) {
		this.recomendadosList = recomendadosList;
	}



	public CondicionesPrecio_OutputData getCondicionesPrecioOutputData() {
		return condicionesPrecioOutputData;
	}



	public void setCondicionesPrecioOutputData(
			CondicionesPrecio_OutputData condicionesPrecioOutputData) {
		this.condicionesPrecioOutputData = condicionesPrecioOutputData;
	}



	public ArrayList<Interlocutores_OutputData> getInterlocutoresList() {
		return interlocutoresList;
	}



	public void setInterlocutoresList(
			ArrayList<Interlocutores_OutputData> interlocutoresList) {
		this.interlocutoresList = interlocutoresList;
	}



	/**
	 * @return the seguroDeudorList
	 */
	public ArrayList<SeguroDeudor_OutputData> getSeguroDeudorList() {
		return seguroDeudorList;
	}



	/**
	 * @param seguroDeudorList the seguroDeudorList to set
	 */
	public void setSeguroDeudorList(
			ArrayList<SeguroDeudor_OutputData> seguroDeudorList) {
		this.seguroDeudorList = seguroDeudorList;
	}



	/**
	 * @return the otrasRetencionesList
	 */
	public ArrayList<OtraRetencion_OutputData> getOtrasRetencionesList() {
		return otrasRetencionesList;
	}



	/**
	 * @param otrasRetencionesList the otrasRetencionesList to set
	 */
	public void setOtrasRetencionesList(
			ArrayList<OtraRetencion_OutputData> otrasRetencionesList) {
		this.otrasRetencionesList = otrasRetencionesList;
	}

	
}
