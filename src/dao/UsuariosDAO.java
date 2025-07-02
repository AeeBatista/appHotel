package dao;

import Model.Usuario;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    private Conexao conexao = new Conexao();


    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " + " (nome, fk_cargo_id,senha) VALUES (?, ?, md5 (?) );");

            //setar parametros
            novoUsuario.setString(1, "Gabriel");
            novoUsuario.setInt(2, 7);
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
            PreparedStatement usuarioAlterado = conndb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?) + ?, fk_cargo_id = ? WHERE id = ?");
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
            PreparedStatement removeUsuario = conndb.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            removeUsuario.setInt(1,2);
            int linhaAfetada = removeUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    //Query SELECT
    public boolean pesquisarUsuario(Usuario usuario) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement stmt = conndb.prepareStatement("SELECT nome FROM usuarios WHERE email = ? AND senha = md5(?);");
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet resultado = stmt.executeQuery();

            boolean acessoAutorizado = resultado.next();

                String nome = resultado.getString("nome");
                System.out.println("Olá, seja bem-vindo, " + nome);
            conndb.close();
            return acessoAutorizado;

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
            return false;
        }
    }
}