package org.minbox.key.plugin.security.minboxpluginsecurity.dataResources;

public class AuthException extends RuntimeException{

	/**
	 * 权限异常
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
	@Override
	public String toString() {
		return "权限不足";
	}

}
