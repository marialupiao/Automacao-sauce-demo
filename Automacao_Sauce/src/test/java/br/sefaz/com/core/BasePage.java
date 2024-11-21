package br.sefaz.com.core;

import br.sefaz.com.core.base.CondicoesEspera;
import br.sefaz.com.core.error.NextError;
import br.sefaz.com.evidencias.evidence.OperadorEvidencia;
import br.sefaz.com.exception.SefazException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static br.sefaz.com.core.DriverFactory.getDriver;
import static br.sefaz.com.tools.Utilitarios.normalizaString;

/**
 Classe BasePage que extende a classe OperadorEvidencia.
 @author Bianco Carvalho
 @since [04/10/2024]
 */
public class BasePage extends OperadorEvidencia {
	private final BasePage.Espera esperaPadrao;
	private static String valorArmazenado;

	public BasePage() {
		super();
		this.esperaPadrao = new BasePage.Espera();
	}

	protected <T> void clicarElemento(T elemento, String mensagemErro) throws Exception {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Espera com tempo máximo de 10 segundos
		try {
			WebElement webElement = this.retornaElemento(elemento);
			wait.until(ExpectedConditions.elementToBeClickable(webElement)); // Aguarda até o elemento estar clicável
			pausaElemento();
			webElement.click();
		} catch (ElementClickInterceptedException var7) {
			try {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", this.retornaElemento(elemento));
			} catch (NoSuchElementException var5) {
				throw new SefazException(var5.getMessage(), var5);
			} catch (Exception var6) {
				throw new SefazException(mensagemErro, var6);
			}
		} catch (NoSuchElementException var8) {
			throw new SefazException(var8.getMessage(), var8);
		} catch (Exception var9) {
			throw new SefazException(mensagemErro, var9);
		}
	}

	public static String obterValorArmazenado() {
		return valorArmazenado;
	}

	protected <T> void digitarTexto(T elemento, String texto, String mensagemErro) throws Exception {
		try {
			this.clicarElemento(elemento, mensagemErro);
			this.retornaElemento(elemento).sendKeys(new CharSequence[]{texto});
		} catch (NoSuchElementException var5) {
			throw new SefazException(var5.getMessage(), var5);
		} catch (Exception var6) {
			throw new SefazException(mensagemErro, var6);
		}
	}

	public <T> boolean validarImagem(T elemento, String urlImagemEsperada) throws SefazException {
		try {
			WebElement webElement = retornaElemento(elemento);
			String backgroundImage = webElement.getCssValue("background-image");
			return backgroundImage.contains(urlImagemEsperada);
		} catch (NoSuchElementException e) {
			throw new SefazException(e.getMessage(), e);
		} catch (Exception e) {
			throw new SefazException("Erro ao validar a imagem", e);
		}
	}


	protected <T> void validarAtributoTexto(T elemento, String texto, String mensagemErro) throws Exception {
		try {
			Assert.assertEquals(normalizaString(texto), normalizaString(this.retornaElemento(elemento).getText()));
		} catch (Exception var5) {
			throw new SefazException("Erro inesperado ao realizar a comparacao entre o texto do elemento e o texto esperado", var5);
		} catch (AssertionError var6) {
			throw new NextError(mensagemErro, var6);
		}
	}

