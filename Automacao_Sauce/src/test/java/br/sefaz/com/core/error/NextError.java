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
     * Construtor que recebe um operador de evidência, uma mensagem e uma exceção
     * Salva a evidência da captura de imagem do erro e registra a mensagem de erro
     * no relatório
     * @param operador Operador de evidência
     * @param message Mensagem de erro
     * @param ex Exceção ocorrida
     */
public NextError(OperadorEvidencia operador, String message, Error ex) throws Exception {
    operador.salvarEvidencia("CAPTURA DE IMAGEM DO ERRO");
    Reporter.log(ex.getMessage());
    Assert.fail(message, ex.getCause());
}

    /**
     * Construtor que recebe uma mensagem e uma exceção
     * Registra a mensagem de erro no relatório
     * @param message Mensagem de erro
     * @param ex Exceção ocorrida
     */
public NextError(String message, Error ex) {
    Reporter.log(ex.getMessage());
    Assert.fail(message, ex.getCause());
}
}
