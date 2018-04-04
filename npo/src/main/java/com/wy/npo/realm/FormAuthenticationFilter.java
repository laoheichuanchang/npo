package com.wy.npo.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import com.wy.npo.utils.Utils;

/**
 * 表单验证（包含验证码）过滤类
 * 增加验证码提交效验
 * @author wangy
 *
 */
@Service("formAuthenticationFilter")
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {
   
	 public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
	 
	 //登录页面用account替换
	 public static final String DEFAULT_ACCOUNT_PARAM = "account";
	 
	 private String usernameParam = DEFAULT_ACCOUNT_PARAM;
	 
	 private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	 
	 public String getCaptchaParam() {
	        return captchaParam;
	 }
	 
	 protected String getCaptcha(ServletRequest request) {
	        return WebUtils.getCleanParam(request, getCaptchaParam());
	 }
	 
	 public String getUsernameParam() {
		  return usernameParam;
	 }
	 
	 protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		  
	        String username = getUsername(request);
	        String password = getPassword(request);
	        
	        if (password == null) {
	            password = "";
	        }
	        boolean rememberMe = isRememberMe(request);
	        String host = getHost(request);
	        String captcha = getCaptcha(request);
	        //因为userNamePasswordToken的构造方法没有captcha，所以也需要重写一个
	        return new UsernamePasswordToken(username, Utils.getEncodePwd(password).toCharArray(), rememberMe, host, captcha);
	    }
}
