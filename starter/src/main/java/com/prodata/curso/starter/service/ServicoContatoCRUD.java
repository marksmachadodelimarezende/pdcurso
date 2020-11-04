package com.prodata.curso.starter.service;

import com.prodata.curso.starter.entity.Operadora;
import com.prodata.curso.starter.entity.Produto;
import core.db.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoOperadoraCRUD {

    private static final String RETURNIG = "returning *";
    public static final String SELECT_FROM_PUBLIC_OPERADORA = "select * from public.operadora";
    public static final String ORDER_BY_ID = " Order by id";

    //Create
    public Operadora create(Operadora operadora){
        String sql = "insert into public.operadora (ddd, nome, categoria) \nvalues ("
                .concat(operadora.getDdd()).concat(", ")
                .concat("'").concat(operadora.getNome()).concat("', ")
                .concat("'").concat(String.valueOf(operadora.getCategoria())).concat("' ")
                .concat(") \n")
                .concat(RETURNIG);

        return execSqlDbGetOperadora(sql);
    }

    //Read (select) >> getList | getOperadora(id)
    public Operadora getOperadora(long id) {
        return execSqlDbGetOperadora(SELECT_FROM_PUBLIC_OPERADORA.concat(" ").concat(getSintaxeWhereId(id)));
    }

    public List<Operadora> getList() {
        List<Operadora> operadoras = new ArrayList<>();
        try {
            ResultSet rs = new Conexao().consultaSql(SELECT_FROM_PUBLIC_OPERADORA.concat(ORDER_BY_ID));
            while (rs.next()) {
                operadoras.add(getItemRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operadoras;
    }

    //Update
    public Operadora update(Operadora operadora) throws Exception {
        validaCampoObrigatorio(operadora);

        String sql = "update public.operadora set \n"
                .concat("\tddd = '").concat(operadora.getDdd()).concat("', \n")
                .concat("\tnome = '").concat(operadora.getNome()).concat("', \n")
                .concat("\tcategoria = '").concat(String.valueOf(operadora.getCategoria())).concat("' \n")
                .concat(getSintaxeWhereId(operadora)).concat("\n")
                .concat(RETURNIG);

        return execSqlDbGetOperadora(sql);
    }

    //Delete
    public String delete(Operadora operadora) throws Exception {
        validaCampoObrigatorio(operadora);
        String msgReturn = "Nenhum registro afetado!";
        String sql = "Delete from public.operadora ".concat(getSintaxeWhereId(operadora));
        int qtdeRow = new Conexao().executaSql(sql);
        if (qtdeRow > 0)
            msgReturn = "Exclusão realizada com sucesso!";

        return msgReturn;
    }

    public String deleteId(long id) throws Exception {
        Operadora operadora = new Operadora();
        operadora.setId(id);
        return delete(operadora);
    }

    //Methods resusable
    private String getSintaxeWhereId(long id) {
        Operadora operadora = new Operadora();
        operadora.setId(id);
        return getSintaxeWhereId(operadora);
    }

    private String getSintaxeWhereId(Operadora operadora) {
        return "where id = ".concat(String.valueOf(operadora.getId()));
    }

    private Operadora execSqlDbGetOperadora(String sql) {
        Operadora operadora = new Operadora();
        try {
            ResultSet rs = new Conexao().consultaSql(sql);
            rs.next();
            operadora = getItemRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operadora;
    }

    private Operadora getItemRow(ResultSet rs) throws SQLException {
        Operadora operadora = new Operadora();

        if (rs == null || rs.getRow() == 0) {
            return operadora;
        }

        operadora.setId(rs.getInt("id"));
        operadora.setNome(rs.getString("nome"));
        operadora.setDdd(rs.getString("ddd"));
        operadora.setCategoria(rs.getInt("categoria"));
        return operadora;
    }

    //Methods validete
    private void validaCampoObrigatorio(Operadora operadora) throws Exception {
        if (operadora.getId() <= 0)
            throw new Exception("Identificador do registro não informado para CRUD do registro!");
    }

}
