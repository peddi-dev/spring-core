package org.peddi.spring.core.aop.aspectj.advice.after;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.util.SpringConfigBootstrapper;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.System.out;

public class AfterAdviceDemo {
	
	public void afterAdviseDemo() {
		
		out.println("=====>AfterAdviseDemo.afterAdviseDemo()");
		
		ConfigurableApplicationContext context = SpringConfigBootstrapper.getAnnotationConfigApplicationContext(AfterAdviceAppConfig.class);
		PersonService perSvc = context.getBean(PersonService.class);
		
		out.printf("%nCount: %s%n", perSvc.personsCount());
		
		try {
			perSvc.getPerson(-1);
		} catch (Throwable e) {
			out.printf("%nExcepiton : %s%n", e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		AfterAdviceDemo app = new AfterAdviceDemo();
		app.afterAdviseDemo();
	}

}
