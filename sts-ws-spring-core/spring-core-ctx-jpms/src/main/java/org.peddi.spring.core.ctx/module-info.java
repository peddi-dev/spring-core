module org.peddi.spring.core.ctx {
	
	requires spring.core;
	requires spring.context;
	requires spring.beans;
	
	exports org.peddi.spring.core.ctx;
	exports org.peddi.spring.core.ctx.annotation;
	exports org.peddi.spring.core.ctx.annotation.service;
}