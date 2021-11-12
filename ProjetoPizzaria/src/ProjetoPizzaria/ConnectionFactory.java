/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Casa
 */
public class ConnectionFactory {
    
  public Connection getConnetion(){
      System.err.println("conectando ao banco de dados");
      try {
          return DriverManager.getConnection("jdbc:mysql://localhost/estacionamento","root","root");
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
  }
  
    public static void main(String[] args) {
      new ConnectionFactory().getConnetion();
        System.err.println("Conexão realizada com Sucesso");
    }
}
