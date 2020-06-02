package org.peddi.spring.core.ctx.xml.messagesource;

import java.util.Locale;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceDemo {
	
	public void readResourceBundle() {
		
		
		MessageSource messageSource = new ClassPathXmlApplicationContext("/org/peddi/spring/core/ctx/xml/messagesource/message-sourece-beans.xml");
		
		String msg = messageSource.getMessage("message", null, "Default", Locale.ENGLISH);
		System.out.printf("message is: %s", msg);
		
		ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) messageSource;
		ctx.close();
		
	}
	
	public static void main(String[] args) {
		MessageSourceDemo app = new MessageSourceDemo();
		app.readResourceBundle();
	}

}
