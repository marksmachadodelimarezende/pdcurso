package core.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Conexao {
    private static final Logger logger = LoggerFactory.getLogger(ConexaoProperties.class);
    private Connection con;

    public Conexao() {
        ConexaoHelper conHelper = new ConexaoProperties().getDataSource();
        try {
            Class.forName(conHelper.getDriver());
            con = DriverManager.getConnection(conHelper.getUrlJdbc(), conHelper.getUsername(), conHelper.getPassword());
            logger.info("Conect DB Success");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error in conect db postgreSQL!", e);
        }
    }

    public Connection getCon() {
        return con;
    }

    public int executaSql(String sql){
        try (Statement statement = con.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet consultaSql(String sql) throws SQLException {
        try(Statement stm = con.createStatement()) {
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
