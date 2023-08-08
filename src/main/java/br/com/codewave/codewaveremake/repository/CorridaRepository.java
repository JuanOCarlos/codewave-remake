package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Integer> {
}
