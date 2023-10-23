package com.example.trusty.repository;

import com.example.trusty.Model.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepoInterface extends JpaRepository<OwnerEntity,Long> {
    OwnerEntity findByOwnerPhone(String ownerPhone);
}
