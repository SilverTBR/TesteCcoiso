package controllers;

import connection.ConnectionFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ControllerReports {

    Connection connection = ConnectionFactory.openConnection();
    public static final String reports_path = System.getProperty("user.dir") + "/src/reports/";

    public static final File product_report_file = new File(reports_path, "products.jrxml");
    public static final File specific_product_report_file = new File(reports_path, "specificProduct.jrxml");
    public static final File product_report_pdf_file = new File(reports_path, "products.pdf");

    public static final File client_report_file = new File(reports_path, "clients.jrxml");
    public static final File specific_client_report_file = new File(reports_path, "specificClient.jrxml");
    public static final File group_client_report_file = new File(reports_path, "groupByClients.jrxml");
    public static final File client_report_pdf_file = new File(reports_path, "clients.pdf");

    public static final File distributor_report_file = new File(reports_path, "distributors.jrxml");
    public static final File specific_distributor_report_file = new File(reports_path, "specificDistributor.jrxml");
    public static final File distributor_report_pdf_file = new File(reports_path, "distributors.pdf");

    public JasperPrint compileReportFile(Map params, File file, File specificFile) {
        JasperPrint print = null;
        try {
            if (params != null) {
                FileInputStream arquivo = new FileInputStream(specificFile);
                JasperReport relatorio = JasperCompileManager.compileReport(arquivo);
                print = JasperFillManager.fillReport(
                        relatorio,
                        params,
                        connection);
            } else {
                FileInputStream arquivo = new FileInputStream(file);
                JasperReport relatorio = JasperCompileManager.compileReport(arquivo);
                print = JasperFillManager.fillReport(
                        relatorio,
                        null,
                        connection);
            }
        } catch (FileNotFoundException | JRException erro) {
            System.err.println("Não foi possível visualizar o relatório .\n\n" + erro);
        }

        return print;
    }

    public void ProductReport(Map params, boolean view) {
        if (view) {
            JasperViewer.viewReport(compileReportFile(params, product_report_file, specific_product_report_file), false);
        } else {
            try {
                JasperExportManager.exportReportToPdfFile(
                        compileReportFile(params, product_report_file, specific_product_report_file),
                        product_report_pdf_file.getAbsolutePath()
                );
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + product_report_pdf_file.getAbsolutePath());
            } catch (JRException ex) {
                Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void ClientReport(Map params, boolean view) {
        if (view) {
            JasperViewer.viewReport(compileReportFile(params, client_report_file, specific_client_report_file), false);
        } else {
            try {
                JasperExportManager.exportReportToPdfFile(
                        compileReportFile(params, client_report_file, specific_client_report_file),
                        client_report_pdf_file.getAbsolutePath()
                );
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + client_report_pdf_file.getAbsolutePath());
            } catch (JRException ex) {
                Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void groupClientReport(Map params, boolean view) {
        if (view) {
            JasperViewer.viewReport(compileReportFile(params, group_client_report_file, specific_client_report_file), false);
        } else {
            try {
                JasperExportManager.exportReportToPdfFile(
                        compileReportFile(params, group_client_report_file, specific_client_report_file),
                        group_client_report_file.getAbsolutePath()
                );
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + group_client_report_file.getAbsolutePath());
            } catch (JRException ex) {
                Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void DistributorReport(Map params, boolean view) {
        if (view) {
            JasperViewer.viewReport(compileReportFile(params, distributor_report_file, specific_distributor_report_file), false);
        } else {
            try {
                JasperExportManager.exportReportToPdfFile(
                        compileReportFile(params, distributor_report_file, specific_distributor_report_file),
                        distributor_report_pdf_file.getAbsolutePath()
                );
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + distributor_report_pdf_file.getAbsolutePath());
            } catch (JRException ex) {
                Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Map buildParams(String paramName, String message) {
        Map params = new HashMap();
        int max = Integer.valueOf(JOptionPane.showInputDialog(
                null,
                message,
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE));

        params.put(paramName, max);
        return params;
    }
}
