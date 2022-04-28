package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
 
	//handler method to handle list students and return more and view
	@GetMapping("/Students")
	public String listStudents(Model model ) {
		model.addAttribute("students",studentService.getALLStudents());
		return "students";
		
	}
	
	
}
