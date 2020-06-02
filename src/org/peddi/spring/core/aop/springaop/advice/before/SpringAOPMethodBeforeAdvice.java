package org.peddi.spring.core.aop.springaop.advice.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import static java.lang.System.out;

public class SpringAOPMethodBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		out.printf("%n------>SpringAOPMethodBeforeAdvice.before()  %nMethod: %s %n [ %s ]%n", 
				method.getName(), 
				method.toString());
		
	}

}
