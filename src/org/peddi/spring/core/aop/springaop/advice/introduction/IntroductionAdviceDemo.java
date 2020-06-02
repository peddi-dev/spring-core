package org.peddi.spring.core.aop.springaop.advice.introduction;

import org.peddi.spring.core.aop.service.PersonService;
import org.peddi.spring.core.aop.service.support.DefaultPersonService;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.DebugInterceptor;
import static java.lang.System.out;

public class IntroductionAdviceDemo {
	
	public void introductionAdviceDemo() {
		
		out.println("======>IntroductionAdviceDemo.introductionAdviceDemo()");
		DefaultPersonService personSvcTarget = new DefaultPersonService();
		ProxyFactory proxyFactory = new ProxyFactory(personSvcTarget);
		DebugInterceptor debugInterceptor = new DebugInterceptor();
		proxyFactory.addAdvice(debugInterceptor);
		
		//Introduction Advice
		IntroductionAdvisor introductionAdvisor =  new LockMixinAdvisor();
		proxyFactory.addAdvisor(introductionAdvisor);
		
		// getting AOP Proxy to personSvcTarget object
		PersonService personSvcProxy = (PersonService) proxyFactory.getProxy();
		
		
		try {
		
			IntroduceInterfaceLockable lockable = (IntroduceInterfaceLockable) personSvcProxy;
			lockable.unlock();
			
			personSvcProxy.setPerson("Raj", 30);


		} catch (Throwable e) {
			// TODO Auto-generated catch block
			out.print(e.getCause().getMessage());
		}

		
	}
	
	public static void main(String[] args) {
		IntroductionAdviceDemo app = new IntroductionAdviceDemo();
		app.introductionAdviceDemo();
	}

}
