package com.prodata.curso.initializer.controller;

import arquitetura.SingletonFactory;
import com.prodata.curso.initializer.entity.Produto;
import com.prodata.curso.initializer.repository.ProdutoRepository;
import com.prodata.curso.initializer.service.ServicoProdutoCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtoController")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    private ServicoProdutoCRUD getServico() {
        ServicoProdutoCRUD service = SingletonFactory.getInstance(ServicoProdutoCRUD.class);
        service.setProdutoRepository(produtoRepository);
        return service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getList(@RequestParam String nome) {
        return ResponseEntity.ok(getServico().getList(nome));
    }


}
