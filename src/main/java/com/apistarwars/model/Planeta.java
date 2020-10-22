package com.apistarwars.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Planeta {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String clima;
    private String terreno;
    private Integer qtdViewFilme;
}
