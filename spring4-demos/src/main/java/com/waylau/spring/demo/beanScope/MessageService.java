package com.waylau.spring.demo.beanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年4月13日 
 */
@Scope("prototype")
@Component
public class MessageService {
	
	public int count = 0;
	/**
	 * 
	 */
	public MessageService() {
		// TODO Auto-generated constructor stub
	}
	
	public String sayHi() {
		count ++;
		return this+ "Hi, girl!" + count;
	}

}
