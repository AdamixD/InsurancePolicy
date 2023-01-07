package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.AddressDTO;
import com.example.InsurancePolicy.client.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/address/")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("all")
    public ResponseEntity<?> getAllAddresses(){
        try{
            return ResponseEntity.ok().body(addressService.getAllAddresses());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAddress(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(addressService.getAddressById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO address){
        try{
            return ResponseEntity.ok().body(addressService.addAddress(address));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable(value="id") Long id, @RequestBody AddressDTO address){
        try{
            return ResponseEntity.ok().body(addressService.updateAddressById(id, address));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(addressService.deleteAddressById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
