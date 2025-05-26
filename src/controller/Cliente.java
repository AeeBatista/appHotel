package controller;

public class Cliente extends Pessoa {
//Declaracao de uma variavel propria da class Cliente
private int quantidadedeOcupacoes;

    public Cliente(String rg, String nomePessoa, int quantidadedeOcupacoes) {
        super(rg, nomePessoa);
        this.quantidadedeOcupacoes = quantidadedeOcupacoes;

    }
    //getters and setters
    public int getQuantidadedeOcupacoes() {
        return quantidadedeOcupacoes;
    }

    public void setQuantidadedeOcupacoes(int quantidadedeOcupacoes) {
        this.quantidadedeOcupacoes = quantidadedeOcupacoes;
    }
}
