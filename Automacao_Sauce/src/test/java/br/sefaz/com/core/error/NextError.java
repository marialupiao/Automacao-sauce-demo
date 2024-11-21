package br.sefaz.com.core.error;

import br.sefaz.com.evidencias.evidence.OperadorEvidencia;
import org.testng.Assert;
import org.testng.Reporter;

/**
 Classe NextError que extende a classe Error
 @author Bianco Carvalho
 */
public class NextError extends Error {

    /**
     * Construtor que recebe um operador de evid�ncia, uma mensagem e uma exce��o
     * Salva a evid�ncia da captura de imagem do erro e registra a mensagem de erro
     * no relat�rio
     * @param operador Operador de evid�ncia
     * @param message Mensagem de erro
     * @param ex Exce��o ocorrida
     */
public NextError(OperadorEvidencia operador, String message, Error ex) throws Exception {
    operador.salvarEvidencia("CAPTURA DE IMAGEM DO ERRO");
    Reporter.log(ex.getMessage());
    Assert.fail(message, ex.getCause());
}

    /**
     * Construtor que recebe uma mensagem e uma exce��o
     * Registra a mensagem de erro no relat�rio
     * @param message Mensagem de erro
     * @param ex Exce��o ocorrida
     */
public NextError(String message, Error ex) {
    Reporter.log(ex.getMessage());
    Assert.fail(message, ex.getCause());
}
}
