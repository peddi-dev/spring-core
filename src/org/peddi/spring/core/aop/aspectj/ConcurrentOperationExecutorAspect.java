package org.peddi.spring.core.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.Ordered;
import org.springframework.dao.PessimisticLockingFailureException;

public class ConcurrentOperationExecutorAspect  implements Ordered{
	
	private static final int DEFAULT_MAX_RETRIES = 2;
	private int maxTries = DEFAULT_MAX_RETRIES;
	private int order = 1;

	public void setMaxTries(int maxTries) {
		this.maxTries = maxTries;
	}

	@Override
	public int getOrder() {
		
		return order;
	}
	
	@Around("com.xyz.myapp.SystemArchitecture.businessService()")
	public void doConccurentOperation(ProceedingJoinPoint pjp) throws Throwable{
		
		int numAttempts = 0;
		PessimisticLockingFailureException lockFailureException = null;
		
		do {
			numAttempts++;
			
			try {
				pjp.proceed();
			} catch (PessimisticLockingFailureException e) {
				lockFailureException = e;
			}
		}while(numAttempts <= this.maxTries);
		
		throw lockFailureException;
	}

}
