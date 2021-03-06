package com.wy.npo.utils;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
    
	/**  
     * @Description: 获取客户端IP地址    
     */    
    public static String getIpAddr(HttpServletRequest request) {     
           String ip = request.getHeader("x-forwarded-for");     
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
               ip = request.getHeader("Proxy-Client-IP");     
           }     
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
               ip = request.getHeader("WL-Proxy-Client-IP");     
           }     
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {     
               ip = request.getRemoteAddr();     
               if(ip.equals("127.0.0.1")){       
                   //根据网卡取本机配置的IP       
                   InetAddress inet=null;       
                   try {       
                       inet = InetAddress.getLocalHost();       
                   } catch (Exception e) {       
                       e.printStackTrace();       
                   }       
                   ip= inet.getHostAddress();       
               }    
           }     
           // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割    
           if(ip != null && ip.length() > 15){      
               if(ip.indexOf(",")>0){       
                   ip = ip.substring(0,ip.indexOf(","));       
               }       
           }       
           return ip;     
    }    
	
    /**
     * 密码转换
     * 
     * @param password
     * @return
     */
    public static String getEncodePwd(String password) {
        String p = DigestUtils.shaHex(password);
        return DigestUtils.md5Hex(p.substring(0, 10) + p.substring(15, 20) + p.substring(25, 30) + p.substring(20, 30));
    }
}
