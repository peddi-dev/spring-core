package org.peddi.spring.core.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import static java.lang.System.out;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		out.println("postProcessBeforeInitialization");
		out.printf("Bean %s  created: %s%n", beanName, bean );
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		out.println("postProcessAfterInitialization");
		out.printf("Bean %s  created: %s%n", beanName, bean );
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
