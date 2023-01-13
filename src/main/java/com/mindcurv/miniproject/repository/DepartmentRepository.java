package com.mindcurv.miniproject.repository;

import com.mindcurv.miniproject.model.Department;
import com.mindcurv.miniproject.model.DepartmentIds;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, DepartmentIds> {
}
