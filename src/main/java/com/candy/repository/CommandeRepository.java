package com.candy.repository;

import com.candy.model.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {
}
