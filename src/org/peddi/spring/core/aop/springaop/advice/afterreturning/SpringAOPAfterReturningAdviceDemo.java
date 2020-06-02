package org.peddi.spring.core.aop.springaop.advice.afterreturning;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;

public class SpringAOPAfterReturningAdviceDemo {
	
public void springAOPAfterReturningAdviceDemo() {
		out.println("======>springAOPAfterReturningAdviceDemo()");
		
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		// After Returning Advice
		proxyFactory.addAdvice(new SpringAOPAfterReturningAdvice());

		
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
		SpringAOPAfterReturningAdviceDemo app = new SpringAOPAfterReturningAdviceDemo();
		app.springAOPAfterReturningAdviceDemo();
	}

}
