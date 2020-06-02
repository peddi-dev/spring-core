package org.peddi.spring.core.aop.springaop.advice.afterthrows;

import static java.lang.System.out;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class SpringAOPThrowsAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable ex)  throws Throwable{
		out.printf("%n------>SpringAOPThrowsAdvice.afterThrowing()  %nMethod: %s%n [ %s ] %n", 
				method.getName(), 
				method.toString());
		
		out.printf("Exception: %s%n", ex.getMessage());
	}
}
