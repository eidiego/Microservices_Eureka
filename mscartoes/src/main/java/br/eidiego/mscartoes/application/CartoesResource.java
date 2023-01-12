package br.eidiego.mscartoes.application;

import br.eidiego.mscartoes.application.representation.CartaoSaveRequest;
import br.eidiego.mscartoes.domain.Cartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    private CartaoService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
       Cartao cartao = request.toModel();
       service.save(cartao);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
