package org.peddi.spring.core.aop.aspectj.advice.before;

import org.peddi.spring.core.aop.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.System.out;
public class BeforeAdviceDemo {
	
	public void beforeAdviseDemo() {
		
		out.println("====>BeforeAdviseDemo.beforeAdviseDemo()");
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeforeAdviceAppConfig.class);
		PersonService personService = context.getBean( PersonService.class);
		
		
		out.println(personService.getPerson("David", 30));
		out.println(personService.personsCount());
		
		context.close();
		
	}

	public static void main(String[] args) {
		
		BeforeAdviceDemo app = new BeforeAdviceDemo();
		app.beforeAdviseDemo();
		
	}

}
