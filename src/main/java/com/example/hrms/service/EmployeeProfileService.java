package com.example.hrms.service;

import com.example.hrms.model.Contact;
import com.example.hrms.model.EmployeeProfile;
import com.example.hrms.model.Photo;
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

    public EmployeeProfile save(String name, Photo employeePhoto, Contact contactInfo) {
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setEmployeeName(name);
        employeeProfile.setEmployeePhoto(employeePhoto);
        employeeProfile.setContactInfo(contactInfo);
        employeeProfileRepository.save(employeeProfile);
        return employeeProfile;
    }


    public long count() {
        return employeeProfileRepository.count();
    }

}
