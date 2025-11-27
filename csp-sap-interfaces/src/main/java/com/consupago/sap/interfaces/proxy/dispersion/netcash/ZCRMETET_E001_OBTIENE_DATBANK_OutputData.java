package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMETET_E001_OBTIENE_DATBANK_OutputData implements Serializable, IProxyOutputData  {
	private static final long serialVersionUID = 4333575693644910250L;
	private String empresaID;
	private String empresaObjID;
	private String sigla;
	private String nombreEmpresa;
	private boolean bloqueado;
	private DataBank dataBank;
	private ArrayList<DataBank> arrDataBank;
	

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public DataBank getDataBank() {
		return new DataBank();
	}

	public void setDataBank(DataBank dataBank) {
		this.dataBank = dataBank;
	}

	public ArrayList<DataBank> getArrDataBank() {
		return arrDataBank;
	}

	public void setArrDataBank(ArrayList<DataBank> arrDataBank) {
		this.arrDataBank = arrDataBank;
	}
	
	public class DataBank implements Serializable, IProxyOutputData  {

		private static final long serialVersionUID = 8442097391317905121L;
		private String empresaID;
		private String cveBanco;
		private String claveConvenioPV;
		private String idConvenioBancario;
		private String tipoCuenta;
		private String ctaDispersora;
		private String titularCuenta;
		private boolean fronterizo;

		public String getEmpresaID() {
			return empresaID;
		}
		public void setEmpresaID(String empresaID) {
			this.empresaID = empresaID;
		}
		public String getCveBanco() {
			return cveBanco;
		}
		public void setCveBanco(String cveBanco) {
			this.cveBanco = cveBanco;
		}
		public String getClaveConvenioPV() {
			return claveConvenioPV;
		}
		public void setClaveConvenioPV(String claveConvenioPV) {
			this.claveConvenioPV = claveConvenioPV;
		}
		public String getTipoCuenta() {
			return tipoCuenta;
		}
		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		public String getCtaDispersora() {
			return ctaDispersora;
		}
		public void setCtaDispersora(String ctaDispersora) {
			this.ctaDispersora = ctaDispersora;
		}

		public String toString() {
			return ToStringBuilder.reflectionToString(this,
					ToStringStyle.MULTI_LINE_STYLE);
		}
		public boolean isFronterizo() {
			return fronterizo;
		}
		public void setFronterizo(boolean fronteriso) {
			this.fronterizo = fronteriso;
		}
		public String getTitularCuenta() {
			return titularCuenta;
		}
		public void setTitularCuenta(String titularCuenta) {
			this.titularCuenta = titularCuenta;
		}
		/**
		 * @return the idConvenioBancario
		 */
		public String getIdConvenioBancario() {
			return idConvenioBancario;
		}
		/**
		 * @param idConvenioBancario the idConvenioBancario to set
		 */
		public void setIdConvenioBancario(String idConvenioBancario) {
			this.idConvenioBancario = idConvenioBancario;
		}
		

	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getEmpresaID() {
		return empresaID;
	}

	public void setEmpresaID(String empresaID) {
		this.empresaID = empresaID;
	}

	public String getEmpresaObjID() {
		return empresaObjID;
	}

	public void setEmpresaObjID(String empresaObjID) {
		this.empresaObjID = empresaObjID;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
