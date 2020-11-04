package com.prodata.curso.starter.controller;

import com.prodata.curso.starter.entity.Produto;
import com.prodata.curso.starter.service.ServicoProdutoCRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "produtoController")
public class ProdutoController {

    @GetMapping("getListaProdutos")
    public ResponseEntity<List<Produto>> getListaProdutos() {
        return ResponseEntity.ok(new ServicoProdutoCRUD().getListaProdutos());
    }

    @GetMapping("consultarPorId")
    public ResponseEntity<Produto> consultarPorId(@RequestParam long id) {
        return ResponseEntity.ok(new ServicoProdutoCRUD().consultarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(new ServicoProdutoCRUD().salvar(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) throws Exception {
        return ResponseEntity.ok(new ServicoProdutoCRUD().atualizar(produto));
    }

    @DeleteMapping
    public ResponseEntity<String> deletarProduto(@RequestBody Produto produto) throws Exception {
        return ResponseEntity.ok(new ServicoProdutoCRUD().deletar(produto));
    }

    @DeleteMapping("deletarPorId")
    public ResponseEntity<String> deletarPorId(@RequestParam long id) throws Exception {
        return ResponseEntity.ok(new ServicoProdutoCRUD().deletarPorId(id));
    }

}
