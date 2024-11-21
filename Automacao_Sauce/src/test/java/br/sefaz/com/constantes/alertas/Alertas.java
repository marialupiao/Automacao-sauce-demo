package br.sefaz.com.constantes.alertas;

public enum Alertas {

    TITULO_PAGINA_INVENTORY("Products"),
    TITULO_INVENTORY_ITEM_NAME("Sauce Labs Backpack"),
    DESCRICAO_SAUCE_LABS_BACKPACK("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
    PRECO_SAUCE_LABS_BACKPACK("$29.99"),
    TITULO_PAGINA_CARRINHO("Your Cart"),
    ICONE_CARRINHO(" 1"),
    TITULO_PAGINA_CHECKOUT("Checkout: Your Information"),
    TITULO_PAGINA_OVERVIEW("Checkout: Overview"),
    SHIPPING_INFORMATION("Free Pony Express Delivery!"),
    PRICE_TOTAL("Total: $32.39"),
    TITULO_PAGINA_COMPLETE("Checkout: Complete!"),
    MENSAGEM_THANK_YOU("Thank you for your order!"),
    MENSAGEM_DESCRICAO("Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    private final String value;

    Alertas(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }
}


