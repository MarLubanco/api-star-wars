package com.apistarwars.controller;

import com.apistarwars.model.Planeta;
import com.apistarwars.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @PostMapping
    public Mono<Planeta> savePlanet(@RequestBody @Validated Planeta planeta) {
        return planetaService.savePlanet(planeta);
    }
    @GetMapping
    public Flux<Planeta> findAllPlanets() {
        return planetaService.findAllPlanets();
    }

    @GetMapping("{nome}")
    public Flux<Planeta> findAllPlanetsByNome(@PathVariable String nome) {
        return planetaService.findAllPlanetsByNome(nome);
    }
}
