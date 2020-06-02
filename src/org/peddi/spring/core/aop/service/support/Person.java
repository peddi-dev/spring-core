package org.peddi.spring.core.aop.service.support;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

	public Person(String name, int age) {
		super();
		this.id = nextId();
		this.name = name;
		this.age = age;
	}

	
	public enum Gender {
		MALE, FEMALE
	}
	
	public Person() {}
	
	public Person(String name, LocalDate birthDay, Gender gender, String emailId, String city, String state) {
		super();
		this.id = nextId();
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.emailId = emailId;
		this.city = city;
		this.state = state;
	}
	

	
	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", name=" + name + ", birthDay=" + birthDay + ", gender=" + gender
				+ ", emailId=" + emailId + ", city=" + city + ", state=" + state + "]";
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public int getAge() {
		
		if (this.getBirthDay() == null ) 
			return 0;
		
		 age = 0;
		//Solution 1
//		Period period = Period.between( this.getBirthDay(), LocalDate.now());
//		age =  period.getYears();
		
		//Solution 2
		age = (int) ChronoUnit.YEARS.between(this.getBirthDay(), LocalDate.now());
		
		return age;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int nextId() {
		return ++count;
	}

	int id;
	int age;
	private String name;
	private LocalDate birthDay;
	private Gender gender;
	private String emailId;
	private String city;
	private String state;
	
	private static int count = 0;
}
