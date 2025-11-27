/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersionnostro;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author olan
 * 
 */
public class Promotor_OutputData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String employeeCd;
	private String employeeNM;
	private String employeeRole;
	private String employeeId;
	private String bloquearPagoLinea;
	private String idTipoPromotor;
	private String tipoPromotor;

	public String getEmployeeCd() {
		return employeeCd;
	}

	public void setEmployeeCd(String employeeCd) {
		this.employeeCd = employeeCd;
	}

	public String getEmployeeNM() {
		return employeeNM;
	}

	public void setEmployeeNM(String employeeNM) {
		this.employeeNM = employeeNM;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getBloquearPagoLinea() {
		return bloquearPagoLinea;
	}

	public void setBloquearPagoLinea(String bloquearPagoLinea) {
		this.bloquearPagoLinea = bloquearPagoLinea;
	}

	public String getIdTipoPromotor() {
		return idTipoPromotor;
	}

	public void setIdTipoPromotor(String idTipoPromotor) {
		this.idTipoPromotor = idTipoPromotor;
	}

	public String getTipoPromotor() {
		return tipoPromotor;
	}

	public void setTipoPromotor(String tipoPromotor) {
		this.tipoPromotor = tipoPromotor;
	}

}
