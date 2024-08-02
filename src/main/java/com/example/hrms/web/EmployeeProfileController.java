package com.example.hrms.web;

import com.example.hrms.model.EmployeeProfile;
import com.example.hrms.service.EmployeeProfileService;
import com.example.hrms.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class EmployeeProfileController {

    private final EmployeeProfileService employeeProfileService;

    public EmployeeProfileController(EmployeeProfileService employeeProfileService, PhotosService photosService) {
        this.employeeProfileService = employeeProfileService;
    }

    @GetMapping("/employees")
    public Iterable<EmployeeProfile> get() {
        return employeeProfileService.get();
    }

    @GetMapping("/employees/{id}")
    public EmployeeProfile get(@PathVariable Integer id) {
        EmployeeProfile employeeProfile = employeeProfileService.get(id);
        if (employeeProfile == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return employeeProfile;
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Integer id) {
        employeeProfileService.remove(id);
    }

    @PostMapping("/employees")
    public EmployeeProfile create(@RequestBody EmployeeProfile employeeProfile) throws IOException {
        return employeeProfileService.save(
                employeeProfile.getEmployeeName(),
                employeeProfile.getEmployeePhoto(),
                employeeProfile.getContactInfo()
        );
    }

}
