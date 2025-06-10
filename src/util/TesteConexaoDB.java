package util;


import dao.*;

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

//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.inserirUsuario();
//                System.out.println("Usuario inserido com sucesso!");

//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.deletarUsuario();
//                System.out.println("Usuario deletado com sucesso!");


//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.inserirCliente();
//                System.out.println("Cliente inserido com sucesso!");
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.deletarCliente();
//                System.out.println("Clientes deletados com sucesso!");

                //Já foi
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.inserirAdicional();
//                System.out.println("Adicional inserido com sucesso!");


//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.deletarAdicional();
//                System.out.println("Adicionais removidas com sucesso!");




//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.inserirPedido();
//                System.out.println("Pedido Inserido com sucesso!");

//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.inserirQuarto();
//                System.out.println("Quarto inserido com sucesso!");

//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.deletarQuarto();
//                System.out.println("Quartos removidas com sucesso!");


                //Já foi
//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.inserirReserva();
//                System.out.println("Reserva Inserido com sucesso!");

//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.deletarReserva();
//                System.out.println("Reservas removidas com sucesso!");

                //Já foi
//                CargosDAO cargosDAO = new CargosDAO();
//                cargosDAO.inserirCargo();
//                System.out.println("Cargo Inserido com sucesso!");

//                CargosDAO cargosDAO = new CargosDAO();
//                cargosDAO.deletarCargo();
//                System.out.println("Cargos deletados com sucesso!");

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.alterarAdicional();
                System.out.println("Adicionais alterados com sucesso!");

                CargosDAO  cargosDAO = new CargosDAO();
                cargosDAO.alterarCargo();
                System.out.println("Cargos alterados com sucesso!");

                QuartosDAO  quartosDAO = new QuartosDAO();
                quartosDAO.alterarQuarto();
                System.out.println("Quartos alterados com sucesso!");

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.alterarClientes();
                System.out.println("Clientes alterados com sucesso!");


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
