/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.models;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZM_WORKINGHOURS_Model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;


	private String dayOfWeek = null;
	
	private String checkIn = null;
	
	private String checkOut = null;
	
	
	/**
	 * 
	 */
	public ZM_WORKINGHOURS_Model() {
		super();
	}

	
	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}


	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}


	/**
	 * @return the checkIn
	 */
	public String getCheckIn() {
		return checkIn;
	}


	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}


	/**
	 * @return the checkOut
	 */
	public String getCheckOut() {
		return checkOut;
	}


	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
