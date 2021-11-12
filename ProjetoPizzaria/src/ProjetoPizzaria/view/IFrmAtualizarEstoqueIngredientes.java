/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoPizzaria.view;

import ProjetoPizzaria.DAO.IngredientesPizzaDAO;
import ProjetoPizzaria.modelo.IngredientesPizza;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class IFrmAtualizarEstoqueIngredientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form IFrmAtualizarEstoqueIngredientes
     */
    public IFrmAtualizarEstoqueIngredientes() {
        initComponents();
        getContentPane().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomeIngrediente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblIngredientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnConfirmar = new javax.swing.JButton();
        txtQuantidadeIngrediente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Atualizar Estoque de Ingredientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        txtNomeIngrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeIngredienteKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Digite o nome do ingrediente:");

        TblIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Ingrediente", "Tipo de Medida", "Quantidade em estoque", "Quantidade MAX", "Quantidade MIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblIngredientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblIngredientes);
        if (TblIngredientes.getColumnModel().getColumnCount() > 0) {
            TblIngredientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            TblIngredientes.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Por favor selecione o ingrediente que deseja atualizar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Informe a quantidade comprada do ingrediente Selecionado:");

        BtnConfirmar.setBackground(new java.awt.Color(255, 51, 51));
        BtnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        jLabel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(BtnConfirmar))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidadeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidadeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(BtnConfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        DefaultTableModel model = (DefaultTableModel)TblIngredientes.getModel();
        
        
        if (!txtQuantidadeIngrediente.getText().equals("")) {
            try {
                int q = Integer.parseInt(txtQuantidadeIngrediente.getText());
                if(q<=0){
                JOptionPane.showMessageDialog(null, "Por favor, preencha a quantidade corretamente", "Preencher quantidade", JOptionPane.OK_OPTION);
                txtQuantidadeIngrediente.setText("");
                txtQuantidadeIngrediente.requestFocus();
                }else{
                try {
                    int r = JOptionPane.showConfirmDialog(null, "Deseja realmente adicionar: " + txtQuantidadeIngrediente.getText() + " " + TblIngredientes.getValueAt(TblIngredientes.getSelectedRow(), 2) + "\n de: " + TblIngredientes.getValueAt(TblIngredientes.getSelectedRow(), 1), "Adicionar Ingrediente", JOptionPane.YES_NO_OPTION);
                    if (r == 0) {
                        IngredientesPizza ingpizza = new IngredientesPizza();
                        IngredientesPizzaDAO dao = new IngredientesPizzaDAO();
                        dao.AtualizarEstoqueIngrediente(ingpizza, TblIngredientes, txtQuantidadeIngrediente);
                        txtNomeIngrediente.setText("");
                        model.setRowCount(0);
                        dao.PesquisarTudo(ingpizza, TblIngredientes);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione algum ingrediente", "Selecione algum ingrediente", JOptionPane.OK_OPTION);
                }
                }
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha a quantidade corretamente", "Preencher quantidade", JOptionPane.OK_OPTION);
                txtQuantidadeIngrediente.setText("");
                txtQuantidadeIngrediente.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, digite a quantidade de ingredientes", "Digite a quantidade", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        BtnConfirmar.setEnabled(true);
        txtQuantidadeIngrediente.setEditable(true);
        txtQuantidadeIngrediente.setBackground(Color.white);
        IngredientesPizza ingPizza = new IngredientesPizza();
        IngredientesPizzaDAO dao = new IngredientesPizzaDAO();
        dao.PesquisarTudo(ingPizza, TblIngredientes);
        txtNomeIngrediente.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNomeIngredienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeIngredienteKeyReleased
        DefaultTableModel model = (DefaultTableModel) TblIngredientes.getModel();
        model.setRowCount(0);
        IngredientesPizza ingPizza = new IngredientesPizza();
        IngredientesPizzaDAO dao = new IngredientesPizzaDAO();
        dao.PesquisarPorNome(ingPizza, TblIngredientes, txtNomeIngrediente);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeIngredienteKeyReleased

    private void jLabel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel4AncestorAdded
        ImageIcon icon = new ImageIcon("src/ProjetoImagem/tabela.png");
    jLabel4.setIcon(new ImageIcon(icon.getImage().getScaledInstance(jLabel4.getWidth(),jLabel4.getHeight(), icon.getIconWidth()))); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4AncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JTable TblIngredientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNomeIngrediente;
    private javax.swing.JTextField txtQuantidadeIngrediente;
    // End of variables declaration//GEN-END:variables
}
