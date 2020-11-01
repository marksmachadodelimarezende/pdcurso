package com.prodata.curso.starter.service;

import com.prodata.curso.starter.entity.Produto;
import core.db.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoProdutoCRUD {

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
