package com.mindcurv.miniproject.model;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
@IdClass(value = DepartmentIds.class)
public class Department {

    @Column
    @Id
    private Integer departmentId;
    @Column
    private String departmentName;
    @Column
    private Integer vacancy;
    @Column(insertable = false, updatable = false)
    @Id
    private Integer collegeId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }
}
