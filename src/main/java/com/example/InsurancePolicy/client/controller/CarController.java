package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.CarDTO;
import com.example.InsurancePolicy.client.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/car/")
public class CarController {
    private final CarService carService;

    @GetMapping("all")
    public ResponseEntity<?> getAllCars(){
        try{
            return ResponseEntity.ok().body(carService.getAllCars());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCar(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(carService.getCarById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addCar(@RequestBody CarDTO car){
        try{
            return ResponseEntity.ok().body(carService.addCar(car));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable(value="id") Long id, @RequestBody CarDTO car){
        try{
            return ResponseEntity.ok().body(carService.updateCarById(id, car));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(carService.deleteCarById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
