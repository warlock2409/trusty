package com.example.trusty.Dtos.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerDto {
    private String ownerName;
    private String ownerPhone;
    private String ownerEmail;
    private String ownerPassword;
}
