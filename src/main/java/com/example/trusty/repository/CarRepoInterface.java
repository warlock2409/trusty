package com.example.trusty.repository;

import com.example.trusty.Model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepoInterface extends JpaRepository<CarEntity,Long> {

}
