package org.peddi.spring.core.aop.aspectj.helper;

public class DefaultUsageTracked implements UsageTracked {
	
	private int usageCount;

	@Override
	public void incrementUsageCount() {
		usageCount++;
	}
	
	public void recordUsage(UsageTracked usageTracked) {
		System.out.printf("%nrecordUsage(): %d: ", usageCount);
	    usageTracked.incrementUsageCount();
	}

}
