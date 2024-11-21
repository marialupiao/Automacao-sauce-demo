package testes.testes;

import br.sefaz.com.core.contantes.Urls;
import br.sefaz.com.massa.LeitorMassaDados;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.json.simple.JSONObject;
import testes.funcionalidade.CartFunc;
import testes.funcionalidade.InventoryFunc;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class InventoryTeste {


    @E("testo todos componentes")
    public void testoTodosComponentes() throws Exception {
        InventoryFunc.verProdutos();
    }

}
