package com.prodata.curso.initializer.repository;

import com.prodata.curso.initializer.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
