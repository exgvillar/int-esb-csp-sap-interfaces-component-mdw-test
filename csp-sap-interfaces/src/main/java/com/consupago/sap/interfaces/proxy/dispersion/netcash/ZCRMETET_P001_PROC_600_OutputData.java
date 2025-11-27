package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMETET_P001_PROC_600_OutputData implements Serializable,
		IProxyOutputData {
	private static final long serialVersionUID = 8848847351411134023L;
	
	private String zidEmpresa; // Organizacion de ventas: Denominacion departamento
	private String zdescripcionViaPago; // Via de pago
	private String zclaveBanco; // Clave de pais del banco
	private String zclaveInterbancaria; // Num cuenta bancaria
	private String zrefere; // Campo de usuario para cluster PC nacional
	private String zmontoSolicitud; // Subtotal 1 de la condicion proveniente del esquema calculo
	private String znumord; // Campo numérico, longitud 12
	private String zmon; // Moneda
	private String zbuGroup; // Agrupacion interl.comerciales
	private String zapePaternoClie; // Apellido de interlocutor comercial (persona)
	private String zapeMaternoClie; // Segundo apellido de persona
	private String znombreClie; // Char 80
	private String znombreClie2; // Número de identificacion
	private String zrfcCliente; // Clase de identificacion
	private String zidType; // Número de identificacion
	private String zid; // 30 caracteres
	private String ztipsol; // Número de interlocutor comercial
	private String zbpCliente; // ID operacion
	private String znumSol; // Campo de texto, longitud 10
	private String zfechaSolicitud; // Nun cuenta bancaria
	private String zconban; // Abreviatura oficina ventas
	private String zidSucursal; // Denominacion de objeto
	private String zdescSucursal; // Abreviatura oficina ventas
	private String zidDistribuidor; // Denominacion de objeto
	private String zdescDistribuidor; // ID producto
	private String zconvenio; // Denominacion del producto
	private String znomconv; // Num. 1
	private String zconvf; // Campo de texto, longitud 10
	private String zfecaut; // Subtotal 1 de la condicion proveniente del esquema calculo
	private String zmontoAut; // Subtotal 1 de la condicion proveniente del esquema calculo
	private String zmontoDes; // Subtotal 1 de la condicion proveniente del esquema calculo
	private String zplazo; // Numc3, utilizacion interna
	private String zscm; // Caracter 60
	private String zidOrdserv; // ID de operacion
	private String zfcreaOs; // Campo de tipo DATS
	private String zstatusOs; // Status individual de un objeto
	private String zimpOs; // Subtotal 1 de la condicion proveniente del esquema calculo
	private String mensaje;  // mensaje en caso de error, campo para CRM
	private boolean isError; // flag para identificar registro con error, campo para CRM.
	private ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> arrMsgReturn;


	public String getZidEmpresa() {
		return zidEmpresa;
	}

	public void setZidEmpresa(String zidEmpresa) {
		this.zidEmpresa = zidEmpresa;
	}

	public String getZdescripcionViaPago() {
		return zdescripcionViaPago;
	}

	public void setZdescripcionViaPago(String zdescripcionViaPago) {
		this.zdescripcionViaPago = zdescripcionViaPago;
	}

	public String getZclaveBanco() {
		return zclaveBanco;
	}

	public void setZclaveBanco(String zclaveBanco) {
		this.zclaveBanco = zclaveBanco;
	}

	public String getZclaveInterbancaria() {
		return zclaveInterbancaria;
	}

	public void setZclaveInterbancaria(String zclaveInterbancaria) {
		this.zclaveInterbancaria = zclaveInterbancaria;
	}

	public String getZrefere() {
		return zrefere;
	}

	public void setZrefere(String zrefere) {
		this.zrefere = zrefere;
	}

	public String getZmontoSolicitud() {
		return zmontoSolicitud;
	}

	public void setZmontoSolicitud(String zmontoSolicitud) {
		this.zmontoSolicitud = zmontoSolicitud;
	}

	public String getZnumord() {
		return znumord;
	}

	public void setZnumord(String znumord) {
		this.znumord = znumord;
	}

	public String getZmon() {
		return zmon;
	}

	public void setZmon(String zmon) {
		this.zmon = zmon;
	}

	public String getZbuGroup() {
		return zbuGroup;
	}

	public void setZbuGroup(String zbuGroup) {
		this.zbuGroup = zbuGroup;
	}

	public String getZapePaternoClie() {
		return zapePaternoClie;
	}

	public void setZapePaternoClie(String zapePaternoClie) {
		this.zapePaternoClie = zapePaternoClie;
	}

	public String getZapeMaternoClie() {
		return zapeMaternoClie;
	}

	public void setZapeMaternoClie(String zapeMaternoClie) {
		this.zapeMaternoClie = zapeMaternoClie;
	}

	public String getZnombreClie() {
		return znombreClie;
	}

	public void setZnombreClie(String znombreClie) {
		this.znombreClie = znombreClie;
	}

	public String getZnombreClie2() {
		return znombreClie2;
	}

	public void setZnombreClie2(String znombreClie2) {
		this.znombreClie2 = znombreClie2;
	}

	public String getZrfcCliente() {
		return zrfcCliente;
	}

	public void setZrfcCliente(String zrfcCliente) {
		this.zrfcCliente = zrfcCliente;
	}

	public String getZidType() {
		return zidType;
	}

	public void setZidType(String zidType) {
		this.zidType = zidType;
	}

	public String getZid() {
		return zid;
	}

	public void setZid(String zid) {
		this.zid = zid;
	}

	public String getZtipsol() {
		return ztipsol;
	}

	public void setZtipsol(String ztipsol) {
		this.ztipsol = ztipsol;
	}

	public String getZbpCliente() {
		return zbpCliente;
	}

	public void setZbpCliente(String zbpCliente) {
		this.zbpCliente = zbpCliente;
	}

	public String getZnumSol() {
		return znumSol;
	}

	public void setZnumSol(String znumSol) {
		this.znumSol = znumSol;
	}

	public String getZfechaSolicitud() {
		return zfechaSolicitud;
	}

	public void setZfechaSolicitud(String zfechaSolicitud) {
		this.zfechaSolicitud = zfechaSolicitud;
	}

	public String getZconban() {
		return zconban;
	}

	public void setZconban(String zconban) {
		this.zconban = zconban;
	}

	public String getZidSucursal() {
		return zidSucursal;
	}

	public void setZidSucursal(String zidSucursal) {
		this.zidSucursal = zidSucursal;
	}

	public String getZdescSucursal() {
		return zdescSucursal;
	}

	public void setZdescSucursal(String zdescSucursal) {
		this.zdescSucursal = zdescSucursal;
	}

	public String getZidDistribuidor() {
		return zidDistribuidor;
	}

	public void setZidDistribuidor(String zidDistribuidor) {
		this.zidDistribuidor = zidDistribuidor;
	}

	public String getZdescDistribuidor() {
		return zdescDistribuidor;
	}

	public void setZdescDistribuidor(String zdescDistribuidor) {
		this.zdescDistribuidor = zdescDistribuidor;
	}

	public String getZconvenio() {
		return zconvenio;
	}

	public void setZconvenio(String zconvenio) {
		this.zconvenio = zconvenio;
	}

	public String getZnomconv() {
		return znomconv;
	}

	public void setZnomconv(String znomconv) {
		this.znomconv = znomconv;
	}

	public String getZconvf() {
		return zconvf;
	}

	public void setZconvf(String zconvf) {
		this.zconvf = zconvf;
	}

	public String getZfecaut() {
		return zfecaut;
	}

	public void setZfecaut(String zfecaut) {
		this.zfecaut = zfecaut;
	}

	public String getZmontoAut() {
		return zmontoAut;
	}

	public void setZmontoAut(String zmontoAut) {
		this.zmontoAut = zmontoAut;
	}

	public String getZmontoDes() {
		return zmontoDes;
	}

	public void setZmontoDes(String zmontoDes) {
		this.zmontoDes = zmontoDes;
	}

	public String getZplazo() {
		return zplazo;
	}

	public void setZplazo(String zplazo) {
		this.zplazo = zplazo;
	}

	public String getZscm() {
		return zscm;
	}

	public void setZscm(String zscm) {
		this.zscm = zscm;
	}

	public String getZidOrdserv() {
		return zidOrdserv;
	}

	public void setZidOrdserv(String zidOrdserv) {
		this.zidOrdserv = zidOrdserv;
	}

	public String getZfcreaOs() {
		return zfcreaOs;
	}

	public void setZfcreaOs(String zfcreaOs) {
		this.zfcreaOs = zfcreaOs;
	}

	public String getZstatusOs() {
		return zstatusOs;
	}

	public void setZstatusOs(String zstatusOs) {
		this.zstatusOs = zstatusOs;
	}

	public String getZimpOs() {
		return zimpOs;
	}

	public void setZimpOs(String zimpOs) {
		this.zimpOs = zimpOs;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> getArrMsgReturn() {
		return arrMsgReturn;
	}

	public void setArrMsgReturn(
			ArrayList<ZCRMETET_P001_PROC_600_OutputMessage> arrMsgReturn) {
		this.arrMsgReturn = arrMsgReturn;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
