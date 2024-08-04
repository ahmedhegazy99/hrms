package com.example.hrms.web;

import com.example.hrms.model.Contact;
import com.example.hrms.model.EmployeeProfile;
import com.example.hrms.service.ContactService;
import com.example.hrms.service.EmployeeProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class EmployeeProfileController {

    private final EmployeeProfileService employeeProfileService;
    private final PhotosController photosController;
    private final ContactService contactService;

    public EmployeeProfileController(EmployeeProfileService employeeProfileService, PhotosController photosController, ContactService contactService) {
        this.employeeProfileService = employeeProfileService;
        this.photosController = photosController;
        this.contactService = contactService;
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
    public EmployeeProfile create(
            @RequestPart("name") String name,
            @ModelAttribute Contact contact,
            @RequestPart("data") MultipartFile file
    ) throws IOException {
        final EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setEmployeeName(name);
        employeeProfile.setEmployeePhoto(photosController.create(file));
        employeeProfile.setContactInfo(contactService.save(contact));
        return employeeProfileService.save(employeeProfile);
    }

    @PutMapping("/employees/{id}")
    public Contact updateContact(
            @PathVariable("id") Integer id,
            @ModelAttribute Contact updContact
    ) throws IOException {
        final EmployeeProfile employeeProfile = employeeProfileService.get(id);
        final Contact contact = employeeProfile.getContactInfo();
        if (updContact.getPhone() != null) contact.setPhone(updContact.getPhone());
        if (updContact.getEmail() != null) contact.setEmail(updContact.getEmail());
        if (updContact.getAddress() != null) contact.setAddress(updContact.getAddress());
        return contactService.save(contact);
    }

    @GetMapping("/employees/count")
    public String count() {
        return "No. of Employees : " + employeeProfileService.count();
    }

}
