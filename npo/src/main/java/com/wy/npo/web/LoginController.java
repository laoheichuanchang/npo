package com.wy.npo.web;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.util.StringUtils;
import com.wy.npo.entity.SysUser;
import com.wy.npo.realm.ShiroDbRealm;
import com.wy.npo.realm.UsernamePasswordToken;
import com.wy.npo.realm.exception.CaptchaException;
import com.wy.npo.service.IUserLoginLogService;
import com.wy.npo.service.IUserService;
import com.wy.npo.utils.Utils;
import com.wy.npo.utils.ValidateCodeUtils;
import com.wy.npo.utils.annotation.OperationLog;




/**
 * 登录
 * @author wangy
 */
@Controller
public class LoginController {
   
	 final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	 @Autowired
	 private IUserLoginLogService userLoginLogService;
	 
	 /** 页面登录验证码  */
	 public final static String VERIFY_CODE = "VERIFY_CODE";
	 
	 
	 /**
	  * 获取验证码
	  * @param request
	  * @param response
	  * @throws IOException
	  */
	 @RequestMapping(value = "/validateCode")
	 public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		    //设置页面不缓存
		    response.setHeader("Pragma", "no-cache");    
	        response.setHeader("Cache-Control", "no-cache");    
	        response.setDateHeader("Expires", 0); 
	        //获取验证码
	        String verifyCode = ValidateCodeUtils.generateTextCode(null);
	        request.getSession().setAttribute(VERIFY_CODE, verifyCode);
	        logger.info("本次生成的验证码：{}，已存放到httpSession中",verifyCode);
	        response.setContentType("image/jpeg");
	        BufferedImage bim = ValidateCodeUtils.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
	        ImageIO.write(bim, "JPEG", response.getOutputStream());
	 }
	 
	 /**
	  * login页面
	  * @return
	  */
	 @RequestMapping(value = {"","/","/index","/login"}, method = RequestMethod.GET)
	 public String toLogin(Model model) {
		    //用户已经登录的情况下，直接跳到欢迎页
		    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		    if(null != user){
		    	model.addAttribute("user", user);
		    	return "/index";
		    }
	        return "/login";
	 }
	 
	 /**
	  * 用户登录
	  * @param user
	  * @param model
	  * @param session
	  * @param request
	  * @return
	  */
	 @RequestMapping(value = "/login",method = RequestMethod.POST)
	 public String login(SysUser user,Model model,HttpSession session, HttpServletRequest request){
		    String captcha = WebUtils.getCleanParam(request, "validateCode");
	        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
	        	return loginFailRedirect(model,"登录失败：请输入登录信息");
	        }
	        try {
	        	UsernamePasswordToken usernamePasswordToken = new 
	 	                UsernamePasswordToken(user.getAccount(),Utils.getEncodePwd(user.getPassword()),captcha);
	        	usernamePasswordToken.setRememberMe(user.isRememberMe());
	 	        Subject subject = SecurityUtils.getSubject();
	 	        //if (!subject.isAuthenticated()){
	              subject.login(usernamePasswordToken);
	 	        //}
	            logger.info("用户：{},登录成功",user.getAccount());
	            user = (SysUser) SecurityUtils.getSubject().getPrincipal();
	            //记录登录日志
				String loginIp = Utils.getIpAddr(request);
				logger.info("用户登录成功，获取到的用户IP地址：" + loginIp);
				userLoginLogService.insert(user.getId(), loginIp);
				model.addAttribute("user", user);
	        }catch(UnknownAccountException ex){
	        	logger.error("======登陆异常："+ex.getMessage()+"=======");
	        	return loginFailRedirect(model,"登录失败：账号不存在");
	        }catch (IncorrectCredentialsException ex){
	        	logger.error("======登陆异常："+ex.getMessage()+"=======");
	        	return loginFailRedirect(model,"登录失败：密码错误");
	        }catch (ShiroException ex){
	        	logger.error("======登陆异常："+ex.getMessage()+"=======");
	        	if(ex instanceof CaptchaException){
	        		return loginFailRedirect(model,ex.getMessage());
	        	}
	        	return loginFailRedirect(model,"登录失败：验证码错误");
	        }catch (Exception ex) {
	            logger.error("======登陆异常："+ex.getMessage()+"=======");
	            return loginFailRedirect(model,"登录失败："+ex.getMessage());
	        }
	        return "/index";
	 }
	 
	 /**
	  * 登录失败，返回登录页面
	  * @param errorCode
	  * @param message
	  * @return
	  */
	 private String loginFailRedirect(Model model,String message) {
		    model.addAttribute("msg", message);
	        return "/login";
	 }
	 
	 
	 /**
	  * 登录退出，调回登录页面
	  * @return
	  */
	 @RequestMapping(value = "logout",method = RequestMethod.GET)
	 public String logout(){
		   Subject currentUser = SecurityUtils.getSubject(); 
	       currentUser.logout(); 
	       return "/login";
	 }
}
