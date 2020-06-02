package org.peddi.spring.core.ctx.xml.event;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class BlacklistEventPublisher implements ApplicationEventPublisherAware {
	
	private List<String> blacklist;
	private ApplicationEventPublisher eventPublisher;
	
	public List<String> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(List<String> blocklist) {
		this.blacklist = blocklist;
	}

	

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.printf("%n*****ApplicationEventPublisher is set: %s%n",applicationEventPublisher );
		this.eventPublisher = applicationEventPublisher;
	}
	
	public void publishEnvent(String address, String content) {
		
		if(this.blacklist.contains(address)) {
			System.out.println("BlocklistEvent Published");
			this.eventPublisher.publishEvent(new BlacklistEvent(this, address, content));
			return;
		}
		
		//send email to address with content
	}
	
	

}
