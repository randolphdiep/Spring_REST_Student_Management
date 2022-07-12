package com.example.demo.model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFO")
public class StudentInfo {
	
    @EmbeddedId
    private StudentIdentity studentIdentity;
    
	private String address;
	@Column(name = "average_score")
	private double averageScore;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth = null;
	
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
	
	public StudentInfo() {}

	public StudentInfo(StudentIdentity studentIdentity, String address, double averageScore, LocalDate dateOfBirth) {
		super();
		this.studentIdentity = studentIdentity;
		this.address = address;
		this.averageScore = averageScore;
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

	public StudentIdentity getStudentIdentity() {
		return studentIdentity;
	}

	public void setStudentIdentity(StudentIdentity studentIdentity) {
		this.studentIdentity = studentIdentity;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
    public String toString() {
        return "StudentInfo [id= " + studentIdentity.getStudentId() + " id= "+ studentIdentity.getInfoId() + " address " + address + "AScore" + averageScore + "date"+ dateOfBirth.toString() + "]";
    }
}