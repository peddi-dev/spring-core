package org.peddi.spring.core.aop.aspectj.advice.after;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

import static java.lang.System.out;

@Aspect
public class AfterAdviceAspect {
	
	
	@Pointcut("execution(* org.peddi.spring.core.aop.service.PersonService.*(..))")
	public void joinPointPredicateExecution() {}
	
	
	@After("joinPointPredicateExecution()")
	public void afterAdviceMethod() {
		
		out.printf("%n------>AfterAdviseAspect.afterAdviseMethod()%n");
	}

}
