package br.com.codewave.codewaveremake.service;

import br.com.codewave.codewaveremake.model.Avaliacao;
import br.com.codewave.codewaveremake.model.enums.AvaliacaoEnum;
import br.com.codewave.codewaveremake.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {
    @Autowired
    public AvaliacaoRepository avaliacaoRepository;

    public void adicionar(Avaliacao avaliacao) {
        Avaliacao model = new Avaliacao();
        switch (avaliacao.getAvaliacao()){
            case PÉSSIMO:
                model.setAvaliacao(AvaliacaoEnum.PÉSSIMO);

                break;

            case RUIM:
                model.setAvaliacao(AvaliacaoEnum.RUIM);
                break;

            case BOM:
                model.setAvaliacao(AvaliacaoEnum.BOM);
                break;

            case MUITO_BOM:
                model.setAvaliacao(AvaliacaoEnum.MUITO_BOM);
                break;

            case ÓTIMO:
                model.setAvaliacao(AvaliacaoEnum.ÓTIMO);
                break;

        }

        avaliacaoRepository.save(model);
    }

    public void listar(Avaliacao avaliacao) {
        Avaliacao model = new Avaliacao();
        switch (avaliacao.getAvaliacao()){
            case PÉSSIMO:
                model.setAvaliacao(AvaliacaoEnum.PÉSSIMO);

                break;

            case RUIM:
                model.setAvaliacao(AvaliacaoEnum.RUIM);
                break;

            case BOM:
                model.setAvaliacao(AvaliacaoEnum.BOM);
                break;

            case MUITO_BOM:
                model.setAvaliacao(AvaliacaoEnum.MUITO_BOM);
                break;

            case ÓTIMO:
                model.setAvaliacao(AvaliacaoEnum.ÓTIMO);
                break;

        }

        avaliacaoRepository.save(model);
    }

    public void deletar(Avaliacao avaliacao) {
        Avaliacao model = new Avaliacao();
        switch (avaliacao.getAvaliacao()){
            case PÉSSIMO:
                model.setAvaliacao(AvaliacaoEnum.PÉSSIMO);

                break;

            case RUIM:
                model.setAvaliacao(AvaliacaoEnum.RUIM);
                break;

            case BOM:
                model.setAvaliacao(AvaliacaoEnum.BOM);
                break;

            case MUITO_BOM:
                model.setAvaliacao(AvaliacaoEnum.MUITO_BOM);
                break;

            case ÓTIMO:
                model.setAvaliacao(AvaliacaoEnum.ÓTIMO);
                break;

        }

        avaliacaoRepository.save(model);
    }

    public void atualizar(Avaliacao avaliacao) {
        Avaliacao model = new Avaliacao();
        switch (avaliacao.getAvaliacao()){
            case PÉSSIMO:
                model.setAvaliacao(AvaliacaoEnum.PÉSSIMO);

                break;

            case RUIM:
                model.setAvaliacao(AvaliacaoEnum.RUIM);
                break;

            case BOM:
                model.setAvaliacao(AvaliacaoEnum.BOM);
                break;

            case MUITO_BOM:
                model.setAvaliacao(AvaliacaoEnum.MUITO_BOM);
                break;

            case ÓTIMO:
                model.setAvaliacao(AvaliacaoEnum.ÓTIMO);
                break;

        }

        avaliacaoRepository.save(model);
    }

}