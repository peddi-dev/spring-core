package org.peddi.spring.core.aop.springaop.advice.around;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;

public class SpringAOPInterceptionAroundAdviceDemo {
	
public void springAOPInterceptionAroundAdviceDemo() {
		
		out.println("======>springAOPInterceptionAroundAdviceDemo()");
	
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		// Interception Around Advice
		proxyFactory.addAdvice(new SpringAOPInterceptionAroundAdvice());

		
		// getting AOP Proxy to personSvcTarget object
		PersonService personSvcProxy = (PersonService) proxyFactory.getProxy();
		
		try {
			Person person = personSvcProxy.getPerson("Raj", 30);
			out.printf("%n%s%n",person);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		SpringAOPInterceptionAroundAdviceDemo app = new SpringAOPInterceptionAroundAdviceDemo();
		app.springAOPInterceptionAroundAdviceDemo();
	}


}
