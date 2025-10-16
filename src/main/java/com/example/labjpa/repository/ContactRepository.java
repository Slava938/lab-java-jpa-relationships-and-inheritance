package com.example.labjpa.repository;

import com.example.labjpa.entity.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}
