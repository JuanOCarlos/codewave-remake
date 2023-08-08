package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Passageiro;
import br.com.codewave.codewaveremake.model.PassageiroInternacional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassageiroInternacionalRepository extends JpaRepository<PassageiroInternacional, String> {

    Optional<PassageiroInternacional> findByPassaporte(String passaporte);
}
