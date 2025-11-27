package com.consupago.sap.interfaces.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TransactionLatency {

	private static Log log = LogFactory.getLog(TransactionLatency.class);

	private long startTime;
	private long finishTime;
	private String message = "";

	public TransactionLatency(String message) {
		this.message = message;
		start();
	}

	public void start() {
		this.startTime = System.currentTimeMillis();
		log.info("TRANSACTION START TIME - " + message + " - " + startTime);
	}

	public void finish() {
		finishTime = System.currentTimeMillis();
		log.info("TRANSACTION FINISH TIME - " + message + " - " + finishTime);
		long latency = finishTime - startTime;
		log.info("TRANSACTION FULL TIME - " + message + " - " + latency + " ms");
	}

}
