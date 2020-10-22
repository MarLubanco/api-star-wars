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
        LOG.info("Salvar novo planeta");
        return Mono
                .defer(() -> Mono.just(this.planetaRepository.save(planeta)));
    }

    public Flux<Planeta> findAllPlanets() {
        return Flux.defer(() -> Flux.fromIterable(this.planetaRepository.findAll()));
    }
}
