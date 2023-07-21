package com.candy.repository;

import com.candy.model.CandyTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandyTagRepository extends JpaRepository<CandyTagEntity, Long> {

    Optional<CandyTagEntity> findByCandytag(String candytag);
}
