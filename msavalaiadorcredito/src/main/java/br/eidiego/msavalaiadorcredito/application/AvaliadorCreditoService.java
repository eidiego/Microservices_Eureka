package br.eidiego.msavalaiadorcredito.application;

import br.eidiego.msavalaiadorcredito.domain.model.DadosCliente;
import br.eidiego.msavalaiadorcredito.domain.model.SituacaoCliente;
import br.eidiego.msavalaiadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {

        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);

        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .build();
    }

}
