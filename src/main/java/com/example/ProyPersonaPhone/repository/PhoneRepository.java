package com.example.ProyPersonaPhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProyPersonaPhone.model.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
