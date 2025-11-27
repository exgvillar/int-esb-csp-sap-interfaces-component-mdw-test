package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMLCOM_P001_PROCESA_LCOM_OutputData implements Serializable,
		IProxyOutputData {

	private static final long serialVersionUID = 8208226190424470834L;
	private String znumerosolicitud;
	private String zidconvenio;
	private String zidproducto;
	private String zidempresa;
	private String ziddependencia;
	private String zidsucursal;
	private String zdescripcionsucural;
	private String zdescripcionconvenio;
	private String zdescripciondep;
	private String zdescripcionprod;
	private String zdescripcionempresa;
	private Double ztasaintprod;
	private Date zfechanacclie;
	private String zidestatussolicitud;
	private String zdescripcionestatsol;
	private String zorigensolicitud;
	private Integer znumeroreprocesosol;
	private String zclaveusuarioiniciador;
	private String zclaveinterbancaria;
	private String zclavebanco;
	private String zdescripcionbanco;
	private String zfrecuencia;
	private String zidcaso;
	private Date zfechasolicitud;
	private String zgrupopago;
	private String zsustitucion;
	private String zgrupoanalista;
	private String zbpcliente;
	private Double zmontosolicitud;
	private String zbppromotor;
	private String znombrepromotor;
	private String znombrepromotor2;
	private String zapepaternoprom;
	private String zapematernoprom;
	private String znombreclie;
	private String znombreclie2;
	private String zapepaternoclie;
	private String zapematernoclie;
	private String zrfccliente;
	private String ztelcleinte;
	private Integer zplazo;
	private String zfolderecmi;
	private String zidcoi;
	private ArrayList<Competidores> arrCompetidores;
	private Competidores competidores;
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getZnumerosolicitud() {
		return znumerosolicitud;
	}

	public void setZnumerosolicitud(String znumerosolicitud) {
		this.znumerosolicitud = znumerosolicitud;
	}

	public String getZidconvenio() {
		return zidconvenio;
	}

	public void setZidconvenio(String zidconvenio) {
		this.zidconvenio = zidconvenio;
	}

	public String getZidproducto() {
		return zidproducto;
	}

	public void setZidproducto(String zidproducto) {
		this.zidproducto = zidproducto;
	}

	public String getZidempresa() {
		return zidempresa;
	}

	public void setZidempresa(String zidempresa) {
		this.zidempresa = zidempresa;
	}

	public String getZiddependencia() {
		return ziddependencia;
	}

	public void setZiddependencia(String ziddependencia) {
		this.ziddependencia = ziddependencia;
	}

	public String getZidsucursal() {
		return zidsucursal;
	}

	public void setZidsucursal(String zidsucursal) {
		this.zidsucursal = zidsucursal;
	}

	public String getZdescripcionsucural() {
		return zdescripcionsucural;
	}

	public void setZdescripcionsucural(String zdescripcionsucural) {
		this.zdescripcionsucural = zdescripcionsucural;
	}

	public String getZdescripcionconvenio() {
		return zdescripcionconvenio;
	}

	public void setZdescripcionconvenio(String zdescripcionconvenio) {
		this.zdescripcionconvenio = zdescripcionconvenio;
	}

	public String getZdescripciondep() {
		return zdescripciondep;
	}

	public void setZdescripciondep(String zdescripciondep) {
		this.zdescripciondep = zdescripciondep;
	}

	public String getZdescripcionprod() {
		return zdescripcionprod;
	}

	public void setZdescripcionprod(String zdescripcionprod) {
		this.zdescripcionprod = zdescripcionprod;
	}

	public String getZdescripcionempresa() {
		return zdescripcionempresa;
	}

	public void setZdescripcionempresa(String zdescripcionempresa) {
		this.zdescripcionempresa = zdescripcionempresa;
	}

	public Double getZtasaintprod() {
		return ztasaintprod;
	}

	public void setZtasaintprod(Double ztasaintprod) {
		this.ztasaintprod = ztasaintprod;
	}

	public Date getZfechanacclie() {
		return zfechanacclie;
	}

	public void setZfechanacclie(Date zfechanacclie) {
		this.zfechanacclie = zfechanacclie;
	}

	public String getZidestatussolicitud() {
		return zidestatussolicitud;
	}

	public void setZidestatussolicitud(String zidestatussolicitud) {
		this.zidestatussolicitud = zidestatussolicitud;
	}

	public String getZdescripcionestatsol() {
		return zdescripcionestatsol;
	}

	public void setZdescripcionestatsol(String zdescripcionestatsol) {
		this.zdescripcionestatsol = zdescripcionestatsol;
	}

	public String getZorigensolicitud() {
		return zorigensolicitud;
	}

	public void setZorigensolicitud(String zorigensolicitud) {
		this.zorigensolicitud = zorigensolicitud;
	}

	public Integer getZnumeroreprocesosol() {
		return znumeroreprocesosol;
	}

	public void setZnumeroreprocesosol(Integer znumeroreprocesosol) {
		this.znumeroreprocesosol = znumeroreprocesosol;
	}

	public String getZclaveusuarioiniciador() {
		return zclaveusuarioiniciador;
	}

	public void setZclaveusuarioiniciador(String zclaveusuarioiniciador) {
		this.zclaveusuarioiniciador = zclaveusuarioiniciador;
	}

	public String getZclaveinterbancaria() {
		return zclaveinterbancaria;
	}

	public void setZclaveinterbancaria(String zclaveinterbancaria) {
		this.zclaveinterbancaria = zclaveinterbancaria;
	}

	public String getZclavebanco() {
		return zclavebanco;
	}

	public void setZclavebanco(String zclavebanco) {
		this.zclavebanco = zclavebanco;
	}

	public String getZdescripcionbanco() {
		return zdescripcionbanco;
	}

	public void setZdescripcionbanco(String zdescripcionbanco) {
		this.zdescripcionbanco = zdescripcionbanco;
	}

	public String getZfrecuencia() {
		return zfrecuencia;
	}

	public void setZfrecuencia(String zfrecuencia) {
		this.zfrecuencia = zfrecuencia;
	}

	public String getZidcaso() {
		return zidcaso;
	}

	public void setZidcaso(String zidcaso) {
		this.zidcaso = zidcaso;
	}

	public Date getZfechasolicitud() {
		return zfechasolicitud;
	}

	public void setZfechasolicitud(Date zfechasolicitud) {
		this.zfechasolicitud = zfechasolicitud;
	}

	public String getZgrupopago() {
		return zgrupopago;
	}

	public void setZgrupopago(String zgrupopago) {
		this.zgrupopago = zgrupopago;
	}

	public String getZsustitucion() {
		return zsustitucion;
	}

	public void setZsustitucion(String zsustitucion) {
		this.zsustitucion = zsustitucion;
	}

	public String getZgrupoanalista() {
		return zgrupoanalista;
	}

	public void setZgrupoanalista(String zgrupoanalista) {
		this.zgrupoanalista = zgrupoanalista;
	}

	public String getZbpcliente() {
		return zbpcliente;
	}

	public void setZbpcliente(String zbpcliente) {
		this.zbpcliente = zbpcliente;
	}

	public Double getZmontosolicitud() {
		return zmontosolicitud;
	}

	public void setZmontosolicitud(Double zmontosolicitud) {
		this.zmontosolicitud = zmontosolicitud;
	}

	public String getZbppromotor() {
		return zbppromotor;
	}

	public void setZbppromotor(String zbppromotor) {
		this.zbppromotor = zbppromotor;
	}

	public String getZnombrepromotor() {
		return znombrepromotor;
	}

	public void setZnombrepromotor(String znombrepromotor) {
		this.znombrepromotor = znombrepromotor;
	}

	public String getZnombrepromotor2() {
		return znombrepromotor2;
	}

	public void setZnombrepromotor2(String znombrepromotor2) {
		this.znombrepromotor2 = znombrepromotor2;
	}

	public String getZapepaternoprom() {
		return zapepaternoprom;
	}

	public void setZapepaternoprom(String zapepaternoprom) {
		this.zapepaternoprom = zapepaternoprom;
	}

	public String getZapematernoprom() {
		return zapematernoprom;
	}

	public void setZapematernoprom(String zapematernoprom) {
		this.zapematernoprom = zapematernoprom;
	}

	public String getZnombreclie() {
		return znombreclie;
	}

	public void setZnombreclie(String znombreclie) {
		this.znombreclie = znombreclie;
	}

	public String getZnombreclie2() {
		return znombreclie2;
	}

	public void setZnombreclie2(String znombreclie2) {
		this.znombreclie2 = znombreclie2;
	}

	public String getZapepaternoclie() {
		return zapepaternoclie;
	}

	public void setZapepaternoclie(String zapepaternoclie) {
		this.zapepaternoclie = zapepaternoclie;
	}

	public String getZapematernoclie() {
		return zapematernoclie;
	}

	public void setZapematernoclie(String zapematernoclie) {
		this.zapematernoclie = zapematernoclie;
	}

	public String getZrfccliente() {
		return zrfccliente;
	}

	public void setZrfccliente(String zrfccliente) {
		this.zrfccliente = zrfccliente;
	}

	public String getZtelcleinte() {
		return ztelcleinte;
	}

	public void setZtelcleinte(String ztelcleinte) {
		this.ztelcleinte = ztelcleinte;
	}

	public Integer getZplazo() {
		return zplazo;
	}

	public void setZplazo(Integer zplazo) {
		this.zplazo = zplazo;
	}

	public String getZfolderecmi() {
		return zfolderecmi;
	}

	public void setZfolderecmi(String zfolderecmi) {
		this.zfolderecmi = zfolderecmi;
	}

	public String getZidcoi() {
		return zidcoi;
	}

	public void setZidcoi(String zidcoi) {
		this.zidcoi = zidcoi;
	}

	public class Competidores {
		private String idordserv;
		private String statusos;
		private String descstatos;
		private String idcompetidor;
		private String nombre1;
		private String nombre2;
		private String apepat;
		private String apemat;
		private Date fechaemision;
		private Date fechavencimiento;
		private Date fechaultdescto;
		private String frecuencia;
		private String concepto;
		private Double monto;
		private String idmetodopago;
		private String desmetodopago;
		private Integer pagstrans;
		private String referencia;
		private String bancocompet;
		private String cuentabancaria;
		private String claveBanco;
		private String referenciaBancaria;
		
		public Competidores(){
		}

		public String toString() {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}

		public String getIdordserv() {
			return idordserv;
		}

		public void setIdordserv(String idordserv) {
			this.idordserv = idordserv;
		}

		public String getStatusos() {
			return statusos;
		}

		public void setStatusos(String statusos) {
			this.statusos = statusos;
		}

		public String getDescstatos() {
			return descstatos;
		}

		public void setDescstatos(String descstatos) {
			this.descstatos = descstatos;
		}

		public String getIdcompetidor() {
			return idcompetidor;
		}

		public void setIdcompetidor(String idcompetidor) {
			this.idcompetidor = idcompetidor;
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

		public Date getFechaemision() {
			return fechaemision;
		}

		public void setFechaemision(Date fechaemision) {
			this.fechaemision = fechaemision;
		}

		public Date getFechavencimiento() {
			return fechavencimiento;
		}

		public void setFechavencimiento(Date fechavencimiento) {
			this.fechavencimiento = fechavencimiento;
		}

		public Date getFechaultdescto() {
			return fechaultdescto;
		}

		public void setFechaultdescto(Date fechaultdescto) {
			this.fechaultdescto = fechaultdescto;
		}

		public String getFrecuencia() {
			return frecuencia;
		}

		public void setFrecuencia(String frecuencia) {
			this.frecuencia = frecuencia;
		}

		public String getConcepto() {
			return concepto;
		}

		public void setConcepto(String concepto) {
			this.concepto = concepto;
		}

		public Double getMonto() {
			return monto;
		}

		public void setMonto(Double monto) {
			this.monto = monto;
		}

		public String getIdmetodopago() {
			return idmetodopago;
		}

		public void setIdmetodopago(String idmetodopago) {
			this.idmetodopago = idmetodopago;
		}

		public String getDesmetodopago() {
			return desmetodopago;
		}

		public void setDesmetodopago(String desmetodopago) {
			this.desmetodopago = desmetodopago;
		}

		public Integer getPagstrans() {
			return pagstrans;
		}

		public void setPagstrans(Integer pagstrans) {
			this.pagstrans = pagstrans;
		}

		public String getReferencia() {
			return referencia;
		}

		public void setReferencia(String referencia) {
			this.referencia = referencia;
		}

		public String getBancocompet() {
			return bancocompet;
		}

		public void setBancocompet(String bancocompet) {
			this.bancocompet = bancocompet;
		}

		public String getCuentabancaria() {
			return cuentabancaria;
		}

		public void setCuentabancaria(String cuentabancaria) {
			this.cuentabancaria = cuentabancaria;
		}

		public String getClaveBanco() {
			return claveBanco;
		}

		public void setClaveBanco(String claveBanco) {
			this.claveBanco = claveBanco;
		}

		public String getReferenciaBancaria() {
			return referenciaBancaria;
		}

		public void setReferenciaBancaria(String referenciaBancaria) {
			this.referenciaBancaria = referenciaBancaria;
		}

	}


	public void setCompetidores(Competidores competidores) {
		this.competidores = competidores;
	}
	
	public Competidores getCompetidores(){
		return new Competidores();
	}

	public ArrayList<Competidores> getArrCompetidores() {
		return arrCompetidores;
	}

	public void setArrCompetidores(ArrayList<Competidores> arrCompetidores) {
		this.arrCompetidores = arrCompetidores;
	}

}
