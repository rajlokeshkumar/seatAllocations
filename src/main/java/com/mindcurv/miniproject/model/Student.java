package com.mindcurv.miniproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Column
    @Id
    private Integer rollNo;
    @Column
    private String studentName;
    @Column
    private String allocatedCollege;
    @Column
    private String allocatedDepartment;
    @Column
    private boolean isAvailable;

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAllocatedCollege() {
        return allocatedCollege;
    }

    public void setAllocatedCollege(String allocatedCollege) {
        this.allocatedCollege = allocatedCollege;
    }

    public String getAllocatedDepartment() {
        return allocatedDepartment;
    }

    public void setAllocatedDepartment(String allocatedDepartment) {
        this.allocatedDepartment = allocatedDepartment;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
