package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.ClientDTO;
import com.example.InsurancePolicy.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/client/")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("all")
    public ResponseEntity<?> getAllClients(){
        try{
            return ResponseEntity.ok().body(clientService.getAllClients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getClient(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(clientService.getClientById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> getClient(@RequestBody ClientDTO client){
        try{
            return ResponseEntity.ok().body(clientService.addClient(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(value="id") Long id, @RequestBody ClientDTO client){
        try{
            return ResponseEntity.ok().body(clientService.updateClientById(id, client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(clientService.deleteClientById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
