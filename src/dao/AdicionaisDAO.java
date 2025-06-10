package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO Adicionais " + "(nome,preco) VALUES (?, ?);");

            //setar parametros
            novoAdicional.setString(1, "Gabriel");
            novoAdicional.setDouble(2,10.2);

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
            PreparedStatement adicionalAlterado = conndb.prepareStatement("UPDATE usuarios SET nome = ?, preco = ? WHERE id = ?");
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
}
