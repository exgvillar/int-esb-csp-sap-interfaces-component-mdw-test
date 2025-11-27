/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String id = null;
	
	private String fieldName = null;
	
	private String type = null;
	
	private String value = null;
	
	private int ratePriority = 0;
	
	private String requestedBy = null;
	
	private boolean authorized = false;
	
	private String authorizedBy = null;
	
	private Date createDate = null;
	
	private Date lastUpdateDate = null;
	
	private boolean active = false;
	
		/**
	 * 
	 */
	public ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData() {
		super();
	}

	/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the fieldName
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * @param fieldName the fieldName to set
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the ratePriority
		 */
		public int getRatePriority() {
			return ratePriority;
		}

		/**
		 * @param ratePriority the ratePriority to set
		 */
		public void setRatePriority(int ratePriority) {
			this.ratePriority = ratePriority;
		}

		/**
		 * @return the requestedBy
		 */
		public String getRequestedBy() {
			return requestedBy;
		}

		/**
		 * @param requestedBy the requestedBy to set
		 */
		public void setRequestedBy(String requestedBy) {
			this.requestedBy = requestedBy;
		}

		/**
		 * @return the authorized
		 */
		public boolean isAuthorized() {
			return authorized;
		}

		/**
		 * @param authorized the authorized to set
		 */
		public void setAuthorized(boolean authorized) {
			this.authorized = authorized;
		}

		/**
		 * @return the authorizedBy
		 */
		public String getAuthorizedBy() {
			return authorizedBy;
		}

		/**
		 * @param authorizedBy the authorizedBy to set
		 */
		public void setAuthorizedBy(String authorizedBy) {
			this.authorizedBy = authorizedBy;
		}

		/**
		 * @return the createDate
		 */
		public Date getCreateDate() {
			return createDate;
		}

		/**
		 * @param createDate the createDate to set
		 */
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		/**
		 * @return the lastUpdateDate
		 */
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}

		/**
		 * @param lastUpdateDate the lastUpdateDate to set
		 */
		public void setLastUpdateDate(Date lastUpdateDate) {
			this.lastUpdateDate = lastUpdateDate;
		}

		/**
		 * @return the active
		 */
		public boolean isActive() {
			return active;
		}

		/**
		 * @param active the active to set
		 */
		public void setActive(boolean active) {
			this.active = active;
		}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
