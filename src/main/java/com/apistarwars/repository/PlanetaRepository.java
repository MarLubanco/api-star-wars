package com.apistarwars.repository;

import com.apistarwars.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
}
