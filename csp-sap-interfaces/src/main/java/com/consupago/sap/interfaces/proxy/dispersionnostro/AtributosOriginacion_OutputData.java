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
public class AtributosOriginacion_OutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cnca;
	private String credNvo;
	private String interCompania;
	private String lcom;
	private String numDisposicion;
	private String segundaDisp;
	




	public String getCnca() {
		return cnca;
	}





	public void setCnca(String cnca) {
		this.cnca = cnca;
	}





	public String getCredNvo() {
		return credNvo;
	}





	public void setCredNvo(String credNvo) {
		this.credNvo = credNvo;
	}





	public String getInterCompania() {
		return interCompania;
	}





	public void setInterCompania(String interCompania) {
		this.interCompania = interCompania;
	}





	public String getLcom() {
		return lcom;
	}





	public void setLcom(String lcom) {
		this.lcom = lcom;
	}





	public String getNumDisposicion() {
		return numDisposicion;
	}





	public void setNumDisposicion(String numDisposicion) {
		this.numDisposicion = numDisposicion;
	}





	public String getSegundaDisp() {
		return segundaDisp;
	}





	public void setSegundaDisp(String segundaDisp) {
		this.segundaDisp = segundaDisp;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
