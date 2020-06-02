package org.peddi.spring.core.ctx.annotation.service.provider;

import org.peddi.spring.core.ctx.annotation.service.MyService;

public class MyServiceImpl implements MyService {

	@Override
	public String doStuff() {
		
		return "Done";
		
	}

}
