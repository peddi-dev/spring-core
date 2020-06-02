package org.peddi.spring.core.aop.springaop.advice.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import static java.lang.System.out;

public class SpringAOPInterceptionAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		out.println("\n------>SpringAOPInterceptionAroundAdvice.invoke()");
		out.printf("Before: invocation=[ %s ]%n", invocation);
		Object rVal = invocation.proceed();
		out.println("Invokcation Returned");
		
		return rVal;
	}

}
