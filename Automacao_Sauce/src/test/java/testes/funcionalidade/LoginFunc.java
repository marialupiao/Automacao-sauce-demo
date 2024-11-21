package testes.funcionalidade;

import br.sefaz.com.base.FuncionalidadesBaseWeb;
import testes.page.LoginPage;

import static br.sefaz.com.core.DriverFactory.getDriver;

public class LoginFunc extends FuncionalidadesBaseWeb {

    public void realizarLogin(String nome, String senha) throws Exception{
            new LoginPage(getDriver())
                    .NomeUsuario(nome)
                    .SenhaUsuario(senha)
                    .ClicarBtnLogin();
         }
}
