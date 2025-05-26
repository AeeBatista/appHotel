package controller;

public class Funcionario extends Pessoa {
    private String setor;

    public Funcionario(String rg, String nomePessoa, String setor) {
        super(rg, nomePessoa);
        this.setor = this.setor;
    }
    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
