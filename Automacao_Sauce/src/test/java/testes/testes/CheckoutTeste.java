package testes.testes;

import io.cucumber.java.pt.E;
import testes.funcionalidade.CheckoutFunc;

public class CheckoutTeste {

    @E("testo os componentes da pagina de checkout")
    public void testoComponentesCheckout() throws Exception {
        CheckoutFunc.verCheckout();
    }
}
