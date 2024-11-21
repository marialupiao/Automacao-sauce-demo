package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BasePage {
    public CompletePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement tituloPaginaComplete;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    private WebElement mensagemThankYou;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/div")
    private WebElement mensagemDescricao;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElement botaoBackHome;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement botaoMenu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logout;

    @Step("Validar o titulo da Pagina Complete")
    public CompletePage validarTituloPaginaComplete() throws Exception {
        aguardarCarregamentoElemento(tituloPaginaComplete);
        validarAtributoTexto(tituloPaginaComplete, Alertas.TITULO_PAGINA_COMPLETE.toString(), "Não foi possivel validar o titulo da pagina complete");
        salvarEvidencia("Validar titulo da pagina complete");
        return this;
    }

    @Step("Validar o texto Thank you for your order")
    public CompletePage validarMensagemThankYou() throws Exception {
        aguardarCarregamentoElemento(mensagemThankYou);
        validarAtributoTexto(mensagemThankYou, Alertas.MENSAGEM_THANK_YOU.toString(), "Não foi possivel validar a mensagem Thank you for your order");
        salvarEvidencia("Validar texto Thank you for your order");
        return this;
    }

    @Step("Validar mensagem de descricao")
    public CompletePage validarMensagemDescricao() throws Exception {
        aguardarCarregamentoElemento(mensagemDescricao);
        validarAtributoTexto(mensagemDescricao, Alertas.MENSAGEM_DESCRICAO.toString(), "Não foi possivel validar a mensagem de descriçao");
        salvarEvidencia("Validar mensagem de descricao");
        return this;
    }

    @Step("Clicar no botao Back Home")
    public CompletePage clicarBotaoBackHome() throws Exception {
        aguardarCarregamentoElemento(botaoBackHome);
        clicarElemento(botaoBackHome, "Não foi possivel clicar no botao Back Home");
        salvarEvidencia("Clicar no botao Back Home");
        return this;
    }

    @Step("Clicar no botao Menu")
    public CompletePage clicarBotaoMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        clicarElemento(botaoMenu, "Não foi possivel clicar no botão menu");
        salvarEvidencia("Clicar no botao Menu");
        return this;
    }

    @Step("Clicar em Logout")
    public CompletePage clicarLogout() throws Exception {
        aguardarCarregamentoElemento(logout);
        clicarElemento(logout, "Não foi possivel clicar em logout");
        salvarEvidencia("Clicar em Logout");
        return this;
    }
}
