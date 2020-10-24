package com.apistarwars.controller;

import com.apistarwars.model.Planeta;
import com.apistarwars.model.StarWarsApiPlanet;
import com.apistarwars.service.PlanetaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Planeta> savePlanet(@RequestBody @Validated Planeta planeta) {
        return planetaService.savePlanet(planeta);
    }
    @GetMapping
    public Flux<Planeta> findAllPlanets() {
        return planetaService.findAllPlanets();
    }

    @GetMapping("nome/{nome}")
    public Flux<Planeta> findAllPlanetsByNome(@PathVariable String nome) {
        return planetaService.findAllPlanetsByNome(nome);
    }

    @GetMapping("api")
    public Flux<StarWarsApiPlanet> findAllPlanetsByApi(@RequestParam("page") Integer page) {
        return planetaService.findAllPlanetsByApi(page);
    }

    @GetMapping("{id}")
    public Mono<Planeta> findPlanetById(@PathVariable Integer id) {
        return planetaService.findAllPlanetsById(id);
    }

    @DeleteMapping("{id}")
    public void removePlanet(@PathVariable Integer id) {
        planetaService.removePlanet(id);
    }
}
