package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ListStudent;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
		
	@Query("SELECT new com.example.demo.model.ListStudent("
			+ "s1.studentId, "
			+ "s1.studentCode, "
			+ "s1.studentName, "
			+ "s2.dateOfBirth, "
			+ "s2.address, "
			+ "s2.averageScore) "	
			+ "FROM Student s1, StudentInfo s2 "
			+ "WHERE s1.studentId = s2.studentIdentity.studentId AND s1.studentCode LIKE %?1% AND s1.studentName LIKE %?2% AND s2.dateOfBirth = ?3"
			)
	public List<ListStudent> searchListStudent(String studentCode, String studentName, LocalDate dateOfBirth);
	
	@Query("SELECT new com.example.demo.model.ListStudent("
			+ "s1.studentId, "
			+ "s1.studentCode, "
			+ "s1.studentName, "
			+ "s2.dateOfBirth, "
			+ "s2.address, "
			+ "s2.averageScore) "	
			+ "FROM Student s1, StudentInfo s2 "
			+ "WHERE s1.studentId = s2.studentIdentity.studentId AND s1.studentCode LIKE %?1% AND s1.studentName LIKE %?2%"
			)
	public List<ListStudent> searchListStudentByCodeAndName(String studentCode, String studentName);
	
	@Query("SELECT new com.example.demo.model.ListStudent("
			+ "s1.studentId, "
			+ "s1.studentCode, "
			+ "s1.studentName, "
			+ "s2.dateOfBirth, "
			+ "s2.address, "
			+ "s2.averageScore) "	
			+ "FROM Student s1, StudentInfo s2 "
			+ "WHERE s2.studentIdentity.studentId = s1.studentId"
			)
	public List<ListStudent> findAllListStudent();
	
	@Query("SELECT new com.example.demo.model.ListStudent("
			+ "s1.studentId, "
			+ "s1.studentCode, "
			+ "s1.studentName, "
			+ "s2.dateOfBirth, "
			+ "s2.address, "
			+ "s2.averageScore) "	
			+ "FROM Student s1, StudentInfo s2 "
			+ "WHERE s2.studentIdentity.studentId = s1.studentId AND s1.studentId = ?1"
			)
	public ListStudent findListStudentById(int studentId);
	
	@Modifying
	@Query(
		value = "insert into student (student_code, student_name) values (?1, ?2)"
		,nativeQuery = true)
	public void addStudent(String code, String name);
	
	@Modifying
	@Query(
	  value = "insert into student_info values ((select student_id from student order by student_id desc limit 1), (select student_id from student order by student_id desc limit 1), ?1, ?2, ?3)",
	  nativeQuery = true)
		public void addStudentInfo(String address, double averageScore, LocalDate dateOfBirth);
}
