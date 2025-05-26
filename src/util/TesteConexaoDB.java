package util;


import java.sql.Connection;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQL está rodando na porta 3306,
se os parametros como endereço IP dos servidor, nome de usuario, senha e nome do banco de dados estão
corretos, utilizando-se o driver JDBC para MySQL*/
public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão sucedida!");
            try{
                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
