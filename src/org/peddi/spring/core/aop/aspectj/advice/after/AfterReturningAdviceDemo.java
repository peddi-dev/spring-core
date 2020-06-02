package org.peddi.spring.core.aop.aspectj.advice.after;


import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.util.SpringConfigBootstrapper;
import org.springframework.context.ConfigurableApplicationContext;
public class AfterReturningAdviceDemo {
	
	public  void afterReturningAdviseDemo() {
		
		out.println("====>AfterReturningAdviseDemo.afterReturningAdviseDemo()");
		ConfigurableApplicationContext context = SpringConfigBootstrapper.getAnnotationConfigApplicationContext(AfterReturningAdviceAppConfig.class);
		
		
		PersonService personService = context.getBean( PersonService.class);
		
		
		out.printf("%n%s%n",personService.getPerson("David", 30));
		out.printf("%nCount:%d%n",personService.personsCount());
		
		context.close();
	}
	
	public static void main(String[] args) {
		AfterReturningAdviceDemo app = new AfterReturningAdviceDemo();
		app.afterReturningAdviseDemo();
		
	}

}
