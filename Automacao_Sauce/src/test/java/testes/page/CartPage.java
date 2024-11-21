package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement iconeCarrinho;

    @FindBy(className = "cart_item_label")
    private WebElement itemNoCarrinho;

    @FindBy(className = "title")
    private WebElement tituloPaginaCarrinho;

    @FindBy(xpath = " //*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement iconeQtdeCarrinho;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement btnCheckout;


    @Step("Clicar no Carrinho")
    public CartPage clicarNoCarrinho() throws Exception {
        aguardarCarregamentoElemento(iconeCarrinho);
        clicarElemento(iconeCarrinho, "Não foi possível clicar no carrinho");
        salvarEvidencia("Clicar no Carrinho");
        return this;
    }

    @Step("Validar Item no Carrinho")
    public CartPage validarItemNoCarrinho() throws Exception {
        verificarPresencaElemento(itemNoCarrinho);
        salvarEvidencia("Validar Item no Carrinho");
        return this;
    }

    @Step("Validar Titulo da Pagina Carrinho")
    public CartPage validarTituloPaginaCarrinho() throws Exception {
        aguardarCarregamentoElemento(tituloPaginaCarrinho);
        validarAtributoTexto(tituloPaginaCarrinho, Alertas.TITULO_PAGINA_CARRINHO.toString(), "Nao foi possivel validar o texto");
        salvarEvidencia("Validar Titulo Pagina Carrinho");
        return this;
    }

    @Step("Validar Icone Carrinho")
    public CartPage validarIconeCarrinho() throws Exception {
        aguardarCarregamentoElemento(iconeQtdeCarrinho);
        validarAtributoTexto(iconeQtdeCarrinho, Alertas.ICONE_CARRINHO.toString(), " Nao foi possivel validar o icone do carrinho");
        salvarEvidencia("Validar Icone do Carrinho");
        return this;
    }

    @Step("Clicar no btn Checkout")
    public CartPage clicarNoBtnCheckout() throws Exception {
        aguardarCarregamentoElemento(btnCheckout);
        clicarElemento(btnCheckout, "Nao foi possivel clicar no botao checkout");
        salvarEvidencia("Clicar no botao Checkout");
        return this;
    }

}
