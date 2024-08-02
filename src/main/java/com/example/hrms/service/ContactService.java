package com.example.hrms.service;

import com.example.hrms.model.Contact;
import com.example.hrms.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public <S extends Contact> S save(S entity) {
        return contactRepository.save(entity);
    }

    public Optional<Contact> findById(Integer integer) {
        return contactRepository.findById(integer);
    }

    public void deleteById(Integer integer) {
        contactRepository.deleteById(integer);
    }
}