package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZRFC_SUC_EMP_X_USUARIO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_SUC_EMP_X_USUARIO_ProxyImpl.class );
	
	public ZRFC_SUC_EMP_X_USUARIO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_SUC_EMP_X_USUARIO");
			if(ft == null)
	            throw new RuntimeException("ZRFC_SUC_EMP_X_USUARIO not found in SAP.");
			
			function = ft.getFunction();
	
			// TODO Change to uppercase
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("T_DATOS");
		
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_SUC_EMP_X_USUARIO_OutputData output = new ZRFC_SUC_EMP_X_USUARIO_OutputData();
				output.setBusinessPartnerId( data.getString("Z_NUMBP") );
				output.setBusinessPartnerName( data.getString("Z_NOMBP") );
				output.setIdPuesto( data.getString("Z_NUMPTO") );
				output.setNombrePuesto( data.getString("Z_NOMPTO") );
				output.setIdSucursal( data.getString("Z_NUMSUC") );
				output.setNombreSucursal( data.getString("Z_NOMSUC") );
				output.setIdEmpresa( data.getString("Z_NUMEMP") );
				output.setClaveEmpresa( data.getString("Z_CVEEMP") );
				output.setNombreEmpresa( data.getString("Z_NOMEMP") );
				output.setIdCOI( data.getString("Z_NUMCOI") );
				output.setNombreCOI( data.getString("Z_NOMCOI") );
				output.setIdDistribuidor( data.getString("Z_NUMDIST") );
				output.setNombreDistribuidor( data.getString("Z_NOMDIST") );
				output.setIdRegion( data.getString("Z_NUMREG") );
				output.setNombreRegion( data.getString("Z_NOMREG") );
				
				returnList.add( output );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_SUC_EMP_X_USUARIO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
