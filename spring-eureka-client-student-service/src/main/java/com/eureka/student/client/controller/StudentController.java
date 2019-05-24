package com.eureka.student.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.student.client.bean.Student;

@RestController
public class StudentController {
	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
	static {
	       schooDB = new HashMap<String, List<Student>>();
	       
	       List<Student> lst = new ArrayList<Student>();
	        Student std = new Student("Sajal", "Class IV");
	        lst.add(std);
	        std = new Student("Lokesh", "Class V");
	        lst.add(std);
	 
	        schooDB.put("abcschool", lst);
	 
	        lst = new ArrayList<Student>();
	        std = new Student("Kajal", "Class III");
	        lst.add(std);
	        std = new Student("Sukesh", "Class VI");
	        lst.add(std);
	 
	        schooDB.put("xyzschool", lst);
	 
	}

	@RequestMapping(value="/getStudent/{schoolname}")
	public List<Student> getStudent(@PathVariable("schoolname") String schoolname)
	{
		System.out.println("Getting Student details for " + schoolname);
		 
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
	}
}
