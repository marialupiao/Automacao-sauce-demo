package testes.page;

import br.sefaz.com.constantes.alertas.Alertas;
import br.sefaz.com.core.BasePage;
import io.cucumber.java.sl.In;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.rmi.server.ExportException;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    private WebElement tituloTelaInventory;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")
    private WebElement filtroZToA;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")
    private WebElement filtroAToZ;

    @FindBy(className ="inventory_item_name" )
    private WebElement btnSauceLabsBackpack;

    @FindBy(xpath = "//*[@id='inventory_item_container']/div/div/div[2]/div[1]")
    private WebElement tituloInventoryItemName;

    @FindBy(xpath = "//*[@id=\'inventory_item_container\']/div/div/div[2]/div[2]" )
    private WebElement descricaoSauceLabsBackpack;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    private WebElement precoSauceLabsBackpack;

    @FindBy(xpath = "//*[@id=\"add-to-cart\"]")
    private WebElement btnAddToCart;

//    @FindBy(xpath = "//*[@id=\"remove\"]")
//    private WebElement btnRemove;


    @Step("validar Titulo Tela();")
    public InventoryPage validarTituloTela() throws Exception{
        aguardarCarregamentoElemento(tituloTelaInventory);
        validarAtributoTexto(tituloTelaInventory,Alertas.TITULO_PAGINA_INVENTORY.toString(),"Não foi possível validar o título da página") ;
        salvarEvidencia("validar titulo pagina inventory");
        return this;
    }

    @Step("Selecionar Z to A")
    public InventoryPage selecionarZToA() throws Exception {
        aguardarCarregamentoElemento(filtroZToA);
        clicarElemento(filtroZToA, "Não foi possível selecionar filtro Z to A");
        salvarEvidencia("Selecionar filtro Z to A");
        return this;
    }

    @Step("Selecionar A to Z")
    public InventoryPage selecionarAToZ() throws Exception {
        aguardarCarregamentoElemento(filtroAToZ);
        clicarElemento(filtroAToZ, "Não foi possível selecionar filtro A to Z");
        salvarEvidencia("Selecionar filtro A to Z");
        return this;
    }

    @Step("Clicar no btn Sauce Labs backpack")
    public InventoryPage clicarBtnSauceLabsBackpack() throws Exception{
           aguardarCarregamentoElemento(btnSauceLabsBackpack);
           clicarElemento(btnSauceLabsBackpack,"não foi possível clicar no botao");
           salvarEvidencia("Clicar no btn Sauce Labs backpack");
           return this;
    }

    @Step("Validar Titulo Inventory Item Name")
    public InventoryPage validarTituloInventoryItemName() throws Exception{
        aguardarCarregamentoElemento(tituloInventoryItemName);
        validarAtributoTexto(tituloInventoryItemName, Alertas.TITULO_INVENTORY_ITEM_NAME.toString(), "Não foi possível validar o título do Item");
        salvarEvidencia("Validar Titulo Inventory Item Name");
        return this;
    }

    @Step("Validar Descricao Sauce Labs Backpack")
    public InventoryPage validarDescricaoSauceLabsBackpack() throws Exception{
        aguardarCarregamentoElemento(descricaoSauceLabsBackpack);
        validarAtributoTexto(descricaoSauceLabsBackpack, Alertas.DESCRICAO_SAUCE_LABS_BACKPACK.toString(), "Não foi possível validar a descrição de Sauce Labs Backpack");
        salvarEvidencia("Validar Descricao Sauce Labs Backpack");
        return this;
    }

    @Step("Validar Preco Sauce Labs Backpack")
    public InventoryPage validarPrecoSauceLabsBackpack() throws Exception{
        aguardarCarregamentoElemento(precoSauceLabsBackpack);
        validarAtributoTexto(precoSauceLabsBackpack, Alertas.PRECO_SAUCE_LABS_BACKPACK.toString(), "Não foi possível validar o preço de Sauce Labs Backpack");
        salvarEvidencia("Validar Preco Sauce Labs Backpack");
        return this;
    }

    @Step("Clicar no Botão Add To Cart")
    public InventoryPage clicarBtnAddToCart() throws Exception{
        aguardarCarregamentoElemento(btnAddToCart);
        clicarElemento(btnAddToCart, "Não foi possível clicar no botão Add to cart");
        salvarEvidencia("Clicar no Botão Add To Cart");
        return this;
    }



//    @Step("Clicar no Botão Remove")
//    public InventoryPage clicarBtnRemove() throws Exception {
//        aguardarCarregamentoElemento(btnRemove);
//        clicarElemento(btnRemove, "Não foi possível clicar no botão Remove");
//        salvarEvidencia("Clicar no botão Remove");
//        return this;
//    }
}
