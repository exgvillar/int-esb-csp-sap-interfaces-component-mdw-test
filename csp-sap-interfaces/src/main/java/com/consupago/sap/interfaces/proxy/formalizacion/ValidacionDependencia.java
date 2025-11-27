package com.consupago.sap.interfaces.proxy.formalizacion;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ValidacionDependencia implements Serializable {
	private static final long serialVersionUID = -417464850470151798L;
	private String valDepFechaReserva;
	private String valDepFolio;
	
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}


	public String getValDepFechaReserva() {
		return valDepFechaReserva;
	}


	public void setValDepFechaReserva(String valDepFechaReserva) {
		this.valDepFechaReserva = valDepFechaReserva;
	}


	public String getValDepFolio() {
		return valDepFolio;
	}


	public void setValDepFolio(String valDepFolio) {
		this.valDepFolio = valDepFolio;
	}


}
