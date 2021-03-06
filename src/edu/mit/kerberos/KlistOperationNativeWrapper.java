package edu.mit.kerberos;

import android.os.Handler;

/**
 * Protected wrapper to enable the stateful interaction with the native library
 * 
 * Attempting to use message handlers directly in native code messes with the
 * Android thread dispatching mechanisms
 * 
 */
class KlistOperationNativeWrapper extends KerberosOperationNativeWrapper {

	public native int klist(String argv, int argc);

	public KlistOperationNativeWrapper(Handler messageHandler) {
		super(messageHandler);
	}

	@Override
	public int executeNativeOperation(String arguments, int argumentCount) {
		return klist(arguments, argumentCount);
	}
}