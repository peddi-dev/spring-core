package org.peddi.spring.core.aop.service;

import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonServiceConfig {

	
	@Bean
	public PersonService personServiceBean() {
		return new DefaultPersonService();
	}
	
}
