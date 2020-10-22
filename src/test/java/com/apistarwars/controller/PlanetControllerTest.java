package com.apistarwars.controller;

import com.apistarwars.ApiStarwarsApplication;
import com.apistarwars.model.Planeta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlanetControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    Planeta planeta = Planeta.builder()
            .clima("Arid")
            .nome("Tatooine")
            .terreno("Plano")
            .qtdViewFilme(3)
            .build();

    @Test
    public void savePlanet_returnIsCreated() {
        webTestClient.post().uri("/planetas")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(planeta))
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void findAll_returnIsOk() {
        webTestClient.get().uri("/planetas")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void findAllByName_returnIsOk() {
        webTestClient.get().uri("/planetas/nome/Tatooine")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void findAllById_returnIsOk() {
        webTestClient.get().uri("/planetas/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void deletePlanet_returnIsOk() {
        Planeta planetaNovo = Planeta.builder()
                .id(7)
                .clima("Arid")
                .nome("Tatooine")
                .terreno("Plano")
                .qtdViewFilme(3)
                .build();
        webTestClient.post().uri("/planetas")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(planetaNovo))
                .exchange()
                .expectStatus().isCreated();

        webTestClient.delete().uri("/planetas/7")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
