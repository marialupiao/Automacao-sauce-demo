package br.sefaz.com.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> threadDriver = ThreadLocal.withInitial(DriverFactory::initDriver);

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	private static WebDriver initDriver() {
		WebDriver driver = null;

		if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
			try {
				switch (Propriedades.BROWSER) {
					case CHROME:
						driver = createChromeDriver();
						break;

					case FIREFOX:
						driver = createFirefoxDriver();
						break;

					case EXPLORER:
						driver = createIEDriver();
						break;

					case EDGE:
						driver = createEdgeDriver();
						break;

					default:
						throw new IllegalArgumentException("Navegador não suportado: " + Propriedades.BROWSER);
				}
			} catch (Exception e) {
				System.err.println("Erro ao configurar o driver para o navegador selecionado: " + e.getMessage());
				e.printStackTrace();
				throw e; // Lança exceção para falhar o teste
			}
		}

		return driver;
	}

	private static WebDriver createChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		configureChromeOptions(options);
		return new ChromeDriver(options);
	}

	private static void configureChromeOptions(ChromeOptions options) {
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		// Adicione o modo headless se necessário
		if (Propriedades.isHeadless()) {
			options.addArguments("--headless");
		}
	}

	private static WebDriver createFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		configureFirefoxOptions(options);
		return new FirefoxDriver(options);
	}

	private static void configureFirefoxOptions(FirefoxOptions options) {
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1580,1280");
		if (Propriedades.isHeadless()) {
			options.setHeadless(true);
		}
	}

	private static WebDriver createIEDriver() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

	private static WebDriver createEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}

	public static void fecharDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			Reporter.log("===============================================", true);
			Reporter.log("Finalizando o DRIVER...", true);
			Reporter.log("===============================================", true);
		}
		threadDriver.remove();
	}

	public static void limpaCookies() {
		WebDriver driver = getDriver();
		driver.manage().deleteAllCookies();
	}

	public static void logDriver() {
		if (Propriedades.FECHAR_BROWSER) {
			fecharDriver();
		}
	}
}
