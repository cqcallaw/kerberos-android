package edu.mit.kerberos;

import android.os.Handler;

/**
 * Protected wrapper to enable the stateful interaction with the native library
 * 
 * Attempting to use message handlers directly in native code messes with the
 * Android thread dispatching mechanisms
 * 
 */
class KdestroyOperationNativeWrapper extends KerberosOperationNativeWrapper {

	public native int kdestroy(String argv, int argc);

	public KdestroyOperationNativeWrapper(Handler messageHandler) {
		super(messageHandler);
	}

	@Override
	public int executeNativeOperation(String arguments, int argumentCount) {
		return kdestroy(arguments, argumentCount);
	}
}