package com.example.InsurancePolicy.client.mapper.service;

import com.example.InsurancePolicy.client.entity.Person;
import com.example.InsurancePolicy.client.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonMapperService {
    private final PersonRepository personRepository;

    public List<Person> getPersonsByIds(List<Long> personsIds) {
        return personRepository.findAllById(personsIds);
    }

    public List<Long> getPersonsId(List<Person> personList) {
        return personList.stream().map(Person::getId).collect(Collectors.toList());
    }
}
