package br.sefaz.com.core.contantes;

public enum Urls {
    SAUCE ("https://www.saucedemo.com/");
    private final String url;

    Urls(String value) {
        this.url = value;
    }

    public String getUrl(){
        return url;
    }


}
