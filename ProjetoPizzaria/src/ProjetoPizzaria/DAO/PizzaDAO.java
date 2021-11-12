/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.ConnectionFactory;
import ProjetoPizzaria.entidade.IPizza;
import ProjetoPizzaria.modelo.Pizza;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author Casa
 */
public class PizzaDAO implements IPizza {
    Connection c;
    public PizzaDAO(){
     c = new ConnectionFactory().getConnetion();
    }
    
    @Override
    public void cadastrarPizzaProcedure(Pizza pizza) {
        
        String sql = "call cadastrarPizza(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            CallableStatement stmt = c.prepareCall(sql);
            stmt.setInt(1, pizza.getIdPizza());
            stmt.setString(2,pizza.getTamanhoPizza());
            stmt.setInt(3, pizza.getQuantidadeSabores());
            stmt.setString(4, pizza.getNomePizza());
            stmt.setInt(5, pizza.getTempoDePreparo());
            stmt.setString(6, pizza.getTipoDePizza());
            stmt.setString(7, pizza.getModoDePreparo());
            stmt.setInt(8,pizza.getQuantidadeIngrediente());
            stmt.setDouble(10,pizza.getPrecoTotal());
            stmt.setInt(11,pizza.getIdSaborPizza_fk());
            stmt.setInt(12,pizza.getIdIngrediente_fk());
            stmt.setInt(13,pizza.getIdSaborBorda_fk());
             FileInputStream imagemFi;
            try {
                File file = new File(pizza.getImagem());
                imagemFi = new FileInputStream(file);
                
                stmt.setBinaryStream(9, imagemFi);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar a imagem","Erro",JOptionPane.OK_OPTION);
            }
            //registrar parametro de saide
          //  stmt.registerOutParameter(14, Types.VARCHAR);
            //executa
            stmt.executeUpdate();
            //MENSAGEM
            //JOptionPane.showMessageDialog(null, stmt.getString(14));
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    
    }
}
