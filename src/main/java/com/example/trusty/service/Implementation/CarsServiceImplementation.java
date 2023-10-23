package com.example.trusty.service.Implementation;

import com.example.trusty.Dtos.RequestDtos.CarRequestDto;
import com.example.trusty.Dtos.ResponseDto.CarResponseDto;
import com.example.trusty.Dtos.TransFormer.CarTransformer;
import com.example.trusty.Exceptions.CarNumberDuplicateException;
import com.example.trusty.Model.CarEntity;
import com.example.trusty.Model.OwnerEntity;
import com.example.trusty.repository.CarRepoInterface;
import com.example.trusty.repository.OwnerRepoInterface;
import com.example.trusty.service.interfaces.CarsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarsServiceImplementation implements CarsServiceInterface {
    @Autowired
    OwnerRepoInterface ownerRepoInterface;
    @Autowired
    CarRepoInterface carRepoInterface;

    @Override
    public CarResponseDto addCar(CarRequestDto car, Long ownerId) {
        CarEntity carEntity = CarTransformer.buildCarEntity(car);
        Optional<OwnerEntity> ownerOptional = ownerRepoInterface.findById(ownerId);

        try {
            if (ownerOptional.isPresent()) {
                OwnerEntity owner = ownerOptional.get();
                CarEntity finalCarEntity = carEntity;

                boolean carWithSameNumberExists = owner.getCars()
                        .stream()
                        .anyMatch(existingCar -> existingCar.getCarNumber().equals(finalCarEntity.getCarNumber()));

                if (carWithSameNumberExists) {
                    throw new CarNumberDuplicateException("Car with the same number already exists");
                }
                // Add the car to the owner
                carEntity.setOwner(owner);
                owner.getCars().add(carEntity);
                // Save the car and the owner
                carEntity = carRepoInterface.save(carEntity);

                // Return a CarResponseDto or perform additional transformations if needed
                return CarTransformer.transformToCarResponseDto(carEntity);
            }
        } catch (CarNumberDuplicateException e) {
            // Handle the exception and send a custom response
            return null;
        }


        return null;
    }
}
