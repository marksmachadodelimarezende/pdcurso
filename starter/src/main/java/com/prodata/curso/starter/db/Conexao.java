package comum.db;

import org.jboss.logging.Logger;

import java.sql.*;
import java.util.Collections;

public class Conexao {
    private Connection con;

    public Conexao() {
        ConexaoHelper conHelper = new ConexaoProperties().getDataSource();
        try {
            Class.forName(conHelper.getDriver());
            con = DriverManager.getConnection(conHelper.getUrlJdbc(), conHelper.getUsername(), conHelper.getPassword());
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.INFO, "Conect DB Success");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.ERROR, "Error in conect db postgreSQL!", e);
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

    public ResultSet consultaSql(String sql) {
        try(Statement stm = con.createStatement()) {
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return (ResultSet) Collections.emptyList();
        }
    }
}
