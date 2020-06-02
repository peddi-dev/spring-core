package org.peddi.spring.core.aop.aspectj.advice.before;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(org.peddi.spring.core.aop.service.PersonServiceConfig.class)
@EnableAspectJAutoProxy
public class BeforeAdviceAppConfig {

	@Bean
	public BeforeAdviceAspect beforeAdviseAspectBean() {
		return new BeforeAdviceAspect();
	}

}
