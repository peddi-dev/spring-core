package org.peddi.spring.core.aop.springaop.advice.introduction;

public interface IntroduceInterfaceLockable {
	void lock();
	void unlock();
	boolean isLocked();

}
