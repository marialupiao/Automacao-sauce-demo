package br.sefaz.com.exception;

import br.sefaz.com.evidencias.evidence.OperadorEvidencia;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;

public class SefazException extends Exception {

	public SefazException(OperadorEvidencia operador, String message, Exception ex) throws Exception {
		operador.salvarEvidencia("CAPTURA DE IMAGEM DO ERRO");
		Assert.fail(message, ex.getCause());
	}

	public SefazException(String message, Exception ex) {
		Reporter.log("\n\n");
		Reporter.log(message);
		Reporter.log(ex.getMessage());
		Assert.fail(message, ex.getCause());
	}

	public SefazException(String reason, NoSuchElementException cause) {
		throw new NoSuchElementException(reason, cause);
	}
}
