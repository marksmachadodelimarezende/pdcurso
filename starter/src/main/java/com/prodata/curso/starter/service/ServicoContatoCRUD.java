package com.prodata.curso.starter.service;

import com.prodata.curso.starter.entity.Contato;
import core.db.UtilDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoContatoCRUD extends UtilDB {

    public static final String SELECT_FROM_PUBLIC_CONTATO = "select * from public.contato";
    public static final String ORDER_BY_ID = " Order by id";
    private static final String RETURNIG = "returning *";

    //Create
    public Contato create(Contato contato) {
        String sql = "insert into public.contato (nome, telefone, id_operadora) \nvalues ("
                .concat("'").concat(contato.getNome()).concat("', ")
                .concat("'").concat(contato.getTelefone()).concat("', ")
                .concat("'").concat(String.valueOf(contato.getIdOperadora())).concat("' ")
                .concat(") \n")
                .concat(RETURNIG);

        return execSqlDbGetContato(sql);
    }

    //Read (select) >> getList | getId(id)
    public Contato getId(long id) {
        return execSqlDbGetContato(SELECT_FROM_PUBLIC_CONTATO.concat(" ").concat(getSintaxeWhereId(id)));
    }

    public List<Contato> getList() {
        List<Contato> contatos = new ArrayList<>();
        try {
            ResultSet rs = consultaSql(SELECT_FROM_PUBLIC_CONTATO.concat(ORDER_BY_ID));
            while (rs.next()) {
                contatos.add(getItemRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contatos;
    }

    //Update
    public Contato update(Contato contato) throws Exception {
        validaCampoObrigatorio(contato);

        String sql = "update public.contato set \n"
                .concat("\tnome = '").concat(contato.getNome()).concat("', \n")
                .concat("\ttelefone = '").concat(contato.getTelefone()).concat("', \n")
                .concat("\tid_operadora = ").concat(String.valueOf(contato.getIdOperadora())).concat(" \n")
                .concat(getSintaxeWhereId(contato)).concat("\n")
                .concat(RETURNIG);

        return execSqlDbGetContato(sql);
    }

    //Delete
    public String delete(Contato contato) throws Exception {
        validaCampoObrigatorio(contato);
        String msgReturn = "Nenhum registro afetado!";
        String sql = "Delete from public.Contato ".concat(getSintaxeWhereId(contato));
        int qtdeRow = executaSql(sql);
        if (qtdeRow > 0)
            msgReturn = "Exclusão realizada com sucesso!";

        return msgReturn;
    }

    public String deleteId(long id) throws Exception {
        Contato Contato = new Contato();
        Contato.setId(id);
        return delete(Contato);
    }

    //Methods resusable
    private String getSintaxeWhereId(long id) {
        Contato contato = new Contato();
        contato.setId(id);
        return getSintaxeWhereId(contato);
    }

    private String getSintaxeWhereId(Contato contato) {
        return "where id = ".concat(String.valueOf(contato.getId()));
    }

    private Contato execSqlDbGetContato(String sql) {
        Contato contato = new Contato();
        try {
            contato = getItemRow(getRegistro(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contato;
    }

    private Contato getItemRow(ResultSet rs) throws SQLException {
        Contato contato = new Contato();

        if (rs == null || rs.getRow() == 0) {
            return contato;
        }

        contato.setId(rs.getInt("id"));
        contato.setNome(rs.getString("nome"));
        contato.setTelefone(rs.getString("telefone"));
        contato.setIdOperadora(rs.getInt("id_operadora"));
        contato.setDataInclusao(rs.getDate("data_inclusao"));
        return contato;
    }

    //Methods validete
    private void validaCampoObrigatorio(Contato contato) throws Exception {
        if (contato.getId() <= 0)
            throw new Exception("Identificador do registro não informado para CRUD do registro!");
    }

}
