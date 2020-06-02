package org.peddi.spring.core.ctx.annotation;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.peddi.spring.core.ctx.annotation.service.MyService;
import org.peddi.spring.core.ctx.annotation.service.provider.MyServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.System.out;

@Configuration
public class AnnotationConfigApp {

	@Bean 
	public MyService myService() {
		return new MyServiceImpl();
	}
	
	public static void main(String[] args) {
		//Create and configure beans
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfigApp.class);
	
	//	ctx.register(AppConfig.class);
	//	ctx.refresh();
		
		// retrieve configured bean instance
		MyService myService = (MyService) ctx.getBean(MyService.class);
		
		// use configured bean instance
		System.out.println("myService Bean: " + myService);
		out.printf("myService Bean doStuff(): %s", myService.doStuff());
		ctx.close();
		
	}
}
