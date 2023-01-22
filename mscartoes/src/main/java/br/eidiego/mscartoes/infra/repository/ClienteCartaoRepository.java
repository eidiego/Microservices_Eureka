package br.eidiego.mscartoes.infra.repository;

import br.eidiego.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository {
    List<ClienteCartao> findByCpf(String cpf);

}
