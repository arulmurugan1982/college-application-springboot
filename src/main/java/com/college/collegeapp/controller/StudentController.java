package com.college.collegeapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.collegeapp.model.Student;



@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	List <Student> students;
	
	StudentController()
	{
		students = new ArrayList<>();
		students.add(new Student((long) 1, "Arul","Murugan"));
		students.add(new Student((long) 2, "Harshu","Murugan"));
		students.add(new Student((long) 3, "Hanya","Murugan"));
		
	}
	

	
	@GetMapping(path = "/{userId}")
	public Student findStudentById(@PathVariable("userId") long userId)
	
	{
		Student studentFromBackEnd = null;
		try {
			studentFromBackEnd = students.stream().filter(student -> student.getUserId().equals(userId))
			.findFirst().orElseThrow(() -> new Exception("userId : " + userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
               
		
	return studentFromBackEnd;
		
	}
	
	
	

}
