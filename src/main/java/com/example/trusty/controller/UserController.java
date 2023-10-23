package com.example.trusty.controller;

import com.example.trusty.Dtos.RequestDtos.OwnerDto;
import com.example.trusty.Dtos.ResponseDto.OwnerResponseDto;
import com.example.trusty.service.Implementation.OwnerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    OwnerServiceImplementation ownerServiceImplementation;

    @GetMapping("/hello")
    public ResponseEntity<String> HelloWorld() {
        return new ResponseEntity<>("Done", HttpStatus.CREATED);
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> AddUser(@RequestBody OwnerDto owner){
//        Check Owner Already Exist or not
       boolean isOwnerFound = ownerServiceImplementation.checkOwner(owner.getOwnerPhone());
//        Add Owner to repo
        if(isOwnerFound){
            return new ResponseEntity<>(0, HttpStatus.CONFLICT);
        }
        OwnerResponseDto ownerResponseDto = ownerServiceImplementation.addOwner(owner);

        return new ResponseEntity<>(ownerResponseDto.getId(), HttpStatus.CREATED);
    }

}