package com.example.demo.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ListStudent;
import com.example.demo.model.Student;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;
import com.example.demo.repository.StudentInfoRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentInfoRepository studentInfoRepository;

	@GetMapping(value = "/add")
	@Transactional
	public void addStudent(@RequestParam(required = false) String code, @RequestParam(required = false) String name,
			@RequestParam(required = false) String address, @RequestParam(required = false) String averageScore,
			@RequestParam(required = false) String dateOfBirth) {
		double score = 0;
		if (averageScore != "") {
			score = Double.parseDouble(averageScore);
		}
		LocalDate date = null;
		if (dateOfBirth != "") {
			date = LocalDate.parse(dateOfBirth);
		}
		studentRepository.addStudent(code, name);
		studentRepository.addStudentInfo(address, score, date);
	}

	@PostMapping("/updated")
	public void updateStudent(@RequestBody ListStudent listStudent) {
		Student updateStudent = new Student(listStudent.getStudentId(), listStudent.getStudentCode(), listStudent.getStudentName());
		studentRepository.save(updateStudent);
		StudentInfo updateStudentInfo = new StudentInfo(new StudentIdentity(
				listStudent.getStudentId(), 
				listStudent.getStudentId()), 
				listStudent.getAddress(), 
				listStudent.getAverageScore(),
				listStudent.getDateOfBirth());
		studentInfoRepository.save(updateStudentInfo);
	}
}
