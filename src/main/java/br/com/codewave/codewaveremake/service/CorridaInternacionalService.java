package br.com.codewave.codewaveremake.service;

import br.com.codewave.codewaveremake.model.Corrida;
import br.com.codewave.codewaveremake.model.CorridaInternacional;
import br.com.codewave.codewaveremake.model.enums.CorridaEnum;
import br.com.codewave.codewaveremake.repository.CorridaInternacionalRepository;
import br.com.codewave.codewaveremake.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorridaInternacionalService {
    @Autowired
    public CorridaInternacionalRepository corridaInternacionalRepository;

    @Autowired
    private MotoristaService motoristaService;

    // Método que adicona uma corrida
    public void adicionar(CorridaInternacional corridaQueSeraSalvo) {
        corridaInternacionalRepository.save(corridaQueSeraSalvo);
    }

    // Método que lista todas as corridas adicionadas
    public List<CorridaInternacional> listarTodos() {
        return corridaInternacionalRepository.findAll();
    }

    // Método que procura uma corrida pelo id e lista
    public CorridaInternacional acharPorId(Integer id) {
        Optional<CorridaInternacional> optionalCorrida = corridaInternacionalRepository.findById(id);
        if (optionalCorrida.isEmpty()){
            throw new RuntimeException("Corrida Não Encontrada");
        }
        return optionalCorrida.get();
    }

    // Método que atualiza uma corrida
    public void atualizar(Integer id, CorridaInternacional corridaInternacional){
        if (corridaInternacionalRepository.existsById(id)){
            corridaInternacionalRepository.save(corridaInternacional);
        }
    }

    // Método que remove uma corrida
    public void remove(Integer id) {
        CorridaInternacional pesquisarCorrrida = acharPorId(id);
        if (corridaInternacionalRepository.existsById(id)){
            corridaInternacionalRepository.deleteById(id);
        }
    }

    // Método que aceita uma corrida puxando o cpf do motorista e mudando o status
    public void aceitarCorrida(CorridaInternacional corridaInternacional, String cpf) {
        corridaInternacional.setMotorista(motoristaService.acharPorId(cpf));
        corridaInternacional.setStatus(CorridaEnum.EM_ANDAMENTO);
        corridaInternacionalRepository.save(corridaInternacional);
    }

    // Método que finaliza uma corrida usando o cpf do motorista e muda o status
    public void finalizarCorrida(CorridaInternacional corridaInternacional, String cpf) {
        corridaInternacional.setMotorista(motoristaService.acharPorId(cpf));
        corridaInternacional.setStatus(CorridaEnum.FINALIZADO);
        corridaInternacionalRepository.save(corridaInternacional);
    }
}
