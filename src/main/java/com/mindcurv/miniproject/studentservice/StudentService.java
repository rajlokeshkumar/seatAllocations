package com.mindcurv.miniproject.studentservice;

import com.mindcurv.miniproject.dto.CollegeResponseDto;
import com.mindcurv.miniproject.dto.StudentAllocationRequestDto;
import com.mindcurv.miniproject.dto.StudentResponseDto;
import com.mindcurv.miniproject.exception.AllocationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {


    public List<CollegeResponseDto> fetchCollegeVacancyDetails();

    public StudentResponseDto getStudentDetails(int rollno) throws AllocationException;

    public StudentResponseDto selectDepartment(StudentAllocationRequestDto studentRequestDto) throws AllocationException;
}
