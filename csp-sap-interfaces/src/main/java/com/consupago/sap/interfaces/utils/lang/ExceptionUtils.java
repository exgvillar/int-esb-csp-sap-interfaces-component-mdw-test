/**
 * 
 */
package com.consupago.sap.interfaces.utils.lang;


/**
 * @author ramon.becerra
 * 
 */
public class ExceptionUtils {

	/**
	 * Defines the String used to define the classpath property in Java System
	 * class
	 */
	private static final String JAVA_CLASS_PATH = "java.class.path";
	
	/** Defines the String used to define the library path in Java System class */
	private static final String JAVA_LIBRARY_PATH = "java.library.path";

	/** Provides the appropriate indent of the stack trace elements */
	private static final String INDENT = "    @";

	/**
	 * 
	 */
	public ExceptionUtils() {
	}

	public static String getCallingClassOfClass(String name) {
		if (name == null) {
			name = ExceptionUtils.class.getName();
		}
		String className = "Unknown";
		Exception e = new Exception();
		StackTraceElement[] stacktrace = e.getStackTrace();
		if (stacktrace != null && stacktrace.length > 1) {
			int i = 0;
			boolean nextOne = false;
			while (i < stacktrace.length) {
				StackTraceElement element = stacktrace[i];
				if (nextOne && !element.getClassName().equals(name)) {
					className = element.getClassName();
				} else if (!nextOne && element.getClassName().equals(name)) {
					nextOne = true;
				}
				++i;
			}
		}
		return className;
	}

	/**
	 * 
	 * @param thrown
	 * @param maxDepth
	 * @return
	 */
	public static String renderStackTrace(Throwable thrown, int maxDepth) {
		if (thrown == null)
			return null;
		StringBuffer buffer = new StringBuffer(200);
		while (thrown != null) {
			buffer.append(thrown.toString()).append("\n");
			StackTraceElement[] elements = thrown.getStackTrace();
			String prevClass = null;
			String prevMethod = null;
			int depth = Math.min(elements.length, maxDepth);
			for (int i = 0; i < depth; ++i) {
				StackTraceElement element = elements[i];
				String className = element.getClassName();
				String methodName = element.getMethodName();
				int lineNumber = element.getLineNumber();
				if (!className.equals(prevClass)
						&& !methodName.equals(prevMethod)) {
					buffer.append("").append(className);
					buffer.append("#").append(methodName);
					buffer.append("()").append("@").append( lineNumber ).append(" \r\n");
					prevClass = className;
					prevMethod = methodName;
				}
			}
			thrown = thrown.getCause();
		}
		return buffer.toString();
	}
	
	public static String getClasspath() {
		return System.getProperty(JAVA_CLASS_PATH);
	} // end method getClasspath

	/**
	 * Returns the library path specified to the Java VM as a
	 * <code>String</code>, simply calling the <code>System.getProperty()</code>
	 * method with the appropriate constant.
	 */
	public static String getLibraryPath() {
		return System.getProperty(JAVA_LIBRARY_PATH);
	} // end method getLibraryPath
 
}
