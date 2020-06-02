package org.peddi.spring.core.aop.springaop.proxyfactory;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;

public class ProxyingPersonServiceInterfaceWithProxyFactoryDemo {
	

	
	/**
	 * programmatically creating AOP Proxy
	 * 
	 */
	
	public void proxyingPersonServiceInterfaceWithProxyFactoryDemo() {
		
		
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		// getting AOP Proxy to personSvcTarget object
		PersonService personSvcProxy = (PersonService) proxyFactory.getProxy();
		
		//out.println(personSvcProxy);
		try {
			personSvcProxy.initPersons();
			out.println(personSvcProxy.getPerson("Raj", 30));
			out.println(personSvcProxy.getPerson(1));
			out.println(personSvcProxy.personsCount());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.printf("%npersonSvcProxy instanceof org.springframework.aop.framework.Advised: %b%n", personSvcProxy instanceof org.springframework.aop.framework.Advised);
		
	}
	

	
	public static void main(String[] args) {
		ProxyingPersonServiceInterfaceWithProxyFactoryDemo app = new ProxyingPersonServiceInterfaceWithProxyFactoryDemo();
		app.proxyingPersonServiceInterfaceWithProxyFactoryDemo();
	}

}
