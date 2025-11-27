/**
 * 
 */
package com.consubanco.sap.interfaces.commons.orgdata;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_E003_BPORGAN_OutputData implements Serializable,
		IProxyOutputData {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private String idOficinaVentas = null;
	
	private String shortnameOficinaVentas = null;
	
	private String nameOficinaVentas = null;
	
	private String idOrganizacionVentas = null;
	
	private String shortnameOrganizacionVentas = null;
	
	private String nameOrganizacionVentas = null;
	
	private String idLocalizacionOficinaVentas = null;
	
	private String descLocalizacionOficinaVentas = null;
	
	private boolean applyProspector = false;
	
	private boolean bpTDCI = false;
	
	private boolean salesOfficeTDCI = false;
	
	private boolean applyNewScoring = false;
	
	/**
	 * 
	 */
	public ZCRMORI_E003_BPORGAN_OutputData() {
		super();
	}

	



	/**
	 * @return the idOficinaVentas
	 */
	public String getIdOficinaVentas() {
		return idOficinaVentas;
	}





	/**
	 * @param idOficinaVentas the idOficinaVentas to set
	 */
	public void setIdOficinaVentas(String idOficinaVentas) {
		this.idOficinaVentas = idOficinaVentas;
	}





	/**
	 * @return the shortnameOficinaVentas
	 */
	public String getShortnameOficinaVentas() {
		return shortnameOficinaVentas;
	}





	/**
	 * @param shortnameOficinaVentas the shortnameOficinaVentas to set
	 */
	public void setShortnameOficinaVentas(String shortnameOficinaVentas) {
		this.shortnameOficinaVentas = shortnameOficinaVentas;
	}





	/**
	 * @return the nameOficinaVentas
	 */
	public String getNameOficinaVentas() {
		return nameOficinaVentas;
	}





	/**
	 * @param nameOficinaVentas the nameOficinaVentas to set
	 */
	public void setNameOficinaVentas(String nameOficinaVentas) {
		this.nameOficinaVentas = nameOficinaVentas;
	}





	/**
	 * @return the idOrganizacionVentas
	 */
	public String getIdOrganizacionVentas() {
		return idOrganizacionVentas;
	}





	/**
	 * @param idOrganizacionVentas the idOrganizacionVentas to set
	 */
	public void setIdOrganizacionVentas(String idOrganizacionVentas) {
		this.idOrganizacionVentas = idOrganizacionVentas;
	}





	/**
	 * @return the shortnameOrganizacionVentas
	 */
	public String getShortnameOrganizacionVentas() {
		return shortnameOrganizacionVentas;
	}





	/**
	 * @param shortnameOrganizacionVentas the shortnameOrganizacionVentas to set
	 */
	public void setShortnameOrganizacionVentas(String shortnameOrganizacionVentas) {
		this.shortnameOrganizacionVentas = shortnameOrganizacionVentas;
	}





	/**
	 * @return the nameOrganizacionVentas
	 */
	public String getNameOrganizacionVentas() {
		return nameOrganizacionVentas;
	}





	/**
	 * @param nameOrganizacionVentas the nameOrganizacionVentas to set
	 */
	public void setNameOrganizacionVentas(String nameOrganizacionVentas) {
		this.nameOrganizacionVentas = nameOrganizacionVentas;
	}


	



	/**
	 * @return the idLocalizacionOficinaVentas
	 */
	public String getIdLocalizacionOficinaVentas() {
		return idLocalizacionOficinaVentas;
	}





	/**
	 * @param idLocalizacionOficinaVentas the idLocalizacionOficinaVentas to set
	 */
	public void setIdLocalizacionOficinaVentas(String idLocalizacionOficinaVentas) {
		this.idLocalizacionOficinaVentas = idLocalizacionOficinaVentas;
	}





	/**
	 * @return the descLocalizacionOficinaVentas
	 */
	public String getDescLocalizacionOficinaVentas() {
		return descLocalizacionOficinaVentas;
	}





	/**
	 * @param descLocalizacionOficinaVentas the descLocalizacionOficinaVentas to set
	 */
	public void setDescLocalizacionOficinaVentas(
			String descLocalizacionOficinaVentas) {
		this.descLocalizacionOficinaVentas = descLocalizacionOficinaVentas;
	}



	/**
	 * @return the applyProspector
	 */
	public boolean isApplyProspector() {
		return applyProspector;
	}





	/**
	 * @param applyProspector the applyProspector to set
	 */
	public void setApplyProspector(boolean applyProspector) {
		this.applyProspector = applyProspector;
	}





	public boolean isBpTDCI() {
		return bpTDCI;
	}





	public void setBpTDCI(boolean bpTDCI) {
		this.bpTDCI = bpTDCI;
	}





	public boolean isSalesOfficeTDCI() {
		return salesOfficeTDCI;
	}





	public void setSalesOfficeTDCI(boolean salesOfficeTDCI) {
		this.salesOfficeTDCI = salesOfficeTDCI;
	}

	/**
	 * @return the applyNewScoring
	 */
	public boolean isApplyNewScoring() {
		return applyNewScoring;
	}





	/**
	 * @param applyNewScoring the applyNewScoring to set
	 */
	public void setApplyNewScoring(boolean applyNewScoring) {
		this.applyNewScoring = applyNewScoring;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
