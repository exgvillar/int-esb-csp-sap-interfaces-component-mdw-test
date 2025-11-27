/**
 * 
 */
package com.consubanco.sap.interfaces.recommender.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 *
 */
public class Direccion_Model implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String street;
	private String houseNum1;
	private String houseNum2;
	private String homeCity;
	private String city1;
	private String city2;
	private String postCode1;
	private String region;
	private String country;
	private String telFijo;
	private String telMov;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the houseNum1
	 */
	public String getHouseNum1() {
		return houseNum1;
	}

	/**
	 * @param houseNum1
	 *            the houseNum1 to set
	 */
	public void setHouseNum1(String houseNum1) {
		this.houseNum1 = houseNum1;
	}

	/**
	 * @return the houseNum2
	 */
	public String getHouseNum2() {
		return houseNum2;
	}

	/**
	 * @param houseNum2
	 *            the houseNum2 to set
	 */
	public void setHouseNum2(String houseNum2) {
		this.houseNum2 = houseNum2;
	}

	/**
	 * @return the homeCity
	 */
	public String getHomeCity() {
		return homeCity;
	}

	/**
	 * @param homeCity
	 *            the homeCity to set
	 */
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	/**
	 * @return the city1
	 */
	public String getCity1() {
		return city1;
	}

	/**
	 * @param city1
	 *            the city1 to set
	 */
	public void setCity1(String city1) {
		this.city1 = city1;
	}

	/**
	 * @return the city2
	 */
	public String getCity2() {
		return city2;
	}

	/**
	 * @param city2
	 *            the city2 to set
	 */
	public void setCity2(String city2) {
		this.city2 = city2;
	}

	/**
	 * @return the postCode1
	 */
	public String getPostCode1() {
		return postCode1;
	}

	/**
	 * @param postCode1
	 *            the postCode1 to set
	 */
	public void setPostCode1(String postCode1) {
		this.postCode1 = postCode1;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the telFijo
	 */
	public String getTelFijo() {
		return telFijo;
	}

	/**
	 * @param telFijo
	 *            the telFijo to set
	 */
	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	/**
	 * @return the telMov
	 */
	public String getTelMov() {
		return telMov;
	}

	/**
	 * @param telMov
	 *            the telMov to set
	 */
	public void setTelMov(String telMov) {
		this.telMov = telMov;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
