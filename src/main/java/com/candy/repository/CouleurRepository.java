package com.candy.repository;

import com.candy.model.CouleurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<CouleurEntity, Integer> {
    CouleurEntity findByCouleurId(int id);
}
