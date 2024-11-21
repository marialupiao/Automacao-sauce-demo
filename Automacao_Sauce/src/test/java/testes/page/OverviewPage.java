package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement tituloPaginaOverview;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement valorSauceLabsBackpack;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]")
    private WebElement shippingInformation;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    private WebElement priceTotal;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement botaoFinish;


    @Step("Validar Titulo da Pagina Overview")
    public OverviewPage validarTituloPaginaOverview() throws Exception {
        aguardarCarregamentoElemento(tituloPaginaOverview);
        validarAtributoTexto(tituloPaginaOverview, Alertas.TITULO_PAGINA_OVERVIEW.toString(), "Não foi possível validar o titulo da Pagina Overview");
        salvarEvidencia("Validar Titulo da Pagina Overview");
        return this;
    }

    @Step("Validar o valor do item Sauce Labs Backpack na page Overview")
    public OverviewPage validarValorSauceLabsBackpack() throws Exception {
        aguardarCarregamentoElemento(valorSauceLabsBackpack);
        validarAtributoTexto(valorSauceLabsBackpack, Alertas.PRECO_SAUCE_LABS_BACKPACK.toString(), "Não foi possível validar o valor do item Sauce Labs Backpack");
        salvarEvidencia("Validar Valor Item Sauce Labs Backpack");
        return this;
    }

    @Step("Validar Shipping Information")
    public OverviewPage validarShippingInformation() throws Exception {
        aguardarCarregamentoElemento(shippingInformation);
        validarAtributoTexto(shippingInformation, Alertas.SHIPPING_INFORMATION.toString(), "Não foi possível validar o conteúdo de Shipping Information");
        salvarEvidencia("Validar Shipping Information");
        return this;
    }

    @Step("Validar Price Total")
    public OverviewPage validarPriceTotal() throws Exception {
        aguardarCarregamentoElemento(priceTotal);
        validarAtributoTexto(priceTotal, Alertas.PRICE_TOTAL.toString(), "Não foi possível validar o Price Total");
        salvarEvidencia("Validar Price Total");
        return this;
    }

    @Step("Clicar no Botao Finish")
    public OverviewPage clicarBotaoFinish() throws Exception {
        aguardarCarregamentoElemento(botaoFinish);
        clicarElemento(botaoFinish, "Não foi possível clicar no botão Finish");
        salvarEvidencia("Clicar no botão Finish");
        return this;
    }



}
