package com.example.hrms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE_PROFILES")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
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

    public void setEmployeePhoto(Photo employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }
}
