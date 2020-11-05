package com.prodata.curso.starter.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Contato {
    private long id;
    private String nome;
    private String telefone;
    private Timestamp dataInclusao;
    private long idOperadora;
    private String operadora;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Timestamp getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Timestamp dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public long getIdOperadora() {
        return idOperadora;
    }

    public void setIdOperadora(long idOperadora) {
        this.idOperadora = idOperadora;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
}
