/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.ConnectionFactory;
import ProjetoPizzaria.entidade.ISabores;
import ProjetoPizzaria.modelo.Sabores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class SaboresDAO implements ISabores {

    Connection c;

    public SaboresDAO() {
        this.c = new ConnectionFactory().getConnetion();
    }

    @Override
    public void PesquisarPorID(Sabores sab, JTable tblSabores, int ID) {
        String sql = "Select * from Sabores where IdSabor =" + ID + ";";
        DefaultTableModel model = (DefaultTableModel) tblSabores.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome(Sabores sab, JTable tblSabores, JTextField txtNome) {
        String sql = "Select * from Sabores where NomeSabor like '" + txtNome.getText() + "%';";
        DefaultTableModel model = (DefaultTableModel) tblSabores.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                      rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AdicionarSabor(Sabores sab) {
        String sql = "insert into Sabores (NomeSabor,valor,tamanho)values(?,?,?)";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, sab.getNomeSabor());
            stmt.setDouble(2, sab.getValor());
            stmt.setString(3, sab.getTamanho());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

  

    @Override
    public void DeletarNome(Sabores sab, JTable tblSabores) {
        DefaultTableModel model = (DefaultTableModel) tblSabores.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("delete from Sabores where IdSabor =" + tblSabores.getValueAt(tblSabores.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            model.removeRow(tblSabores.getSelectedRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarTudo(Sabores sab, JTable tblSabores) {
        DefaultTableModel model = (DefaultTableModel) tblSabores.getModel();
        String sql = "Select * from Sabores;";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                      rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarDados(Sabores sab, JTable tblSabores, String nome, double valor, String tamanho,String tipo) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update Sabores set NomeSabor ='"+nome+"',valor='"+valor+"',tamanho='"+tamanho+"',tipo='"+tipo+"' where IdSabor = "+tblSabores.getValueAt(tblSabores.getSelectedRow(),0).toString()+";");
            stmt.execute();
            stmt.close();
            tblSabores.setValueAt(nome,tblSabores.getSelectedRow(),1);
            tblSabores.setValueAt(valor,tblSabores.getSelectedRow(),2);
            tblSabores.setValueAt(tamanho,tblSabores.getSelectedRow(),3);
            tblSabores.setValueAt(tipo,tblSabores.getSelectedRow(),4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNomeValorTamanho(Sabores sab, JTable tblSabores, String nome, double valor, String simbolo, String tamanho) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and valor"+simbolo+" '"+valor+"' and tamanho = '"+tamanho+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorNomeValor(Sabores sab, JTable tblSabores, String nome, double valor, String simbolo) {
DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and valor"+simbolo+" '"+valor+"' ;";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                   rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }


    }

    @Override
    public void PesquisarPorNomeTamanho(Sabores sab, JTable tblSabores, String nome, String tamanho) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and tamanho = '"+tamanho+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                 rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarValorTamanho(Sabores sab, JTable tblSabores, String simbolo, double valor, String tamanho) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where valor"+simbolo+" '"+valor+"' and tamanho = '"+tamanho+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                 rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }



    }

    @Override
    public void PesquisarPorTamanho(Sabores sab, JTable tblSabores, String tamanho) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where tamanho = '"+tamanho+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValor(Sabores sab, JTable tblSabores, String simbolo, double valor) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where valor"+simbolo+" '"+valor+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                 rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNomeValorTamanhoTipo(Sabores sab, JTable tblSabores, String nome, double valor, String simbolo, String tamanho, String tipo) {
        DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and valor"+simbolo+" '"+valor+"' and tamanho = '"+tamanho+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }


    }

    @Override
    public void PesquisarPorNomeValorTipo(Sabores sab, JTable tblSabores, String nome, double valor, String simbolo, String tipo) {
    DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and valor"+simbolo+" '"+valor+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }


    }

    @Override
    public void PesquisarPorNomeTamanhoTipo(Sabores sab, JTable tblSabores, String nome, String tamanho, String tipo) {
            DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and tamanho = '"+tamanho+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNomeTipo(Sabores sab, JTable tblSabores, String nome, String tipo) {
            DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where NomeSabor like'"+nome+"%' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValorTipo(Sabores sab, JTable tblSabores, double valor, String simbolo, String tipo) {
            DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where valor"+simbolo+" '"+valor+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTamanhoTipo(Sabores sab, JTable tblSabores, String tamanho, String tipo) {
            DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where tamanho = '"+tamanho+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTipo(Sabores sab, JTable tblSabores, String tipo) {
            DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValorTamanhoTipo(Sabores sab, JTable tblSabores, double valor, String simbolo, String tamanho, String tipo) {
         DefaultTableModel model = (DefaultTableModel)tblSabores.getModel();
        String sql= "select * from Sabores where valor"+simbolo+" '"+valor+"' and tipo='"+tipo+"';";
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            model.addRow(new Object[]{
                  rs.getInt("IdSabor"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("valor"),
                    rs.getString("tamanho"),
                    rs.getString("tipo")
            
            });
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }


    }

}
