package com.example.trusty.service.interfaces;

import com.example.trusty.Dtos.RequestDtos.OwnerDto;
import com.example.trusty.Dtos.ResponseDto.OwnerResponseDto;

public interface OwnerServiceInterface {

    boolean checkOwner(String ownerPhone);

    OwnerResponseDto addOwner(OwnerDto owner);
}
