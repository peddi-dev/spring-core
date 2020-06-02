package org.peddi.spring.core.ctx.xml.event;

import org.springframework.context.ApplicationEvent;


public class BlacklistEvent extends ApplicationEvent {
	

	private static final long serialVersionUID = 231436L;
	final String address;
	final String content;

	public BlacklistEvent(Object source, String address, String content) {
		super(source);
		this.address = address;
		this.content = content;
	}

	@Override
	public Object getSource() {
		
		return super.getSource();
	}

	@Override
	public String toString() {
		
		return String.format("%s, %s, %s",  
				super.toString(),
				this.address,
				this.content);
	}
}
