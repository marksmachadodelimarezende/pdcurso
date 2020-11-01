package core.db;

public class ConexaoHelper {
    private String driver;
    private String server;
    private String port;
    private String dbname;
    private String username;
    private String password;
    private String urlJdbc;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlJdbc() {
        return urlJdbc;
    }

    public void setUrlJdbc(String urlJdbc) {
        this.urlJdbc = urlJdbc;
    }
}
