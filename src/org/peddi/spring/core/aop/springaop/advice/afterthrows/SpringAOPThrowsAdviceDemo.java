package org.peddi.spring.core.aop.springaop.advice.afterthrows;

import static java.lang.System.out;

import java.util.Optional;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;

public class SpringAOPThrowsAdviceDemo {
	
public void springAOPThrowsAdviceDemo() {
		
		
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		// ThrowsAdvice
		proxyFactory.addAdvice(new SpringAOPThrowsAdvice());
		
		// getting AOP Proxy to personSvcTarget object
		PersonService personSvcProxy = (PersonService) proxyFactory.getProxy();
		
		try {
			Optional<Person> person = personSvcProxy.getPerson(-1);
			out.printf("%n%s%n",person);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		SpringAOPThrowsAdviceDemo app = new SpringAOPThrowsAdviceDemo();
		app.springAOPThrowsAdviceDemo();;
	}

}
