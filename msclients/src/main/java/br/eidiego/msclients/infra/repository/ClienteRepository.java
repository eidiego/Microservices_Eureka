package br.eidiego.msclients.infra.repository;

import br.eidiego.msclients.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query()
    Optional<Cliente> findByCpf(String cpf);
}
