package br.com.codewave.codewaveremake.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity(name = "tb_passageiro-internacional")
public class PassageiroInternacional {

    @Id
    private String passaporte;

    @CPF
    private String cpf;

    @Column(length = 100)
    private String nome;

    @Column(length = 100)
    @Email
    private String email;

    @Column(length = 11, name = "numero_de_telefone")
    private String numeroDeTelefone;

    private double longitude;
    private double latitude;

    private String senha;
}
