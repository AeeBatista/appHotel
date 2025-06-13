package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public boolean alterarClientes() {
        PreparedStatement Cliente = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado = conndb.prepareStatement("UPDATE usuarios" + "SET nome = ?, cpf = ?, telefone = ?  WHERE id = ?");
            clienteAlterado.setString(1, "Gabrielzinhuu");
            clienteAlterado.setString(2, "###.###.###-#");
            clienteAlterado.setString(3, "## #####-####");

            int linhaAfetada = clienteAlterado.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCliente = conndb.prepareStatement("DELETE FROM Clientes WHERE id = ?");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Cliente: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarCliente() {


        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarCliente = conndb.prepareStatement("SELECT nome, cpf, telefone " + " FROM clientes WHERE id = ?");
            buscarCliente.setInt(1, 1);
            ResultSet resultado = buscarCliente.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                System.out.println("Nome: " + nome + "CPF: " + cpf + "Telefone: " + telefone);

            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }
}