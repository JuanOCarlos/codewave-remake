package br.com.codewave.codewaveremake.model;

import br.com.codewave.codewaveremake.model.enums.CorridaEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_corrida")
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(precision = 10, scale = 2, name = "valor_a_receber")
    private BigDecimal valorAReceber;

    @Column(precision = 10,scale = 2, name = "valor_a_pagar")
    private BigDecimal valorAPagar;

    @ManyToOne
    private Destino destino;

    @ManyToOne
    private Motorista motorista;

    @ManyToOne
    private Passageiro passageiro;

    @ManyToOne
    private Pagamento pagamento;

    private CorridaEnum status = CorridaEnum.PENDENTE;

}
