package com.prodata.curso.starter.core;

import core.db.Conexao;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class RunReportJasper extends Conexao {

    public void printReportPdf(HttpServletRequest request,HttpServletResponse response, Map<String, Object> params) {
        String pathReportJasper = "/reports/gerencial/listaContato.jasper";
        String[] arrayReportJasper = pathReportJasper.split("/");
        String nameReportJasper = arrayReportJasper[arrayReportJasper.length - 1];
        pathReportJasper = pathReportJasper.replace(nameReportJasper, "");
        String subReportDir = new File("").getAbsolutePath()+pathReportJasper;
        params.put("SUBREPORT_DIR",  subReportDir);

        String nameReportPdf = nameReportJasper.replace(".jasper", ".pdf");

        params.put("clausulaWhere", "Where true");
        params.put("nome_empresa", "Curso AngularJs + Spring Boot + PostgreSQL");
        params.put("titulo", "Listagem de contatos");

        try (Connection con = getCon()) {
            Path path = Paths.get(subReportDir+nameReportJasper);
            InputStream jasperStream = new FileInputStream(path.toString());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
            byte[] reportByte = JasperRunManager.runReportToPdf(path.toString(), params, con);

            //Adicionando relatorio para download
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=" + nameReportPdf);

            //Adicionar relatorio no Servlet
            OutputStream outputStream = response.getOutputStream();
            //JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            outputStream.write(reportByte);
            outputStream.flush();
            outputStream.close();

            jasperStream.close();

        } catch (JRException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
