package com.waylau.spring.demo.beanScope;

import org.springframework.stereotype.Repository;

/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">waylau.com</a>  2015年5月5日
 */
@Repository
public class UserDao {

	/**
	 * 
	 */
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public String sayHello(){
		return "Hi girl!";
	}

}
