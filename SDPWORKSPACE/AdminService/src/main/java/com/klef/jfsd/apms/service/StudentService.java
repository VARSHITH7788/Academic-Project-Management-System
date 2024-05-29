package com.klef.jfsd.apms.service;

import com.klef.jfsd.apms.model.Student;

public interface StudentService 
{
	
	public Student checkstudentlogin(String email, String pwd);
	public String updatestudent(Student s);
	
}
