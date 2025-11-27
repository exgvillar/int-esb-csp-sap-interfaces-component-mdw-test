package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.dispersion.netcash.ZCRMETET_E001_OBTIENE_DATBANK_OutputData.DataBank;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
/**
 * 
 * @author jcontreras
 *	proxy que devuelve la informacion de las solicitudes para armar lo que era el i600.
 */
public class ZCRMETET_E001_OBTIENE_DATBANK_ProxyImpl {


	private static Log log = LogFactory.getLog( ZCRMETET_E001_OBTIENE_DATBANK_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMETET_E001_OBTIENE_DATBANK";
	
	public ZCRMETET_E001_OBTIENE_DATBANK_ProxyImpl() {
		super();		
	}

	public ZCRMETET_E001_OBTIENE_DATBANK_OutputData  executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		// genero el objeto padre contenedor de todos los datos
		ZCRMETET_E001_OBTIENE_DATBANK_OutputData outputData = new ZCRMETET_E001_OBTIENE_DATBANK_OutputData();

		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
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

			JCoParameterList salidas = function.getExportParameterList();
			outputData.setEmpresaID(salidas.getInt("E_PARTNER")+"");
			outputData.setEmpresaObjID(( salidas.getInt("E_OBJID")>0 )? salidas.getInt("E_OBJID")+"" : (String)function.getImportParameterList().getValue("I_OBJID") );
			outputData.setSigla(salidas.getString("E_SIGLA"));
			outputData.setNombreEmpresa(salidas.getString("E_NOMCOR"));
			outputData.setBloqueado( (StringUtils.trimToNull(salidas.getString("E_STATUS"))!=null)?true:false);
			
			JCoTable data = function.getExportParameterList().getTable("ET_DATBANK");
			System.out.println("jcotable" + data);
			ArrayList<DataBank> arrDataBanks = new ArrayList<DataBank>();
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				DataBank dataBank = outputData.getDataBank();
				dataBank.setEmpresaID(data.getString("PARTNER"));
				dataBank.setCveBanco(data.getString("BANKL"));
				dataBank.setClaveConvenioPV( data.getString("BANKN"));
				dataBank.setTipoCuenta(data.getString("BKREF"));
				dataBank.setCtaDispersora(data.getString("ACCNAME"));
				dataBank.setFronterizo( ( data.getString("ACCNAME").matches("[0-9]*") )?false:true );
				
				arrDataBanks.add( dataBank );
			}
			outputData.setArrDataBank(arrDataBanks);
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
		}
		return( outputData );
	}
	

}
