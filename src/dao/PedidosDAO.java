package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos " + "(fk_usuario_id,fk_cliente_id,pagamento) VALUES (?, ?, ?);");

            //setar parametros
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "Débito/Crédito");

            int LinhaAfetada = novoPedido.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarPedido() {


        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarPedido = conndb.prepareStatement("SELECT pagamento  FROM pedidos WHERE fk_usuario_id + fk_cliente_id = ?");
            buscarPedido.setInt(1, 1);
            ResultSet resultado = buscarPedido.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("Nome: " + nome + "Email: " + email);

            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);

        }
    }
}
