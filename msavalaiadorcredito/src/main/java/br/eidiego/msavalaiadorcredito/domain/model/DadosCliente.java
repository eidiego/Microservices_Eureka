package br.eidiego.msavalaiadorcredito.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class DadosCliente {

    private Long id;
    private List<CartaoCliente> cartoes;

}
