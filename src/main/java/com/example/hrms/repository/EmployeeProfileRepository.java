package com.example.hrms.repository;

import com.example.hrms.model.EmployeeProfile;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeProfileRepository extends CrudRepository<EmployeeProfile, Integer> {
}
