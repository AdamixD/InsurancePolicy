package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.AccidentDTO;
import com.example.InsurancePolicy.client.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/accident/")
public class AccidentController {
    private final AccidentService accidentService;

    @GetMapping("all")
    public ResponseEntity<?> getAllAccidents(){
        try{
            return ResponseEntity.ok().body(accidentService.getAllAccidents());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAccident(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(accidentService.getAccidentById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addAccident(@RequestBody AccidentDTO accident){
        try{
            return ResponseEntity.ok().body(accidentService.addAccident(accident));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAccident(@PathVariable(value="id") Long id, @RequestBody AccidentDTO accident){
        try{
            return ResponseEntity.ok().body(accidentService.updateAccidentById(id, accident));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAccident(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(accidentService.deleteAccidentById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
