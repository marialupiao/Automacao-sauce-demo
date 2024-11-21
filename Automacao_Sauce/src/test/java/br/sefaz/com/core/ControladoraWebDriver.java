package br.sefaz.com.core;

import org.openqa.selenium.WebDriver;

public abstract class ControladoraWebDriver {

	protected WebDriver driver;

    public ControladoraWebDriver() {
    }

    protected abstract void criarWebDriver();

    public WebDriver getWebDriver() {
        if (this.driver == null) {
            this.criarWebDriver();
        }

        return this.driver;
    }
}