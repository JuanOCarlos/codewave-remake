package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParadaRepository extends JpaRepository<Parada, Integer> {
}
