package com.mindcurv.miniproject.studentserviceimpl;

import com.mindcurv.miniproject.dto.AllocationRequestDto;
import com.mindcurv.miniproject.dto.StudentAllocationRequestDto;
import com.mindcurv.miniproject.model.College;
import com.mindcurv.miniproject.model.Department;
import com.mindcurv.miniproject.model.DepartmentIds;
import com.mindcurv.miniproject.model.Student;
import com.mindcurv.miniproject.repository.CollegeRepository;
import com.mindcurv.miniproject.repository.DepartmentRepository;
import com.mindcurv.miniproject.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    public CollegeRepository collegeRepository;

    @Autowired
    public StudentRepository studentRepository;


    @Autowired
    public DepartmentRepository departmentRepository;

    @Test
    void fetchCollegeVacancyDetails() {
        List<College> colleges = (List<College>) collegeRepository.findAll();
       // Assert.notEmpty(colleges, "No colleges preset kindly load the data ");
        Assertions.assertFalse(colleges.isEmpty(),"No colleges preset kindly load the data ");
    }


    @Test
    void selectDepartment() {
        StudentAllocationRequestDto aStudentAllocationRequestDto = new StudentAllocationRequestDto();
        aStudentAllocationRequestDto.setStudentName("test");
        aStudentAllocationRequestDto.setRollNo(1);
        AllocationRequestDto aAllocationRequestDto = new AllocationRequestDto();
        aAllocationRequestDto.setCollegeid(1);
        aAllocationRequestDto.setDepartmentid(1);
        aStudentAllocationRequestDto.getAllocationRequestDtos().add(aAllocationRequestDto);
        Optional<Student> studentdetail = this.studentRepository.findById(aStudentAllocationRequestDto.getRollNo());
        //Assert.isTrue(studentdetail.isPresent(), "Rollnumber not present");
        Assertions.assertTrue(studentdetail.isPresent(), "Rollnumber not present");

    }

    @Test
    void preferredCollegeTest() {
        StudentAllocationRequestDto aStudentAllocationRequestDto = new StudentAllocationRequestDto();
        aStudentAllocationRequestDto.setStudentName("test");
        aStudentAllocationRequestDto.setRollNo(1);
        AllocationRequestDto aAllocationRequestDto = new AllocationRequestDto();
        aAllocationRequestDto.setCollegeid(1);
        aAllocationRequestDto.setDepartmentid(1);
        aStudentAllocationRequestDto.getAllocationRequestDtos().add(aAllocationRequestDto);
        DepartmentIds aDepartmentIds = new DepartmentIds();
        aDepartmentIds.setCollegeId(aAllocationRequestDto.getCollegeid());
        aDepartmentIds.setDepartmentId(aAllocationRequestDto.getDepartmentid());
        Optional<Department> aDepartment = this.departmentRepository.findById(aDepartmentIds);
        Integer initialVacancy = aDepartment.get().getVacancy();
        aDepartment.get().setVacancy(aDepartment.get().getVacancy() - 1);
        Department aNewDepartment = departmentRepository.save(aDepartment.get());
        Assertions.assertTrue(initialVacancy > aNewDepartment.getVacancy(), "vaccany information not updated");
      //  Assert.isTrue(initialVacancy > aNewDepartment.getVacancy(), "vaccany information not updated");
    }
}