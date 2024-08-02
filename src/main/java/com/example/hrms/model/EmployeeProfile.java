package com.example.hrms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String employeeName;

    @OneToOne
    private Photo employeePhoto;

    @OneToOne
    private Contact contactInfo;

    public EmployeeProfile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Photo getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(Photo employeePhotoID) {
        this.employeePhoto = employeePhotoID;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfoID) {
        this.contactInfo = contactInfoID;
    }
}
