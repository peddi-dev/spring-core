package org.peddi.spring.core.ctx.xml.messagesource;

import java.util.Locale;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceConusmerDemo {
	
	private MessageSource messages;

	
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}


	public void readMessage() {
		String message = this.messages.getMessage("message", null, "default", Locale.ENGLISH);
		
		System.out.printf("\n\nMessageSourceConusmerDemo::readMessage()\n");
		System.out.printf("Message is : %s%n",message);
		
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("/org/peddi/spring/core/ctx/xml/messagesource/message-source-inject-beans.xml");
		MessageSourceConusmerDemo msConsumer = appCtx.getBean(MessageSourceConusmerDemo.class);
		msConsumer.readMessage();
		appCtx.close();
		
	}

}
