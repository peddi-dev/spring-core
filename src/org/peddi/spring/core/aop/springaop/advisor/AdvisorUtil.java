package org.peddi.spring.core.aop.springaop.advisor;

import org.peddi.spring.core.aop.springaop.advice.before.SpringAOPMethodBeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

public class AdvisorUtil {

	public static PointcutAdvisor getNameMatchMethodPointcutAdvisor() {
		
		
		MethodBeforeAdvice advice = new SpringAOPMethodBeforeAdvice();
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(advice);
		advisor.setMappedName("getPerson");
		
		return advisor;
	}
	
	public static PointcutAdvisor getRegexpMethodPointcutAdvisor() {

		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		advisor.setAdvice(new SpringAOPMethodBeforeAdvice() );
		advisor.setPattern(".*get.*");
		
		return advisor;
	}
	
}
