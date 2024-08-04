package com.example.hrms.service;

import com.example.hrms.model.EmployeeProfile;
import com.example.hrms.repository.EmployeeProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProfileService {

    private final EmployeeProfileRepository employeeProfileRepository;

    public EmployeeProfileService(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }

    public Iterable<EmployeeProfile> get() {
        return employeeProfileRepository.findAll();
    }

    public EmployeeProfile get(Integer id) {
        return employeeProfileRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        employeeProfileRepository.deleteById(id);
    }

    public EmployeeProfile save(EmployeeProfile employeeProfile) {
        return employeeProfileRepository.save(employeeProfile);
    }

    public long count() {
        return employeeProfileRepository.count();
    }

}
