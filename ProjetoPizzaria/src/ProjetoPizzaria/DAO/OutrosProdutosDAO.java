/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.DAO;

import ProjetoPizzaria.ConnectionFactory;
import ProjetoPizzaria.entidade.IOutrosProdutos;
import ProjetoPizzaria.modelo.OutrosProdutos;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class OutrosProdutosDAO implements IOutrosProdutos {

    Connection c;

    public OutrosProdutosDAO() {
        this.c = new ConnectionFactory().getConnetion();
    }

    @Override
    public void cadastrarProdutos(OutrosProdutos op) {
        String sql = "insert into outrosProdutos(nomeProduto,precoProduto,quantidade,quantidadeMax,quantidadeMin)values (?,?,?,?,?);";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, op.getNomeProduto());
            stmt.setDouble(2, op.getPrecoProduto());
            stmt.setInt(3, op.getQuantidade());
            stmt.setInt(4,op.getQuantMax());
            stmt.setInt(5,op.getQuantMin());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pesquisaInicial(OutrosProdutos op, JTable tblProdutos) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement("select * from outrosProdutos;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
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
    public void pesquisarPorNome(OutrosProdutos op, JTable tblProdutos, JTextField txtNome) {
        String sql = "select * from outrosProdutos where nomeProduto like '" + txtNome.getText() + "%';";
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
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
    public void deletarProduto(OutrosProdutos op, JTable tblProdutos) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("delete from outrosProdutos where IdOutrosProdutos = " + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            model.removeRow(tblProdutos.getSelectedRow());
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarNomeQuantidadePreco(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int quantidade, double preco) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set nomeProduto = '" + txtNome.getText() + "',precoProduto ='" + String.valueOf(preco) + "',quantidade ='" + String.valueOf(quantidade) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(), 1);
            tblProdutos.setValueAt(String.valueOf(preco), tblProdutos.getSelectedRow(), 2);
            tblProdutos.setValueAt(String.valueOf(quantidade), tblProdutos.getSelectedRow(), 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarNomePreco(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double preco) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set nomeProduto = '" + txtNome.getText() + "',precoProduto ='" + String.valueOf(preco) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(), 1);
            tblProdutos.setValueAt(String.valueOf(preco), tblProdutos.getSelectedRow(), 2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarNomeQuantidade(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int quantidade) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set nomeProduto = '" + txtNome.getText() + "',quantidade ='" + String.valueOf(quantidade) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(), 1);

            tblProdutos.setValueAt(String.valueOf(quantidade), tblProdutos.getSelectedRow(), 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarPrecoQuantidade(OutrosProdutos op, JTable tblProdutos, double preco, int quantidade) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set precoProduto ='" + String.valueOf(preco) + "',quantidade ='" + String.valueOf(quantidade) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();

            tblProdutos.setValueAt(String.valueOf(preco), tblProdutos.getSelectedRow(), 2);
            tblProdutos.setValueAt(String.valueOf(quantidade), tblProdutos.getSelectedRow(), 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarNome(OutrosProdutos op, JTable tblProdutos, JTextField txtNome) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set nomeProduto = '" + txtNome.getText() + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(), 1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarQuantidade(OutrosProdutos op, JTable tblProdutos, int quantidade) {

        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set quantidade ='" + String.valueOf(quantidade) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();

            tblProdutos.setValueAt(String.valueOf(quantidade), tblProdutos.getSelectedRow(), 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterarPreco(OutrosProdutos op, JTable tblProdutos, double preco) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set precoProduto ='" + String.valueOf(preco) + "' where IdOutrosProdutos =" + tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString() + ";");
            stmt.execute();

            tblProdutos.setValueAt(String.valueOf(preco), tblProdutos.getSelectedRow(), 2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorId(OutrosProdutos op, JTable tblProdutos, int id) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        String sql = "select * from outrosProdutos where IdOutrosProdutos = " + id + ";";
        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
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
    public void pesquisarPorNomePrecoIgualQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto ='" + p + "' and quantidade ='" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoIgualQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto ='" + p + "' and quantidade >'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoIgualQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto ='" + p + "' and quantidade <'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMaiorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto >'" + p + "' and quantidade ='" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMaiorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto >'" + p + "' and quantidade >'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMaiorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto >'" + p + "' and quantidade <'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMenorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto <'" + p + "' and quantidade ='" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMenorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto <'" + p + "' and quantidade >'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMenorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto <'" + p + "' and quantidade <'" + q + "' and nomeProduto like '" + txtNome.getText() + "%';";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '" + txtNome.getText() + "%' and precoProduto = " + p + ";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '" + txtNome.getText() + "%' and precoProduto > " + p + ";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomePrecoMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, double p) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '" + txtNome.getText() + "%' and precoProduto < " + p + ";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomeQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q) {
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '"+txtNome.getText()+"%' and quantidade = "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
              while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomeQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q) {
   DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '"+txtNome.getText()+"%' and quantidade > "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
              while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorNomeQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, JTextField txtNome, int q) {
   DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where nomeProduto like '"+txtNome.getText()+"%' and quantidade < "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
              while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorPrecoIgualQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto = "+p+" and quantidade = "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorPrecoIgualQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto = "+p+" and quantidade > "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }

    @Override
    public void pesquisarPorPrecoIgualQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto = "+p+" and quantidade < "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorPrecoMaiorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto > "+p+" and quantidade = "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorPrecoMaiorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto > "+p+" and quantidade > "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void pesquisarPorPrecoMaiorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto > "+p+" and quantidade < "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void pesquisarPorPrecoMenorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto < "+p+" and quantidade = "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void pesquisarPorPrecoMenorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, double p, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto < "+p+" and quantidade > "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorPrecoMenorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, double p, int q) {

DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto < "+p+" and quantidade < "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pesquisarPorPrecoIgual(OutrosProdutos op, JTable tblProdutos, double p) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto ="+p+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorPrecoMaior(OutrosProdutos op, JTable tblProdutos, double p) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto > "+p+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorPrecoMenor(OutrosProdutos op, JTable tblProdutos, double p) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where precoProduto < "+p+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorQuantidadeIgual(OutrosProdutos op, JTable tblProdutos, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where quantidade ="+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorQuantidadeMaior(OutrosProdutos op, JTable tblProdutos, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where quantidade >"+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                   rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void pesquisarPorQuantidadeMenor(OutrosProdutos op, JTable tblProdutos, int q) {
DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
model.setRowCount(0);
        try {
            String sql = "select * from outrosProdutos where quantidade < "+q+";";
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("IdOutrosProdutos"),
                    rs.getString("nomeProduto"),
                    rs.getDouble("precoProduto"),
                    rs.getInt("quantidade"),
                    rs.getInt("quantidadeMax"),
                    rs.getInt("quantidadeMin")
                });

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void atualizarEstoqueProdutos(OutrosProdutos op, JTable tblProdutos, JTextField txtQuantidade) {
        try {
            int estoque,quantMax;
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            estoque = Integer.parseInt(tblProdutos.getValueAt(tblProdutos.getSelectedRow(),3).toString());
            quantMax =  Integer.parseInt(tblProdutos.getValueAt(tblProdutos.getSelectedRow(),4).toString());
            estoque +=quantidade;
            if(estoque>quantMax){
                JOptionPane.showMessageDialog(null,"Não foi possível atualizar a quantidadade em estoque, \n a quantidade excede a máxima em: " + (estoque - quantMax), "Quantidade inválida", JOptionPane.OK_OPTION);
                txtQuantidade.setBackground(Color.PINK);
                txtQuantidade.setText("");
                txtQuantidade.requestFocus();
                               
            }else{
                txtQuantidade.setBackground(Color.white);
                PreparedStatement stmt = c.prepareStatement("update outrosProdutos set quantidade = '"+estoque+"' where IdOutrosProdutos = "+tblProdutos.getValueAt(tblProdutos.getSelectedRow(),0).toString()+";");
                stmt.execute();
                stmt.close();
                tblProdutos.setValueAt(estoque, tblProdutos.getSelectedRow(), 3);
                        JOptionPane.showMessageDialog(null,"Estoque atualizado com sucesso","Atualizar Estoque",JOptionPane.OK_OPTION);
                txtQuantidade.setText("");
            
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterarDados(OutrosProdutos op, JTable tblProdutos,JTextField txtNome, double preco, int quantidade, int quantMax, int quantMin) {
        DefaultTableModel model = (DefaultTableModel)tblProdutos.getModel();
        try {
            PreparedStatement stmt = c.prepareStatement("update outrosProdutos set nomeProduto = '"+txtNome.getText()+"', precoProduto = '"+preco+"', quantidade = '"+quantidade+"', quantidadeMax = '"+quantMax+"', quantidadeMin ='"+quantMin+"' where IdOutrosProdutos = "+tblProdutos.getValueAt(tblProdutos.getSelectedRow(),0).toString()+";");
            stmt.execute();
            stmt.close();
            tblProdutos.setValueAt(txtNome.getText(), tblProdutos.getSelectedRow(), 1);
            tblProdutos.setValueAt(preco,tblProdutos.getSelectedRow(),2);
            tblProdutos.setValueAt(quantidade,tblProdutos.getSelectedRow(),3);
            tblProdutos.setValueAt(quantMax,tblProdutos.getSelectedRow(),4);
            tblProdutos.setValueAt(quantMin,tblProdutos.getSelectedRow(),5);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
