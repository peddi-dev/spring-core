package org.peddi.spring.core.aop.aspectj.advice.after;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static java.lang.System.out;

@Aspect
public class AfterReturningAdviceAspect {
	
	
	@Pointcut("execution(* org.peddi.spring.core.aop.service.PersonService.*(..))")
	public void joinPointPredicateExecution() {  }
	
	@AfterReturning("joinPointPredicateExecution()")
	public void afterReturningAdviceMethod() {
		
		out.println("----->AfterReturningAdviseAspect.afterReturningAdviseMethod()");
		
	}

}
