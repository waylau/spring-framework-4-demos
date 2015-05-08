/**
 * 
 */
package com.waylau.spring.demo.beanScope;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @author <a href="http://www.waylau.com">waylau.com</a>  2015年5月5日
 */
@Component
@Scope("prototype")
public class DadTask implements Runnable {
	static Logger logger = Logger.getLogger(DadTask.class);
	
	@Autowired
	DadDao dadDao;
	
	private String name;
	/**
	 * 
	 */
	public DadTask setDadTask(String name) {
		this.name = name;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		logger.info("DadTask:"+this + ";DadDao:"+dadDao + ";"+dadDao.sayHello(name) );
	}

}
