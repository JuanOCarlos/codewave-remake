package br.com.codewave.codewaveremake.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;


@Data
@Entity(name = "tb_empresa")
public class Empresa {

    @Id
    @CNPJ
    private String cnpj;
    @Column(length = 255)
    private String carro;

    @Column(length = 100)
    private String nome;
}