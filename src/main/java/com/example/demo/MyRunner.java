package com.example.demo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Component
public class MyRunner implements CommandLineRunner {
	 
	@Autowired
	StudentRepository studentRepository;
	
    @Override
    public void run(String...args) throws Exception {
//    	List<ListStudent> list = listStudentService.searchListStudent(null, "n");
//    	list.forEach(student -> System.out.println(student.toString()));
    	
//    	LocalDate date = LocalDate.parse("2022-06-08");
//    	List<StudentInfo> list = studentInfoService.searchByDate(date);
//    	String date = "2022-06-08";
//    	List<ListStudent> list = listStudentService.searchByBirthday(date);
//    	list.forEach(student -> System.out.println(student.toString()));

    	
    	LocalDate date = LocalDate.parse("2001-07-06");
    	List<com.example.demo.model.ListStudent> list = studentRepository.findAllListStudent();
    	list.forEach(student -> System.out.println(student.getStudentName() + student.getStudentCode()));
    }
}
