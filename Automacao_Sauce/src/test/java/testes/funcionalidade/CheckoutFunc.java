package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.CheckoutPage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class CheckoutFunc extends FuncionalidadesBaseWeb {

    public static void verCheckout() throws Exception {
      new CheckoutPage(getDriver())
              .validarTituloPageCheckout()
              .preencherCampoFirstName()
              .preencherCampoLastName()
              .preencherCampoPostalCode()
              .clicarNoBotaoContinue();
    }
}
