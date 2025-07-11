package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        PreparedStatement Quarto = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado = conndb.prepareStatement("UPDATE quartos" + "SET nome = ?, numero_quarto = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?");
            quartoAlterado.setString(1, "Gamadinho");
            quartoAlterado.setInt(2, 2);
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

    //Query SELECT
    public void pesquisarQuarto() {


        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarQuarto = conndb.prepareStatement("SELECT nome, numero_quarto, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel FROM quartos WHERE id = ?");
            buscarQuarto.setInt(1, 1);
            ResultSet resultado = buscarQuarto.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                int qtd_cama_casal = resultado.getInt("qtd_cama_casal");
                int qtd_cama_solteiro = resultado.getInt("qtd_cama_solteiro");
                String preco = resultado.getString("preco");
                String disponivel = resultado.getString("disponivel");
                System.out.println("Nome: " + nome + "qtd_cama_casal: " + qtd_cama_casal + "qtd_cama_solteiro: " + qtd_cama_solteiro + "preco: " + preco + "disponivel: " + disponivel);

            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar os quartos: " + erro);
        }
    }
}
