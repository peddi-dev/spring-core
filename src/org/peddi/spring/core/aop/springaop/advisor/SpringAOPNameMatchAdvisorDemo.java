package org.peddi.spring.core.aop.springaop.advisor;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.peddi.spring.core.aop.springaop.advice.before.SpringAOPMethodBeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class SpringAOPNameMatchAdvisorDemo {


	
	public void springAOPNameMatchAdvisorDemo() {
		out.println("======>springAOPNameMatchAdvisorDemo()");
		
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		
		
		// add advisor with Before Advice and Name Match Pointcut
		MethodBeforeAdvice advice = new SpringAOPMethodBeforeAdvice();
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(advice);
		advisor.setMappedName("getPerson");
		proxyFactory.addAdvisor(advisor);
		
		// getting AOP Proxy to personSvcTarget object
		PersonService personSvcProxy = (PersonService) proxyFactory.getProxy();
		
		//out.println(personSvcProxy);
		try {
			Person person = personSvcProxy.getPerson("Raj", 30);
			out.printf("%n%s%n",person);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		SpringAOPNameMatchAdvisorDemo app = new SpringAOPNameMatchAdvisorDemo();
		app.springAOPNameMatchAdvisorDemo();
	}
}
