package com.arun.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.studentapp.model.StudentDeatilsDto;
import com.arun.studentapp.service.StudentAppService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAppController {
	@Autowired
	StudentAppService studentAppService;

	@PostMapping("/login")
	public StudentDeatilsDto loginController(@RequestBody StudentDeatilsDto studentDeatilsDto) {

		return studentAppService.loginService(studentDeatilsDto);

	}

	@PostMapping("/signup")
	public boolean setStudentDeatils(@RequestBody StudentDeatilsDto studentDeatilsDto) {

		return studentAppService.signUpService(studentDeatilsDto);

	}
	
	@PostMapping("/delete")
	public boolean deleteStudentDeatils(@RequestBody StudentDeatilsDto studentDeatilsDto) {

		return studentAppService.deleteService(studentDeatilsDto);

	}
	@PostMapping("/update")
	public boolean updateStudentDeatils(@RequestBody StudentDeatilsDto studentDeatilsDto) {

		return studentAppService.updateService(studentDeatilsDto);

	}
}
