package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ListStudent;
import com.example.demo.model.StudentIdentity;
import com.example.demo.repository.StudentInfoRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/list")
public class ScreenListController {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentInfoRepository studentInfoRepository;

	@GetMapping(value = "/show")
	public List<ListStudent> show() {
		return studentRepository.findAllListStudent();
	}

	@GetMapping(value = "/search")
	public List<ListStudent> search(@RequestParam(required = false) String code,
			@RequestParam(required = false) String name, @RequestParam(required = false) String birthday) {
		List<ListStudent> list = new ArrayList<>();
		if (code == "" && name == "" && birthday == "") {
			list = studentRepository.findAllListStudent();
		} else if (birthday == "") {
			list = studentRepository.searchListStudentByCodeAndName(code, name);
		} else {
			LocalDate dateOfBirth = LocalDate.parse(birthday);
			list = studentRepository.searchListStudent(code, name, dateOfBirth);
		}
		return list;
	}

	@DeleteMapping("/delete/{id}")
	@Transactional
	public void deleteStudent(@PathVariable(value = "id") int studentId) throws Exception {
		studentRepository.deleteById(studentId);
		studentInfoRepository.deleteById(new StudentIdentity(studentId, studentId));
	}
	
	@GetMapping("/edit/{id}")
	public ListStudent editStudent(@PathVariable(value = "id") int studentId){
		return studentRepository.findListStudentById(studentId);
	}
}
