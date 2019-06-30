package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
private String firstName;
private String lastName;
private String country;
private LinkedHashMap<String, String> countryOptions;
private String favouriteLanguage;
private String[] operatingSystems;


public Student() {
	countryOptions=new LinkedHashMap<>();
	countryOptions.put("IN", "India");
	countryOptions.put("DE", "Denmark");
	countryOptions.put("BR", "Brazil");
	countryOptions.put("FR", "France");
	countryOptions.put("US", "United States of America");
}



public String[] getOperatingSystems() {
	return operatingSystems;
}



public void setOperatingSystems(String[] operatingSystems) {
	this.operatingSystems = operatingSystems;
}



public String getFavouriteLanguage() {
	return favouriteLanguage;
}

public void setFavouriteLanguage(String favouriteLanguage) {
	this.favouriteLanguage = favouriteLanguage;
}

public String getCountry() {
	return country;
}
public LinkedHashMap<String, String> getCountryOptions() {
	return countryOptions;
}
public void setCountry(String country) {
	this.country = country;
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
