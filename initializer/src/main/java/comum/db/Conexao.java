package comum.db;

import org.jboss.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url;
    private String user;
    private String password;
    private Connection con;

    public Conexao() {
        url = "jdbc:postgresql://localhost:5432/pdcurso";
        user = "postgres";
        password = "root";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.INFO, "Conect DB Success");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Logger.Level.ERROR, "Error in conect db postgreSQL!", e);
        }
    }

    public Connection getCon() {
        return con;
    }
}
