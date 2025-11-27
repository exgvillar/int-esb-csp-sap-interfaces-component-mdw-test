package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.CONVENIO_Model;
import com.consubanco.sap.interfaces.recomendados.model.DISTRIBUIDOR_Model;
import com.consubanco.sap.interfaces.recomendados.model.EMPRESA_Model;
import com.consubanco.sap.interfaces.recomendados.model.PRODUCTO_Model;
import com.consubanco.sap.interfaces.recomendados.model.SUCURSAL_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;

public class ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl.class );
	
	public ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_E002_GETINFO_CLTEREFI" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_E002_GETINFO_CLTEREFI not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}

			function.execute(destination);
			
			ZCRMRECO_E002_GETINFO_CLTEREFI_OutputData data = new ZCRMRECO_E002_GETINFO_CLTEREFI_OutputData();

			JCoStructure dataStructure  = function.getExportParameterList().getStructure("E_RESULT");			
			log.info("" + dataStructure.toString());
			data.setNumeroSolicitud(dataStructure.getString("NUMERO_SOL"));

			EMPRESA_Model empresa = new EMPRESA_Model();
			empresa.setId(dataStructure.getString("CLV_EMPRESA"));
			empresa.setDescription(dataStructure.getString("NOM_EMPRESA"));
			
			SUCURSAL_Model sucursal = new SUCURSAL_Model();
			sucursal.setId(dataStructure.getString("CLV_SUCURSAL"));
			sucursal.setDescription(dataStructure.getString("NOM_SUCURSAL"));
			
			CONVENIO_Model convenio = new CONVENIO_Model();
			convenio.setId(dataStructure.getString("ID_CONVENIO"));
			convenio.setDescription(dataStructure.getString("NOM_CONVENIO"));
			
			PRODUCTO_Model producto = new PRODUCTO_Model();
			producto.setId(dataStructure.getString("ID_PRODUCTO"));
			producto.setDescription(dataStructure.getString("NOM_PRODUCTO"));
			
			DISTRIBUIDOR_Model distribuidor = new DISTRIBUIDOR_Model();
			distribuidor.setId( dataStructure.getString("ID_DISTRIB") );
			distribuidor.setSiglas( dataStructure.getString("SIG_DISTRIB") );
			distribuidor.setDescription( dataStructure.getString("NOM_DISTRIB") );
			
			data.setEmpresa(empresa);
			data.setSucursal(sucursal);
			data.setConvenio(convenio);
			data.setProducto(producto);		
			data.setDistribuidor(distribuidor);

			log.info( "" +  data.toString() );

			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_E002_GETINFO_CLTEREFI" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
