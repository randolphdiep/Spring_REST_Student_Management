package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentIdentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "info_id")
    private Integer infoId;
	@Column(name = "student_id")
    private Integer studentId;

    public StudentIdentity() {}

    public StudentIdentity(Integer infoId, Integer studentId) {
    	this.infoId = infoId;
        this.studentId = studentId;
    }

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentIdentity that = (StudentIdentity) o;
        
        if (!(infoId == that.infoId)) return false;
        return studentId == that.studentId;
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(infoId, studentId);
    }
}
