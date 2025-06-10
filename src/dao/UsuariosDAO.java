package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {

    private Conexao conexao = new Conexao();


    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " + " (nome, fk_cargo_id,senha) VALUES (?, ?, md5 (?) );");

            //setar parametros
            novoUsuario.setString(1, "Gabriel");
            novoUsuario.setInt(2, 1);
            novoUsuario.setString(3, "!10G%H");

            int LinhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;

        }
    }


    public boolean alterarUsuario() {
        PreparedStatement Usuario = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement usuarioAlterado = conndb.prepareStatement("UPDATE usuarios" + "SET nome = ?, email = ?, senha = md5(?) + ?, " + "fk_cargo_id = ? WHERE id = ?");
            usuarioAlterado.setString(1, "Gabrielzinho Lindu");
            usuarioAlterado.setString(2, "Gowgowgow@gmail.com");
            usuarioAlterado.setString(3, "123");
            usuarioAlterado.setInt(4, 1);
            usuarioAlterado.setInt(5, 1); // altera usuário c/ chave primária ID = 1

            int linhaAfetada = usuarioAlterado.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement("DELETE FROM Usuarios WHERE id = ?");
            removeUsuario.setInt(1,2);
            int linhaAfetada = removeUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
}