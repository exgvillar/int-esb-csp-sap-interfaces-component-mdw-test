/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.dynamic;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMOP1098_P001_CAMPO_SUC_OutputData implements Serializable,
		IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3620011517710648206L;

	private String idClasificacion = null;
	
	private String idDocumento = null;
	
	private String idCampo = null;
	
	private String descripcion = null;
	
	private String nombreTecnico = null;
		
	private String maxLength = null;
	
	private String visibleFlag = null;
		
	/**
	 * 
	 */
	public ZCRMOP1098_P001_CAMPO_SUC_OutputData() {
		super();
	}

	
	


	/**
	 * @return the idClasificacion
	 */
	public String getIdClasificacion() {
		return idClasificacion;
	}





	/**
	 * @param idClasificacion the idClasificacion to set
	 */
	public void setIdClasificacion(String idClasificacion) {
		this.idClasificacion = idClasificacion;
	}





	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}





	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}





	/**
	 * @return the idCampo
	 */
	public String getIdCampo() {
		return idCampo;
	}





	/**
	 * @param idCampo the idCampo to set
	 */
	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
	}





	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}





	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}





	/**
	 * @return the nombreTecnico
	 */
	public String getNombreTecnico() {
		return nombreTecnico;
	}





	/**
	 * @param nombreTecnico the nombreTecnico to set
	 */
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}





	/**
	 * @return the maxLength
	 */
	public String getMaxLength() {
		return maxLength;
	}





	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}





	/**
	 * @return the visibleFlag
	 */
	public String getVisibleFlag() {
		return visibleFlag;
	}





	/**
	 * @param visibleFlag the visibleFlag to set
	 */
	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
