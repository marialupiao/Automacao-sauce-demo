package br.sefaz.com.evidencias.evidence;

import java.util.ArrayList;

public class RelatorioEvidencia {
	private ArrayList<SelecaoEvidencia> evidenceList = null;
	private String reportName = null;
	private String tester = null;
	private String project = null;
	private String exceptionString = null;
	private String sistema = null;
	private String jornada = null;

	public RelatorioEvidencia(ArrayList<SelecaoEvidencia> evidenceList, String tester,
							  String project, String exceptionString, String sistema, String jornada) {
		this.evidenceList = evidenceList;
		this.tester = tester;
		this.project = project;
		this.exceptionString = exceptionString;
		this.sistema = sistema;
		this.jornada = jornada;
	}

	public ArrayList<SelecaoEvidencia> getEvidenceList() {
		return evidenceList;
	}

	public void setEvidenceList(ArrayList<SelecaoEvidencia> evidenceList) {
		this.evidenceList = evidenceList;
	}

	public String getTester() {
		return this.tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getExceptionString() {
		return this.exceptionString;
	}

	public void setExceptionString(String exceptionString) {
		this.exceptionString = exceptionString;
	}


	public String getsistema() { return this.sistema;}

	public void setsistema(String sistema) { this.sistema = sistema;}

	public String getjornada() { return this.jornada; }

	public void setjornada(String jornada) { this.jornada = jornada; }

}