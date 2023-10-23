package com.example.trusty.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;

    @Column(unique = true)
    private String carNumber;
    private String makeModel;
    private boolean booked;

    @ManyToOne
    private OwnerEntity owner;
}
