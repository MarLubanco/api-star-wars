package com.apistarwars.repository;

import com.apistarwars.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {

    List<Planeta> findAllPlanetsByNome(String nome);
}
