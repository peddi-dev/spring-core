package org.peddi.spring.core.ctx.xml.event;

import org.springframework.context.ApplicationListener;

public class BlacklistEventListener implements ApplicationListener<BlacklistEvent> {
	
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	@Override
	public void onApplicationEvent(BlacklistEvent event) {
		
		System.out.println("\n*****onApplicationEvent() from ApplicationListener interface ");
		
		System.out.printf("%nBlocklistEvent Received: %s%n", event);
		
		//notify to the notificationAddress
		System.out.printf("%nNotified to the address: %s", this.notificationAddress);
		
	}

}
