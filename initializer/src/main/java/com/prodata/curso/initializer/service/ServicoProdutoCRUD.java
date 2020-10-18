package com.prodata.curso.initializer.service;

import com.prodata.curso.initializer.entity.Produto;
import com.prodata.curso.initializer.repository.ProdutoRepository;

import java.util.List;

public class ServicoProdutoCRUD {

    ProdutoRepository produtoRepository;

    public void setProdutoRepository(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getList() {
        return produtoRepository.findAll();
    }

}
