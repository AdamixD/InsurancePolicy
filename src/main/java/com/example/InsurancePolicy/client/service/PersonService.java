package com.example.InsurancePolicy.client.service;

import com.example.InsurancePolicy.client.dto.PersonDTO;
import com.example.InsurancePolicy.client.entity.Person;
import com.example.InsurancePolicy.client.mapper.PersonMapper;
import com.example.InsurancePolicy.client.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> getAllPersons() {
        return personMapper.toDto(personRepository.findAll());
    }

    public PersonDTO getPersonById(Long id) {
        return personMapper.toDto(personRepository.findById(id).orElse(null));
    }

    public Person addPerson(PersonDTO client) {
        return personRepository.save(personMapper.toEntity(client));
    }

    public Person updatePersonById(Long id, PersonDTO personDTO) {
        Person oldPerson = personRepository.getById(id);
        personMapper.updateEntity(oldPerson, personDTO);

        return personRepository.save(oldPerson);
    }

    public Long deletePersonById(Long id) {
        personRepository.deleteById(id);

        return id;
    }
}
