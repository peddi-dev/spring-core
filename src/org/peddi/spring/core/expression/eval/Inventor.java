package org.peddi.spring.core.expression.eval;

import java.time.LocalDate;

public class Inventor {
	String name;
	LocalDate birthday;
	String nationality;
	public Inventor(String name, LocalDate birthday, String nationality) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.nationality = nationality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
