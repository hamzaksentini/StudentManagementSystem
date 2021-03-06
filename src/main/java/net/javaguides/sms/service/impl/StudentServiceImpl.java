package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository StudentRepository;
	
	public StudentServiceImpl(net.javaguides.sms.repository.StudentRepository studentRepository) {
		super();
		StudentRepository = studentRepository;
	}





	@Override
	public List<Student> getALLStudents() {
		return StudentRepository.findAll();
	}

}
