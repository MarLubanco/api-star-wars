package com.apistarwars.service;

import com.apistarwars.ApiStarwarsApplication;
import com.apistarwars.model.Planeta;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiStarwarsApplication.class)
public class PlanetServiceTest {

    @Autowired
    private PlanetaService planetaService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    Planeta planeta = Planeta.builder()
            .clima("Arid")
            .nome("Tatooine")
            .terreno("Plano")
            .qtdViewFilme(3)
            .build();

    Planeta planetaDois = Planeta.builder()
                .clima("Teste")
                .nome("Teste")
                .terreno("Plano")
                .qtdViewFilme(10)
                .build();

    @Test
    public void savePlanet_persistNewPlanet() {
        Mono<Planeta> planetPersisted = planetaService.savePlanet(planeta);
        Assert.assertEquals("Tatooine",planetPersisted.block().getNome());
    }

    @Test
    public void findAllPlanets_returnFluxPlanets() {
        Flux<Planeta> allPlanets = planetaService.findAllPlanets();
        Assert.assertEquals(java.util.Optional.of(1L), allPlanets.count().block());
    }

    @Test
    public void findAllPlanetsByNome_returnMonoPlanetByName() {
        Flux<Planeta> planetByNome = planetaService.findAllPlanetsByNome("Tatooine");
        Assert.assertEquals("Tatooine", planetByNome.blockFirst().getNome());
    }

    @Test
    public void findPlanetsById_returnMonoPlanetById() {
        Mono<Planeta> planetsById = planetaService.findAllPlanetsById(1);
        Assert.assertEquals(1, Mono.defer(() -> Mono.just(planetsById)));
    }

    @Test
    public void removePlanet_removedPlanetById() {
        thrown.expect(Exception.class);
        planetaService.removePlanet(1);
        planetaService.findAllPlanetsById(1);
    }
}
