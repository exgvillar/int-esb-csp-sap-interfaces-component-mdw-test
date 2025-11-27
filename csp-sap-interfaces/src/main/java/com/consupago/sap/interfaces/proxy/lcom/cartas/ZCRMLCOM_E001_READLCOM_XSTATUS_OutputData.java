package com.consupago.sap.interfaces.proxy.lcom.cartas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData implements Serializable,
		IProxyOutputData {
	private String numdoc;
	private String tipdoc;
	private String numcli;
	private String nombre1;
	private String nombre2;
	private String apepat;
	private String apemat;
	private String status;
	private String destatus;
	private Date fecNac;
	private String rfcClte;
	private Date fecSol;
	private String frecPago;
	private String idConvenio;
	private String descConven;
	private String idEmpresa;
	private String descEmpresa;
	private BigDecimal monto;
	private BigDecimal montoLiqu;
	private String producto;
	private String descProducto;
	private String plazo;
	private String porcInt;
	private String credsus;
	private ArrayList<OrdenesServicio> ordenesServicio;
	private OrdenesServicio ordenesServ;
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public class OrdenesServicio{
		private String idOrdservOrdenServ;
		private String statusOsOrdenServ;
		private String descstatOsOrdenServ;
		private String idCompetidorOrdenServ;
		private String nombre1OrdenServ;
		private String nombre2OrdenServ;
		private String apepatOrdenServ;
		private String apematOrdenServ;
		private Date fechaEmisionOrdenServ;
		private Date fechaVencimientoOrdenServ;
		private Date fechaUltdesctoOrdenServ;
		private String frecPagoOrdenServ;
		private String descFrecPagoOrdenServ;
		private String conceptoOrdenServ;
		private BigDecimal montoOrdenServ;
		private String idMetodoPagoOrdenServ;
		private String desMetodoPagoOrdenServ;
		private Double pagsTransOrdenServ;
		private String referenciaOrdenServ;
		private String bancoCompetOrdenServ;
		private String cuentaBancariaOrdenServ;
		private String claveBancoOrdenServ;
		private String referenciaBancariaOrdenServ;

		public String toString() {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}

		public String getIdOrdservOrdenServ() {
			return idOrdservOrdenServ;
		}

		public void setIdOrdservOrdenServ(String idOrdservOrdenServ) {
			this.idOrdservOrdenServ = idOrdservOrdenServ;
		}

		public String getStatusOsOrdenServ() {
			return statusOsOrdenServ;
		}

		public void setStatusOsOrdenServ(String statusOsOrdenServ) {
			this.statusOsOrdenServ = statusOsOrdenServ;
		}

		public String getDescstatOsOrdenServ() {
			return descstatOsOrdenServ;
		}

		public void setDescstatOsOrdenServ(String descstatOsOrdenServ) {
			this.descstatOsOrdenServ = descstatOsOrdenServ;
		}

		public String getIdCompetidorOrdenServ() {
			return idCompetidorOrdenServ;
		}

		public void setIdCompetidorOrdenServ(String idCompetidorOrdenServ) {
			this.idCompetidorOrdenServ = idCompetidorOrdenServ;
		}

		public String getNombre1OrdenServ() {
			return nombre1OrdenServ;
		}

		public void setNombre1OrdenServ(String nombre1OrdenServ) {
			this.nombre1OrdenServ = nombre1OrdenServ;
		}

		public String getNombre2OrdenServ() {
			return nombre2OrdenServ;
		}

		public void setNombre2OrdenServ(String nombre2OrdenServ) {
			this.nombre2OrdenServ = nombre2OrdenServ;
		}

		public String getApepatOrdenServ() {
			return apepatOrdenServ;
		}

		public void setApepatOrdenServ(String apepatOrdenServ) {
			this.apepatOrdenServ = apepatOrdenServ;
		}

		public String getApematOrdenServ() {
			return apematOrdenServ;
		}

		public void setApematOrdenServ(String apematOrdenServ) {
			this.apematOrdenServ = apematOrdenServ;
		}

		public Date getFechaEmisionOrdenServ() {
			return fechaEmisionOrdenServ;
		}

		public void setFechaEmisionOrdenServ(Date fechaEmisionOrdenServ) {
			this.fechaEmisionOrdenServ = fechaEmisionOrdenServ;
		}

		public Date getFechaVencimientoOrdenServ() {
			return fechaVencimientoOrdenServ;
		}

		public void setFechaVencimientoOrdenServ(Date fechaVencimientoOrdenServ) {
			this.fechaVencimientoOrdenServ = fechaVencimientoOrdenServ;
		}

		public Date getFechaUltdesctoOrdenServ() {
			return fechaUltdesctoOrdenServ;
		}

		public void setFechaUltdesctoOrdenServ(Date fechaUltdesctoOrdenServ) {
			this.fechaUltdesctoOrdenServ = fechaUltdesctoOrdenServ;
		}

		public String getFrecPagoOrdenServ() {
			return frecPagoOrdenServ;
		}

		public void setFrecPagoOrdenServ(String frecPagoOrdenServ) {
			this.frecPagoOrdenServ = frecPagoOrdenServ;
		}

		public String getDescFrecPagoOrdenServ() {
			return descFrecPagoOrdenServ;
		}

		public void setDescFrecPagoOrdenServ(String descFrecPagoOrdenServ) {
			this.descFrecPagoOrdenServ = descFrecPagoOrdenServ;
		}

		public String getConceptoOrdenServ() {
			return conceptoOrdenServ;
		}

		public void setConceptoOrdenServ(String conceptoOrdenServ) {
			this.conceptoOrdenServ = conceptoOrdenServ;
		}

		public BigDecimal getMontoOrdenServ() {
			return montoOrdenServ;
		}

		public void setMontoOrdenServ(BigDecimal montoOrdenServ) {
			this.montoOrdenServ = montoOrdenServ;
		}

		public String getIdMetodoPagoOrdenServ() {
			return idMetodoPagoOrdenServ;
		}

		public void setIdMetodoPagoOrdenServ(String idMetodoPagoOrdenServ) {
			this.idMetodoPagoOrdenServ = idMetodoPagoOrdenServ;
		}

		public String getDesMetodoPagoOrdenServ() {
			return desMetodoPagoOrdenServ;
		}

		public void setDesMetodoPagoOrdenServ(String desMetodoPagoOrdenServ) {
			this.desMetodoPagoOrdenServ = desMetodoPagoOrdenServ;
		}

		public Double getPagsTransOrdenServ() {
			return pagsTransOrdenServ;
		}

		public void setPagsTransOrdenServ(Double pagsTransOrdenServ) {
			this.pagsTransOrdenServ = pagsTransOrdenServ;
		}

		public String getReferenciaOrdenServ() {
			return referenciaOrdenServ;
		}

		public void setReferenciaOrdenServ(String referenciaOrdenServ) {
			this.referenciaOrdenServ = referenciaOrdenServ;
		}

		public String getBancoCompetOrdenServ() {
			return bancoCompetOrdenServ;
		}

		public void setBancoCompetOrdenServ(String bancoCompetOrdenServ) {
			this.bancoCompetOrdenServ = bancoCompetOrdenServ;
		}

		public String getCuentaBancariaOrdenServ() {
			return cuentaBancariaOrdenServ;
		}

		public void setCuentaBancariaOrdenServ(String cuentaBancariaOrdenServ) {
			this.cuentaBancariaOrdenServ = cuentaBancariaOrdenServ;
		}

		public String getClaveBancoOrdenServ() {
			return claveBancoOrdenServ;
		}

		public void setClaveBancoOrdenServ(String claveBancoOrdenServ) {
			this.claveBancoOrdenServ = claveBancoOrdenServ;
		}

		public String getReferenciaBancariaOrdenServ() {
			return referenciaBancariaOrdenServ;
		}

		public void setReferenciaBancariaOrdenServ(String referenciaBancariaOrdenServ) {
			this.referenciaBancariaOrdenServ = referenciaBancariaOrdenServ;
		}

	
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public String getTipdoc() {
		return tipdoc;
	}

	public void setTipdoc(String tipdoc) {
		this.tipdoc = tipdoc;
	}

	public String getNumcli() {
		return numcli;
	}

	public void setNumcli(String numcli) {
		this.numcli = numcli;
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

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDestatus() {
		return destatus;
	}

	public void setDestatus(String destatus) {
		this.destatus = destatus;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getRfcClte() {
		return rfcClte;
	}

	public void setRfcClte(String rfcClte) {
		this.rfcClte = rfcClte;
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

	public String getDescConven() {
		return descConven;
	}

	public void setDescConven(String descConven) {
		this.descConven = descConven;
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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getMontoLiqu() {
		return montoLiqu;
	}

	public void setMontoLiqu(BigDecimal montoLiqu) {
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

	public String getCredsus() {
		return credsus;
	}

	public void setCredsus(String credsus) {
		this.credsus = credsus;
	}

	public ArrayList<OrdenesServicio> getOrdenesServicio() {
		return ordenesServicio;
	}

	public void setOrdenesServicio(ArrayList<OrdenesServicio> ordenesServicio) {
		this.ordenesServicio = ordenesServicio;
	}

	public OrdenesServicio getOrdenesServ() {
		return new OrdenesServicio();
	}

	public void setOrdenesServ(OrdenesServicio ordenesServ) {
		this.ordenesServ = ordenesServ;
	}
	
	
}
