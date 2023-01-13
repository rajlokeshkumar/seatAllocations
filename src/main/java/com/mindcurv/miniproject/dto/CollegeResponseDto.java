package com.mindcurv.miniproject.dto;
import java.util.List;

public class CollegeResponseDto {
    private Integer collegeId;
    private String collegeName;
    private String location;
    private List<DepartmentDto> departmentList;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<DepartmentDto> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DepartmentDto> departmentList) {
        this.departmentList = departmentList;
    }
}
