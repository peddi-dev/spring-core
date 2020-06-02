package org.peddi.spring.core.aop.springaop.advice.afterreturning;

import static java.lang.System.out;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SpringAOPAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		out.printf("%n------>SpringAOPAfterReturningAdvice.afterReturning() %nMethod: %s%n [ %s ] %n", 
				method.getName(), 
				method.toString());
		
		
		
	}

}
