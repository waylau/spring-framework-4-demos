package com.waylau.spring.demo.beanScope;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">waylau.com</a>  2015年5月5日
 */
@Service
public class UserService implements ApplicationContextAware {
	
	static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private DadTask dadTask;
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private MessageService messageService;
 
	public void runSington() {
		for(int i= 0; i<100; i++){
			System.out.println(messageService.sayHi());
		}

	}
	public void runPrototype() {
		for(int i= 0; i<100; i++){
			messageService = applicationContext.getBean("messageService", MessageService.class);
			logger.info(messageService.sayHi());
		}

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
