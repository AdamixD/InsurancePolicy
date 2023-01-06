package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.AccidentParticipantDTO;
import com.example.InsurancePolicy.client.service.AccidentParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/accident_participant/")
public class AccidentParticipantController {
    private final AccidentParticipantService accidentParticipantService;

    @GetMapping("all")
    public ResponseEntity<?> getAllAccidentParticipants(){
        try{
            return ResponseEntity.ok().body(accidentParticipantService.getAllAccidentParticipants());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAccidentParticipant(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(accidentParticipantService.getAccidentParticipantById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addAccidentParticipant(@RequestBody AccidentParticipantDTO accidentParticipant){
        try{
            return ResponseEntity.ok().body(accidentParticipantService.addAccidentParticipant(accidentParticipant));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAccidentParticipant(@PathVariable(value="id") Long id, @RequestBody AccidentParticipantDTO accidentParticipant){
        try{
            return ResponseEntity.ok().body(accidentParticipantService.updateAccidentParticipantById(id, accidentParticipant));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAccidentParticipant(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(accidentParticipantService.deleteAccidentParticipantById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
