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
            novoUsuario.setString(1,"Gabriel");
            novoUsuario.setInt(2,1);
            novoUsuario.setString(3,"!10G%H");

            int LinhaAfetada = novoUsuario.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;

        }
    }
}
