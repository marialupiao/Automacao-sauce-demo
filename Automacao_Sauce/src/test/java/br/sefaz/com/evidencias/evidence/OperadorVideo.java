package br.sefaz.com.evidencias.evidence;

import br.sefaz.com.core.Propriedades;

public class OperadorVideo {
    public static void iniciaGravacao () {
            if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
                switch (Propriedades.BROWSER) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver",
                                System.getProperty("user.dir") + "/src/driver/chromedriver.exe");
                        break;
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver",
                                System.getProperty("user.dir") + "/src/driver/geckodriver.exe");
                        break;
                    case EXPLORER:
                        System.setProperty("webdriver.ie.driver",
                                System.getProperty("user.dir") + "/src/driver/IEDriverServer.exe");
                        break;
                    case EDGE:
                        System.setProperty("webdriver.edge.driver",
                                System.getProperty("user.dir") + "/src/driver/msedgedriver.exe");
                        break;
                }
            }

            if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
                switch (Propriedades.BROWSER) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver",
                                System.getProperty("user.dir") + "/src/driver/chromedriver.exe");
                        break;
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver",
                                System.getProperty("user.dir") + "/src/driver/geckodriver.exe");
                        break;
                    case EXPLORER:
                        System.setProperty("webdriver.ie.driver",
                                System.getProperty("user.dir") + "/src/driver/msedgedriver.exe");
                        break;
                }
            }
        }
}