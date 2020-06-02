package org.peddi.spring.core.aop.aspectj.introductions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

import org.peddi.spring.core.aop.aspectj.helper.UsageTracked;


/**
 * Introductions (known as inter-type declarations in AspectJ) enable 
 * an aspect to declare that advised objects implement a given interface, 
 * and to provide an implementation of that interface on behalf of those objects.
 *
 */

@Aspect
public class UsageTrackingAspect implements UsageTracked{
	
	@DeclareParents(value="org.peddi.spring.core.aop.service.PersonService",
			defaultImpl=UsageTrackingAspect.class)
	public static UsageTracked mixin;
	int count = 0;
	
	//TODO: this advisor is not working, to be investigated
	@Before("execution(* org.peddi.spring.core.aop.service.PersonService.*(..)) and this(usageTracked)")
	public void recordUsage(UsageTracked usageTracked) {
		
		System.out.println("UsageTrackingAspect.recordUsage()");
		usageTracked.incrementUsageCount();
		
	}

	@Override
	public void incrementUsageCount() {
		count++;
		
	}
	
	

}
