package org.peddi.spring.core.aop.springaop.advice.introduction;

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import static java.lang.System.out;

public class LockMixin extends DelegatingIntroductionInterceptor implements IntroduceInterfaceLockable {

	private static final long serialVersionUID = 7930411778334093085L;
	private boolean lock = false;
	
	@Override
	public void lock() {
		out.println("#######LockMixin.lock()");
		this.lock  = true;
		
	}

	@Override
	public void unlock() {
		out.println("#######LockMixin.unlock()");
		this.lock = false;
	}

	@Override
	public boolean isLocked() {
		out.println("#######LockMixin.isLocked()");
		
		return this.lock;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		out.printf("%n------>IntroductionAdvice(LockMixin).invocation()  %nMethod: %s [ %s ] %n", 
				invocation.getMethod().getName(),
				invocation.getMethod().toString());
		
		if( isLocked() && invocation.getMethod().getName().startsWith("set") ) {
			
			out.println("~~~~~~~>Checking the Lock");
			throw new LockException("object is Locked");
		}
		
		return super.invoke(invocation);
	}

}
