package br.sefaz.com.executa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


@CucumberOptions(
            plugin = {"pretty", "html:./src/test/evidencias/Relatorio/Relatorio.html"},
            features = {"src/test/resources/features/Sauce.feature"},
            glue = {"testes.testes"},
            tags = "@Executa and not @nExecuta",
            monochrome = true,
            dryRun = false,
            snippets = CucumberOptions.SnippetType.CAMELCASE
    )
public class ExecutaLoginIT extends AbstractTestNGCucumberTests implements ITest {

    private String scenarioName;

    @AfterSuite
    public static void mataProcesso() throws IOException {
        //mataProcessos();
    }

    @BeforeMethod
    public void beforeMethod(Object[] testData) {
        //scenarioName = ((PickleWrapper) testData[0]).getPickle().getName();
        scenarioName = "";
    }

    @Override
    public String getTestName() {
        return scenarioName ;
    }
}