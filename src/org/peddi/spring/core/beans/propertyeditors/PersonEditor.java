package org.peddi.spring.core.beans.propertyeditors;

import java.beans.PropertyEditorSupport;

public class PersonEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String[] values = text.split(":");
		
		Person person = new Person();
		person.setFirstName(values[0]);
		person.setLastName(values[1]);
	
		
		setValue(person);
		
		//super.setAsText(text);
	}

	
}
