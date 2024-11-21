package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.InventoryPage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class InventoryFunc extends FuncionalidadesBaseWeb {
    public static void verProdutos() throws Exception {
        new InventoryPage(getDriver())
                .validarTituloTela()
                .selecionarZToA()
                .selecionarAToZ()
                .clicarBtnSauceLabsBackpack()
                .validarTituloInventoryItemName()
                .validarDescricaoSauceLabsBackpack()
                .validarPrecoSauceLabsBackpack()
                .clicarBtnAddToCart();


    }
}
