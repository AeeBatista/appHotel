package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO Pedidos " + "(fk_usuario_id,fk_cliente_id,pagamento) VALUES (?, ?, ?);");

            //setar parametros
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2,1 );
            novoPedido.setString(3,"Débito/Crédito");

            int LinhaAfetada = novoPedido.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}
