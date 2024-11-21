package br.sefaz.com.core.contantes;

public enum Jornadas {

	SEFAZ("SEFAZ"),
    ADESAO("Adesão");

    private final String jornada;

    Jornadas(String value) {
        this.jornada = value;
    }
    
    public String getJornada(){
        return jornada;
    }
}
