package org.peddi.spring.core.aop.aspectj.advice.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import static java.lang.System.out;

@Aspect
public class AroundAdviceAspect {
	
	@Pointcut("execution( * org.peddi.spring.core.aop.service.PersonService.getPerson(String, int)) ")
	public void joinPointPredicateExecution() {
		// this method won't be called
		out.println("\n****** THIS WON't PRINT\n");
	}
	
	// Around Advise
	@Around("joinPointPredicateExecution() and args(name, age)")
	public Object aroundAdviseMethod( ProceedingJoinPoint pjp, String name , int age) throws Throwable {
		
		out.println("----->AroundAdviseAspect.aroundAdviseMethod()");
		
		String id = String.format("Profiling for %s and %d", name, age);
		
		StopWatch timer = new StopWatch(id);
		
		try {
			
			timer.start();
			out.println("----->BeforeCalling AdvisedMethod()");
			Object result = pjp.proceed();
			out.println(result);
			out.println("----->AfterCalling AdvisedMethod()\n");
			return result;
			
		}finally {
			timer.stop();
			out.println(timer.prettyPrint());
		}
	}
	

}
