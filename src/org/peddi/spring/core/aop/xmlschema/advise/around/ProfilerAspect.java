package org.peddi.spring.core.aop.xmlschema.advise.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import static java.lang.System.out;

public class ProfilerAspect {

	// this is an Around Advise Method
	public Object profile(ProceedingJoinPoint pjp, String name, int age) throws Throwable {

		String id = String.format("Profiling for %s and %d", name, age);

		StopWatch timer = new StopWatch(id);

		timer.start();

		try {

			out.println();

			Object retVal = pjp.proceed();

			out.println(retVal);

			return retVal;

		} finally {
			timer.stop();
			out.println(timer.prettyPrint());
		}

	}

}
