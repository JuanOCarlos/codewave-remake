package br.com.codewave.codewaveremake.facade.impl;

import br.com.codewave.codewaveremake.facade.AceitarCorridaFacade;
import br.com.codewave.codewaveremake.model.Corrida;
import br.com.codewave.codewaveremake.model.Pagamento;
import br.com.codewave.codewaveremake.service.CorridaService;
import br.com.codewave.codewaveremake.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AceitarCorridaFacadeImpl implements AceitarCorridaFacade {

    @Autowired
    private CorridaService corridaService;
    @Autowired
    private PagamentoService pagamentoService;

    @Override
    public void aceitarCorrida(String cpf, Pagamento pagamento, Integer corridaId) {
        pagamentoService.adicionar(pagamento);
        Corrida corrida = corridaService.acharPorId(corridaId);
        corrida.setPagamento(pagamento);
        corridaService.aceitarCorrida(corrida, cpf);
    }
}
