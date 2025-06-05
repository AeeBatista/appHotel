package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " + " (nome,cpf,telefone) VALUES (?, ?, ?);");

            //setar parametros
            novoCliente.setString(1, "Gabriel");
            novoCliente.setString(2, "###.###.###.##");
            novoCliente.setString(3, "(##) ######-####");

            int LinhaAfetada = novoCliente.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}