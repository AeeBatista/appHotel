package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class
Conexao {

    private String driver;
    private String url;
    private String usuario;
    private String senha;


    /*Construtor de modo que essa classe Conexao.java for istanciar
    um objeto, o construtor será executado e a classe Conexao.java
    inicializada
     */
     public Conexao() {
         carregarConfiguracoes();
     }

     //Metodo com os parametros de configuração das variaveis de ambiente
    public void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("config.properties")){
            props.load(inputPropsConfig);

            driver = props.getProperty("driver");
            url = props.getProperty("url");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");
    }
        catch (Exception erro) {
        System.out.println("Erro ao carregar configurações" + erro.getMessage());}
    }


    public Connection conectar() {
        Connection condb = null;


        try {
            // Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

        /* Iniciar o driver já carregado por meio
        do metodo getConnection(IP, porta, nome do banco, usuario, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        } catch (SQLException | ClassNotFoundException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados: " + erro);
            return null;
        }
    }
}