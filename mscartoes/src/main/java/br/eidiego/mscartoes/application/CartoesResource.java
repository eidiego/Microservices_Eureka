package br.eidiego.mscartoes.application;

import br.eidiego.mscartoes.application.representation.CartoesPorClienteResponse;
import br.eidiego.mscartoes.application.representation.ClienteCartaoService;
import br.eidiego.mscartoes.domain.ClienteCartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.eidiego.mscartoes.application.representation.CartaoSaveRequest;
import br.eidiego.mscartoes.domain.Cartao;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;

    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
       Cartao cartao = request.toModel();
        cartaoService.save(cartao);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(
            @RequestParam("cpf") String cpf) {
          List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
          List<CartoesPorClienteResponse> resultList = lista.stream().map(CartoesPorClienteResponse::fromModel)
                  .collect(Collectors.toList());
          return ResponseEntity.ok(resultList);

    }

}
