package org.peddi.spring.core.beans.propertyeditors;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

public class EmployeePropertyEditorDemo {
	
	public void employeePropertyEditorDemo() {
		
		ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("org/peddi/spring/core/beans/propertyeditors/config.xml");
		Employee emp = (Employee) context.getBean("emp1");
		
		out.println("*** Employee Editor Demo");
		out.print(emp);
		
		context.close();
		
	}
	
	public static void main(String[] args) {
		EmployeePropertyEditorDemo app = new EmployeePropertyEditorDemo();
		app.employeePropertyEditorDemo();
	}

}
