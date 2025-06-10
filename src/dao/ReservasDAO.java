package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoReserva = conndb.prepareStatement("INSERT INTO Reservas " + " (fk_pedido_id,fk_quarto_id,fk_adicional_id,fim,inicio) VALUES (?, ?, ?, ? ,?);");

            //setar parametros
            novoReserva.setInt(1, 50);
            novoReserva.setInt(2, 20);
            novoReserva.setInt(3, 10);
            //Inicio
            //Fim

            int LinhaAfetada = novoReserva.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir reserva: " + erro);
            return false;
        }
    }

    public boolean deletarReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeReserva = conndb.prepareStatement("DELETE FROM Reservas WHERE id = ?");
            removeReserva.setInt(1, 2);
            int linhaAfetada = removeReserva.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Reservas: " + erro);
            return false;
        }
    }


}
