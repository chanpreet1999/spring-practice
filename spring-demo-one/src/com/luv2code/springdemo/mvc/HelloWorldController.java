package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "processForm";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String VersionTwo(HttpServletRequest request , Model model){
		
		//getParameter
		String name=request.getParameter("studentName");
		
		String result="Yo! "+name;
		result=result.toUpperCase();
		
		//add result to model
		model.addAttribute("message", result);
		return "processForm";
	}
	
	@RequestMapping("processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model){
		
		theName=theName.toUpperCase();
		String result="Hey There My Friend "+theName;
		
		//add the attribute to model
		model.addAttribute("message", result);
		
		return "processForm";
	}

}
