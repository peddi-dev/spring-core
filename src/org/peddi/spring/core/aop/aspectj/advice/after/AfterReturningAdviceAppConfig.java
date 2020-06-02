package org.peddi.spring.core.aop.aspectj.advice.after;

import org.peddi.spring.core.aop.service.PersonServiceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersonServiceConfig.class)
@EnableAspectJAutoProxy
public class AfterReturningAdviceAppConfig {
	

	
	@Bean AfterReturningAdviceAspect afterReturningAdviseAspectBean() {
		return new AfterReturningAdviceAspect();
	}
}
