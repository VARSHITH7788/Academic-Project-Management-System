package com.klef.jfsd.apms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.apms.model.Student;

import com.klef.jfsd.apms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("student")
public class ClientController 
{
	
	
	@Autowired
	private StudentService studentService;

	
	@GetMapping("/")
	public String login()
	{
		
		return "home";
		
	}
	
	@GetMapping("studentlogin")
	public ModelAndView studentlogin()
	{
		
		ModelAndView mv = new ModelAndView("studentlogin");
		return mv;
		
	}
	
	@PostMapping("checkstudentlogin")
	public ModelAndView checkstudentlogin(HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		Student s = studentService.checkstudentlogin(email, pwd);
		if(s!=null)
		{
			mv.addObject("sid", s.getId());
			mv.setViewName("studenthome");
		}
		else
		{
			mv.addObject("message", "Incorrect Combination of Email and Password");
			mv.setViewName("showerror");
		}
		
		return mv;
		
	}
	
	@GetMapping("studenthome")
	public String studenthome()
	{
		return "studenthome";
	}


	
	
}
