package com.example.InsurancePolicy.client.controller;

import com.example.InsurancePolicy.client.dto.CarModelDTO;
import com.example.InsurancePolicy.client.service.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "app/car_model/")
public class CarModelController {
    private final CarModelService carModelService;

    @GetMapping("all")
    public ResponseEntity<?> getAllCarModels(){
        try{
            return ResponseEntity.ok().body(carModelService.getAllCarModels());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCarModel(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(carModelService.getCarModelById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> addCarModel(@RequestBody CarModelDTO carModel){
        try{
            return ResponseEntity.ok().body(carModelService.addCarModel(carModel));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCarModel(@PathVariable(value="id") Long id, @RequestBody CarModelDTO carModel){
        try{
            return ResponseEntity.ok().body(carModelService.updateCarModelById(id, carModel));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCarModel(@PathVariable(value="id") Long id){
        try{
            return ResponseEntity.ok().body(carModelService.deleteCarModelById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
