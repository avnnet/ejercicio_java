package com.example.ProyPersonaPhone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyPersonaPhone.model.Persona;
import com.example.ProyPersonaPhone.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Long id, Persona updatedPersona) {
        Optional<Persona> existingPersona = personaRepository.findById(id);
        if (existingPersona.isPresent()) {
            Persona persona = existingPersona.get();
            persona.setName(updatedPersona.getName());
            persona.setEmail(updatedPersona.getEmail());
            persona.setPassword(updatedPersona.getPassword());
            persona.setPhones(updatedPersona.getPhones());
            return personaRepository.save(persona);
        }
        return null;
    }

    public boolean deletePersona(Long id) {
        Optional<Persona> existingPersona = personaRepository.findById(id);
        if (existingPersona.isPresent()) {
            personaRepository.delete(existingPersona.get());
            return true;
        }
        return false;
    }
}