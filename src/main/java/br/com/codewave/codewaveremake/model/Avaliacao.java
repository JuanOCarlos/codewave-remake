package br.com.codewave.codewaveremake.model;

import br.com.codewave.codewaveremake.model.enums.AvaliacaoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private AvaliacaoEnum avaliacao;

}
