package br.sefaz.com.evidencias.relatorio;

import br.sefaz.com.EvidenciaUtils.EvidenciaUtils;
import br.sefaz.com.evidencias.evidence.EvidenciaTipo;
import br.sefaz.com.evidencias.evidence.RelatorioEvidencia;
import br.sefaz.com.evidencias.evidence.SelecaoEvidencia;
import br.sefaz.com.tools.Utilitarios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.testng.Reporter;
import testes.testes.Hooks.Hooks;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GeneradorEvidenciaReport {

    public GeneradorEvidenciaReport() {
    }
    public static void generareEvidenceReport(RelatorioEvidencia relatorioEvidencia, EvidenciaTipo reportType) throws IOException {

        List<SelecaoEvidencia> data = relatorioEvidencia.getEvidenceList();
        Properties properties = EvidenciaUtils.loadProperties();
        String evidenceDir = System.getProperty("user.dir") + System.getProperty("file.separator") +
                properties.getProperty("evidence.dir") + System.getProperty("file.separator") + Hooks.name + System.getProperty("file.separator");
        createEvidenceDir(evidenceDir);

        try {

            String companyImage = properties.getProperty("image.company.path");
            String customerImage = properties.getProperty("image.customer.path");
            String headerImage = properties.getProperty("image.header.path");
            String footerImage = properties.getProperty("image.footer.path");

            BufferedImage imageCompany;
            BufferedImage imageClient;
            BufferedImage headerCompany;
            BufferedImage footerCompany;

            if (companyImage == null || companyImage.equals("null")) {
                imageCompany = null;
            } else {
                imageCompany = ImageIO.read(new File(companyImage));
            }

            if (customerImage == null || customerImage.equals("null")) {
                imageClient = null;
            } else {
                imageClient = ImageIO.read(new File(customerImage));
            }

            if (headerImage == null || headerImage.equals("null")) {
                headerCompany = null;
            } else {
                headerCompany = ImageIO.read(new File(headerImage));
            }

            if (footerImage == null || footerImage.equals("null")) {
                footerCompany = null;
            } else {
                footerCompany = ImageIO.read(new File(footerImage));
            }

            String tester = relatorioEvidencia.getTester();
            if (tester == null) {
                tester = "";
            }

            String project = relatorioEvidencia.getProject();
            if (project == null) {
                project = "";
            }

            String excecao = relatorioEvidencia.getExceptionString();
            if (excecao == null) {
                excecao = "";
            }

            Map<String, Object> parameters = new HashMap();
            if (excecao != null) {
                parameters.put("SEL_EXCEPTION", excecao);
            }

            String sistema = relatorioEvidencia.getsistema();
            if (sistema == null) {
                sistema = "";
            }

            String jornada = relatorioEvidencia.getjornada();
            if (jornada == null) {
                jornada = "";
            }

            parameters.put("SEL_FOOTER_LOGO", footerCompany);
            parameters.put("SEL_HEADER_LOGO", headerCompany);
            parameters.put("SEL_COMPANY_LOGO", imageCompany);
            parameters.put("SEL_CUSTOMER_LOGO", imageClient);
            parameters.put("SEL_PROJECT", project);
            parameters.put("SEL_TESTER", tester);
            parameters.put("SEL_SISTEMA", sistema);
            parameters.put("SEL_JORNADA", jornada);
            parameters.put("SEL_LABEL_EVINDENCE_TITLE", properties.getProperty("label.evidenceReport"));
            parameters.put("SEL_LABEL_PROJECT", properties.getProperty("label.project"));
            parameters.put("SEL_LABEL_TESTER", properties.getProperty("label.tester"));
            parameters.put("SEL_LABEL_SISTEMA", properties.getProperty("label.sistema"));
            parameters.put("SEL_LABEL_JORNADA", properties.getProperty("label.jornada"));
            parameters.put("SEL_LABEL_STATUS", properties.getProperty("label.status"));
            parameters.put("SEL_LABEL_PASS", properties.getProperty("label.status.pass"));
            parameters.put("SEL_LABEL_FAILED", properties.getProperty("label.status.failed"));
            parameters.put("SEL_LABEL_EVIDENCE_REPORT", properties.getProperty("label.evidenceReport"));
            parameters.put("SEL_LABEL_DATE", properties.getProperty("label.date"));
            parameters.put("SEL_LABEL_FOOTER", properties.getProperty("label.footer"));
            parameters.put("SEL_LABEL_ERROR_DETAIL", properties.getProperty("label.errorDetail"));
            parameters.put("SEL_LABEL_PAGE", properties.getProperty("label.page"));
            parameters.put("SEL_LABEL_COMPANY_NAME", properties.getProperty("label.company.name"));

            JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(data);

            JasperPrint jasperPrint = JasperFillManager.fillReport(properties.getProperty("evidence.file")
                    ,parameters, datasource);

            switch (reportType) {
                case PDF:
                    JasperExportManager.exportReportToPdfFile(jasperPrint,  evidenceDir + Hooks.name + ".pdf");
                    Reporter.log("Evidência gerada em: " + evidenceDir + Hooks.name + ".pdf", true);
                    break;

                case HTML:
                    JasperExportManager.exportReportToHtmlFile(jasperPrint, evidenceDir + Hooks.name + " - " + Utilitarios.dataAtual() + ".html");
                    Reporter.log("Evidência gerada em: " + evidenceDir + Hooks.name + ".html", true);
                    break;
                default:
                    break;
            }

        } catch (SecurityException | JRException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean createEvidenceDir(String directory) {
        boolean dirExists = false;

        try {
            File dir = new File(directory);
            boolean exists = dir.exists();

            if (!exists) {
                dir.mkdir();
                dirExists = false;
            } else {
                dirExists = true;
            }
        } catch (SecurityException se) {
            se.printStackTrace();
        }
        return dirExists;
    }
}
