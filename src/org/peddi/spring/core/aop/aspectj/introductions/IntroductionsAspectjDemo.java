package org.peddi.spring.core.aop.aspectj.introductions;

import org.peddi.spring.core.aop.aspectj.helper.UsageTracked;
import org.peddi.spring.core.aop.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static java.lang.System.out;

public class IntroductionsAspectjDemo {
	
	public void introductionsAspectjDemo() {
		
		System.out.println("IntroductionsAspectjDemo.introductionsAspectjDemo()");
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(IntroductionsAspectjConfig.class);
		
		PersonService perSvc =  context.getBean(PersonService.class);
		int count = perSvc.personsCount();
		System.out.println(count);
		//UsageTrackingAspect uta = context.getBean(UsageTrackingAspect.class);
		out.println(perSvc instanceof UsageTracked);
		
		context.close();	
		
	}
	
	public static void main(String[] args) {
		IntroductionsAspectjDemo app = new IntroductionsAspectjDemo();
		app.introductionsAspectjDemo();
	}

}
