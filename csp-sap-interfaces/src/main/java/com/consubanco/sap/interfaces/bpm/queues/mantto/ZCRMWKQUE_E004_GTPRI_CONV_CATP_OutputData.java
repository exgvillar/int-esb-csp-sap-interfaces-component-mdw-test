/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CATEGORIAS_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E004_GTPRI_CONV_CATP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private ArrayList<ZM_CONVENIOS_Model> conveniosList = null;
	
	private ArrayList<ZM_CATEGORIAS_Model> categoriesList = null;
	
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E004_GTPRI_CONV_CATP_OutputData() {
		super();
	}

	/**
	 * @return the conveniosList
	 */
	public ArrayList<ZM_CONVENIOS_Model> getConveniosList() {
		return conveniosList;
	}

	/**
	 * @param conveniosList the conveniosList to set
	 */
	public void setConveniosList(ArrayList<ZM_CONVENIOS_Model> conveniosList) {
		this.conveniosList = conveniosList;
	}

	/**
	 * @return the categoriesList
	 */
	public ArrayList<ZM_CATEGORIAS_Model> getCategoriesList() {
		return categoriesList;
	}

	/**
	 * @param categoriesList the categoriesList to set
	 */
	public void setCategoriesList(ArrayList<ZM_CATEGORIAS_Model> categoriesList) {
		this.categoriesList = categoriesList;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
