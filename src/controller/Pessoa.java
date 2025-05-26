package controller;

public class Pessoa {
    private String nomePessoa, rg;

    /*Contrutor: inicializa a classe
     quando um acesso e tipagem*/
    public Pessoa(String rg, String nomePessoa) {
        this.rg = rg;
        this.nomePessoa = nomePessoa;
    }

    public String getRg() {
        return rg;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
}
