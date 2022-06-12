package com.arun.studentapp.model;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentDeatilsDto, Integer>  {

}
