package br.com.codewave.codewaveremake.facade;

import br.com.codewave.codewaveremake.model.Pagamento;

public interface AceitarCorridaFacade {

    void aceitarCorrida(String cpf, Pagamento pagamento, Integer corridaId);
}
