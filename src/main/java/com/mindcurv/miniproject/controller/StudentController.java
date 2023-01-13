package com.mindcurv.miniproject.controller;

import com.mindcurv.miniproject.dto.CollegeResponseDto;
import com.mindcurv.miniproject.dto.StudentAllocationRequestDto;
import com.mindcurv.miniproject.dto.StudentResponseDto;
import com.mindcurv.miniproject.exception.AllocationException;
import com.mindcurv.miniproject.studentservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/getStudentDetails/{rollno}")
    @ResponseBody
    public ResponseEntity<StudentResponseDto> getStudentDetails(@PathVariable("rollno") int rollno) throws AllocationException {
        StudentResponseDto aStudentResponseDto = studentService.getStudentDetails(rollno);
        return new ResponseEntity<>(aStudentResponseDto, HttpStatus.OK);
    }

    @GetMapping("/fetchCollegeVacancyDetails")
    @ResponseBody
    public ResponseEntity<List<CollegeResponseDto>> fetchCollegeVacancyDetails() {
        List<CollegeResponseDto> aCollegeResponseDtos = studentService.fetchCollegeVacancyDetails();
        return new ResponseEntity<>(aCollegeResponseDtos, HttpStatus.OK);
    }

    @PutMapping("/selectDepartment")
    @ResponseBody
    public ResponseEntity<StudentResponseDto> selectDepartment(@RequestBody StudentAllocationRequestDto studentAllocationRequestDto) throws AllocationException {
        StudentResponseDto aStudentResponseDto1 = studentService.selectDepartment(studentAllocationRequestDto);
        return new ResponseEntity<>(aStudentResponseDto1, HttpStatus.OK);
    }
}
