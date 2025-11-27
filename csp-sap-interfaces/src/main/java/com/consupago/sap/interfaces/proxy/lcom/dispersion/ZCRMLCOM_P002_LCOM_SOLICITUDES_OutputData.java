package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData implements Serializable,
		IProxyOutputData {

	private static final long serialVersionUID = 1793817271998249608L;
	private String znumeroSolicitud;
	private String zidEmpresa;
	private String zbpEmpresa;
	private String zsigEmpresa;
	private String zdescripcionEmpresa;
	private String zidDistribuidor;
	private String zdescDistribuidor;
	private String zsigDistribuidor;
	private String zidSucursal;
	private String zdescSucursal;
	private String zsigSucursal;
	private String zclabe;
	private String ztipoDeCuenta;
	private String zclaveBanco;
	private String zdescripcionBanco;
	private String zviaDePago;
	private String zdescripcionViaPago;
	private Date zfechaSolicitud;
	private String zbpCliente;
	private String znombreClie;
	private String znombreClie2;
	private String zapePaternoClie;
	private String zapeMaternoClie;
	private String zrfcCliente;
	private BigDecimal zmontoSolicitud;
	private BigDecimal zmontoDisper;
	private BigDecimal zmontoTotal;
	private BigDecimal zmontoCat;
	private BigDecimal zmontoDisperCompet;
	private BigDecimal zmontoLiqinter;
	private ArrayList<String> ctaDisp;
	private ArrayList<String> referencia;
	private ArrayList<CompetidorInfo> arrCompetidoresInfo;
	private CompetidorInfo competidorInfo;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getZnumeroSolicitud() {
		return znumeroSolicitud;
	}

	public void setZnumeroSolicitud(String znumeroSolicitud) {
		this.znumeroSolicitud = znumeroSolicitud;
	}

	public String getZidEmpresa() {
		return zidEmpresa;
	}

	public void setZidEmpresa(String zidEmpresa) {
		this.zidEmpresa = zidEmpresa;
	}

	public String getZdescripcionEmpresa() {
		return zdescripcionEmpresa;
	}

	public void setZdescripcionEmpresa(String zdescripcionEmpresa) {
		this.zdescripcionEmpresa = zdescripcionEmpresa;
	}

	public String getZidDistribuidor() {
		return zidDistribuidor;
	}

	public void setZidDistribuidor(String zidDistribuidor) {
		this.zidDistribuidor = zidDistribuidor;
	}

	public String getZidSucursal() {
		return zidSucursal;
	}

	public void setZidSucursal(String zidSucursal) {
		this.zidSucursal = zidSucursal;
	}

	public String getZclabe() {
		return zclabe;
	}

	public void setZclabe(String zclabe) {
		this.zclabe = zclabe;
	}

	public String getZtipoDeCuenta() {
		return ztipoDeCuenta;
	}

	public void setZtipoDeCuenta(String ztipoDeCuenta) {
		this.ztipoDeCuenta = ztipoDeCuenta;
	}

	public String getZclaveBanco() {
		return zclaveBanco;
	}

	public void setZclaveBanco(String zclaveBanco) {
		this.zclaveBanco = zclaveBanco;
	}

	public String getZdescripcionBanco() {
		return zdescripcionBanco;
	}

	public void setZdescripcionBanco(String zdescripcionBanco) {
		this.zdescripcionBanco = zdescripcionBanco;
	}

	public String getZviaDePago() {
		return zviaDePago;
	}

	public void setZviaDePago(String zviaDePago) {
		this.zviaDePago = zviaDePago;
	}

	public String getZdescripcionViaPago() {
		return zdescripcionViaPago;
	}

	public void setZdescripcionViaPago(String zdescripcionViaPago) {
		this.zdescripcionViaPago = zdescripcionViaPago;
	}

	public Date getZfechaSolicitud() {
		return zfechaSolicitud;
	}

	public void setZfechaSolicitud(Date zfechaSolicitud) {
		this.zfechaSolicitud = zfechaSolicitud;
	}

	public String getZbpCliente() {
		return zbpCliente;
	}

	public void setZbpCliente(String zbpCliente) {
		this.zbpCliente = zbpCliente;
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

	public String getZrfcCliente() {
		return zrfcCliente;
	}

	public void setZrfcCliente(String zrfcCliente) {
		this.zrfcCliente = zrfcCliente;
	}

	public BigDecimal getZmontoSolicitud() {
		return zmontoSolicitud;
	}

	public void setZmontoSolicitud(BigDecimal zmontoSolicitud) {
		this.zmontoSolicitud = zmontoSolicitud;
	}

	public BigDecimal getZmontoDisper() {
		return zmontoDisper;
	}

	public void setZmontoDisper(BigDecimal zmontoDisper) {
		this.zmontoDisper = zmontoDisper;
	}

	public BigDecimal getZmontoTotal() {
		return zmontoTotal;
	}

	public void setZmontoTotal(BigDecimal zmontoTotal) {
		this.zmontoTotal = zmontoTotal;
	}

	public BigDecimal getZmontoCat() {
		return zmontoCat;
	}

	public void setZmontoCat(BigDecimal zmontoCat) {
		this.zmontoCat = zmontoCat;
	}

	public BigDecimal getZmontoDisperCompet() {
		return zmontoDisperCompet;
	}

	public void setZmontoDisperCompet(BigDecimal zmontoDisperCompet) {
		this.zmontoDisperCompet = zmontoDisperCompet;
	}

	public BigDecimal getZmontoLiqinter() {
		return zmontoLiqinter;
	}

	public void setZmontoLiqinter(BigDecimal zmontoLiqinter) {
		this.zmontoLiqinter = zmontoLiqinter;
	}

	public ArrayList<String> getCtaDisp() {
		return ctaDisp;
	}

	public void setCtaDisp(ArrayList<String> ctaDisp) {
		this.ctaDisp = ctaDisp;
	}

	public ArrayList<String> getReferencia() {
		return referencia;
	}

	public void setReferencia(ArrayList<String> referencia) {
		this.referencia = referencia;
	}

	public class CompetidorInfo {
		private String idOrdServ;
		private String idCompetidor;
		private String nombre1;
		private String nombre2;
		private String nombre3;
		private String nombre4;
		private String idMetodoPago;
		private String desMetodoPago;
		private String cuentaBancaria;
		private String tipoDeCuenta;
		private String claveBanco;
		private String nombreDeBanco;
		private BigDecimal montoDisper;
		private String referenciaComp;
		private String conceptoLcom;

		public String toString() {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}

		public CompetidorInfo(){}
		
		public String getIdOrdServ() {
			return idOrdServ;
		}

		public void setIdOrdServ(String idOrdServ) {
			this.idOrdServ = idOrdServ;
		}

		public String getIdCompetidor() {
			return idCompetidor;
		}

		public void setIdCompetidor(String idCompetidor) {
			this.idCompetidor = idCompetidor;
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

		public String getNombre3() {
			return nombre3;
		}

		public void setNombre3(String nombre3) {
			this.nombre3 = nombre3;
		}

		public String getNombre4() {
			return nombre4;
		}

		public void setNombre4(String nombre4) {
			this.nombre4 = nombre4;
		}

		public String getIdMetodoPago() {
			return idMetodoPago;
		}

		public void setIdMetodoPago(String idMetodoPago) {
			this.idMetodoPago = idMetodoPago;
		}

		public String getDesMetodoPago() {
			return desMetodoPago;
		}

		public void setDesMetodoPago(String desMetodoPago) {
			this.desMetodoPago = desMetodoPago;
		}

		public String getCuentaBancaria() {
			return cuentaBancaria;
		}

		public void setCuentaBancaria(String cuentaBancaria) {
			this.cuentaBancaria = cuentaBancaria;
		}

		public String getTipoDeCuenta() {
			return tipoDeCuenta;
		}

		public void setTipoDeCuenta(String tipoDeCuenta) {
			this.tipoDeCuenta = tipoDeCuenta;
		}

		public String getClaveBanco() {
			return claveBanco;
		}

		public void setClaveBanco(String claveBanco) {
			this.claveBanco = claveBanco;
		}

		public String getNombreDeBanco() {
			return nombreDeBanco;
		}

		public void setNombreDeBanco(String nombreDeBanco) {
			this.nombreDeBanco = nombreDeBanco;
		}

		public BigDecimal getMontoDisper() {
			return montoDisper;
		}

		public void setMontoDisper(BigDecimal montoDisper) {
			this.montoDisper = montoDisper;
		}

		public String getReferenciaComp() {
			return referenciaComp;
		}

		public void setReferenciaComp(String referenciaComp) {
			this.referenciaComp = referenciaComp;
		}

		public String getConceptoLcom() {
			return conceptoLcom;
		}

		public void setConceptoLcom(String conceptoLcom) {
			this.conceptoLcom = conceptoLcom;
		}

	}

	public ArrayList<CompetidorInfo> getArrCompetidoresInfo() {
		return arrCompetidoresInfo;
	}

	public void setArrCompetidoresInfo(ArrayList<CompetidorInfo> arrCompetidoresInfo) {
		this.arrCompetidoresInfo = arrCompetidoresInfo;
	}

	public CompetidorInfo getCompetidorInfo() {
		return new CompetidorInfo();
	}

	public void setCompetidorInfo(CompetidorInfo competidorInfo) {
		this.competidorInfo = competidorInfo;
	}

	public String getZdescDistribuidor() {
		return zdescDistribuidor;
	}

	public void setZdescDistribuidor(String zdescDistribuidor) {
		this.zdescDistribuidor = zdescDistribuidor;
	}

	public String getZdescSucursal() {
		return zdescSucursal;
	}

	public void setZdescSucursal(String zdescSucursal) {
		this.zdescSucursal = zdescSucursal;
	}

	public String getZbpEmpresa() {
		return zbpEmpresa;
	}

	public void setZbpEmpresa(String zbpEmpresa) {
		this.zbpEmpresa = zbpEmpresa;
	}

	public String getZsigEmpresa() {
		return zsigEmpresa;
	}

	public void setZsigEmpresa(String zsigEmpresa) {
		this.zsigEmpresa = zsigEmpresa;
	}

	public String getZsigDistribuidor() {
		return zsigDistribuidor;
	}

	public void setZsigDistribuidor(String zsigDistribuidor) {
		this.zsigDistribuidor = zsigDistribuidor;
	}

	public String getZsigSucursal() {
		return zsigSucursal;
	}

	public void setZsigSucursal(String zsigSucursal) {
		this.zsigSucursal = zsigSucursal;
	}

}
