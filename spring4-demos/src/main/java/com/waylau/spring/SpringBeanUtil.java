/**
 * 
 */
package com.waylau.spring;

import org.springframework.context.ApplicationContext;

/**
 * 说明：Spring 获取 Bean 方法
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年4月11日 
 */
public class SpringBeanUtil {
 
	private static ApplicationContext context;     
	
    public static Object getBean(String beanName){  
    	return context.getBean(beanName);          
    }
    
	public static void setContext(ApplicationContext ctx) {
		context = ctx;
	}
}
