package org.peddi.spring.core.ctx.xml.event;

import org.springframework.context.event.EventListener;

public class BlacklistEventListenerWithAnnotation {
	
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}
	
	@EventListener
	public void processBlacklistEvent(BlacklistEvent blEnvent) {
		
		System.out.println("****** @EventListener processBlacklistEvent()");
		
		System.out.printf("%nBlocklistEvent Received: %s%n", blEnvent);
		
		//notify to the notificationAddress
		System.out.printf("%nNotified to the address: %s", this.notificationAddress);
		
	}

}
