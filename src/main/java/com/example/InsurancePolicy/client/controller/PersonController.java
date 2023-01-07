package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.PersonDTO;
import com.example.InsurancePolicy.client.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/person/")
public class PersonController {
    private final PersonService personService;

    @GetMapping("all")
    public ResponseEntity<?> getAllPersons(){
        try{
            return ResponseEntity.ok().body(personService.getAllPersons());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPerson(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(personService.getPersonById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addPerson(@RequestBody PersonDTO person){
        try{
            return ResponseEntity.ok().body(personService.addPerson(person));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable(value="id") Long id, @RequestBody PersonDTO person){
        try{
            return ResponseEntity.ok().body(personService.updatePersonById(id, person));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(personService.deletePersonById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
