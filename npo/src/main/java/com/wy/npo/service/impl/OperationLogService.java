package com.wy.npo.service.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.npo.constants.enums.OperationTypeEnum;
import com.wy.npo.dao.SysOperationLogMapper;
import com.wy.npo.entity.BaseEntityVO;
import com.wy.npo.entity.SysOperationLog;
import com.wy.npo.entity.SysUser;
import com.wy.npo.utils.annotation.FieldComment;
import com.wy.npo.utils.annotation.OperationLog;
import com.wy.npo.vo.OperationLogVO;

/**
 * 操作日志记录业务类
 * @author wangy
 */
@Aspect
@Service
@Transactional
public class OperationLogService {

	final static Logger logger = LoggerFactory.getLogger(OperationLogService.class);
	
	@Autowired
	private SysOperationLogMapper sysOperationLogMapper;
	
	
	//@Pointcut(value = "@annotation(com.wy.npo.utils.annotation.OperationLog)")
    //@Pointcut("@annotation(com.wy.npo.utils.annotation.OperationLog)")   
    //@Pointcut("execution(* com.wy.npo.web.LoginController.*(..))")
	@Pointcut("@annotation(com.wy.npo.utils.annotation.OperationLog)")   
	public void controllerLog(){
	}
	
	/**
	 * 拦截操作前日志
	 */
	@Before("controllerLog()")  
	public void before(JoinPoint joinPoint){  
		logger.info("获取用户操作，操作内容");
		try {
			OperationLogVO operationLogVO = getMethodOperationContent(joinPoint);
			logger.info("获取用户操作，操作内容：{}",operationLogVO);
			SysOperationLog operationLog = new SysOperationLog();
			operationLog.setOperationName(operationLogVO.getOperationName());
			operationLog.setOperationType(String.valueOf(operationLogVO.getOperationType()));
			
		    SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
			operationLog.setOperator(user.getId());
			operationLog.setOperationTime(new Date());
			
			Object[] objects = joinPoint.getArgs();    
			for(Object object:objects){
				if(object instanceof BaseEntityVO){
					/**
					 * 脑洞大开，考虑将请求参数拼装成固定的格式记录日志，方便非技术人员阅读操作日志
					 */
					operationLog.setRequestParams(toChString(object));
					//operationLog.setRequestParams(object.toString());
				}else if(operationLogVO.getOperationType().intValue() 
						== OperationTypeEnum.OPERATION_DELETE.getCode().intValue() 
								||operationLogVO.getOperationType().intValue() 
								== OperationTypeEnum.OPERATION_RESET_PWD.getCode().intValue()){
					//这里要求所有的删除请求方法都会出传入ID编号
					if(object instanceof Integer){
						operationLog.setRequestParams("请求参数ID编号为【"+object+"】的记录");
					}
				}else if(operationLogVO.getOperationType().intValue() 
						== OperationTypeEnum.OPERATION_UPDATE_PWD.getCode().intValue()){
					//传入多个参数的的情况，暂时先判断请求是否为修改密码，如果为修改密码，则不需要记录请求参数
					operationLog.setRequestParams("用户："+user.getAccount()+"修改密码");
				}else{
					
				}
			}
			sysOperationLogMapper.insertSelective(operationLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toChString(Object obj) throws IntrospectionException, IllegalAccessException, 
	                       IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields(); 
		String r = "请求参数：【"; 
		for (Field field : fields) {
			 FieldComment t = (FieldComment) field.getAnnotation(FieldComment.class);
			 //用这个类获取字段的值，对象不能序列化，因为这个类会去找相关字段的get\set方法,所以这里过滤一下序列化生产的字段
			 if(!"serialVersionUID".equals(field.getName())){
				 PropertyDescriptor pd = new PropertyDescriptor(field.getName(),  
		                    clazz); 
				 Method getMethod = pd.getReadMethod();//获得get方法  
		         Object o = getMethod.invoke(obj);//执行get方法返回一个Object
				 if(null != t && null != o){
				    r += t.value() + ":"+ o + ",";
				 }
			 }
		}
		return r.substring(0, r.length()-1) + "】";
	}
	
	
	 /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public OperationLogVO getMethodOperationContent(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        Integer operationType = null;
        String operationName = "";
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                	 operationType = method.getAnnotation(OperationLog.class).operationType().getCode();
                	 operationName = method.getAnnotation(OperationLog.class).operationName();
                	 
                     break;    
                }    
            }    
        }
        OperationLogVO operationLogVo = new OperationLogVO();
        operationLogVo.setOperationType(operationType);
        operationLogVo.setOperationName(operationName);
        return operationLogVo;    
    }
}
