package com.chanpreet.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		theModel.addAttribute("employee", new Employee());
	
		return "employee-form";
	}
	
	
	@RequestMapping("/processEmployee")
	public String processForm(@ModelAttribute("employee") Employee theEmployee)
	{
		System.out.println("Employee Name:"+theEmployee.getFirstName()+
				" "+theEmployee.getLastName());
		
		return "employee-confirmation";
	}
}
