package br.sefaz.com.core.contantes;

public enum Projeto {

    SEFAZ("SEFAZ"),
    DEC("DEC");

    private final String projeto;

    Projeto(String value) {
        this.projeto = value;
    }

    public String getJornada(){
        return projeto;
    }
}
