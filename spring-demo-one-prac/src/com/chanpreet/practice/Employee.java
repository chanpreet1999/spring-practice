package com.chanpreet.practice;

import java.util.LinkedHashMap;

public class Employee {

	private String firstName;
	private String lastName;
	private String programmingLanguage;
	private String country;
	private LinkedHashMap<String,String> countryOptions;
	private String[] operatingSystems;
	
	public Employee(){
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("IN", "INDIA");
		countryOptions.put("DE", "DENMARK");
		countryOptions.put("US", "USA");
		countryOptions.put("BR", "BRAZIL");
	}
	
	
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
