/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E006_GET_TIMEATNCOX_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String businessPartner = null;
	
	private String user = null;
	
	private String areaId = null;
	
	private String areaDesc = null;
	
	private String experienceLevelId = null;
	
	private String experienceLevelDesc = null;
	
	private ArrayList<ZM_CONVENIOS_Model> conveniosList = null;
	
	private String productCategoryId = null;
	
	private String productCategoryDesc = null;
	
	private String sourceChannelId = null;
	
	private String sourceChannelDesc = null;
	
	private int attentionTime = 0;
	
	private String userLastUpdate = null;
	
	private Date createDate = null;
	
	private Date lastUpdateDate = null;
	
		/**
	 * 
	 */
	public ZCRMWKQUE_E006_GET_TIMEATNCOX_OutputData() {
		super();
	}

	
	/**
		 * @return the businessPartner
		 */
		public String getBusinessPartner() {
			return businessPartner;
		}


		/**
		 * @param businessPartner the businessPartner to set
		 */
		public void setBusinessPartner(String businessPartner) {
			this.businessPartner = businessPartner;
		}


		/**
		 * @return the user
		 */
		public String getUser() {
			return user;
		}


		/**
		 * @param user the user to set
		 */
		public void setUser(String user) {
			this.user = user;
		}


		/**
		 * @return the areaId
		 */
		public String getAreaId() {
			return areaId;
		}


		/**
		 * @param areaId the areaId to set
		 */
		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}


		/**
		 * @return the areaDesc
		 */
		public String getAreaDesc() {
			return areaDesc;
		}


		/**
		 * @param areaDesc the areaDesc to set
		 */
		public void setAreaDesc(String areaDesc) {
			this.areaDesc = areaDesc;
		}


		/**
		 * @return the experienceLevelId
		 */
		public String getExperienceLevelId() {
			return experienceLevelId;
		}


		/**
		 * @param experienceLevelId the experienceLevelId to set
		 */
		public void setExperienceLevelId(String experienceLevelId) {
			this.experienceLevelId = experienceLevelId;
		}


		/**
		 * @return the experienceLevelDesc
		 */
		public String getExperienceLevelDesc() {
			return experienceLevelDesc;
		}


		/**
		 * @param experienceLevelDesc the experienceLevelDesc to set
		 */
		public void setExperienceLevelDesc(String experienceLevelDesc) {
			this.experienceLevelDesc = experienceLevelDesc;
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
		 * @return the productCategoryId
		 */
		public String getProductCategoryId() {
			return productCategoryId;
		}


		/**
		 * @param productCategoryId the productCategoryId to set
		 */
		public void setProductCategoryId(String productCategoryId) {
			this.productCategoryId = productCategoryId;
		}


		/**
		 * @return the productCategoryDesc
		 */
		public String getProductCategoryDesc() {
			return productCategoryDesc;
		}


		/**
		 * @param productCategoryDesc the productCategoryDesc to set
		 */
		public void setProductCategoryDesc(String productCategoryDesc) {
			this.productCategoryDesc = productCategoryDesc;
		}


		/**
		 * @return the sourceChannelId
		 */
		public String getSourceChannelId() {
			return sourceChannelId;
		}


		/**
		 * @param sourceChannelId the sourceChannelId to set
		 */
		public void setSourceChannelId(String sourceChannelId) {
			this.sourceChannelId = sourceChannelId;
		}


		/**
		 * @return the sourceChannelDesc
		 */
		public String getSourceChannelDesc() {
			return sourceChannelDesc;
		}


		/**
		 * @param sourceChannelDesc the sourceChannelDesc to set
		 */
		public void setSourceChannelDesc(String sourceChannelDesc) {
			this.sourceChannelDesc = sourceChannelDesc;
		}


		/**
		 * @return the attentionTime
		 */
		public int getAttentionTime() {
			return attentionTime;
		}


		/**
		 * @param attentionTime the attentionTime to set
		 */
		public void setAttentionTime(int attentionTime) {
			this.attentionTime = attentionTime;
		}


		/**
		 * @return the userLastUpdate
		 */
		public String getUserLastUpdate() {
			return userLastUpdate;
		}


		/**
		 * @param userLastUpdate the userLastUpdate to set
		 */
		public void setUserLastUpdate(String userLastUpdate) {
			this.userLastUpdate = userLastUpdate;
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


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
