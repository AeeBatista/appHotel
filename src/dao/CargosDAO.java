package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCargo = conndb.prepareStatement("INSERT INTO cargos " + " (nome) VALUES (?);");

            //setar parametros
            novoCargo.setString(1, "Cargo");

            int LinhaAfetada = novoCargo.executeUpdate();
            conndb.close();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }
    public boolean alterarCargo() {
        PreparedStatement Cargo = null;
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement cargoAlterado = conndb.prepareStatement("UPDATE cargos SET nome = ? WHERE id = ?;");
            cargoAlterado.setString(1, "Auxiliar DB");
            int linhaAfetada = cargoAlterado.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cargo: " + erro);
            return false;
        }
    }

    public boolean deletarCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCargos = conndb.prepareStatement("DELETE FROM Cargos WHERE id = ?");
            removeCargos.setInt(1, 4);
            int linhaAfetada = removeCargos.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar o cargo: " + erro);
            return false;
        }
    }
}

