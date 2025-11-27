package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZIT_CONVENIO_CAT_OutputData implements Serializable,
		IProxyOutputData {
	

	private String mandt;
	private String productId;
	private String zaltasistemaexte;
	private String zavaladosdiscapp;
	private String zcapturarava;
	private String productId2;
	private String productId3;
	private String zempleadobase;
	private String zdisseparada;
	private Date zz0011;
	private Date zz0012;
	private String zllamadadecalida;
	private String shortText;
	private String zrequierevale;
	private String zsupempoderado;
	private String zz0010;
	private String zempleadotienena;
	private String zcapturarava2;
	private String zvalidanosujetos;
	private String zbdsobregirado;
	private String zvalidasujeto;
	private String zdeduccionesadd;
	private String zgrupconv;
	private String ztipoamortiza;
	private String zcvebrms;
	private String zgpoanalista;
	private Date zinicjur;
	private Date zfinjur;
	private String zcategoria;
	private String zcattext;

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	public String getMandt() {
		return mandt;
	}
	public void setMandt(String mandt) {
		this.mandt = mandt;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getZaltasistemaexte() {
		return zaltasistemaexte;
	}
	public void setZaltasistemaexte(String zaltasistemaexte) {
		this.zaltasistemaexte = zaltasistemaexte;
	}
	public String getZavaladosdiscapp() {
		return zavaladosdiscapp;
	}
	public void setZavaladosdiscapp(String zavaladosdiscapp) {
		this.zavaladosdiscapp = zavaladosdiscapp;
	}
	public String getZcapturarava() {
		return zcapturarava;
	}
	public void setZcapturarava(String zcapturarava) {
		this.zcapturarava = zcapturarava;
	}
	public String getProductId2() {
		return productId2;
	}
	public void setProductId2(String productId2) {
		this.productId2 = productId2;
	}
	public String getProductId3() {
		return productId3;
	}
	public void setProductId3(String productId3) {
		this.productId3 = productId3;
	}
	public String getZempleadobase() {
		return zempleadobase;
	}
	public void setZempleadobase(String zempleadobase) {
		this.zempleadobase = zempleadobase;
	}
	public String getZdisseparada() {
		return zdisseparada;
	}
	public void setZdisseparada(String zdisseparada) {
		this.zdisseparada = zdisseparada;
	}
	public Date getZz0011() {
		return zz0011;
	}
	public void setZz0011(Date zz0011) {
		this.zz0011 = zz0011;
	}
	public Date getZz0012() {
		return zz0012;
	}
	public void setZz0012(Date zz0012) {
		this.zz0012 = zz0012;
	}
	public String getZllamadadecalida() {
		return zllamadadecalida;
	}
	public void setZllamadadecalida(String zllamadadecalida) {
		this.zllamadadecalida = zllamadadecalida;
	}
	public String getShortText() {
		return shortText;
	}
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	public String getZrequierevale() {
		return zrequierevale;
	}
	public void setZrequierevale(String zrequierevale) {
		this.zrequierevale = zrequierevale;
	}
	public String getZsupempoderado() {
		return zsupempoderado;
	}
	public void setZsupempoderado(String zsupempoderado) {
		this.zsupempoderado = zsupempoderado;
	}
	public String getZz0010() {
		return zz0010;
	}
	public void setZz0010(String zz0010) {
		this.zz0010 = zz0010;
	}
	public String getZempleadotienena() {
		return zempleadotienena;
	}
	public void setZempleadotienena(String zempleadotienena) {
		this.zempleadotienena = zempleadotienena;
	}
	public String getZcapturarava2() {
		return zcapturarava2;
	}
	public void setZcapturarava2(String zcapturarava2) {
		this.zcapturarava2 = zcapturarava2;
	}
	public String getZvalidanosujetos() {
		return zvalidanosujetos;
	}
	public void setZvalidanosujetos(String zvalidanosujetos) {
		this.zvalidanosujetos = zvalidanosujetos;
	}
	public String getZbdsobregirado() {
		return zbdsobregirado;
	}
	public void setZbdsobregirado(String zbdsobregirado) {
		this.zbdsobregirado = zbdsobregirado;
	}
	public String getZvalidasujeto() {
		return zvalidasujeto;
	}
	public void setZvalidasujeto(String zvalidasujeto) {
		this.zvalidasujeto = zvalidasujeto;
	}
	public String getZdeduccionesadd() {
		return zdeduccionesadd;
	}
	public void setZdeduccionesadd(String zdeduccionesadd) {
		this.zdeduccionesadd = zdeduccionesadd;
	}
	public String getZgrupconv() {
		return zgrupconv;
	}
	public void setZgrupconv(String zgrupconv) {
		this.zgrupconv = zgrupconv;
	}
	public String getZtipoamortiza() {
		return ztipoamortiza;
	}
	public void setZtipoamortiza(String ztipoamortiza) {
		this.ztipoamortiza = ztipoamortiza;
	}
	public String getZcvebrms() {
		return zcvebrms;
	}
	public void setZcvebrms(String zcvebrms) {
		this.zcvebrms = zcvebrms;
	}
	public String getZgpoanalista() {
		return zgpoanalista;
	}
	public void setZgpoanalista(String zgpoanalista) {
		this.zgpoanalista = zgpoanalista;
	}
	public Date getZinicjur() {
		return zinicjur;
	}
	public void setZinicjur(Date zinicjur) {
		this.zinicjur = zinicjur;
	}
	public Date getZfinjur() {
		return zfinjur;
	}
	public void setZfinjur(Date zfinjur) {
		this.zfinjur = zfinjur;
	}
	public String getZcategoria() {
		return zcategoria;
	}
	public void setZcategoria(String zcategoria) {
		this.zcategoria = zcategoria;
	}
	public String getZcattext() {
		return zcattext;
	}
	public void setZcattext(String zcattext) {
		this.zcattext = zcattext;
	}

	
}
