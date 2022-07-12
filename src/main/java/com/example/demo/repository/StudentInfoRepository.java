package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentIdentity;
import com.example.demo.model.StudentInfo;

@Repository
public interface StudentInfoRepository extends CrudRepository<StudentInfo, StudentIdentity> {
	@Query("SELECT s FROM StudentInfo s WHERE s.dateOfBirth = ?1")
	public List<StudentInfo> findByDate(LocalDate date);
	
	@Query("SELECT s FROM StudentInfo s WHERE s.studentIdentity.infoId = ?1 AND s.studentIdentity.studentId = ?1 ")
	public StudentInfo findByAll(int id);
}
