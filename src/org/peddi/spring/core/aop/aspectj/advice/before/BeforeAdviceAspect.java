package org.peddi.spring.core.aop.aspectj.advice.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


import static java.lang.System.out;

@Aspect

public class BeforeAdviceAspect {
	
	/**
	 * Following all pointcut expressions are worked fine
	 */
	//execution(* org.peddi.spring.core.aop.service.*.*(..))
	//execution(* org.peddi.spring.core.aop.service..*.*(..))
	//execution(* org.peddi.spring.core.aop.service.PersonService+.*(..))
	//execution(* org.peddi.spring.core.aop.service.PersonService+.*(..))
	//within(org.peddi.spring.core.aop.service.*)
	//within(org.peddi.spring.core.aop.service..*)
	//target(org.peddi.spring.core.aop.service.PersonService
	//this(org.peddi.spring.core.aop.service.PersonService)
	//bean(personServiceBean)
	//bean(*ServiceBean)
	
	@Pointcut("execution( * org.peddi.spring.core.aop.service..*.*(..))")
	public void joinPointPredicateExecution() { }
	
	@Pointcut("within(org.peddi.spring.core.aop.service..*)")
	public void joinPointPredicateWithin() { }
	
	@Before("joinPointPredicateExecution()")
	public void beforeAdviseMethod() {
		
		out.printf("%n----->BeforeAdviseAspect.joinPointPredicate()%n" );
		
	}

}
