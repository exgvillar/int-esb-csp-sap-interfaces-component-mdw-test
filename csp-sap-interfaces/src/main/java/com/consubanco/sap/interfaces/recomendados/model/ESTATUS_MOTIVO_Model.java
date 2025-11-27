package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;

/**
 * @author omar.corona
 *
 */
public class ESTATUS_MOTIVO_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String numeroOrdenServicio = null;
	
	private String nuevoEstatus = null;
		 
	private ArrayList<ProxyInputParameter> motivos = null;
	
	
	
	public ESTATUS_MOTIVO_Model() {
		super();
	}
	
	

	/**
	 * @return the numeroOrdenServicio
	 */
	public String getNumeroOrdenServicio() {
		return numeroOrdenServicio;
	}



	/**
	 * @param numeroOrdenServicio the numeroOrdenServicio to set
	 */
	public void setNumeroOrdenServicio(String numeroOrdenServicio) {
		this.numeroOrdenServicio = numeroOrdenServicio;
	}



	/**
	 * @return the nuevoEstatus
	 */
	public String getNuevoEstatus() {
		return nuevoEstatus;
	}



	/**
	 * @param nuevoEstatus the nuevoEstatus to set
	 */
	public void setNuevoEstatus(String nuevoEstatus) {
		this.nuevoEstatus = nuevoEstatus;
	}



	/**
	 * @return the motivos
	 */
	public ArrayList<ProxyInputParameter> getMotivos() {
		return motivos;
	}



	/**
	 * @param motivos the motivos to set
	 */
	public void setMotivos(ArrayList<ProxyInputParameter> motivos) {
		this.motivos = motivos;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
