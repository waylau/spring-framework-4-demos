package com.waylau.spring.demo.beanScope;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.waylau.spring.AppConfig;
import com.waylau.spring.SpringBeanUtil;

/**
 * 说明：Singleton beans with prototype-bean dependencies 
 * 处理 Singleton bean 依赖 prototype bean
 *
 * @author <a href="http://www.waylau.com">waylau.com</a>  2015年5月5日
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringBeanUtil.setContext(ctx);
        
        UserService userService = ctx.getBean(UserService.class);
 
        userService.runPrototype();
       // userService.startTask();
        
    }
}
