package br.eidiego.msclients.application;

import java.net.URI;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.eidiego.msclients.application.representation.ClienteSaveRequest;
import br.eidiego.msclients.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesResource {

	Logger log;
	
	@Autowired
    private ClienteService service;

    @GetMapping
    private String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request) {
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = ("cpf"))
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf) {
        log.info("Obtendo o status do microservice de clientes");
        Optional<Cliente> cliente = service.getByCPF(cpf);
        if(cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

}
