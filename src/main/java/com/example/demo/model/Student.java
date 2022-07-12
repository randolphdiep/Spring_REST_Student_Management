package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private int studentId;
	@Column(name = "student_name", nullable = false, length = 20)
	private String studentName;
	@Column(name = "student_code", nullable = false, length = 10)
	private String studentCode;
	
	public Student() {}
	
	public Student(int studentId ,String studentCode,String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}
	
	public Student(String studentCode, String studentName) {
		super();
		this.studentName = studentName;
		this.studentCode = studentCode;
	}

    public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	@Override
    public String toString() {
        return "Student [id= " + studentId + " student_name= "+ studentName + " student_code= " + studentCode + "]";
    }
}