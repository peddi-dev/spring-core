package org.peddi.spring.core.aop.aspectj.advice.after;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.util.SpringConfigBootstrapper;
import org.springframework.context.ConfigurableApplicationContext;

public class AfterThrowingAdviceDemo {
	
	public  void afterThrowingAdviseDemo() {
		
		out.println("====>AfterThrowingAdviseDemo.afterThrowingAdviseDemo()");
		ConfigurableApplicationContext context = SpringConfigBootstrapper.getAnnotationConfigApplicationContext(AfterThrowingAdviceAppConfig.class);
		
		
		PersonService personService = context.getBean( PersonService.class);
		
		
		try {
			out.printf("%n%s%n",personService.getPerson(-1));
		} catch (Throwable e) {
			out.printf("%nExcepiton : %s%n", e.getMessage());
			//e.printStackTrace();
		}
		
		
		context.close();
	}
	
	public static void main(String[] args) {
		AfterThrowingAdviceDemo app = new AfterThrowingAdviceDemo();
		app.afterThrowingAdviseDemo();
	}

}
