package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement senha;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    @Step("Login")
    public LoginPage NomeUsuario(String logar) throws Exception {
        aguardarCarregamentoElemento(login);
        digitarTexto(login, logar, "Nao foi possivel inserir o login");
        salvarEvidencia("Insere o login no sistema");
        return this;
    }
    @Step("Senha")
    public LoginPage SenhaUsuario(String password) throws Exception {
        aguardarCarregamentoElemento(senha);
        digitarTexto(senha, password, "Nao foi possivel inserir a senha");
        salvarEvidencia("Insere a senha no sistema");
        return this;
    }
    @Step("Clicar")
    public void ClicarBtnLogin() throws Exception {
        aguardarCarregamentoElemento(btnLogin);
        clicarElemento(btnLogin, "Não foi possível clicar no botão de login");
    }
}
