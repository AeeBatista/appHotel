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
                return LinhaAfetada > 0;
            } catch (Exception erro) {
                System.out.println("Erro ao inserir cargo: " + erro);
                return false;
            }
        }
    }
