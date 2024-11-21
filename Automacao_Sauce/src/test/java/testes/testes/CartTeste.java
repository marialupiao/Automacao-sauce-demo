package testes.testes;

import io.cucumber.java.pt.E;
import testes.funcionalidade.CartFunc;

public class CartTeste {

    @E("testo todos componentes da pagina cart")
    public void testoTodosComponentesDaPaginaCart() throws Exception {
        CartFunc.verCarrinho();
    }
}
