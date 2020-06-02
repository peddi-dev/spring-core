package org.peddi.spring.core.ctx.annotation;

import org.peddi.spring.core.ctx.annotation.service.MyService;
import org.peddi.spring.core.ctx.annotation.service.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Configuration
public class AnnotationAppConfigDemo {
	
	
	
	
	@Bean
	public MyService getMyService() {
		
		return new MyServiceImpl(); 
	}







	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationAppConfigDemo.class);
		MyService myServiceBean = ctx.getBean(MyService.class);
		System.out.println(myServiceBean.doStuff());
	}

}
