/**
 * 
 */
package com.consubanco.sap.interfaces.sic.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZFM_SIC_CONVENIOS_MOVS_model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String moveType = null;
	
	private String orderType = null;
	
	
 	
	
	
	/**
	 * 
	 */
	public ZFM_SIC_CONVENIOS_MOVS_model() {
		super();
	}

	
	

	/**
	 * @return the moveType
	 */
	public String getMoveType() {
		return moveType;
	}




	/**
	 * @param moveType the moveType to set
	 */
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}




	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}




	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
