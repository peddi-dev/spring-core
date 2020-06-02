package org.peddi.spring.core.beans.factory.config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorDemo {
	
	public void beanPostProcessorDemo() {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/peddi/spring/core/beans/factory/config/beans.xml");
		
		
		ctx.close();
		
	}
	
	public static void main(String[] args) {
		BeanPostProcessorDemo app = new BeanPostProcessorDemo();
		app.beanPostProcessorDemo();
	}

}
