package testes.testes;

import io.cucumber.java.pt.E;
import testes.funcionalidade.CompleteFunc;

public class CompleteTeste {

    @E("testo os componentes da pagina Complete")
    public void testoOsComponentesDaPaginaComplete() throws Exception {
        CompleteFunc.verComplete();
    }

}
