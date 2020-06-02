package org.peddi.spring.core.aop.springaop.advice.before;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.peddi.spring.core.aop.springaop.advisor.AdvisorUtil;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;

public class SpringAOPMethodBeforeAdviceDemo {
	
	public void springAOPMethodBeforeAdviceDemo() {
		out.println("======>springAOPMethodBeforeAdviceDemo()");
		
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		// Method Before Advice
		// proxyFactory.addAdvice(new SpringAOPMethodBeforeAdvice());
		proxyFactory.addAdvisor(AdvisorUtil.getRegexpMethodPointcutAdvisor());
		
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
		SpringAOPMethodBeforeAdviceDemo app = new SpringAOPMethodBeforeAdviceDemo();
		app.springAOPMethodBeforeAdviceDemo();
	}

}
