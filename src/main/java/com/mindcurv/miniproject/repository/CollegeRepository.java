package com.mindcurv.miniproject.repository;

import com.mindcurv.miniproject.model.College;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CollegeRepository extends CrudRepository<College, Integer> {

}
