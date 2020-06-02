package org.peddi.spring.core.ctx.xml.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class BlacklistEventDemo {
	
	public void blacklistEventDemo() {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("/org/peddi/spring/core/ctx/xml/appevent/events-config.xml");
		BlacklistEventPublisher eventPub = ctx.getBean(BlacklistEventPublisher.class);
		eventPub.publishEnvent("user1@example.com", "email content.");
		
		ctx.close();
		
	}

	public static void main(String[] args) {
		BlacklistEventDemo app = new BlacklistEventDemo();
		app.blacklistEventDemo();

	}

}
