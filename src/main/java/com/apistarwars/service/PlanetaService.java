package com.apistarwars.service;

import com.apistarwars.model.Planeta;
import com.apistarwars.repository.PlanetaRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;
    private static Logger LOG = Logger.getLogger(PlanetaService.class.getName());

    public void getPlanetas() {
//        Object o = clientSwapi.recuperaPlanetas();
//        System.out.println(o);
    }

    public Mono<Planeta> savePlanet(Planeta planeta) {
        LOG.info("Save new planet - " + planeta.getNome());
        return Mono
                .defer(() -> Mono.just(this.planetaRepository.save(planeta)));
    }

    public Flux<Planeta> findAllPlanets() {
        LOG.info("Return list planets");
        return Flux.defer(() -> Flux.fromIterable(this.planetaRepository.findAll()));
    }

    public Flux<Planeta> findAllPlanetsByNome(String nome) {
        LOG.info("Return planets - Filter by name - " + nome);
        return Flux.defer(() -> Flux.fromIterable(this.planetaRepository.findAllPlanetsByNome(nome)));
    }

    public Mono<Planeta> findAllPlanetsById(Integer id) {
        LOG.info("Return planets - Filter by id - " + id);
        return Mono.defer(() -> Mono.just(this.planetaRepository.findById(id).orElseThrow()));
    }

    public void removePlanet(Integer id) {
        LOG.info("Remove planet by id - " + id);
        this.planetaRepository.deleteById(id);
    }
}
