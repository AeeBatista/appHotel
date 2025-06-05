package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {


    private Conexao conexao = new Conexao();

    public boolean inserirAdicional() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO Adicionais " + "(nome,preco) VALUES (?, ?);");

            //setar parametros
            novoAdicional.setString(1, "Gabriel");
            novoAdicional.setDouble(2,10.2);

            int LinhaAfetada = novoAdicional.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }
}
