package org.peddi.spring.core.aop.xmlschema.advise.around;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpingAOPXMLConfigBasedDemo {
	
	public void xmlConfigBasedAOPDemo() {
		
		String config = "org/peddi/spring/core/aop/xmlschema/advise/around/spring-aop-schema-config.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(config);
		PersonService perSvc = context.getBean("personServiceBean", PersonService.class) ;
		Person per = perSvc.getPerson("John", 30);
		System.out.println(per);
		context.close();
	}
	
	public static void main(String[] args) {
		SpingAOPXMLConfigBasedDemo app = new SpingAOPXMLConfigBasedDemo();
		app.xmlConfigBasedAOPDemo();
	}

}
