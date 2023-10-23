package com.example.trusty.service.Implementation;

import com.example.trusty.Dtos.RequestDtos.OwnerDto;
import com.example.trusty.Dtos.ResponseDto.OwnerResponseDto;
import com.example.trusty.Dtos.TransFormer.OwnerTransformer;
import com.example.trusty.Model.OwnerEntity;
import com.example.trusty.repository.OwnerRepoInterface;
import com.example.trusty.service.interfaces.OwnerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImplementation implements OwnerServiceInterface {
    @Autowired
    OwnerRepoInterface userRepoInterface;

    @Override
    public boolean checkOwner(String ownerPhone) {
       OwnerEntity owner = userRepoInterface.findByOwnerPhone(ownerPhone);
       return owner != null;
    }

    @Override
    public OwnerResponseDto addOwner(OwnerDto owner) {
       OwnerEntity ownerEntity = OwnerTransformer.buildOwnerEntity(owner);

        OwnerEntity savedOwner = userRepoInterface.save(ownerEntity);

        return OwnerTransformer.buildOwnerAddResponse(savedOwner);
    }
}
