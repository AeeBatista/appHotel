package controller;

import Model.Usuario;
import dao.UsuariosDAO;

public class UsuariosController{
    private final UsuariosDAO usuariosDao;


    /*Construtor para inicializar objeto UsuariosController(). Ao inicializalo, o construtor
    de UsuariosDao() será executado, significa que a camada de Controle estará verificando se os
    parametros necessários foram informados para que sejam enviados as requisições(package DAO)
     */
    public UsuariosController(){
        this.usuariosDao = new UsuariosDAO();
    }

    public boolean pesquisarUsuario(String email, String senha){
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()){
            return false; }
            Usuario usuario = new Usuario("", email, senha, 7);
            return usuariosDao.pesquisarUsuario(usuario);
}

    }
