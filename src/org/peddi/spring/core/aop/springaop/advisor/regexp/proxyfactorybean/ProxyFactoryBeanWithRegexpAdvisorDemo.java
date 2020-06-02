package org.peddi.spring.core.aop.springaop.advisor.regexp.proxyfactorybean;

import static java.lang.System.out;

import org.peddi.spring.core.aop.service.PersonService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanWithRegexpAdvisorDemo {
	
public void proxyFactoryBeanWithRegexpAdvisorDemo() {
		
		out.println("====>proxyFactoryBeanWithRegexpAdvisorDemo()");
		
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("org/peddi/spring/core/aop/springaop/advisor/regexp/proxyfactorybean/spring-aop-regexp-advisor-config.xml");
		
		PersonService personSvcProxy = context.getBean("personSvcProxyBean", PersonService.class);
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
		ProxyFactoryBeanWithRegexpAdvisorDemo app = new ProxyFactoryBeanWithRegexpAdvisorDemo();
		app.proxyFactoryBeanWithRegexpAdvisorDemo();
	}

}
