package testes.testes;

import br.sefaz.com.core.contantes.Urls;
import br.sefaz.com.massa.LeitorMassaDados;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.simple.JSONObject;
import testes.funcionalidade.LoginFunc;

import static br.sefaz.com.core.DriverFactory.getDriver;
import static br.sefaz.com.core.DriverFactory.logDriver;

public class LoginTeste {

    LoginFunc loginFunc = new LoginFunc();
    JSONObject recuperarMassa = LeitorMassaDados.leitorMassa("login", "logins");

    @Dado("que eu acesse o site")
    public void queEuAcesseOSite() {
        getDriver().get(Urls.SAUCE.getUrl());
    }
    @Quando("Logo no sistema com sucesso")
    public void logoNoSistemaComSucesso() throws Exception {
        loginFunc.realizarLogin(
                (String) recuperarMassa.get("usuario"),
                (String) recuperarMassa.get("senha")
        );
    }
    @Entao("Finaliza o sistema")
    public void finalizaOSistema() {
        logDriver();
    }
}