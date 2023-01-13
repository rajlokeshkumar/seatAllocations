package com.mindcurv.miniproject.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentAllocationRequestDto {
    private Integer rollNo;

    private String studentName;

    private List<AllocationRequestDto> allocationRequestDtos = new ArrayList<>();


    public Integer getRollNo() {
        return rollNo;
    }

    public List<AllocationRequestDto> getAllocationRequestDtos() {
        return allocationRequestDtos;
    }

    public void setAllocationRequestDtos(List<AllocationRequestDto> allocationRequestDtos) {
        this.allocationRequestDtos = allocationRequestDtos;
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
}
