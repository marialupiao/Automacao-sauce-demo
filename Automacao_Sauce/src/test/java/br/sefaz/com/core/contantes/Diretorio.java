package br.sefaz.com.core.contantes;

public enum Diretorio {

    DIRETORIO_LOCAL (System.getProperty("user.dir") + "\\src\\test\\evidencias\\anexo\\brasao.jpg"),
    DIRETORIO_LOCAL_TXT (System.getProperty("user.dir") + "\\src\\test\\evidencias\\anexo\\testeQA.txt");
    private final String diretorio;

    Diretorio(String value) {this.diretorio = value;}

    public String getDiretorio(){return diretorio;}

}
