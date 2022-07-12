package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;
import com.example.demo.repository.StudentInfoRepository;

@Service
public class StudentInfoService {
	@Autowired
	StudentInfoRepository studentInfoRepo;
	
	public void save(StudentInfo studentInfo){
		studentInfoRepo.save(studentInfo);
	}
	
	public StudentInfo findById(StudentIdentity studentIdentity) {
		StudentInfo studentInfo = studentInfoRepo.findById(studentIdentity).get();
		return studentInfo;
	}
	
	public List<StudentInfo> findAll(){
		return (List<StudentInfo>) studentInfoRepo.findAll();
	}
	
	public void deleteById(StudentIdentity studentIdentity) {
		studentInfoRepo.deleteById(studentIdentity);
	}
	
	
}