package org.peddi.spring.core.aop.springaop.proxyfactorybean;

import org.peddi.spring.core.aop.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

public class ProxyingPersonServiceInterfaceWithProxyFactoryBeanDemo {
	
	public void proxyingPersonServiceInterfaceDemo() {
		
		out.println("====>proxyingPersonServiceInterfaceDemo()");
		
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("org/peddi/spring/core/aop/springaop/proxyfactorybean/spring-aop-peroson-config.xml");
		
		PersonService personSvcProxy = context.getBean("personSvcProxy", PersonService.class);
		out.println(personSvcProxy);
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
		context.close();
		
	}
	
	public static void main(String[] args) {
		ProxyingPersonServiceInterfaceWithProxyFactoryBeanDemo app = new ProxyingPersonServiceInterfaceWithProxyFactoryBeanDemo();
		app.proxyingPersonServiceInterfaceDemo();
	}

}
