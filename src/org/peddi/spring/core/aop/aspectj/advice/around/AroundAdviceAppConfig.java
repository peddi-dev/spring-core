package org.peddi.spring.core.aop.aspectj.advice.around;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Import(org.peddi.spring.core.aop.service.PersonServiceConfig.class)
@Configuration
@EnableAspectJAutoProxy
public class AroundAdviceAppConfig {

	@Autowired
	AroundAdviceAspect executionTimeProfiler;

	@Bean
	AroundAdviceAspect getExecutionTimeProfiler() {
		return new AroundAdviceAspect();
	}

}
