package com.klef.jfsd.apms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.apms.model.Student;
import com.klef.jfsd.apms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentRepository studentRepository;
	


	@Override
	public Student checkstudentlogin(String email, String pwd) 
	{
		
		return studentRepository.checkstudentlogin(email, pwd);
		
	}

	@Override
	public String updatestudent(Student s) 
	{
		Student s1 = studentRepository.findById(s.getId()).get();
		
		s1.setName(s.getName());
		s1.setGender(s.getGender());
		s1.setDepartment(s.getDepartment());
		s1.setDateofbirth(s.getDateofbirth());
		s1.setEmail(s.getEmail());
		s1.setContact(s.getContact());
		s1.setPassword(s.getPassword());
		s1.setActive(s.isActive());
		
		studentRepository.save(s1);
		
		return "Profile Updated Successfully";
		
	}

}
