package com.prodata.curso.initializer.service;

import com.prodata.curso.initializer.entity.Produto;
import com.prodata.curso.initializer.repository.ProdutoRepository;
import comum.db.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicoProdutoCRUD {

//    ProdutoRepository produtoRepository;
//    public void setProdutoRepository(ProdutoRepository produtoRepository) {
//        this.produtoRepository = produtoRepository;
//    }

//    public List<Produto> getList() {
//        return produtoRepository.findAll();
//    }
//
//    public List<Produto> getList(String textContains) {
//        if (textContains.isEmpty())
//            return getList();
//
//        return produtoRepository.findByNomeContainingIgnoreCase(textContains);
//    }

    public List<Produto> getListaProdutos() {
        List<Produto> retorno = new ArrayList<>();
        String sql = "Select * from tb_produto";
        ResultSet rs = new Conexao().consultaSql(sql);
        try {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setObs(rs.getString("obs"));
                produto.setObsCompra(rs.getString("obs_compra"));
                produto.setQuantidade(rs.getBigDecimal("quantidade"));
                produto.setValor(rs.getBigDecimal("valor"));
                retorno.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
