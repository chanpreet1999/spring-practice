package com.chanpreet.practice;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.chanpreet.practice.customAnnotations.CourseCode;

public class Employee {

	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0,message="must be greater than equal to 0")
	@Max(value=10,message="cannot be more than 10")
	private Integer freePasses;
	
	private String programmingLanguage;
	private String country;
	private LinkedHashMap<String,String> countryOptions;
	private String[] operatingSystems;
	
	@Pattern(regexp="[789]{1}[0-9]{9}",message="Please Enter a Valid Phone Number")
	private String phno;
	
	@CourseCode
	private String courseCode;
	
	
	public Employee(){
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("IN", "INDIA");
		countryOptions.put("DE", "DENMARK");
		countryOptions.put("US", "USA");
		countryOptions.put("BR", "BRAZIL");
	}
	
	
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
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
