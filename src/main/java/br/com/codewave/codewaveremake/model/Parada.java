package br.com.codewave.codewaveremake.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_parada")
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String localDaParada;
    @ManyToOne
    private Corrida corrida;

    @ManyToOne
    private CorridaInternacional corridaInternacional;
}
