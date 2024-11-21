package br.sefaz.com.evidencias.evidence;

import br.sefaz.com.core.contantes.Projeto;
import br.sefaz.com.evidencias.relatorio.GeneradorEvidenciaReport;
import br.sefaz.com.exception.SefazException;
import junit.framework.TestCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import testes.testes.Hooks.Hooks;

import java.io.IOException;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class OperadorEvidencia {

	public void salvarEvidencia(String descricao) throws Exception {

		try {
			Hooks.evidences.add(new SelecaoEvidencia("[PASSO]" + "     " + " - " + " [ " + descricao + " ]", getScrrenshotAsBase64(getDriver())));
		} catch (SefazException var31) {
			Hooks.evidences.add(new SelecaoEvidencia("[PASSO]" + "     " + " - " + "[" + descricao + "]", getScrrenshotAsBase64(getDriver())));
			setError(var31);
			Reporter.log("N�o foi poss�vel salvar o Screenshot");
		}
		finally {
			logarPasso(descricao );
			//gerarEvidencia();
		}
	}

	public static synchronized void gerarEvidencia (String erros) {
		String usuario = System.getProperty("user.name");
		String sistema = System.getProperty("os.name");
		RelatorioEvidencia report = new RelatorioEvidencia(Hooks.evidences, usuario,
				Projeto.SEFAZ.getJornada(), erros, sistema, Projeto.DEC.getJornada());
		try {
			GeneradorEvidenciaReport.generareEvidenceReport(report, EvidenciaTipo.PDF);
		} catch (IOException var6) {
			var6.printStackTrace();
		} finally {
			logarPasso(erros);
		}
	}

	private String calcularTempoExecucao(ITestResult result) {
		long minutos = (result.getEndMillis() - result.getStartMillis()) / 1000L / 60L;
		long segundos = (result.getEndMillis() - result.getStartMillis()) / 1000L % 60L;
		return minutos + "m" + segundos + "s";
	}
	private void setError(Throwable t)  {
		try {
			Hooks.evidences.add(new SelecaoEvidencia(t.getLocalizedMessage(), getScrrenshotAsBase64(getDriver())));
			TestCase.fail(t.getMessage());
		} catch (Exception var3) {
			var3.printStackTrace();
			Reporter.log("N�o foi poss�vel salvar o Screenshot");
		}
	}
	protected static String getScrrenshotAsBase64(WebDriver getDriver) {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	public static void logarPasso(String texto){
		Reporter.log("[PASSO] " + texto, true);
	}
}
