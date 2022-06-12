package com.arun.studentapp.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.studentapp.model.StudentDeatilsDto;
import com.arun.studentapp.model.StudentRepository;

@Service
public class StudentAppService {

	@Autowired
	StudentRepository studentRespository;

	public Integer idFinder(StudentDeatilsDto studentDeatilsDto) {
		StudentDeatilsDto studentDeatilsDtoResponse = new StudentDeatilsDto();
		List<StudentDeatilsDto> studentList = (List<StudentDeatilsDto>) studentRespository.findAll();
		studentList.parallelStream().forEach(obj -> {
			if (obj.getUserName().equals(studentDeatilsDto.getUserName())) {
				studentDeatilsDtoResponse.setId(obj.getId());

			}
		});

		return studentDeatilsDtoResponse.getId();

	}
	

	public StudentDeatilsDto loginService(StudentDeatilsDto studentDeatilsDto) {

		Integer id = idFinder(studentDeatilsDto);
		StudentDeatilsDto loginResponse = new StudentDeatilsDto();
		StudentDeatilsDto loginDbDetails = new StudentDeatilsDto();
		if (id != 0) {
			loginDbDetails = studentRespository.findById(id).get();
			if (loginDbDetails.getPassword().equals(studentDeatilsDto.getPassword())) {
				loginResponse = loginDbDetails;
			} else {
				loginResponse.setError("Password Mismatch. Check Again !!");
			}

		} else {
			loginResponse.setError("Username / Password Mismatch. Check Again !!");
		}

		return loginResponse;
	}

	public boolean signUpService(StudentDeatilsDto studentDeatilsDto) {
		Integer id = idFinder(studentDeatilsDto);
		if (id != 0) {
			return false;

		} else {
			studentRespository.save(studentDeatilsDto);
			return true;
		}

	}

	public boolean updateService(StudentDeatilsDto studentDeatilsDto) {
			studentRespository.save(studentDeatilsDto);
			return true;
	}

	public boolean deleteService(StudentDeatilsDto studentDeatilsDto) {

		studentRespository.deleteById(studentDeatilsDto.getId());

		return true;
	}

}
