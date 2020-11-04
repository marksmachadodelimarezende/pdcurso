package com.prodata.curso.starter.controller;

import com.prodata.curso.starter.entity.Contato;
import com.prodata.curso.starter.service.ServicoContatoCRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contatoController")
public class ContatoController {

    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        return ResponseEntity.ok(new ServicoContatoCRUD().create(contato));
    }

    @GetMapping
    public ResponseEntity<List<Contato>> getList() {
        return ResponseEntity.ok(new ServicoContatoCRUD().getList());
    }

    @GetMapping("getId")
    public ResponseEntity<Contato> getId(@RequestParam long id) {
        return ResponseEntity.ok(new ServicoContatoCRUD().getId(id));
    }

    @PutMapping
    public ResponseEntity<Contato> update(@RequestBody Contato contato) throws Exception {
        return ResponseEntity.ok(new ServicoContatoCRUD().update(contato));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Contato contato) throws Exception {
        return ResponseEntity.ok(new ServicoContatoCRUD().delete(contato));
    }

    @DeleteMapping("deleteId")
    public ResponseEntity<String> deleteId(@RequestParam long id) throws Exception {
        return ResponseEntity.ok(new ServicoContatoCRUD().deleteId(id));
    }
}
