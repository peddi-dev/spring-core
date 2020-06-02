package org.peddi.spring.core.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class PointcutDeclaration {
	
	@Pointcut("execution(* transfer(..)")
	public void anyOldTransfer() {
		
	}

}
