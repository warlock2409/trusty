package com.example.trusty.Dtos.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRequestDto {
    private String carName;
    private String carNumber;
    private String makeModel;

}
