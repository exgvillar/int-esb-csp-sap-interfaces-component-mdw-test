package com.consupago.sap.interfaces.utils.proxy.creator;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class CreateProxyForRFCImpl {

	private static Log log = LogFactory.getLog( CreateProxyForRFCImpl.class );
	
	private final String RFC_NAME = "ZRFC_SOL_COUNT_READ";
	private final String PACKAGE = "com.consupago.sap.interfaces.proxy.lcom.dispersion.";
	
	public CreateProxyForRFCImpl() {
		super();		
	}

	
	
	public void generaJcoFile( JCoDestination destination) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		ArrayList<String> arrTablas = new ArrayList<String>();

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
			
			JCoListMetaData entradas =  ft.getImportParameterList();
			JCoListMetaData salidas =  ft.getExportParameterList();
			JCoListMetaData salTab =  ft.getTableParameterList();
						
			if (entradas != null){
				System.out.println("=========\nENTRADAS:");
				for (int i = 0; i < entradas.getFieldCount(); i++) {
					System.out.println(entradas.getName(i) + "::" + entradas.getTypeAsString(i));
					if (entradas.isStructure(i))
						this.generaEstrutura(function.getImportParameterList().getStructure(entradas.getName(i)) );
					if (entradas.isTable(i)){
						arrTablas.addAll( this.generaTabla(function.getImportParameterList().getTable(entradas.getName(i)) , function.getImportParameterList() ) );
					}
				}
			}

			if (salidas != null){
				for (int i = 0; i < salidas.getFieldCount(); i++) {
					System.out.println("============\nSALIDAS:");
					System.out.println(salidas.getName(i) + "::" + salidas.getTypeAsString(i) );
					if (salidas.isStructure(i))
						this.generaEstrutura(function.getExportParameterList().getStructure(salidas.getName(i)) );
					if (salidas.isTable(i)){
						arrTablas.addAll( this.generaTabla(function.getExportParameterList().getTable(salidas.getName(i)) , function.getExportParameterList() ) );
					}
				}
			}
			
			if (salTab != null){
				for (int i = 0; i < salTab.getFieldCount(); i++) {
					System.out.println("============\nSALIDA TABLA:");
					System.out.println(salTab.getName(i) + "::" + salTab.getTypeAsString(i) );
//					if (salTab.isStructure(i))
//						this.generaEstrutura(function.getExportParameterList().getStructure(salidas.getName(i)) );
					if (salTab.isTable(i)){
						arrTablas.addAll( this.generaTabla(function.getTableParameterList().getTable(salTab.getName(i)) , function.getTableParameterList() ) );
					}
				}
			}

			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
	private void generaEstrutura(JCoStructure estructura){
		Iterator<JCoField> field = estructura.iterator();
		while (field.hasNext()) {
			JCoField jCoField = (JCoField) field.next();
			System.out.println(  jCoField.getName() + "::" +  jCoField.getType()  + "::" + jCoField.getTypeAsString() );
		}
	}
	
	private ArrayList<String> generaTabla(JCoTable estructura, JCoParameterList tablaPrincipal){
		ArrayList<String> nombresTabla = new ArrayList<String>();
		Iterator<JCoField> field = estructura.iterator();
		System.out.println("Tabla: ----");
		while (field.hasNext()) {
			JCoField jCoField = (JCoField) field.next();
//			System.out.println(  jCoField.getName() + ":" +  jCoField.getType()  + ":" + jCoField.getClassNameOfValue());
			String[] tipo = jCoField.getClassNameOfValue().split("\\.");
			String[] campo = jCoField.getName().toLowerCase().split("\\_");
			boolean isprimer=true;
			StringBuffer buf = new StringBuffer();
			for (String segmento : campo) {
				if (isprimer){
					buf.append(segmento);
					isprimer= false;
				} else {
					buf.append(WordUtils.capitalize(segmento) );
				}
					
			}
			if (!jCoField.isTable() ){
//				System.out.println("private " + tipo[tipo.length-1] + " " + buf.toString() +";");
				System.out.println("output.set" + WordUtils.capitalize(buf.toString()) + "(data.get"+ tipo[tipo.length-1] +"(\"" + jCoField.getName() + "\") );");
			} else {
//				JCoTable subtabla =  tablaPrincipal.getTable( jCoField.getName() );
				System.out.println("JCoTable ztb"+ WordUtils.capitalize(buf.toString()) +" =  data.getTable(\""+jCoField.getName()+"\");");
//				System.out.println("private ArrayList<" + WordUtils.capitalize(buf.toString()) + "> " + buf.toString() +";");
//				jCoField.getTable();
//				System.out.println("tabla: " + subtabla );
			}
		}
		return nombresTabla;
	}

	
	public static void main(String[] args) throws Exception {
		CreateProxyForRFCImpl forRFCImpl = new CreateProxyForRFCImpl();
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		forRFCImpl.generaJcoFile(destination);
	}
}
