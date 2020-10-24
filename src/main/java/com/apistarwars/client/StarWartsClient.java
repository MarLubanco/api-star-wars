package com.apistarwars.client;

import com.apistarwars.model.StarWarsApiPlanet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "starwarsapi", url = "https://swapi.dev/api")
public interface StarWartsClient {

    @GetMapping("/planets/{id}")
    StarWarsApiPlanet find(@PathVariable Integer id);

    @GetMapping("/planets/{id}")
    List<StarWarsApiPlanet> findAllPlanets(@RequestParam("page") Integer page);
}
