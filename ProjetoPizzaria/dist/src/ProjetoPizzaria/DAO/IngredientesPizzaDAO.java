/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.entidade.IIngredientesPizza;
import ProjetoPizzaria.modelo.IngredientesPizza;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import ProjetoPizzaria.ConnectionFactory;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class IngredientesPizzaDAO implements IIngredientesPizza {

    Connection c;

    public IngredientesPizzaDAO() {
        this.c = new ConnectionFactory().getConnetion();
    }

    @Override
    public void CadastrarIngredientes(IngredientesPizza ingPizza) {
        String sql = "Insert into IngredientesPizza (NomeIngrediente,Quantidade,TipoDeUnidade,quantidadeMax,quantidadeMin) values (?,?,?,?,?);";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ingPizza.getNomeIngrediente());
            stmt.setInt(2, ingPizza.getQuantidade());
            stmt.setString(3, ingPizza.getTipoDeUnidade());
            stmt.setInt(4, ingPizza.getQuantidadeMax());
            stmt.setInt(5, ingPizza.getQuantidadeMin());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarIngredientes(IngredientesPizza ingPizza, JTextField txtNomeIngrediente, JTable tblIngredientes) {
        int linha;
        try {
            PreparedStatement stmt = c.prepareStatement("select * from ingredientespizza where NomeIngrediente like '" + txtNomeIngrediente.getText() + "%';");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
            while (rs.next()) {
                for (linha = 0; linha < 1; linha++) {

                    model.addRow(new Object[]{
                        rs.getInt("IdIngredientesPizza"),
                        rs.getString("NomeIngrediente"),
                        rs.getString("Quantidade"),
                        rs.getString("TipoDeUnidade"),
                        rs.getInt("quantidadeMax"),
                        rs.getInt("quantidadeMin")
                    });
                }

            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void DeltarIngredientes(IngredientesPizza ingPizza, JTable tblIngredientes) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("delete from IngredientesPizza where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            model.removeRow(tblIngredientes.getSelectedRow());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarTudo(IngredientesPizza ingPizza, JTable tblIngredientes) {
        int linha;
        try {
            PreparedStatement stmt = c.prepareStatement("select * from ingredientespizza;");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getString("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")

                });

            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNomeIngrediente(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNovoNomeIngrediente) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNovoNomeIngrediente.getText() + "' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            tblIngredientes.setValueAt(txtNovoNomeIngrediente.getText(), tblIngredientes.getSelectedRow(), 1);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AtualizarEstoqueIngrediente(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        int r, x, max;
        try {
            //PEGANDO O VALOR DA QUANTIDADE ATUAL
            r = Integer.parseInt(tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 3).toString());
            //PEGANDO O VALOR DA QUANTIDADE A SER SOMADA
            x = Integer.parseInt(txtQuantidade.getText());
            //QUANTIDADE FINAL
            r += x;
            max = Integer.parseInt(tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 4).toString());
            if (r > max) {
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar a quantidadade em estoque, \n a quantidade excede a máxima em: " + (r - max), "Quantidade inválida", JOptionPane.OK_OPTION);
                txtQuantidade.setBackground(Color.PINK);
                txtQuantidade.requestFocus();
                txtQuantidade.setText("");
            } else {
                txtQuantidade.setBackground(Color.white);
                PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + r + "' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
                stmt.execute();
                stmt.close();
                model.setValueAt(r, tblIngredientes.getSelectedRow(), 3);
                JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso", "Atualizar Estoque", JOptionPane.OK_OPTION);
                txtQuantidade.setText("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void CorrigirEstoqueIngrediente(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        int x;

        try {

            x = Integer.parseInt(txtQuantidade.getText());

            txtQuantidade.setBackground(Color.white);
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + x + "' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            model.setValueAt(x, tblIngredientes.getSelectedRow(), 3);
            txtQuantidade.setText("");
            JOptionPane.showMessageDialog(null, "Dados corrigidos com sucesso", "Corrigir dados", JOptionPane.OK_OPTION);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like '" + txtNome.getText() + "%';";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorQuantidadeIgual(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade) {
        String sql = "select * from IngredientesPizza where Quantidade = " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorQuantidadeMaior(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade) {

        String sql = "select * from IngredientesPizza where Quantidade > " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorQuantidadeMenor(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade) {
        String sql = "select * from IngredientesPizza where Quantidade < " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTipo(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        String Sql = "select * from IngredientesPizza where TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "';";
        try {
            PreparedStatement stmt = c.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorID(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtID) {

        String sql = "select * from IngredientesPizza where IdIngredientesPizza =" + txtID.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorNome_Quantidade_Tipo_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like'" + txtNome.getText() + "%' and TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade =" + txtQuantidade.getText().toString() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome_Quantidade_Tipo_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like'" + txtNome.getText() + "%' and TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade <" + txtQuantidade.getText().toString() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome_Quantidade_Tipo_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo) {

        String sql = "select * from IngredientesPizza where NomeIngrediente like'" + txtNome.getText().toString() + "%' and TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade >" + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome_Tipo(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like '" + txtNome.getText() + "%' and TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "';";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome_Quantidade_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like '" + txtNome.getText() + "%' and Quantidade = " + txtQuantidade.getText().toString() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void PesquisarPorNome_Quantidade_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade) {

        String sql = "select * from IngredientesPizza where NomeIngrediente like '" + txtNome.getText() + "%' and Quantidade > " + txtQuantidade.getText().toString() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorNome_Quantidade_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade) {
        String sql = "select * from IngredientesPizza where NomeIngrediente like '" + txtNome.getText().toString() + "%' and Quantidade < " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTipo_Quantidade_IGUAL(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade) {
        String sql = "select * from ingredientespizza where TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade = " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTipo_Quantidade_MAIOR(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade) {
        String sql = "select * from ingredientespizza where TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade > " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarPorTipo_Quantidade_MENOR(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, JTextField txtQuantidade) {

        String sql = "select * from ingredientespizza where TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' and Quantidade < " + txtQuantidade.getText() + ";";
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarTipoDeUnidade(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Quantidade_Tipo(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JTextField txtQuantidade, JComboBox CbTipo) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "', Quantidade = '" + txtQuantidade.getText() + "' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(txtQuantidade.getText(), tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Quantidade(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade, JTextField txtNome) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = ' " + txtNome.getText() + " ',Quantidade = '" + txtQuantidade.getText().toString() + " ' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(txtQuantidade.getText(), tblIngredientes.getSelectedRow(), 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_TIPO(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipoMedida) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + " ', TipoDeUnidade = '" + CbTipoMedida.getSelectedItem().toString() + " ' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(CbTipoMedida.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantidade_TIPO(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtQuantidade, JComboBox CbTipo) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + txtQuantidade.getText() + "', TipoDeUnidade = '" + CbTipo.getSelectedItem() + "' where IdIngredientesPizza =" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0) + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtQuantidade.getText(), tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem(), tblIngredientes.getSelectedRow(), 2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarId_Nome_Tipo_PorNome(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("select IdIngredientesPizza,NomeIngrediente,TipoDeUnidade from ingredientespizza where NomeIngrediente like '" + txtNome.getText() + "%';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void PesquisarId_Nome_Tipo(IngredientesPizza ingPizza, JTable tblIngredientes) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("select IdIngredientesPizza,NomeIngrediente,TipoDeUnidade from ingredientespizza;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdIngredientesPizza"),
                    rs.getString("NomeIngrediente"),
                    rs.getString("TipoDeUnidade"),
                    rs.getInt("Quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Tipo_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantidade, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza=" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Tipo_Quantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantidade, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza=" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Tipo_Quantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantidade, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza=" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarNome_Tipo_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',quantidadeMax = '" + quantMax + "', quantidadeMax = '" + quantMin + "' where IdIngredientesPizza=" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantidade, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza=60;");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarTipo_Quantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza=" + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarNome_Tipo_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Tipo_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, JComboBox CbTipo, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Quantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantidade, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_Quantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantidade, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',Quantidade = '" + quantidade + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "',quantidadeMax = '" + quantMax + "',quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarTipo_Quantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarTipo_Quantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantidade, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarTipo_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "',quantidadeMax = '" + quantMax + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantidade_QuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, int quantidade, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + quantidade + "',quantidadeMax = '" + quantMax + "',quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarNome_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JTextField txtNome, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set NomeIngrediente = '" + txtNome.getText() + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(txtNome.getText(), tblIngredientes.getSelectedRow(), 1);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarTipo_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarTipo_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, JComboBox CbTipo, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set TipoDeUnidade = '" + CbTipo.getSelectedItem().toString() + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(CbTipo.getSelectedItem().toString(), tblIngredientes.getSelectedRow(), 2);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantidade_QuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, int quantidade, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + quantidade + "', quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantidade_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, int quantidade, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set Quantidade = '" + quantidade + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantidade, tblIngredientes.getSelectedRow(), 3);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantMax_QuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set quantidadeMax = '" + quantMax + "', quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AlterarQuantMax(IngredientesPizza ingPizza, JTable tblIngredientes, int quantMax) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set quantidadeMax = '" + quantMax + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantMax, tblIngredientes.getSelectedRow(), 4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void AlterarQuantMin(IngredientesPizza ingPizza, JTable tblIngredientes, int quantMin) {
        DefaultTableModel model = (DefaultTableModel) tblIngredientes.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update IngredientesPizza set quantidadeMin = '" + quantMin + "' where IdIngredientesPizza = " + tblIngredientes.getValueAt(tblIngredientes.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            stmt.close();
            tblIngredientes.setValueAt(quantMin, tblIngredientes.getSelectedRow(), 5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
