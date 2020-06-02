package org.peddi.spring.core.aop.service.support;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.peddi.spring.core.aop.service.PersonService;

public class DefaultPersonService implements PersonService {
	
	List<Person> members = new ArrayList<>();
	
	@Override
	public void setPerson(String name, int age) {
		System.out.println("\n******DefaultPersonService.setPerson(String name, int age)\n");	
		Person p = new Person(name, age);
		this.members.add(p);
		
	}

	@Override
	public Person getPerson(String name, int age) {
		
		System.out.println("\n******DefaultPersonService.getPerson(String name, int age)\n");	
		Person p = new Person(name, age);
		this.members.add(p);
		return p;
	}
	
	@Override
	public Optional<Person> getPerson(int id) throws Throwable {
		System.out.println("\n******DefaultPersonService.getPerson(int id)\n");
		if	(id == -1) {
			throw new Throwable("Invalid Person Id: "+ id);
		}
		return getPersonById(id);
	}

	@Override
	public int personsCount() {
		System.out.println("\n******DefaultPersonService.personsCount()\n");
		return this.members.size();
	}
	

	
	private Optional<Person> getPersonById(int id) {
		
		
		for(Person p : members) {
			if (p.getId() == id) {
				return Optional.of(p);
			}
		}
		
		return Optional.empty();
	}
	
	public void initPersons() {
		
		System.out.println("\n******DefaultPersonService.initPersons()\n");
		this.members = new ArrayList<>();
		this.members.add(new Person("AUser1", LocalDate.of(1970, Month.APRIL, 10), Person.Gender.MALE, "user1@abc.com","Bengaluru","Karnataka"));
        this.members.add(new Person("BUser2", LocalDate.of(1960, Month.JANUARY, 5), Person.Gender.MALE, "user2@abc.com","Mysuru","Karnataka"));
        this.members.add(new Person("CUser3", LocalDate.of(1980, Month.MAY, 10), Person.Gender.FEMALE, "user3@abc.com","Hyderbad","Telangana"));
        this.members.add(new Person("ZUser4", LocalDate.of(1975, Month.JUNE, 10), Person.Gender.MALE, "user4@abc.com","Amaravathi","AndhraPradesh"));
        this.members.add(new Person("XUser5", LocalDate.of(1990, Month.SEPTEMBER, 10), Person.Gender.FEMALE, "user5@abc.com","Chennai","Tamilnadu"));
        this.members.add(new Person("YUser6", LocalDate.of(1990, Month.AUGUST, 10), Person.Gender.MALE, "user6@abc.com","Trivendrum","Kerala"));

	}



}
