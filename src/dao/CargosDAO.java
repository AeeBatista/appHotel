package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            PreparedStatement removeCargos = conndb.prepareStatement("DELETE FROM cargos WHERE id = ?");
            removeCargos.setInt(1, 4);
            int linhaAfetada = removeCargos.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar o cargo: " + erro);
            return false;
        }
    }


    //Query SELECT
    public void pesquisarCargo() {


        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscarCargo = conndb.prepareStatement("SELECT nome  FROM cargos WHERE id = ?");
            buscarCargo.setInt(1, 1);
            ResultSet resultado = buscarCargo.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Nome: " + nome);

            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar cargo: " + erro);
        }
    }
}

