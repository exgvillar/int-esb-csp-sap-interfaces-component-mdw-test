/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class ZCRM_EMPLEADO_COMISION_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731330349300633710L;
	
	private String siglaDistribuidor = null;
	
	private String nombreDistribuidor = null;

	private String siglaSucursal = null;
	
	private String idSucursal = null;
	
	private String nombreSucursal = null;
	
	private String siglaPuesto = null;
	
	private String nombrePuesto = null;
	
	private String businessPartnerId = null;
	
	private String nombre1 = null;
	
	private String nombre2 = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private Date fechaInicioContrato = null;
	
	private String rfc = null;

	private String numEmpleadoNomina = null;
	
	/**
* 
*/
	public ZCRM_EMPLEADO_COMISION_OutputData() {
		super();
	}

	
	
	
	

	/**
	 * @return the siglaDistribuidor
	 */
	public String getSiglaDistribuidor() {
		return siglaDistribuidor;
	}






	/**
	 * @param siglaDistribuidor the siglaDistribuidor to set
	 */
	public void setSiglaDistribuidor(String siglaDistribuidor) {
		this.siglaDistribuidor = siglaDistribuidor;
	}






	/**
	 * @return the nombreDistribuidor
	 */
	public String getNombreDistribuidor() {
		return nombreDistribuidor;
	}






	/**
	 * @param nombreDistribuidor the nombreDistribuidor to set
	 */
	public void setNombreDistribuidor(String nombreDistribuidor) {
		this.nombreDistribuidor = nombreDistribuidor;
	}






	/**
	 * @return the siglaSucursal
	 */
	public String getSiglaSucursal() {
		return siglaSucursal;
	}






	/**
	 * @param siglaSucursal the siglaSucursal to set
	 */
	public void setSiglaSucursal(String siglaSucursal) {
		this.siglaSucursal = siglaSucursal;
	}






	/**
	 * @return the idSucursal
	 */
	public String getIdSucursal() {
		return idSucursal;
	}






	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}






	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}






	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}






	/**
	 * @return the siglaPuesto
	 */
	public String getSiglaPuesto() {
		return siglaPuesto;
	}






	/**
	 * @param siglaPuesto the siglaPuesto to set
	 */
	public void setSiglaPuesto(String siglaPuesto) {
		this.siglaPuesto = siglaPuesto;
	}






	/**
	 * @return the nombrePuesto
	 */
	public String getNombrePuesto() {
		return nombrePuesto;
	}






	/**
	 * @param nombrePuesto the nombrePuesto to set
	 */
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}






	/**
	 * @return the businessPartnerId
	 */
	public String getBusinessPartnerId() {
		return businessPartnerId;
	}






	/**
	 * @param businessPartnerId the businessPartnerId to set
	 */
	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
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
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}






	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}






	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}






	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	



	/**
	 * @return the fechaInicioContrato
	 */
	public Date getFechaInicioContrato() {
		return fechaInicioContrato;
	}






	/**
	 * @param fechaInicioContrato the fechaInicioContrato to set
	 */
	public void setFechaInicioContrato(Date fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}


	



	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}






	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}






	/**
	 * @return the numEmpleadoNomina
	 */
	public String getNumEmpleadoNomina() {
		return numEmpleadoNomina;
	}






	/**
	 * @param numEmpleadoNomina the numEmpleadoNomina to set
	 */
	public void setNumEmpleadoNomina(String numEmpleadoNomina) {
		this.numEmpleadoNomina = numEmpleadoNomina;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
