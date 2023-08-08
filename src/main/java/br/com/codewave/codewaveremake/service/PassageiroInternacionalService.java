package br.com.codewave.codewaveremake.service;

import br.com.codewave.codewaveremake.model.Passageiro;
import br.com.codewave.codewaveremake.model.PassageiroInternacional;
import br.com.codewave.codewaveremake.repository.PassageiroInternacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroInternacionalService {

    @Autowired
    public PassageiroInternacionalRepository passageiroInternacionalRepository;

    public void adicionar(PassageiroInternacional passageiroInternacional) {
        passageiroInternacionalRepository.save(passageiroInternacional);
    }

    public List<PassageiroInternacional> lsitarTodos() {
        return passageiroInternacionalRepository.findAll();
    }

    public PassageiroInternacional acharPorPassaporte(String passaporte) {
        Optional<PassageiroInternacional> optionalPassageiroInternacional = passageiroInternacionalRepository.findByPassaporte(passaporte);
        if (optionalPassageiroInternacional.isEmpty()) {
            throw new RuntimeException("Passageiro não encontrado");
        }
        return optionalPassageiroInternacional.get();
    }

    public void atualizar(String passaporte, PassageiroInternacional passageiroInternacional){
        if (passageiroInternacionalRepository.existsById(passaporte)){
            passageiroInternacionalRepository.save(passageiroInternacional);
        }
    }

    public void remove(String passaporte) {
        PassageiroInternacional pesquisarDestino = acharPorPassaporte(passaporte);
        if (passageiroInternacionalRepository.existsById((passaporte))){
            passageiroInternacionalRepository.deleteById((passaporte));
        }
    }
}