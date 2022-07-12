package com.example.demo.model;

import java.time.LocalDate;

public class ListStudent {

	private int studentId;
	private String studentCode;
	private String studentName;
	private LocalDate dateOfBirth;
	private String address;
	private double averageScore;

	public ListStudent(int studentId, String studentCode, String studentName, LocalDate dateOfBirth, String address, double averageScore) {
		super();
		this.studentId = studentId;
		this.studentCode = studentCode;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.averageScore = averageScore;
	}
	
	
	@Override
	public String toString() {
		return "ListStudent [code= " + studentCode + "name= " + studentName + " birthday= " + dateOfBirth + "address=" + address+ "score="+ averageScore +"]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
}

