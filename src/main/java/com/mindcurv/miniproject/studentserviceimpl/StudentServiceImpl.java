package com.mindcurv.miniproject.studentserviceimpl;

import com.mindcurv.miniproject.dto.*;
import com.mindcurv.miniproject.exception.AllocationException;
import com.mindcurv.miniproject.studentservice.StudentService;
import com.mindcurv.miniproject.model.College;
import com.mindcurv.miniproject.model.Department;
import com.mindcurv.miniproject.model.DepartmentIds;
import com.mindcurv.miniproject.model.Student;
import com.mindcurv.miniproject.repository.CollegeRepository;
import com.mindcurv.miniproject.repository.DepartmentRepository;
import com.mindcurv.miniproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public CollegeRepository collegeRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public List<CollegeResponseDto> fetchCollegeVacancyDetails() {

        List<CollegeResponseDto> aListCollegeResponseDtos = new ArrayList<>();
        List<College> fetchDetails = (List<College>) collegeRepository.findAll();
        for (College aCollege : fetchDetails) {
            CollegeResponseDto aCollegeResponseDto = new CollegeResponseDto();
            aCollegeResponseDto.setCollegeId(aCollege.getCollegeId());
            aCollegeResponseDto.setCollegeName(aCollege.getCollegeName());
            aCollegeResponseDto.setLocation(aCollege.getLocation());
            List<DepartmentDto> aDepartmentDtos = new ArrayList<>();
            for (Department aDepartment : aCollege.getDepartmentList()) {
                DepartmentDto aDepartmentDto = new DepartmentDto();
                aDepartmentDto.setVacancy(aDepartment.getVacancy());
                aDepartmentDto.setDepartmentId(aDepartment.getDepartmentId());
                aDepartmentDto.setDepartmentName(aDepartment.getDepartmentName());
                aDepartmentDtos.add(aDepartmentDto);
            }
            aCollegeResponseDto.setDepartmentList(aDepartmentDtos);
            aListCollegeResponseDtos.add(aCollegeResponseDto);
        }
        return aListCollegeResponseDtos;

    }

    @Override
    public StudentResponseDto getStudentDetails(int rollNo) throws AllocationException {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Optional<Student> studentDetail = studentRepository.findById(rollNo);
        if (studentDetail.isPresent()) {
            studentResponseDto.setStudentName(studentDetail.get().getStudentName());
            studentResponseDto.setRollNo(studentDetail.get().getRollNo());
            studentResponseDto.setAllocatedCollege(studentDetail.get().getAllocatedCollege());
            studentResponseDto.setAllocatedDepartment(studentDetail.get().getAllocatedDepartment());
        } else {
            throw new AllocationException("students not found in the database");
        }

        return studentResponseDto;
    }

    @Override
    public StudentResponseDto selectDepartment(StudentAllocationRequestDto studentAllocationRequestDto) throws AllocationException {
        StudentResponseDto studentResponseDto;
        Optional<Student> studentdetail = this.studentRepository.findById(studentAllocationRequestDto.getRollNo());
        if (studentdetail.isPresent()) {
            if (studentdetail.get().isAvailable()) {
                studentAllocationRequestDto.setStudentName(studentdetail.get().getStudentName());
                studentResponseDto = preferredCollege(studentAllocationRequestDto);
                if (studentResponseDto.getAllocatedCollege() != null) {
                    studentdetail.get().setAvailable(false);
                    studentdetail.get().setAllocatedDepartment(studentResponseDto.getAllocatedDepartment());
                    studentdetail.get().setAllocatedCollege(studentResponseDto.getAllocatedCollege());
                    this.studentRepository.save(studentdetail.get());
                }
            } else {
                throw new AllocationException("Already allocated seat for this students");
            }
        } else {
            throw new AllocationException("students not found in the database");
        }
        return studentResponseDto;
    }

    public StudentResponseDto preferredCollege(StudentAllocationRequestDto studentAllocationRequestDto) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        for (AllocationRequestDto aAllocationRequestDto : studentAllocationRequestDto.getAllocationRequestDtos()) {
            DepartmentIds aDepartmentIds = new DepartmentIds();
            aDepartmentIds.setCollegeId(aAllocationRequestDto.getCollegeid());
            aDepartmentIds.setDepartmentId(aAllocationRequestDto.getDepartmentid());
            Optional<Department> aDepartment = this.departmentRepository.findById(aDepartmentIds);
            if (aDepartment.isPresent() && aDepartment.get().getVacancy() > 0) {
                studentResponseDto.setRollNo(studentAllocationRequestDto.getRollNo());
                studentResponseDto.setStudentName(studentAllocationRequestDto.getStudentName());
                studentResponseDto.setAllocatedDepartment(aDepartment.get().getDepartmentName());
                studentResponseDto.setAllocatedCollege(aDepartment.get().getCollegeId().toString());
                aDepartment.get().setVacancy(aDepartment.get().getVacancy() - 1);
                this.departmentRepository.save(aDepartment.get());
                //sending message 
                RestTemplate aRestTemplate=new RestTemplate();
                ResponseEntity<String> message=aRestTemplate.exchange("https://api.authkey.io/request?authkey=c3cdb36d16a26263&mobile=231321&country_code=44&sid=6306",HttpMethod.GET, null, String.class);
                System.out.println(message.getBody());
                break;

            }
        }
        return studentResponseDto;
    }


}




