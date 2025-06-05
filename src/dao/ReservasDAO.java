package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoReserva = conndb.prepareStatement("INSERT INTO Clientes " + " (fk_pedido_id,fk_quarto_id,fk_adicional_id,fim,inicio) VALUES (?, ?, ?, ? ,?);");

            //setar parametros
            novoReserva.setInt(1, 50);
            novoReserva.setInt(2, 20);
            novoReserva.setInt(3, 10);

            int LinhaAfetada = novoReserva.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}
