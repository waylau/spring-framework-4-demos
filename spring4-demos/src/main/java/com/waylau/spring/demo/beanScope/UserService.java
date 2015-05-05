package com.waylau.spring.demo.beanScope;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.waylau.spring.SpringBeanUtil;



/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">waylau.com</a>  2015年5月5日
 */
@Service
public class UserService implements ApplicationContextAware {

	@Autowired
	private UserDao userDao;
	@Autowired
	private DadDao dadDao;
	@Autowired
	private DadTask dadTask;
	
	private ApplicationContext applicationContext;
	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public String sayHello() {
		return userDao.sayHello();
	}
	
	public String sayToDad(String name) {
		return dadDao.sayHello(name);
	}
	
	public void startTask() {
        ScheduledThreadPoolExecutor  scheduledThreadPoolExecutor  = new ScheduledThreadPoolExecutor(2);
        
        dadTask = applicationContext.getBean("dadTask", DadTask.class);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(dadTask.setDadTask("Lily"), 1000, 2000, TimeUnit.MILLISECONDS);
        dadTask = applicationContext.getBean("dadTask", DadTask.class);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(dadTask.setDadTask("Lucy"), 1000, 2000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void setApplicationContext (ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
		
	}
}
