package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista , String> {

    Optional<Motorista> findByCpf(String cpf);
    Motorista findByEmail(String email);
}
