package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO Adicionais " + "(nome,preco) VALUES (?, ?);");

            //setar parametros
            novoAdicional.setString(1, "Gabriel");
            novoAdicional.setDouble(2, 10.2);

            int LinhaAfetada = novoAdicional.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }

    public boolean alterarAdicional() {
        PreparedStatement Adicional = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement adicionalAlterado = conndb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?");
            adicionalAlterado.setString(1, "Gabrielzinhu");
            adicionalAlterado.setDouble(2, 100.2);

            int linhaAfetada = adicionalAlterado.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Adicionais: " + erro);
            return false;
        }
    }

    public boolean deletarAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicional = conndb.prepareStatement("DELETE FROM Adicionais WHERE id = ?");
            removeAdicional.setInt(1, 6);
            int linhaAfetada = removeAdicional.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Adicionais: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarAdicional() {


        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarAdicional = conndb.prepareStatement("SELECT nome, preco  FROM adicionais WHERE id = ?");
            buscarAdicional.setInt(1, 1);
            ResultSet resultado = buscarAdicional.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String preco = resultado.getString("preço");
                System.out.println("Nome: " + nome + "Preço: " + preco);

            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar preços: " + erro);
        }
    }
}