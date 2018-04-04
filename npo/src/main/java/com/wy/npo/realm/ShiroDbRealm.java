package com.wy.npo.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.wy.npo.entity.SysUser;
import com.wy.npo.realm.exception.CaptchaException;
import com.wy.npo.service.ISysPermissionsService;
import com.wy.npo.service.IUserService;

/**
 * shiro Realm
 * @author wangy
 *
 */
public class ShiroDbRealm extends AuthorizingRealm {
	
	final static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISysPermissionsService sysPermissionsService;
	
	
	/** 页面登录验证码  */
	public final static String VERIFY_CODE = "VERIFY_CODE";
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		logger.info("获取用户的访问权限信息");
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
		info.setStringPermissions(sysPermissionsService.queryPermissionsByAccount(user.getAccount()));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Session session = SecurityUtils.getSubject().getSession();
		String code = (String) session.getAttribute(VERIFY_CODE);
		if(StringUtils.isEmpty(code)){
	          throw new CaptchaException("登录失败： 验证码已过期");
	    }
	        
	    if (StringUtils.isEmpty(token.getCaptcha()) || !StringUtils.equals(code.toLowerCase(),token.getCaptcha().toLowerCase())) {
	    	  throw new CaptchaException("登录失败： 验证码错误");
	    }
		// 把token转换成User对象  
        SysUser userLogin = tokenToUser(token);
        // 验证用户是否可以登录 
        SysUser user = userService.doLogin(userLogin);
        if(user == null)  
        	 return null;
  
        //当前 Realm 的 name  
        String realmName = this.getName();  
        
		//登陆的主要信息
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword(), realmName);
	    return authcInfo;
	}
	
	private SysUser tokenToUser(UsernamePasswordToken authcToken) {  
		SysUser user = new SysUser();  
        user.setAccount(authcToken.getUsername());  
        user.setPassword(String.valueOf(authcToken.getPassword()));  
        return user;  
    }  

	/**
	 * 清楚权限缓存信息(修改权限后，不需要退出登录，权限即可生效)
	 * @author wangy
	 */
	public void clearCachedAuthorization(){
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}
}
