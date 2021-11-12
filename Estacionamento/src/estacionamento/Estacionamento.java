/*
Projeto:    Estacionamento
Autor:      Emerson Moreno de Oliveira
RA:         2090782021004
Data:       21/05/2021
Objetivo:   Metodo principal, de entrada da aplicação
*/


package estacionamento;

import java.sql.*;
import java.util.*;


public class Estacionamento {


    public static void main(String[] args) {
      // Connection con = Conexao.abrirConexao();
      // CarroBean cb = new CarroBean();
//CarroDAO cd = new CarroDAO(con);
       
      //testamdo inserir
    // cb.setPlaca("JLL2897");
    // cb.setCor("Azul Marinho");
     //cb.setDescricao("Bugati pegadora de novinha");
      //System.out.println(cd.inserir(cb));
       
       
       //Testando método inserir 
 //cb.setPlaca("JKL2897"); 
 //cb.setCor("Verde"); 
 //cb.setDescricao("Carro 3"); 
 //System.out.println(cd.inserir(cb));


 //Testando método alterar 
// cb.setPlaca("JKL2897"); 
// cb.setCor("Amarelo"); 
 //cb.setDescricao("Carro 3"); 
 //System.out.println(cd.alterar(cb));


 //Testando excluir 
// cb.setPlaca("JKL2897"); 
 //System.out.println(cd.excluir(cb));
      
      //List<CarroBean> lista = cd.listarTodos();
      //  if(lista != null){ 
 //for(CarroBean carro : lista){ 
 //System.out.println("Placa: "+carro.getPlaca()); 
 //System.out.println("Cor: "+carro.getCor()); 
// System.out.println("Descrição:"+carro.getDescricao()); 
 
// }
   // }
    //  Conexao.fecharConexao(con);
        
                        GUI_Carro gui_Carro =
                new GUI_Carro();
        gui_Carro.setVisible(true);
        
   }
    
}
