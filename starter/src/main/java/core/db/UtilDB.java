package core.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilDB extends Conexao {

    private static final Logger logger = LoggerFactory.getLogger(UtilDB.class);

    public static ResultSet getRegistro(String sql) throws SQLException {
        try {
            ResultSet rs = consultaSql(sql);
            rs.next();
            return rs;
        } catch (SQLException e) {
            String err = "Ocorreu um erro ao tentar consultar registro na tabela!";
            logger.error(err, e);
            throw new SQLException(err);
        }
    }
}
