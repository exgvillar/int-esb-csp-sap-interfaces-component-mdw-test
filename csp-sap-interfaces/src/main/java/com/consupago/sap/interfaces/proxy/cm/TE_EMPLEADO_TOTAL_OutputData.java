/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
@Deprecated
public class TE_EMPLEADO_TOTAL_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6254248212217395800L;

	private String nivel = null;
	
	private String idEmpleado = null;

	private double monto = 0;
	
	private String nombre1 = null;
	
	private String nombre2 = null;
	
	private String apellidoPaterno = null;
	
	private String apellidoMaterno = null;
	
	private String sigla_puesto = null;
	
	private String puesto = null;
	
	private String numEmpleadoNomina = null;
	
	private String bpSuperior = null;
	
	private String celula = null;
	
	private String tipoRelacion = null;
	
	private boolean activo = false;

	/**
* 
*/
	public TE_EMPLEADO_TOTAL_OutputData() {
		super();
	}

	
	
	



	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}







	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}







	/**
	 * @return the idEmpleado
	 */
	public String getIdEmpleado() {
		return idEmpleado;
	}







	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}







	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}







	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
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







	public String getApellidoPaterno() {
		return apellidoPaterno;
	}







	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}







	public String getApellidoMaterno() {
		return apellidoMaterno;
	}







	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}









	/**
	 * @return the sigla_puesto
	 */
	public String getSigla_puesto() {
		return sigla_puesto;
	}







	/**
	 * @param siglaPuesto the sigla_puesto to set
	 */
	public void setSigla_puesto(String siglaPuesto) {
		sigla_puesto = siglaPuesto;
	}







	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}







	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
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




	/**
	 * @return the bpSuperior
	 */
	public String getBpSuperior() {
		return bpSuperior;
	}







	/**
	 * @param bpSuperior the bpSuperior to set
	 */
	public void setBpSuperior(String bpSuperior) {
		this.bpSuperior = bpSuperior;
	}







	/**
	 * @return the celula
	 */
	public String getCelula() {
		return celula;
	}







	/**
	 * @param celula the celula to set
	 */
	public void setCelula(String celula) {
		this.celula = celula;
	}







	/**
	 * @return the tipoRelacion
	 */
	public String getTipoRelacion() {
		return tipoRelacion;
	}







	/**
	 * @param tipoRelacion the tipoRelacion to set
	 */
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}




	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}







	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
