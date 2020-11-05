package com.prodata.curso.starter.service;

import com.prodata.curso.starter.entity.Contato;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServicoContatoProcessamento {

    //Aplicacao da API STREAM sobre listas
    protected List<Contato> incluirNomeOperadora(List<Contato> contatos) {
        return contatos
                .stream()
                .filter(Objects::nonNull)
                .peek(contato -> {
                    contato.setOperadora(contato.getIdOperadora() > 0 ? getNomeOperadora(contato.getIdOperadora()) : ""); //If Ternário
                })
                .collect(Collectors.toList());
    }

    private String getNomeOperadora(long id) {
        return new ServicoOperadoraCRUD().getOperadora(id).getNome();
    }
}
