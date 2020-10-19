package com.prodata.curso.initializer.repository;

import com.prodata.curso.initializer.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

//    @Query("SELECT t FROM Produto t WHERE upper(t.nome) like %:nome% ORDER BY t.nome ASC")
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
