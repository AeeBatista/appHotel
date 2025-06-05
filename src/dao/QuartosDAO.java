package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos " + "(nome,numero_quarto,qtd_cama_casal,qtd_cama_solteiro,preco,disponivel) VALUES (?, ?, ?, ? ,? ,?);");

            //setar parametros
            novoQuarto.setString(1, "Gabriel");
            novoQuarto.setInt(2, 1);
            novoQuarto.setInt(3, 0);
            novoQuarto.setInt(4, 0);
            novoQuarto.setDouble(5,10.2);
            novoQuarto.setInt(6, 0);

            int LinhaAfetada = novoQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
}

