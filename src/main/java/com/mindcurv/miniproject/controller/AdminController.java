package com.mindcurv.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindcurv.miniproject.exception.AllocationException;
import com.mindcurv.miniproject.studentservice.StudentService;

@RestController
public class AdminController {


    @Autowired
    public StudentService studentService;

    @GetMapping("/getAdminInfo")
    @ResponseBody
    public ResponseEntity<String> getAdminInfo() throws AllocationException {
        //StudentResponseDto aStudentResponseDto = studentService.getStudentDetails(rollno);
        return new ResponseEntity<>("Hello I am admin", HttpStatus.OK);
    }
	
}
