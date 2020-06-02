package org.peddi.spring.core.aop.aspectj.introductions;

import org.peddi.spring.core.aop.aspectj.helper.UsageTracked;
import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class IntroductionsAspectjConfig {
	@Autowired
	PersonService personService;
	
	@Autowired
	UsageTracked usageTracking;
	
	@Bean
	public PersonService getPersonService() {
		return new DefaultPersonService();
	}
	
	@Bean
	public UsageTracked getUsageTracking() {
		return new UsageTrackingAspect();
	}

}
