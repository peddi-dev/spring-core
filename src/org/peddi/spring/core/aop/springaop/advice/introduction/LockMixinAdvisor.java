package org.peddi.spring.core.aop.springaop.advice.introduction;


import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockMixinAdvisor extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = -6593413413432167589L;

	public LockMixinAdvisor() {
		super(new LockMixin(), IntroduceInterfaceLockable.class);
	}
}
