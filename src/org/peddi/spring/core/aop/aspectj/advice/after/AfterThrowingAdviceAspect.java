package org.peddi.spring.core.aop.aspectj.advice.after;

import static java.lang.System.out;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AfterThrowingAdviceAspect {
	
	@Pointcut("execution(* org.peddi.spring.core.aop.service..*.*(..))")
	public void joinPointPredicateExecution() {  }
	
	@AfterReturning("joinPointPredicateExecution()")
	public void afterThrowingAdviceMethod() {
		
		out.println("----->AfterThrowingAdviseAspect.afterThrowingAdviseMethod()");
		
	}

}
