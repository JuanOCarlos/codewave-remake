package br.com.codewave.codewaveremake.repository;

import br.com.codewave.codewaveremake.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    Optional<Empresa> findByCnpj(String cnpj);
}
