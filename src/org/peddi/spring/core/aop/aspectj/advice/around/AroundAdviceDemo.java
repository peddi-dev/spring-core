package org.peddi.spring.core.aop.aspectj.advice.around;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.System.out;


public class AroundAdviceDemo {
	
	public void aspectJAOPDemo() {
		
	out.println("=====>SpringAOPAspectJBasedDemo.aspectJAOPDemo()");
		
	ConfigurableApplicationContext context = new	AnnotationConfigApplicationContext(AroundAdviceAppConfig.class);
	PersonService perSvc = context.getBean(PersonService.class);
	Person person = perSvc.getPerson("David", 25);
	out.printf("%nPerson Object from PersonService bean:  %s%n", person);
	//out.println(Arrays.toString(context.getBeanDefinitionNames()));
	context.close();
		
	}
	
	public static void main(String[] args) {
		AroundAdviceDemo app = new AroundAdviceDemo();
		app.aspectJAOPDemo();
	}

}
