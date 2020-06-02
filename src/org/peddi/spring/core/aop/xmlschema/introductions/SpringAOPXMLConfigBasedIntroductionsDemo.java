package org.peddi.spring.core.aop.xmlschema.introductions;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPXMLConfigBasedIntroductionsDemo {
	
	/**
	 * Introductions are inter-type declarations in Aspejct
	 * Introductions add byte-code to the methods which are being intercepted
	 */
	public void introductionsDemo() {
		System.out.println("======>SpringAOPXMLConfigBasedIntroductionsDemo.introductionsDemo()");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("org/peddi/spring/core/aop/xmlschema/introductions/spring-schema-aop-introductions-config.xml");
		PersonService perSvc = context.getBean("personServiceBean", PersonService.class);
		Person person = perSvc.getPerson("Jane", 40);
		System.out.printf("%nPerson from introductionsDemo(): %s%n", person);
		System.out.printf("%nPersonCount from introductionsDemo(): %d%n", perSvc.personsCount());
		context.close();
	}
	
	public static void main(String[] args) {
		SpringAOPXMLConfigBasedIntroductionsDemo app = new SpringAOPXMLConfigBasedIntroductionsDemo();
		app.introductionsDemo();
	}

}
