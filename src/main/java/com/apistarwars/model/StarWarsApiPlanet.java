package com.apistarwars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StarWarsApiPlanet {

    private String climate;
    private String gravity;
    private String population;
    private List<String> films;
}
