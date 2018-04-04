package com.wy.npo.realm.exception;

import org.apache.shiro.ShiroException;

public class CaptchaException extends ShiroException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2715310502801238965L;

	
    public CaptchaException() {
        super();
    }
    
    
    public CaptchaException(String message) {
        super(message);
    }
}
