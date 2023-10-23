package com.example.trusty.Dtos.TransFormer;

import com.example.trusty.Dtos.RequestDtos.CarRequestDto;
import com.example.trusty.Dtos.ResponseDto.CarResponseDto;
import com.example.trusty.Model.CarEntity;

public class CarTransformer {
    public static CarEntity buildCarEntity(CarRequestDto carRequestDto){
        return CarEntity.builder()
                .carName(carRequestDto.getCarName())
                .carNumber(carRequestDto.getCarNumber())
                .makeModel(carRequestDto.getMakeModel())
                .build();
    }

    public static CarResponseDto transformToCarResponseDto(CarEntity carEntity) {
        return CarResponseDto.builder().carName(carEntity.getCarName())
                .carNumber(carEntity.getCarNumber())
                .makeModel(carEntity.getMakeModel())
                .id(carEntity.getId())
                .booked(false)
                .build();
    }
}
