package com.prodata.curso.starter.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;
    private String obs;
    private String obsCompra;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObsCompra() {
        return obsCompra;
    }

    public void setObsCompra(String obsCompra) {
        this.obsCompra = obsCompra;
    }
}


