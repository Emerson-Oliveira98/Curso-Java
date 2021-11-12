/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.entidade.IUsuarios;
import ProjetoPizzaria.modelo.Usuarios;
import ProjetoPizzaria.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Casa
 */
public class UsuariosDAO implements IUsuarios {
Connection c;
    public UsuariosDAO(){
        
        this.c = new ConnectionFactory().getConnetion();
    }
   
    @Override
    public void VerificarLoginGerente(Usuarios usuario, String login) {
          
        try {
              
            PreparedStatement stmt = c.prepareStatement("select LoginUsuario,Senha,ConfirmaSenha from Usuarios where Usuarios.Funcao like 'Gerente' and LoginUsuario = '"+login+"';");
            ResultSet result = stmt.executeQuery();
            
            while (result.next()){
            usuario.setLoginUsuario(result.getString("LoginUsuario"));
            usuario.setSenha(result.getString("Senha"));
            usuario.setConfirmaSenha(result.getString("ConfirmaSenha"));
            }
            stmt.close();
            result.close();
            
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void VerificarLoginFuncionario(Usuarios usuario, String login) {
             
        try {
              
            PreparedStatement stmt = c.prepareStatement("select LoginUsuario,Senha,ConfirmaSenha from Usuarios where Usuarios.Funcao like 'Funcionario' and LoginUsuario = '"+login+"';");
            ResultSet result = stmt.executeQuery();
            
            while (result.next()){
            usuario.setLoginUsuario(result.getString("LoginUsuario"));
            usuario.setSenha(result.getString("Senha"));
            usuario.setConfirmaSenha(result.getString("ConfirmaSenha"));
            }
            stmt.close();
            result.close();
            
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    
}
