package com.example.trusty.Dtos.ResponseDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDto {
    public Long id;
    public String carName;
    public String carNumber;
    public String makeModel;
    public boolean booked;
}
