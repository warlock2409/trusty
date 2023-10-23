package com.example.trusty.Dtos.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OwnerResponseDto {
    public String OwnerUserName;
    public boolean isOwnerFound;
    public Long id;
}
