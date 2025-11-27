package com.consupago.sap.interfaces.proxy;

import java.util.ArrayList;

import com.sap.conn.jco.JCoDestination;

public interface IStandardSAPProxy {

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception;
}
