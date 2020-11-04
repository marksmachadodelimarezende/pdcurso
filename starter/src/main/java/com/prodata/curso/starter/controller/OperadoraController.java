package com.prodata.curso.starter.controller;

import com.prodata.curso.starter.entity.Operadora;
import com.prodata.curso.starter.service.ServicoOperadoraCRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/operadoraController")
public class OperadoraController {

    @PostMapping
    public ResponseEntity<Operadora> create(@RequestBody Operadora operadora) {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().create(operadora));
    }

    @GetMapping
    public ResponseEntity<List<Operadora>> getList() {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().getList());
    }

    @GetMapping("getOperadora")
    public ResponseEntity<Operadora> getOperadora(@RequestParam long id) {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().getOperadora(id));
    }

    @PutMapping
    public ResponseEntity<Operadora> update(@RequestBody Operadora operadora) throws Exception {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().update(operadora));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Operadora operadora) throws Exception {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().delete(operadora));
    }

    @DeleteMapping("deleteId")
    public ResponseEntity<String> deleteId(@RequestParam long id) throws Exception {
        return ResponseEntity.ok(new ServicoOperadoraCRUD().deleteId(id));
    }
}
