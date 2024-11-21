package br.sefaz.com.tools;

import br.sefaz.com.core.BasePage;
import br.sefaz.com.core.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class GeradorPaginaWeb {

    public GeradorPaginaWeb() {
    }

    public <TPage extends BasePage> BasePage getInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(DriverFactory.getDriver(), pageClass);
        } catch (Exception var3) {
            var3.printStackTrace();
            throw var3;
        }
    }
}

	
