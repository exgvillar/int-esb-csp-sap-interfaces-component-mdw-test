/**
 * 
 */
package com.consubanco.sap.interfaces.recommender.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class ElegibilityModel extends ServiceOrderModel implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String solCotRecomended;
	private int recommendedNumber;
	private Date elegibilityDate;
	private boolean elegibility;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the solCotRecomended
	 */
	public String getSolCotRecomended() {
		return solCotRecomended;
	}

	/**
	 * @param solCotRecomended
	 *            the solCotRecomended to set
	 */
	public void setSolCotRecomended(String solCotRecomended) {
		this.solCotRecomended = solCotRecomended;
	}

	/**
	 * @return the recommendedNumber
	 */
	public int getRecommendedNumber() {
		return recommendedNumber;
	}

	/**
	 * @param recommendedNumber
	 *            the recommendedNumber to set
	 */
	public void setRecommendedNumber(int recommendedNumber) {
		this.recommendedNumber = recommendedNumber;
	}

	/**
	 * @return the elegibilityDate
	 */
	public Date getElegibilityDate() {
		return elegibilityDate;
	}

	/**
	 * @param elegibilityDate
	 *            the elegibilityDate to set
	 */
	public void setElegibilityDate(Date elegibilityDate) {
		this.elegibilityDate = elegibilityDate;
	}

	/**
	 * @return the elegibility
	 */
	public boolean isElegibility() {
		return elegibility;
	}

	/**
	 * @param elegibility
	 *            the elegibility to set
	 */
	public void setElegibility(boolean elegibility) {
		this.elegibility = elegibility;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
