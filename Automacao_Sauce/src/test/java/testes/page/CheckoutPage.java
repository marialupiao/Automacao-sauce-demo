package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.qameta.allure.Step;
import org.apache.commons.collections4.functors.ExceptionPredicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement tituloPaginaCheckout;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement campoFirstName;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement campoLastName;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement campoPostalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement botaoContinue;

    @Step("Validar título da página Checkout")
    public CheckoutPage validarTituloPageCheckout() throws Exception {
        aguardarCarregamentoElemento(tituloPaginaCheckout);
        validarAtributoTexto(tituloPaginaCheckout, Alertas.TITULO_PAGINA_CHECKOUT.toString(), "Não foi possível validar titulo da pagina Checkout");
        salvarEvidencia("Validar Titulo da Pagina Checkout");
        return this;
    }

    @Step("Preencher campo First Name")
    public CheckoutPage preencherCampoFirstName() throws Exception {
        aguardarCarregamentoElemento(campoFirstName);
        digitarTexto(campoFirstName, "Joao", "Nao foi possivel preencher o campo First Name");
        salvarEvidencia("Preencher o campo First Name");
        return this;
    }

    @Step("Preencher campo Last Name")
    public CheckoutPage preencherCampoLastName() throws Exception {
        aguardarCarregamentoElemento(campoLastName);
        digitarTexto(campoLastName, "da Silva", "Não foi possível preencher o campo Last Name");
        salvarEvidencia("Preencher o campo Last Name");
        return this;
    }

    @Step("Preencher campo Postal Code")
    public CheckoutPage preencherCampoPostalCode() throws Exception {
        aguardarCarregamentoElemento(campoPostalCode);
        digitarTexto(campoPostalCode, "11075701", "Não foi possível preencher o campo Postal Code");
        salvarEvidencia("Preencher o campo Postal Code");
        return this;
    }

    @Step("Clicar no botão Continue")
    public CheckoutPage clicarNoBotaoContinue() throws Exception {
        aguardarCarregamentoElemento(botaoContinue);
        clicarElemento(botaoContinue, "Não foi possível clicar no botão Continue");
        salvarEvidencia("Clicar no botão Continue");
        return this;
    }




}
