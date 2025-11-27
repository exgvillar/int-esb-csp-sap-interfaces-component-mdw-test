/**
 * 
 */
package com.consubanco.sap.interfaces.commons.employees.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author rbecerra
 *
 */
public class ZTL_EMPLEOBP_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8820984487934293448L;

	private String bpId = null;
	
	private String claveProfesion = null;
	
	private String lugarTrabajo = null;
	
	private String giroEmpresa = null;
	
	private String actividadEmpresa = null;
	
	private String giroActividadAltoRiesgo = null;
	
	private String cargoDesempenadoId = null;
	
	private String cargoDesempenado = null;
	
	private String telefonoTrabajo = null;
	
	private int antiguedadEmpleoActual = 0;
	
	private int antiguedadEmpleoAnterior = 0;
	
	private double ingresoMensual = 0;
	
	private double otrosIngresos = 0;
	
	private String fuenteOtrosIngresos = null;
	
	private String mail = null;
	
		
	/**
	 * 
	 */
	public ZTL_EMPLEOBP_Model() {
		super();
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
	 * @return the claveProfesion
	 */
	public String getClaveProfesion() {
		return claveProfesion;
	}



	/**
	 * @param claveProfesion the claveProfesion to set
	 */
	public void setClaveProfesion(String claveProfesion) {
		this.claveProfesion = claveProfesion;
	}



	/**
	 * @return the lugarTrabajo
	 */
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}



	/**
	 * @param lugarTrabajo the lugarTrabajo to set
	 */
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}



	/**
	 * @return the giroEmpresa
	 */
	public String getGiroEmpresa() {
		return giroEmpresa;
	}



	/**
	 * @param giroEmpresa the giroEmpresa to set
	 */
	public void setGiroEmpresa(String giroEmpresa) {
		this.giroEmpresa = giroEmpresa;
	}



	/**
	 * @return the actividadEmpresa
	 */
	public String getActividadEmpresa() {
		return actividadEmpresa;
	}



	/**
	 * @param actividadEmpresa the actividadEmpresa to set
	 */
	public void setActividadEmpresa(String actividadEmpresa) {
		this.actividadEmpresa = actividadEmpresa;
	}



	/**
	 * @return the giroActividadAltoRiesgo
	 */
	public String getGiroActividadAltoRiesgo() {
		return giroActividadAltoRiesgo;
	}



	/**
	 * @param giroActividadAltoRiesgo the giroActividadAltoRiesgo to set
	 */
	public void setGiroActividadAltoRiesgo(String giroActividadAltoRiesgo) {
		this.giroActividadAltoRiesgo = giroActividadAltoRiesgo;
	}



	/**
	 * @return the cargoDesempenadoId
	 */
	public String getCargoDesempenadoId() {
		return cargoDesempenadoId;
	}



	/**
	 * @param cargoDesempenadoId the cargoDesempenadoId to set
	 */
	public void setCargoDesempenadoId(String cargoDesempenadoId) {
		this.cargoDesempenadoId = cargoDesempenadoId;
	}



	/**
	 * @return the cargoDesempenado
	 */
	public String getCargoDesempenado() {
		return cargoDesempenado;
	}



	/**
	 * @param cargoDesempenado the cargoDesempenado to set
	 */
	public void setCargoDesempenado(String cargoDesempenado) {
		this.cargoDesempenado = cargoDesempenado;
	}



	/**
	 * @return the telefonoTrabajo
	 */
	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}



	/**
	 * @param telefonoTrabajo the telefonoTrabajo to set
	 */
	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}



	/**
	 * @return the antiguedadEmpleoActual
	 */
	public int getAntiguedadEmpleoActual() {
		return antiguedadEmpleoActual;
	}



	/**
	 * @param antiguedadEmpleoActual the antiguedadEmpleoActual to set
	 */
	public void setAntiguedadEmpleoActual(int antiguedadEmpleoActual) {
		this.antiguedadEmpleoActual = antiguedadEmpleoActual;
	}



	/**
	 * @return the antiguedadEmpleoAnterior
	 */
	public int getAntiguedadEmpleoAnterior() {
		return antiguedadEmpleoAnterior;
	}



	/**
	 * @param antiguedadEmpleoAnterior the antiguedadEmpleoAnterior to set
	 */
	public void setAntiguedadEmpleoAnterior(int antiguedadEmpleoAnterior) {
		this.antiguedadEmpleoAnterior = antiguedadEmpleoAnterior;
	}



	/**
	 * @return the ingresoMensual
	 */
	public double getIngresoMensual() {
		return ingresoMensual;
	}



	/**
	 * @param ingresoMensual the ingresoMensual to set
	 */
	public void setIngresoMensual(double ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}



	/**
	 * @return the otrosIngresos
	 */
	public double getOtrosIngresos() {
		return otrosIngresos;
	}



	/**
	 * @param otrosIngresos the otrosIngresos to set
	 */
	public void setOtrosIngresos(double otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}



	/**
	 * @return the fuenteOtrosIngresos
	 */
	public String getFuenteOtrosIngresos() {
		return fuenteOtrosIngresos;
	}



	/**
	 * @param fuenteOtrosIngresos the fuenteOtrosIngresos to set
	 */
	public void setFuenteOtrosIngresos(String fuenteOtrosIngresos) {
		this.fuenteOtrosIngresos = fuenteOtrosIngresos;
	}


	

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}



	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
