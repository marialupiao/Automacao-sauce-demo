package testes.testes.Hooks;

import br.sefaz.com.core.BasePage;
import br.sefaz.com.evidencias.evidence.SelecaoEvidencia;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.testng.Reporter;

import java.util.ArrayList;

import static br.sefaz.com.evidencias.evidence.OperadorVideo.iniciaGravacao;

public class Hooks extends BasePage {

    public static ArrayList<SelecaoEvidencia> evidences = null;
    public static String name;

    @Before
    public static void setUp(Scenario scenario) {
        iniciaGravacao();
        name = scenario.getName();
        evidences = new ArrayList<>();
    }
        @After
    public static void cenario(Scenario scenario) {
        String descricao = scenario.getStatus() + " - " + scenario.getName();
        if (scenario.getStatus() == Status.FAILED) {
            gerarEvidencia("Cenário Falhou: " + scenario.getName());
            Reporter.log(descricao, true);
        } else {
            if (scenario.getStatus() == Status.SKIPPED) {
                gerarEvidencia("Cenário Ignorado: " + scenario.getName());
                Reporter.log(descricao, true);
            } else {
                if (scenario.getStatus() == Status.PASSED)
                    gerarEvidencia("");
                Reporter.log(descricao, true);
            }
        }
    }
}