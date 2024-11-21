package testes.testes;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import testes.funcionalidade.OverviewFunc;

public class OverviewTeste {

    @E("testo os componentes da Pagina Overview")
    public void testoOsComponentesDaPaginaOverview() throws Exception {
        OverviewFunc.verOverview();
        //throw new io.cucumber.java.PendingException();
    }
}
