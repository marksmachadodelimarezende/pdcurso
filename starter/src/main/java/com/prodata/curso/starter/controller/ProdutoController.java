package com.prodata.curso.starter.controller;

import com.prodata.curso.starter.entity.Produto;
import com.prodata.curso.starter.service.ServicoProdutoCRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtoController")
public class ProdutoController {

    @GetMapping("getListaProdutos")
    public ResponseEntity<List<Produto>> getListaProdutos() {
        return ResponseEntity.ok(new ServicoProdutoCRUD().getListaProdutos());
    }


}
