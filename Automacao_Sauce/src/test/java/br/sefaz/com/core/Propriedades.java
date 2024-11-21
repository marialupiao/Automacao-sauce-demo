package br.sefaz.com.core;


import static br.sefaz.com.core.Propriedades.Browsers.CHROME;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;
	public static Browsers BROWSER = CHROME;

	public static boolean HEADLESS_MODE = false; // Altere para true se quiser iniciar em modo headless

	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

	public enum Browsers{
		CHROME,
		FIREFOX,
		EXPLORER,
		EDGE
	}
	public enum TipoExecucao{
		LOCAL,
		GRID
	}

	public static boolean isHeadless() {
		return HEADLESS_MODE;
	}

}
