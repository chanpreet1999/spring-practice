package com.chanpreet.practice;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@InitBinder
	public void initBinder(WebDataBinder theDataBinder){
		StringTrimmerEditor theTrimmerEditor=new StringTrimmerEditor(true);
		theDataBinder.registerCustomEditor(String.class, theTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel){
		
		theModel.addAttribute("employee", new Employee());
	
		return "employee-form";
	}
	
	
	@RequestMapping("/processEmployee")
	public String processForm(@Valid @ModelAttribute("employee") Employee theEmployee,
			BindingResult theBindingResult)
	{
		System.out.println("Employee Name:"+theEmployee.getFirstName()+
				" "+theEmployee.getLastName());
		
		if(theBindingResult.hasErrors()){
			return "employee-form";
		}
			
		else{
		return "employee-confirmation";
		}
	}
}
