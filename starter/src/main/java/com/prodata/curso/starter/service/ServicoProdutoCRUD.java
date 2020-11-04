package com.prodata.curso.starter.service;

import com.prodata.curso.starter.entity.Produto;
import core.db.Conexao;
import core.db.UtilDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoProdutoCRUD extends UtilDB {

    private void validaCampoObrigatorio(Produto produto) throws Exception {
        if (produto.getId() <= 0)
            throw new Exception("Código do produto não informado para CRUD do registro!");
    }

    private Produto getItemProduto(ResultSet rs) throws SQLException {
        if (rs == null || rs.getRow() == 0)
            return null;

        Produto produto = new Produto();
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setObs(rs.getString("obs"));
        produto.setQuantidade(rs.getBigDecimal("quantidade"));
        produto.setValor(rs.getBigDecimal("valor"));
        return produto;
    }

    private Produto execSqlDbGetProduto(String sql) {
        Produto produto = new Produto();
        try {
            ResultSet rs = new Conexao().consultaSql(sql);
            rs.next();
            produto = getItemProduto(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produto> getListaProdutos() throws SQLException {
        List<Produto> retorno = new ArrayList<>();
        String sql = "Select * from produto";
        ResultSet rs = consultaSql(sql);
        try {
            while (rs.next()) {
                Produto produto = getItemProduto(rs);
                retorno.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public Produto consultarPorId(long id) {
        String sql = "select * from produto where id = " + id;
        return execSqlDbGetProduto(sql);
    }

    public Produto salvar(Produto produto) {
        String sql = "insert into produto (nome, quantidade, valor, obs) \nvalues ("
                .concat("'").concat(produto.getNome()).concat("'")
                .concat(", ")
                .concat("'").concat(produto.getQuantidade().toString()).concat("'")
                .concat(", ")
                .concat("'").concat(produto.getValor().toString()).concat("'")
                .concat(", ")
                .concat("'").concat(produto.getObs()).concat("'")
                .concat(") \nreturning * ");

        return execSqlDbGetProduto(sql);
    }

    public Produto atualizar(Produto produto) throws Exception {
        validaCampoObrigatorio(produto);

        String sql = "update produto set \n"
                .concat("\tnome = '").concat(produto.getNome()).concat("'")
                .concat(", \n")
                .concat("\tquantidade = '").concat(produto.getQuantidade().toString()).concat("'")
                .concat(", \n")
                .concat("\tvalor = '").concat(produto.getValor().toString()).concat("'")
                .concat(", \n")
                .concat("\tobs = '").concat(produto.getObs()).concat("'")
                .concat("\nwhere id = ").concat(String.valueOf(produto.getId()))
                .concat("\nreturning * ");

        return execSqlDbGetProduto(sql);
    }

    public String deletar(Produto produto) throws Exception {
        validaCampoObrigatorio(produto);
        String sql = "Delete from produto where id = " + produto.getId();
        String msgRetorno = "Nenhum registro afetado!";
        int qtdeRegAfetado = new Conexao().executaSql(sql);
        if (qtdeRegAfetado > 0)
            msgRetorno = "Exclusão feita com sucesso!\nRegistro(s) afetado(s): " + qtdeRegAfetado;

        return msgRetorno;
    }

    public String deletarPorId(long id) throws Exception {
        Produto produto = new Produto();
        produto.setId(id);
        return deletar(produto);
    }

}
