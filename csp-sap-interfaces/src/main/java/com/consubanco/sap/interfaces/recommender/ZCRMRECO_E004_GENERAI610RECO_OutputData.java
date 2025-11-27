/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author Ing. Adrian Alejo
 * 
 */
public class ZCRMRECO_E004_GENERAI610RECO_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String idSolicitud;
	private String forpag;
	private String codban;
	private String clave;
	private String refere;
	private String monto;
	private String numord;
	private String apepat;
	private String apemat;
	private String nombre;
	private String tipide;
	private String numide;
	private String idEmpresa;
	private String nombreEmpresa;
	private String siglaEmpresaOrg;
	private String convenioH2H;
	private String telCel;
	private String fecEnvSms;
	private String rfc;
	private String cp;
	private String curp;
	private String fechaNac;

	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud
	 *            the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	/**
	 * @return the forpag
	 */
	public String getForpag() {
		return forpag;
	}

	/**
	 * @param forpag
	 *            the forpag to set
	 */
	public void setForpag(String forpag) {
		this.forpag = forpag;
	}

	/**
	 * @return the codban
	 */
	public String getCodban() {
		return codban;
	}

	/**
	 * @param codban
	 *            the codban to set
	 */
	public void setCodban(String codban) {
		this.codban = codban;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the refere
	 */
	public String getRefere() {
		return refere;
	}

	/**
	 * @param refere
	 *            the refere to set
	 */
	public void setRefere(String refere) {
		this.refere = refere;
	}

	/**
	 * @return the monto
	 */
	public String getMonto() {
		return monto;
	}

	/**
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}

	/**
	 * @return the numord
	 */
	public String getNumord() {
		return numord;
	}

	/**
	 * @param numord
	 *            the numord to set
	 */
	public void setNumord(String numord) {
		this.numord = numord;
	}

	/**
	 * @return the apepat
	 */
	public String getApepat() {
		return apepat;
	}

	/**
	 * @param apepat
	 *            the apepat to set
	 */
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	/**
	 * @return the apemat
	 */
	public String getApemat() {
		return apemat;
	}

	/**
	 * @param apemat
	 *            the apemat to set
	 */
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipide
	 */
	public String getTipide() {
		return tipide;
	}

	/**
	 * @param tipide
	 *            the tipide to set
	 */
	public void setTipide(String tipide) {
		this.tipide = tipide;
	}

	/**
	 * @return the numide
	 */
	public String getNumide() {
		return numide;
	}

	/**
	 * @param numide
	 *            the numide to set
	 */
	public void setNumide(String numide) {
		this.numide = numide;
	}

	/**
	 * @return the idEmpresa
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa
	 *            the idEmpresa to set
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa
	 *            the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the siglaEmpresaOrg
	 */
	public String getSiglaEmpresaOrg() {
		return siglaEmpresaOrg;
	}

	/**
	 * @param siglaEmpresaOrg
	 *            the siglaEmpresaOrg to set
	 */
	public void setSiglaEmpresaOrg(String siglaEmpresaOrg) {
		this.siglaEmpresaOrg = siglaEmpresaOrg;
	}

	/**
	 * @return the convenioH2H
	 */
	public String getConvenioH2H() {
		return convenioH2H;
	}

	/**
	 * @param convenioH2H
	 *            the convenioH2H to set
	 */
	public void setConvenioH2H(String convenioH2H) {
		this.convenioH2H = convenioH2H;
	}

	/**
	 * @return the telCel
	 */
	public String getTelCel() {
		return telCel;
	}

	/**
	 * @param telCel
	 *            the telCel to set
	 */
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	/**
	 * @return the fecEnvSms
	 */
	public String getFecEnvSms() {
		return fecEnvSms;
	}

	/**
	 * @param fecEnvSms
	 *            the fecEnvSms to set
	 */
	public void setFecEnvSms(String fecEnvSms) {
		this.fecEnvSms = fecEnvSms;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the fechaNac
	 */
	public String getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac
	 *            the fechaNac to set
	 */
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
