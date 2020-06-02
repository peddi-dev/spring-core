package org.peddi.spring.core.aop.service;

import java.util.Optional;

import org.peddi.spring.core.aop.service.support.Person;



public interface PersonService {

	
	Person getPerson(String name, int age);
	Optional<Person> getPerson(int id) throws Throwable;
	int personsCount();
	void initPersons();
	void setPerson(String name, int age);

}
