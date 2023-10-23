package com.example.trusty.controller;

import com.example.trusty.Dtos.RequestDtos.CarRequestDto;
import com.example.trusty.Dtos.ResponseDto.CarResponseDto;
import com.example.trusty.service.Implementation.CarsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarsController {

    @Autowired
    CarsServiceImplementation carsServiceImplementation;

    @PostMapping("/add-car/{OwnerId}")
    public ResponseEntity<?> AddCard(@RequestBody CarRequestDto car , @PathVariable Long OwnerId){

        CarResponseDto carResponseDto = carsServiceImplementation.addCar(car,OwnerId);
        if(carResponseDto == null){
            return new ResponseEntity<>("Car with the same number already exists", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(carResponseDto, HttpStatus.CREATED);
    }

}
