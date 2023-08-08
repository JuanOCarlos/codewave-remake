package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, String> {
    Optional<Passageiro> findByCpf(String cpf);
    Passageiro findByEmail(String email);

}
