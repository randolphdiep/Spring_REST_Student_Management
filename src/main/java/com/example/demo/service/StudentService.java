package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public Student findById(int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}
	
	public List<Student> findAll(){
		return (List<Student>) studentRepo.findAll();
	}
	
	public void deleteById(int studentId) {
		studentRepo.deleteById(studentId);
	}

}
