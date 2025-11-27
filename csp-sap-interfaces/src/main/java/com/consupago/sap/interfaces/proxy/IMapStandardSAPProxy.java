package com.consupago.sap.interfaces.proxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sap.conn.jco.JCoDestination;

public interface IMapStandardSAPProxy {

	public Map<String,Collection> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception;
}
