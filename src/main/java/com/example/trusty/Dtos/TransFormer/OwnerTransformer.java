package com.example.trusty.Dtos.TransFormer;

import com.example.trusty.Dtos.RequestDtos.OwnerDto;
import com.example.trusty.Dtos.ResponseDto.OwnerResponseDto;
import com.example.trusty.Model.OwnerEntity;

public class OwnerTransformer {

    public static OwnerEntity buildOwnerEntity(OwnerDto owner){
        return OwnerEntity.builder()
                .ownerEmail(owner.getOwnerEmail())
                .ownerName(owner.getOwnerName())
                .ownerPhone(owner.getOwnerPhone())
                .password(owner.getOwnerPassword()).build();
    }

    public  static OwnerResponseDto buildOwnerAddResponse(OwnerEntity owner){
        return OwnerResponseDto.builder().OwnerUserName(owner.getOwnerName()+owner.getOwnerPhone().substring(6))
                .isOwnerFound(false)
                .id(owner.getId())
                .build();

    }
}
