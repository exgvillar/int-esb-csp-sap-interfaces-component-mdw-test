/**
 * 
 */
package com.consubanco.sap.interfaces.common.formatF02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_PEPS_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

	private String numSolicitud = null;

	private String numCliente = null;
	
	private Date fechaCreacionSolicitud = null;
	
	private Date fechaEstatusPEP = null;
	
	private Date fechaAltaQEQ = null;
	
	private Date fechaBajaQEQ = null;
	
	private String puestoPEP = null;
	
	private String areaDepto = null;
	
	private String cargoEleccionPopular = null;
	
	private Date fechaInicioGestion = null;
	
	private String nombreDependencia = null;
	
	private String direccionDependencia = null;
	
	private double ingresoBrutoMensual = 0;
	
	private String otrosNegocios = null;
	
	private String descOtrosNegocios = null;
	
	private ArrayList<ZTL_PEPS_INGRESO_Model> ingresos = null;

	private ArrayList<ZTL_PEPS_FAMILIAR_Model> familiares = null;
	
	private ArrayList<ZTL_QEQ_Model> qeq = null;
	
	private String message;
	
	
	/**
	 * 
	 */
	public ZTL_PEPS_Model() {
		super();
	}

	
	
	/**
	 * @return the numSolicitud
	 */
	public String getNumSolicitud() {
		return numSolicitud;
	}



	/**
	 * @param numSolicitud the numSolicitud to set
	 */
	public void setNumSolicitud(String numSolicitud) {
		this.numSolicitud = numSolicitud;
	}



	/**
	 * @return the numCliente
	 */
	public String getNumCliente() {
		return numCliente;
	}



	/**
	 * @param numCliente the numCliente to set
	 */
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}


	/**
	 * @return the fechaCreacionSolicitud
	 */
	public Date getFechaCreacionSolicitud() {
		return fechaCreacionSolicitud;
	}



	/**
	 * @param fechaCreacionSolicitud the fechaCreacionSolicitud to set
	 */
	public void setFechaCreacionSolicitud(Date fechaCreacionSolicitud) {
		this.fechaCreacionSolicitud = fechaCreacionSolicitud;
	}





	/**
	 * @return the fechaEstatusPEP
	 */
	public Date getFechaEstatusPEP() {
		return fechaEstatusPEP;
	}



	/**
	 * @param fechaEstatusPEP the fechaEstatusPEP to set
	 */
	public void setFechaEstatusPEP(Date fechaEstatusPEP) {
		this.fechaEstatusPEP = fechaEstatusPEP;
	}



	/**
	 * @return the fechaAltaQEQ
	 */
	public Date getFechaAltaQEQ() {
		return fechaAltaQEQ;
	}



	/**
	 * @param fechaAltaQEQ the fechaAltaQEQ to set
	 */
	public void setFechaAltaQEQ(Date fechaAltaQEQ) {
		this.fechaAltaQEQ = fechaAltaQEQ;
	}



	/**
	 * @return the fechaBajaQEQ
	 */
	public Date getFechaBajaQEQ() {
		return fechaBajaQEQ;
	}



	/**
	 * @param fechaBajaQEQ the fechaBajaQEQ to set
	 */
	public void setFechaBajaQEQ(Date fechaBajaQEQ) {
		this.fechaBajaQEQ = fechaBajaQEQ;
	}



	/**
	 * @return the puestoPEP
	 */
	public String getPuestoPEP() {
		return puestoPEP;
	}



	/**
	 * @param puestoPEP the puestoPEP to set
	 */
	public void setPuestoPEP(String puestoPEP) {
		this.puestoPEP = puestoPEP;
	}



	/**
	 * @return the areaDepto
	 */
	public String getAreaDepto() {
		return areaDepto;
	}



	/**
	 * @param areaDepto the areaDepto to set
	 */
	public void setAreaDepto(String areaDepto) {
		this.areaDepto = areaDepto;
	}




	/**
	 * @return the cargoEleccionPopular
	 */
	public String getCargoEleccionPopular() {
		return cargoEleccionPopular;
	}



	/**
	 * @param cargoEleccionPopular the cargoEleccionPopular to set
	 */
	public void setCargoEleccionPopular(String cargoEleccionPopular) {
		this.cargoEleccionPopular = cargoEleccionPopular;
	}



	/**
	 * @return the fechaInicioGestion
	 */
	public Date getFechaInicioGestion() {
		return fechaInicioGestion;
	}



	/**
	 * @param fechaInicioGestion the fechaInicioGestion to set
	 */
	public void setFechaInicioGestion(Date fechaInicioGestion) {
		this.fechaInicioGestion = fechaInicioGestion;
	}





	/**
	 * @return the nombreDependencia
	 */
	public String getNombreDependencia() {
		return nombreDependencia;
	}



	/**
	 * @param nombreDependencia the nombreDependencia to set
	 */
	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}



	/**
	 * @return the direccionDependencia
	 */
	public String getDireccionDependencia() {
		return direccionDependencia;
	}



	/**
	 * @param direccionDependencia the direccionDependencia to set
	 */
	public void setDireccionDependencia(String direccionDependencia) {
		this.direccionDependencia = direccionDependencia;
	}



	/**
	 * @return the ingresoBrutoMensual
	 */
	public double getIngresoBrutoMensual() {
		return ingresoBrutoMensual;
	}



	/**
	 * @param ingresoBrutoMensual the ingresoBrutoMensual to set
	 */
	public void setIngresoBrutoMensual(double ingresoBrutoMensual) {
		this.ingresoBrutoMensual = ingresoBrutoMensual;
	}



	/**
	 * @return the otrosNegocios
	 */
	public String getOtrosNegocios() {
		return otrosNegocios;
	}



	/**
	 * @param otrosNegocios the otrosNegocios to set
	 */
	public void setOtrosNegocios(String otrosNegocios) {
		this.otrosNegocios = otrosNegocios;
	}



	/**
	 * @return the descOtrosNegocios
	 */
	public String getDescOtrosNegocios() {
		return descOtrosNegocios;
	}



	/**
	 * @param descOtrosNegocios the descOtrosNegocios to set
	 */
	public void setDescOtrosNegocios(String descOtrosNegocios) {
		this.descOtrosNegocios = descOtrosNegocios;
	}


	
	

	/**
	 * @return the ingresos
	 */
	public ArrayList<ZTL_PEPS_INGRESO_Model> getIngresos() {
		return ingresos;
	}



	/**
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(ArrayList<ZTL_PEPS_INGRESO_Model> ingresos) {
		this.ingresos = ingresos;
	}


	
	

	/**
	 * @return the familiares
	 */
	public ArrayList<ZTL_PEPS_FAMILIAR_Model> getFamiliares() {
		return familiares;
	}



	/**
	 * @param familiares the familiares to set
	 */
	public void setFamiliares(ArrayList<ZTL_PEPS_FAMILIAR_Model> familiares) {
		this.familiares = familiares;
	}


	

	/**
	 * @return the qeq
	 */
	public ArrayList<ZTL_QEQ_Model> getQeq() {
		return qeq;
	}



	/**
	 * @param qeq the qeq to set
	 */
	public void setQeq(ArrayList<ZTL_QEQ_Model> qeq) {
		this.qeq = qeq;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
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
}
