/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_SUC_EMP_X_USUARIO_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7367199285994535339L;

	private String businessPartnerId = null;
	
	private String businessPartnerName = null;
	
	private String idPuesto = null;
	
	private String nombrePuesto = null;
	
	private String idSucursal = null;
	
	private String nombreSucursal = null;
	
	private String idEmpresa = null;
	
	private String claveEmpresa = null;
	
	private String nombreEmpresa = null;
	
	private String idCOI = null;
	
	private String nombreCOI = null;
	
	private String idDistribuidor = null;
	
	private String nombreDistribuidor = null;
	
	private String idRegion = null;
	
	private String nombreRegion = null;
	
	/**
	 * 
	 */
	public ZRFC_SUC_EMP_X_USUARIO_OutputData() {
		super();
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
	 * @return the businessPartnerName
	 */
	public String getBusinessPartnerName() {
		return businessPartnerName;
	}

	/**
	 * @param businessPartnerName the businessPartnerName to set
	 */
	public void setBusinessPartnerName(String businessPartnerName) {
		this.businessPartnerName = businessPartnerName;
	}

	/**
	 * @return the idPuesto
	 */
	public String getIdPuesto() {
		return idPuesto;
	}

	/**
	 * @param idPuesto the idPuesto to set
	 */
	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
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
	 * @return the idEmpresa
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the claveEmpresa
	 */
	public String getClaveEmpresa() {
		return claveEmpresa;
	}

	/**
	 * @param claveEmpresa the claveEmpresa to set
	 */
	public void setClaveEmpresa(String claveEmpresa) {
		this.claveEmpresa = claveEmpresa;
	}

	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the idCOI
	 */
	public String getIdCOI() {
		return idCOI;
	}

	/**
	 * @param idCOI the idCOI to set
	 */
	public void setIdCOI(String idCOI) {
		this.idCOI = idCOI;
	}

	/**
	 * @return the nombreCOI
	 */
	public String getNombreCOI() {
		return nombreCOI;
	}

	/**
	 * @param nombreCOI the nombreCOI to set
	 */
	public void setNombreCOI(String nombreCOI) {
		this.nombreCOI = nombreCOI;
	}

	/**
	 * @return the idDistribuidor
	 */
	public String getIdDistribuidor() {
		return idDistribuidor;
	}

	/**
	 * @param idDistribuidor the idDistribuidor to set
	 */
	public void setIdDistribuidor(String idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
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
	 * @return the idRegion
	 */
	public String getIdRegion() {
		return idRegion;
	}

	/**
	 * @param idRegion the idRegion to set
	 */
	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	/**
	 * @return the nombreRegion
	 */
	public String getNombreRegion() {
		return nombreRegion;
	}

	/**
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
