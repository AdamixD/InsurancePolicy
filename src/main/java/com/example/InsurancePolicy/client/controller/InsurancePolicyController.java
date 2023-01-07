package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.InsurancePolicyDTO;
import com.example.InsurancePolicy.client.service.InsurancePolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/insurance_policy/")
public class InsurancePolicyController {
    private final InsurancePolicyService insurancePolicyService;

    @GetMapping("all")
    public ResponseEntity<?> getAllInsurancePolicys(){
        try{
            return ResponseEntity.ok().body(insurancePolicyService.getAllInsurancePolicies());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getInsurancePolicy(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(insurancePolicyService.getInsurancePolicyById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addInsurancePolicy(@RequestBody InsurancePolicyDTO insurancePolicy){
        try{
            return ResponseEntity.ok().body(insurancePolicyService.addInsurancePolicy(insurancePolicy));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateInsurancePolicy(@PathVariable(value="id") Long id, @RequestBody InsurancePolicyDTO insurancePolicy){
        try{
            return ResponseEntity.ok().body(insurancePolicyService.updateInsurancePolicyById(id, insurancePolicy));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteInsurancePolicy(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(insurancePolicyService.deleteInsurancePolicyById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
