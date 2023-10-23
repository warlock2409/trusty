package com.example.trusty.service.interfaces;


import com.example.trusty.Dtos.RequestDtos.CarRequestDto;
import com.example.trusty.Dtos.ResponseDto.CarResponseDto;

public interface CarsServiceInterface {
    CarResponseDto addCar(CarRequestDto car, Long ownerId);
}
