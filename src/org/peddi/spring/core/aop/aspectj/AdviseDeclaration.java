package org.peddi.spring.core.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.peddi.spring.core.aop.aspectj.helper.Account;
import org.springframework.dao.DataAccessException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;


@Aspect
public class AdviseDeclaration {
	
   /**Declaration of @Before advise in an @Aspect with 
	* @Before advise using Pointcut expression as reference to named pointcut
	* com.xyz.myapp.SystemArchitecture.dataAccessOperation() is a pointcut defined 
	* in org.peddi.spring.core.aop.aspectj.SystemArchitecture Aspect
	*/
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck() {
			
	}
	
	
	/**
	 * Declaration of @Before advise in an @Aspect with 
	 * @Before advise using Pointcut expression in-place
	 */ 
	@Before("execution(* com.xyz.myapp.dao..(..) )")
	public void doAccessCheck2() {
			
	}
	
	
   /*
    *  Declaration of @AfterReturning advise in an @Aspect with 
	* @AfterReturning advise using Pointcut expression as reference to named pointcut
	* com.xyz.myapp.SystemArchitecture.dataAccessOperation() is a pointcut defined 
	* in org.peddi.spring.core.aop.aspectj.SystemArchitecture Aspect
	*/
	@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck3() {
			
	}
	
	/**
	 * accessing the return value in the @AfterReturning advise 
	 * The name used in the returning attribute must correspond to the 
	 * name of a parameter in the advice method.
	 */
	
	@AfterReturning(
			pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
			returning="retVal")
	public void doAccessCheck4(Object retVal) {
		
	}
	
	/**
	 * @AfterThrwoing advise runs after matching method execution exits by 
	 * throwing an exception.
	 */
	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doRecoveryActions() {
		
	}
	
	/**
	 * @AfterReturning advise parameter can be used to bind the thrown exception
	 * A throwing clause also restricts matching to only those method executions 
	 * that throw an exception of the specified type ( DataAccessException, in this case).
	 * 
	 */
	
	@AfterThrowing(pointcut ="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
			throwing="ex")
	public void doRecoveryActions2(DataAccessException ex) {
		
	}
	
	/**
	 * After (finally) advice runs when a matched method execution exits. 
	 * It is declared by using the @After annotation. After advice must be prepared 
	 * to handle both normal and exception return conditions. It is typically used 
	 * for releasing resources and similar purposes
	 */
	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void releaseLock() {
		
	}
	
	/**
	 * Around advice runs “around” a matched method’s execution. 
	 * It has the opportunity to do work both before and after the 
	 * method executes and to determine when, how, and 
	 * even if the method actually gets to execute at all. 
	 * Around advice is often used if you need to share state before 
	 * and after a method execution in a thread-safe manner 
	 * (starting and stopping a timer, for example)
	 * @throws Throwable 
	 */
	@Around("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public Object doAccessCheck(ProceedingJoinPoint pjp) throws Throwable {
		
		// start timer
		
		Object retVal = pjp.proceed();
		
		// stop time
		
		
		return retVal;
	}
	
	
	/**
	 * The args(account,..) part of the pointcut expression serves two purposes. 
	 * First, it restricts matching to only those method executions where the method 
	 * takes at least one parameter, and the argument passed to that 
	 * parameter is an instance of Account. Second, it makes the actual
	 * Account object available to the advice through the account parameter.
	 * 
	 */
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
	public void validateAccount(Account account) {
	    // ...
	}
	

}
