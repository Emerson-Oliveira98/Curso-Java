/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.ConnectionFactory;
import ProjetoPizzaria.entidade.ISaborBordaRecheada;
import ProjetoPizzaria.modelo.SaborBordaRecheada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class SaborBordaRecheadaDAO implements ISaborBordaRecheada {

    Connection c;

    public SaborBordaRecheadaDAO() {
        this.c = new ConnectionFactory().getConnetion();
    }

    @Override
    public void AdicionarSaborBorda(SaborBordaRecheada saboBordRech) {
        String sql = "insert into SaborBordaRecheada (NomeSabor,Valor) values(?,?)";

        try {
            PreparedStatement stmt = c.prepareStatement(sql);

            stmt.setString(1, saboBordRech.getNomeSabor());
            stmt.setDouble(2, saboBordRech.getValor());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarInicial(SaborBordaRecheada saboBordRech, JTable tblSaborBorda) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel(); 
        String sql = "select * from SaborBordaRecheada;";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });

            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DeletarSabor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("delete from SaborBordaRecheada where IdSaborBordaRecheada =" + tblSaborBorda.getValueAt(tblSaborBorda.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            model.removeRow(tblSaborBorda.getSelectedRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNomeSabor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtNome) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update SaborBordaRecheada set NomeSabor = '" + txtNome.getText().toString() + "' where IdSaborBordaRecheada =" + tblSaborBorda.getValueAt(tblSaborBorda.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblSaborBorda.setValueAt(txtNome.getText(), tblSaborBorda.getSelectedRow(), 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarValor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update SaborBordaRecheada set Valor = '" + txtValor.getText() + "' where IdSaborBordaRecheada =" + tblSaborBorda.getValueAt(tblSaborBorda.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblSaborBorda.setValueAt(txtValor.getText(), tblSaborBorda.getSelectedRow(), 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNomeValor(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtNome, JTextField txtValor) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update SaborBordaRecheada set NomeSabor = '" + txtNome.getText() + "', Valor ='" + txtValor.getText() + "' where IdSaborBordaRecheada =" + tblSaborBorda.getValueAt(tblSaborBorda.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblSaborBorda.setValueAt(txtNome.getText(), tblSaborBorda.getSelectedRow(), 1);
            tblSaborBorda.setValueAt(txtValor.getText(), tblSaborBorda.getSelectedRow(), 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorID(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtID) {
        DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        String sql = "select * from SaborBordaRecheada where IdSaborBordaRecheada = " + txtID.getText() + ";";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtNomeSabor) {
   DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        String sql = "select * from SaborBordaRecheada where NomeSabor like  '" + txtNomeSabor.getText() + "%';";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValorMAIOR(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor) {
  DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        String sql = "select * from SaborBordaRecheada where Valor >" + txtValor.getText() + ";";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValorMENOR(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor) {
  DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        String sql = "select * from SaborBordaRecheada where Valor <" + txtValor.getText() + ";";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorValorIGUAL(SaborBordaRecheada saboBordRech, JTable tblSaborBorda, JTextField txtValor) {
  DefaultTableModel model = (DefaultTableModel) tblSaborBorda.getModel();
        String sql = "select * from SaborBordaRecheada where Valor =" + txtValor.getText() + ";";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdSaborBordaRecheada"),
                    rs.getString("NomeSabor"),
                    rs.getDouble("Valor")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarInicialCombo(SaborBordaRecheada saboBordRech, JComboBox cbBordas) {
String sql = "select NomeSabor from SaborBordaRecheada where valor > 0;";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                cbBordas.addItem(rs.getString("NomeSabor"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void PesquisarValorPorNomeCombo(SaborBordaRecheada saboBordRech, JComboBox cbBordas, JTextField txtPrecoBorda) {
String sql = "select valor from SaborBordaRecheada where NomeSabor = '"+cbBordas.getSelectedItem()+"';";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                txtPrecoBorda.setText("");
                txtPrecoBorda.setText(rs.getString("valor"));
            }
            stmt.close();
            rs.close();
            
        } catch (Exception e) {
        }
    }

    @Override
    public int pesquisarIdPorNome(SaborBordaRecheada saboBordRech, String nome) {
        try {
            PreparedStatement stmt = c.prepareStatement("select IdSaborBordaRecheada from SaborBordaRecheada where NomeSabor='"+nome+"';");
            ResultSet rs = stmt.executeQuery();
            int id=0;
            while(rs.next()){
            id = rs.getInt("IdSaborBordaRecheada");
            }
            stmt.close();
            rs.close();
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
