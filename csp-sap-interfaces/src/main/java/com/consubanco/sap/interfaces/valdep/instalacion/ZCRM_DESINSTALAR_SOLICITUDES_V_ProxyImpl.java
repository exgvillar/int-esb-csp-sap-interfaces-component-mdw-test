package com.consubanco.sap.interfaces.valdep.instalacion;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRM_DESINSTALAR_SOLICITUDES_V";
	
	public ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData> executeRemoteFunction( JCoDestination destination) throws Exception {
		ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData> returnList = new ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			function.execute(destination);
			
			
			
			JCoTable dataTableOsValDep = function.getExportParameterList().getTable("E_OS_VALDEP");
			
			for (int i = 0; i < dataTableOsValDep.getNumRows(); i++, dataTableOsValDep.nextRow()) {		
				ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData datRet = new ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData();
				datRet.setzEstatus(dataTableOsValDep.getString("ZESTATUS"));
				datRet.setzIdSolicitud(dataTableOsValDep.getString("ZIDSOLICITUD"));
				// por cada registro hay que obtener las subestructuras internas ...
				JCoTable dataTableInfoOS = dataTableOsValDep.getTable("Z_OS_VALDEP");
				ArrayList<Z_OS_VALDEP_OutputData> arrOsValDep = new ArrayList<Z_OS_VALDEP_OutputData>();
				for (int j = 0; j < dataTableInfoOS.getNumRows(); j++, dataTableInfoOS.nextRow()) {
					Z_OS_VALDEP_OutputData osVALDEPOutputData = new Z_OS_VALDEP_OutputData();
					osVALDEPOutputData.setzIdOs(dataTableInfoOS.getString("ZIDOS"));
					osVALDEPOutputData.setzEstatusOs(dataTableInfoOS.getString("ZESTATUS"));
					// obtenlgo la estrutura de los montos
					JCoTable dataTableMontos = dataTableInfoOS.getTable("ZMONTOS");
					ArrayList<Z_OS_MONTOS_OutputData> arrMontos = new ArrayList<Z_OS_MONTOS_OutputData>();
					for (int k = 0; k < dataTableMontos.getNumRows(); k++, dataTableMontos.nextRow()) {
						Z_OS_MONTOS_OutputData montosOutputData = new Z_OS_MONTOS_OutputData();
						montosOutputData.setzMontoCredito(dataTableMontos.getString("ZMONTO_CREDITO"));
						montosOutputData.setzMontoDescuento(dataTableMontos.getString("ZMONTO_DESCUENTO"));
						arrMontos.add( montosOutputData );
					}
					osVALDEPOutputData.setArrMontos(arrMontos);
					// obtengo la estructura de Interlocutores.
					JCoTable dataTableInterlocutore = dataTableInfoOS.getTable("ZINTERLOCUTORES");
					ArrayList<Z_OS_INTERLOCUTORES_OutPutData> arrInterloc = new ArrayList<Z_OS_INTERLOCUTORES_OutPutData>();
					for (int l = 0; l < dataTableInterlocutore.getNumRows(); l++, dataTableInterlocutore.nextRow()) {
						Z_OS_INTERLOCUTORES_OutPutData interlocOutPutData = new Z_OS_INTERLOCUTORES_OutPutData();
						interlocOutPutData.setzSolicitante(dataTableInterlocutore.getString("ZSOLICITANTE"));
						interlocOutPutData.setzNombreSolicitante(dataTableInterlocutore.getString("ZNOMBRE_SOLICITANTE"));
						interlocOutPutData.setzEmpleadoResp( dataTableInterlocutore.getString("ZEMPLEADO_RESP"));
						interlocOutPutData.setzNombreEmpResp( dataTableInterlocutore.getString("ZNOMBRE_EMPL_RESP"));
						arrInterloc.add(interlocOutPutData);
					}
					osVALDEPOutputData.setArrInterlocutores(arrInterloc);
					// obtengo la estrutura de fechas...
					JCoTable dataTableFechas = dataTableInfoOS.getTable("ZFECHA");
					ArrayList<Z_OS_FECHAS_OutputData> arrFechas = new ArrayList<Z_OS_FECHAS_OutputData>();
					for (int l = 0; l < dataTableFechas.getNumRows(); l++, dataTableFechas.nextRow()) {
						Z_OS_FECHAS_OutputData fechasOutputData = new Z_OS_FECHAS_OutputData();
						fechasOutputData.setzFechaDesinst(dataTableFechas.getString("ZFECHA_DESINST"));
						fechasOutputData.setzFechaInst(dataTableFechas.getString("ZFECHA_INST"));
						arrFechas.add(fechasOutputData);						
					}
					osVALDEPOutputData.setArrFechas(arrFechas);
					arrOsValDep.add(osVALDEPOutputData);
				}
				datRet.setArrOsValDep(arrOsValDep);
				returnList.add(datRet);
			}

			// obtengo los datos directos de cada 
			return (returnList);

		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
