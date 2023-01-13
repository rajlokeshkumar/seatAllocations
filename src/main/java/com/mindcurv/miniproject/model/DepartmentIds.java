package com.mindcurv.miniproject.model;

import java.io.Serializable;

public class DepartmentIds implements Serializable {
    private Integer collegeId;
    private Integer departmentId;


    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
