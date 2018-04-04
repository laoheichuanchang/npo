package com.wy.npo.realm;

/**
 * 令牌类
 * 用户、密码、验证码
 * @author wangy
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = -5345161804550426416L;
    
	private String captcha;
	
	public UsernamePasswordToken() {
        super();
    }
	
	public UsernamePasswordToken(final String username, final char[] password,String captcha) {
		this(username, password, false, null, captcha);
	}
	
	public UsernamePasswordToken(final String username, final String password,String captcha) {
        this(username, password != null ? password.toCharArray() : null, false, null,captcha);
    }
	
	
	public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
		super(username,password,rememberMe,host);
		this.captcha = captcha;
	}
	
    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
    
}
