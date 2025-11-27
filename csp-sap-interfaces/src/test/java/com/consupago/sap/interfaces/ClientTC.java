/**
 * 
 */
package com.consupago.sap.interfaces;

import junit.framework.TestCase;

/**
 * @author ramon.becerra
 *
 */
public class ClientTC extends TestCase {

	/**
	 * 
	 */
	public ClientTC() {
	}

	/**
	 * @param name
	 */
	public ClientTC(String name) {
		super(name);
	}
	
	public void testConnect2( ) throws Exception {
		StepByStepClient client = new StepByStepClient();
		StepByStepClient.step2ConnectUsingPool();
	}
	
	public void testConnect3( ) throws Exception {
		StepByStepClient client = new StepByStepClient();
		StepByStepClient.step3SimpleCall();
	}
}
