package net.javaguides.sms.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@RestController("/students")
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getALLStudents());
		return "students";
	}
	
	
}
