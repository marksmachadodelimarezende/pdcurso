package core.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConexaoProperties {
    private static final Logger logger = LoggerFactory.getLogger(ConexaoProperties.class);
    private static final String CONEXAO_PROPERTIES = "src/main/java/core/db/conexao.properties";

    protected ConexaoHelper getDataSource() {
        ConexaoHelper conexaoHelper = new ConexaoHelper();
        //Ler arquivo conexao.properties, que esta na mesma pasta desta classe
        try {
            String pathReal = new File(CONEXAO_PROPERTIES).getAbsolutePath();
            Path path = Paths.get(pathReal);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                setProperties(conexaoHelper, linha);
            }
            //Monta url Jdbc : jdbc:postgresql://localhost:5432/pdcurso
            String urlJdbc = "jdbc:postgresql://"
                    .concat(conexaoHelper.getServer())
                    .concat(":")
                    .concat(conexaoHelper.getPort())
                    .concat("/")
                    .concat(conexaoHelper.getDbname());
            conexaoHelper.setUrlJdbc(urlJdbc);
            logger.info("Arquivo de conexão lido com sucesso!");
        } catch (IOException e) {
            logger.error("Erro ao recuperar dados de conexão", e);
            e.printStackTrace();
        }
        return conexaoHelper;
    }

    private void setProperties(ConexaoHelper conexaoHelper, String linha) {
        if (!linha.isEmpty()){
            if (linha.startsWith("driver"))
                conexaoHelper.setDriver(linha.replace("driver=",""));

            if (linha.startsWith("server"))
                conexaoHelper.setServer(linha.replace("server=",""));

            if (linha.startsWith("port"))
                conexaoHelper.setPort(linha.replace("port=",""));

            if (linha.startsWith("dbname"))
                conexaoHelper.setDbname(linha.replace("dbname=",""));

            if (linha.startsWith("username"))
                conexaoHelper.setUsername(linha.replace("username=",""));

            if (linha.startsWith("password"))
                conexaoHelper.setPassword(linha.replace("password=",""));
        }
    }
}
