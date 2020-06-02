package org.peddi.spring.core.aop.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigBootstrapper {

	public static ConfigurableApplicationContext getAnnotationConfigApplicationContext(Class<?> configClass) {

		return new AnnotationConfigApplicationContext(configClass);
	}

}
