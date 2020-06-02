package org.peddi.spring.core.beans.propertyeditors;

import java.util.Date;

public class Employee extends Person{
	
	Person spouse;
	int employeeNumber; 
	String job;
	Date joinDate;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public String getJob() {
		return job;
	}
	
	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [" + super.toString() + " employeeNumber=" + employeeNumber + ", job=" + job + ", joinDate="+ joinDate + ", {spouse="+ spouse  + "}" +  "]"; 
		
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	

}
