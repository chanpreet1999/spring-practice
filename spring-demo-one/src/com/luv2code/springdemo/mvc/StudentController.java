package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		//create an object of student
		Student theStudent=new Student();
		
		//add this attribute to model
		theModel.addAttribute("student", theStudent);
		
		//now go to processForm jsp page
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)
	{
		System.out.println("Student Name:"+theStudent.getFirstName()
		+" "+theStudent.getLastName());
	
		return "student-confirmation";
	}
}