	public <T> void rolarParaBaixoAteElemento(T elemento) {
		WebElement element = null;
		double fatorRolagem = 0.2D;
		boolean esperaEntreRolagens = true;
		double rolagem = (double) getDriver().manage().window().getSize().height * 0.2D;
		boolean passoRolagem = true;
		long inicio = System.currentTimeMillis();
		long tempoDecorrido = 0L;
		Object var13 = null;

		while (tempoDecorrido < 30000L) {
			try {
				if (elemento instanceof By) {
					element = new WebDriverWait(getDriver(), Duration.ofSeconds(1L)).until(ExpectedConditions.presenceOfElementLocated((By) elemento));
				} else {
					element = new WebDriverWait(getDriver(), Duration.ofSeconds(1L)).until(ExpectedConditions.visibilityOf((WebElement) elemento));
				}

				if (element != null) {
					inicio = System.currentTimeMillis();

					while (System.currentTimeMillis() - inicio < 30000L) {
						try {
							this.rolarJs(element);
							return;
						} catch (Exception var17) {
							Thread.sleep(1000L);
						}
					}
				}
			} catch (Exception var18) {
			}

			tempoDecorrido = System.currentTimeMillis() - inicio;

			for (int i = 0; (double) i <= rolagem + 7.0D; i += 7) {
				try {
					((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,7);", new Object[0]);
				} catch (Exception var16) {
				}
			}
		}

	}

	protected <T> boolean verificarPresencaElemento(T localizador) {
		try {
			WebElement elemento = this.esperaPadrao.definir(5).esperarElementoVisivel(localizador);
			if (elemento == null) {
				return false;
			} else {
				boolean elementoVisivel = elemento.isDisplayed();
				if (elementoVisivel) {
					return true;
				} else {
					Point localizacaoElemento = elemento.getLocation();
					Dimension dimensaoElemento = elemento.getSize();
					Dimension dimensaoTela = getDriver().manage().window().getSize();
					if (localizacaoElemento.y + dimensaoElemento.height > dimensaoTela.height) {
						return false;
					} else {
						return localizacaoElemento.y > 0;
					}
				}
			}
		} catch (Exception var7) {
			return false;
		}
	}

protected <T> boolean aguardarCarregamentoElemento(T elemento) {
		try {
			WebElement element = this.esperaPadrao.esperarElementoVisivel(elemento);
			return element != null;
		} catch (Exception var4) {
			Reporter.log(var4.getMessage(), true);
			return false;
		}
	}

	protected <T> void apagarCampoTexto(T elemento, String mensagemErro) throws Exception {
		try {
			this.retornaElemento(elemento).clear();
		} catch (NoSuchElementException var4) {
			throw new SefazException(var4.getMessage(), var4);
		} catch (Exception var5) {
			throw new SefazException(mensagemErro, var5);
		}
	}

	private <T> void rolarJs(WebElement elemento) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\"});", new Object[]{elemento});
	}

	private <T> void realcaElementoVermelho(WebDriver driver, T elemento) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", new Object[]{elemento});
	}


	private <T> void realcaElementoAmarelo(WebDriver driver, T elemento) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid yellow'", new Object[]{elemento});
	}

	public void pausaElemento() {
		Espera espera = new Espera();
		espera.aguardar(300);
	}

	protected <T> WebElement retornaElemento(T localizador) throws SefazException {
		String mensagemErro = "Elemento " + localizador + " n?o encontrado";

		try {
			WebElement elemento = this.esperaPadrao.esperarElementoPresente(localizador);
			if (elemento == null) {
				throw new NoSuchElementException(mensagemErro);
			} else {
				return elemento;
			}
		} catch (Exception var4) {
			throw new SefazException(mensagemErro, var4);
		}
	}

	protected <T> WebElement retornaElemento(T localizador, int tempoEspera) throws SefazException {
		String mensagemErro = "Elemento " + localizador + " não encontrado";

		try {
			WebElement elemento = this.esperaPadrao.definir(tempoEspera).esperarElementoPresente(localizador);
			if (elemento == null) {
				throw new NoSuchElementException(mensagemErro);
			} else {
				return elemento;
			}
		} catch (NoSuchElementException var5) {
			throw new SefazException(mensagemErro, var5);
		}
	}

	protected <T> WebElement retornarElemento(T elemento, String mensagemErro) throws Exception {
		try {
			return this.retornaElemento(elemento);
		} catch (NoSuchElementException var4) {
			throw new SefazException(var4.getMessage(), var4);
		} catch (Exception var5) {
			throw new SefazException(mensagemErro, var5);
		}
	}
	public class Espera {
		private final int TEMPO_ESPERA_PADRAO = 30;
		private final int TEMPO_SLEEP_PADRAO = 6000;
		private final int tempoEspera;
		private final int tempoSleep;
		private Class<? extends Throwable> ignora;
		private WebDriverWait wait;

		public Espera() {
			this.tempoEspera = TEMPO_ESPERA_PADRAO;
			this.tempoSleep = TEMPO_SLEEP_PADRAO;
			this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TEMPO_ESPERA_PADRAO));
		}

		public Espera(int tempoSegundos, Class<? extends Throwable> excecao) {
			this.tempoEspera = tempoSegundos;
			this.tempoSleep = TEMPO_SLEEP_PADRAO;
			this.ignora = excecao;
			this.wait = (WebDriverWait) new WebDriverWait(getDriver(), Duration.ofSeconds(tempoSegundos)).ignoring(excecao);
		}

		public Espera(int tempoSegundos, int tempoSleep) {
			this.tempoEspera = tempoSegundos;
			this.tempoSleep = tempoSleep;
			this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempoSegundos), Duration.ofMillis(tempoSleep));
		}

		private void criarWait() {
			if (wait == null) {
				wait = (WebDriverWait) new WebDriverWait(getDriver(), Duration.ofSeconds(tempoEspera))
						.pollingEvery(Duration.ofMillis(tempoSleep));
			}
		}

		public void aguardar(int tempoEmMilissegundos) {
			try {
				Thread.sleep(tempoEmMilissegundos);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		<T> WebElement esperarElementoVisivel(T localizador) {
			criarWait();
			return (WebElement) this.wait.until(CondicoesEspera.esperarElementoVisivel(localizador));
		}

		<T> WebElement esperarElementoPresente(T localizador) {
			criarWait();
			return (WebElement) this.wait.until(CondicoesEspera.esperaElementoExistente(localizador));
		}

		public Espera definir(int tempoSegundos) {
			return new Espera(tempoSegundos, TEMPO_SLEEP_PADRAO);
		}
	}
}