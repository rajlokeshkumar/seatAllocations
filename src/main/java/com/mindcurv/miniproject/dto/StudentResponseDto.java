package com.mindcurv.miniproject.dto;

public class StudentResponseDto {

    private Integer rollNo;

    private String studentName;

    private String allocatedCollege;

    private String allocatedDepartment;

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
}
