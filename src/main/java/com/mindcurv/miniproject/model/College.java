package com.mindcurv.miniproject.model;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "COLLEGE")

public class College {
    @Column
    @Id
    private Integer collegeId;
    @Column
    private String collegeName;
    @Column
    private String location;

    @OneToMany
    @JoinColumn(name = "collegeId", nullable = false)
    private List<Department> departmentList;

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

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
