/**
 * 
 */
package com.consupago.sap.interfaces.format;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author Juan Ramon
 *
 */
public final class SAPFormatter {

	 /**
     * Log4J instance class, write the events of this class in the specified log file
     */
    private static Log log = LogFactory.getLog( SAPFormatter.class );
  
	
    /**
     * Input format = dd.MM.yyyy
     * Output format = DDMMAAAA
     * @param date
     * @return
     */
    public static synchronized java.util.Date formatSAPDate( String date ) throws Exception {
    	java.util.Date td = null;
		if( date == null ) {
			td = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			td = format.parse( date );
		}
		return( td );
	}

    /**
     * 
     * @param date
     * @return
     * @throws Exception
     */
    public static synchronized java.util.Date convertUtilDate2SqlDate( Date date ) throws Exception {
    	java.util.Date td = null;
		if( date == null ) {
			td = null;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			td = format.parse( date.toString() );
		}
		return( td );
	}
    
    public static synchronized java.sql.Date convertToSqlDate( java.util.Date date ) throws Exception {
    	java.sql.Date td = null;
		if( date == null ) {
			td = null;
		} else {
			td = new java.sql.Date( date.getTime() );
		}
		return( td );
	}
    
    /**
     * @param base64Content
     * @return
     */
    public static byte[] convertFileBinario(String base64Content) throws IOException {
		byte[] decodedBytes = null;
		
		if(StringUtils.trimToNull(base64Content) != null) {
			decodedBytes = java.util.Base64.getDecoder().decode( base64Content );
		}
		
		return decodedBytes;		
	}
}
