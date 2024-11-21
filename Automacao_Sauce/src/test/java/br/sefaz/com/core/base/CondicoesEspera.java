package br.sefaz.com.core.base;

import br.sefaz.com.tools.Utilitarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.util.ArrayList;


public class CondicoesEspera {

	 public CondicoesEspera() {
	    }

	public static <T> ExpectedCondition<WebElement> esperaElementoExistente(final T elemento) {
		return elemento instanceof WebElement ? driver -> {
			try {
				return (WebElement) elemento;
			} catch (Exception ignored) {
			}

			return null;
		} : ExpectedConditions.presenceOfElementLocated((By)elemento);
	}

	public static <T> ExpectedCondition<WebElement> esperarElementoVisivel(T localizador) {
		return localizador instanceof WebElement ? ExpectedConditions.visibilityOf((WebElement)localizador) : ExpectedConditions.visibilityOfElementLocated((By)localizador);
	}

	public static <T> ExpectedCondition<WebElement> esperarElementoClicavel(T localizador) {
		return localizador instanceof WebElement ? ExpectedConditions.elementToBeClickable((WebElement)localizador) : ExpectedConditions.elementToBeClickable((By)localizador);
	}

	public static <T> ExpectedCondition<Boolean> esperarElementoOcultar(T localizador) {
		return ExpectedConditions.not(esperarElementoVisivel(localizador));
	}

	public static ExpectedCondition<String> esperarFontePagina(final WebDriver driver) {
		return new ExpectedCondition<>() {
			@Nullable
			public String apply(@Nullable WebDriver input) {
				try {
					return driver.getPageSource();
				} catch (Exception var3) {
					return null;
				}
			}
		};
	}

	public static ExpectedCondition<Boolean> esperarPaginaOcultar(final WebDriver driver, final String texto) {
		return input -> {
			try {
				return !Utilitarios.normalizaString(driver.getPageSource()).contains(Utilitarios.normalizaString(texto));
			} catch (Exception var3) {
				return false;
			}
		};
	}

	public static ExpectedCondition<String> esperarPaginaConterQualquerTexto(final WebDriver driver, final String... textos) {
		return new ExpectedCondition<>() {
			@Nullable
			public String apply(@Nullable WebDriver input) {
				String elementoEncontrado = null;

				try {
					String pagina = driver.getPageSource().toLowerCase();

					for (String texto : textos) {
						if (pagina.contains(texto.toLowerCase())) {
							elementoEncontrado = elementoEncontrado == null ? texto : elementoEncontrado + texto;
						}
					}
				} catch (Exception ignored) {
				}

				return elementoEncontrado;
			}
		};
	}

	public static ExpectedCondition<Boolean> esperarPaginaConterTodosTextos(final WebDriver driver, final String... textos) {
		return input -> {
			ArrayList<String> listaTextosEncontrados = new ArrayList<>();

			try {
				String pagina = driver.getPageSource().toUpperCase();

				for (String texto : textos) {
					if (pagina.contains(texto.toUpperCase())) {
						listaTextosEncontrados.add(texto.toUpperCase());
					}
				}
			} catch (Exception ignored) {
			}

			return listaTextosEncontrados.size() == textos.length;
		};
	}
}
