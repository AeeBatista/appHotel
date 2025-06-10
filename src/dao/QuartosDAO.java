package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " + "(nome,numero_quarto,qtd_cama_casal,qtd_cama_solteiro,preco,disponivel) VALUES (?, ?, ?, ? ,? ,?);");

            //setar parametros
            novoQuarto.setString(1, "Gabriel");
            novoQuarto.setInt(2, 1);
            novoQuarto.setInt(3, 0);
            novoQuarto.setInt(4, 0);
            novoQuarto.setDouble(5, 10.2);
            novoQuarto.setInt(6, 0);

            int LinhaAfetada = novoQuarto.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
    public boolean alterarQuarto() {
        PreparedStatement Usuario = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado = conndb.prepareStatement("UPDATE usuarios" + "SET nome = ?, numero_quarto = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?");
            quartoAlterado.setString(1, "Gamadinho");
            quartoAlterado.setInt(2,2);
            quartoAlterado.setInt(3, 1);
            quartoAlterado.setInt(4, 1);
            quartoAlterado.setDouble(5, 10.2);
            quartoAlterado.setInt(6, 0);

            int linhaAfetada = quartoAlterado.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar quartos: " + erro);
            return false;
        }
    }

    public boolean deletarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuartos = conndb.prepareStatement("DELETE FROM Quartos WHERE id = ?");
            removeQuartos.setInt(1, 1);
            int linhaAfetada = removeQuartos.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto: " + erro);
            return false;
        }
    }
}
