package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.AddressHistoryDTO;
import com.example.InsurancePolicy.client.service.AddressHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/address_history/")
public class AddressHistoryController {
    private final AddressHistoryService addressHistoryService;

    @GetMapping("all")
    public ResponseEntity<?> getAllAddresses(){
        try{
            return ResponseEntity.ok().body(addressHistoryService.getAllAddressesHistory());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAddress(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(addressHistoryService.getAddressHistoryById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addAddress(@RequestBody AddressHistoryDTO address){
        try{
            return ResponseEntity.ok().body(addressHistoryService.addAddressHistory(address));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable(value="id") Long id, @RequestBody AddressHistoryDTO address){
        try{
            return ResponseEntity.ok().body(addressHistoryService.updateAddressHistoryById(id, address));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(addressHistoryService.deleteAddressHistoryById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
