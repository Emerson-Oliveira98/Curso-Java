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
public class DFrmCadPizzaIngredientes extends javax.swing.JDialog {

    int IdIngrediente;
    String NomeIngrediente;
    String Tipo;
    boolean ok = false;
    int Quantidade;
    public static IFrmCadPizzas frmcad;

    /**
     * Creates new form DFrmCadPizzaIngredientes
     */
    public DFrmCadPizzaIngredientes(IFrmCadPizzas parent, boolean modal) {
        // super(parent, modal);
        this.frmcad = parent;
        this.setModal(modal);
        ok = false;
        initComponents();
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngrediente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIngrediente = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolha o Ingrediente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblIngrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do ingrediente", "Tipo de medida", "Quantidade Atual", "Quantidade máxima", "Quantidade mínima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIngrediente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblIngrediente);
        if (tblIngrediente.getColumnModel().getColumnCount() > 0) {
            tblIngrediente.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblIngrediente.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Digite o nome do ingrediente:");

        txtIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngredienteActionPerformed(evt);
            }
        });
        txtIngrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIngredienteKeyReleased(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(255, 0, 0));
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Digite a quantidade do ingrediente:");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        lblImagem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblImagemAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtQuantidade))
                        .addGap(272, 401, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngredienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngredienteKeyReleased
        IngredientesPizza ingpizza = new IngredientesPizza();
        IngredientesPizzaDAO dao = new IngredientesPizzaDAO();
        DefaultTableModel model = (DefaultTableModel) tblIngrediente.getModel();
        try {
            model.setRowCount(0);
        } catch (Exception e) {
        }
        dao.PesquisarPorNome(ingpizza, tblIngrediente, txtIngrediente);

    }//GEN-LAST:event_txtIngredienteKeyReleased

    private void txtIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngredienteActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        try {
            IdIngrediente = (Integer.parseInt(tblIngrediente.getValueAt(tblIngrediente.getSelectedRow(), 0).toString()));
            NomeIngrediente = ((String) tblIngrediente.getValueAt(tblIngrediente.getSelectedRow(), 1));
            Tipo = ((String) tblIngrediente.getValueAt(tblIngrediente.getSelectedRow(), 2));
            try {
                Quantidade = Integer.parseInt(txtQuantidade.getText());
                if (Quantidade>=0) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um valor válido no campo quantidade", "Valor inválido", JOptionPane.OK_OPTION);
                    txtQuantidade.requestFocus();
                    txtQuantidade.setBackground(Color.pink);
                    txtQuantidade.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um valor válido no campo quantidade", "Valor Inválido", JOptionPane.OK_OPTION);
                txtQuantidade.requestFocus();
                txtQuantidade.setBackground(Color.pink);
                txtQuantidade.setText("");
            }
            ok = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione algum ingrediente", "Erro", JOptionPane.OK_OPTION);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        
        IngredientesPizza ingPizza = new IngredientesPizza();
        IngredientesPizzaDAO dao = new IngredientesPizzaDAO();
        dao.PesquisarTudo(ingPizza, tblIngrediente);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased


    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void lblImagemAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblImagemAncestorAdded
 ImageIcon icon = new ImageIcon("src/ProjetoImagem/tabela.png");
    lblImagem.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblImagem.getWidth(),lblImagem.getHeight(), icon.getIconWidth())));

        // TODO add your handling code here:
    }//GEN-LAST:event_lblImagemAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DFrmCadPizzaIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DFrmCadPizzaIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DFrmCadPizzaIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DFrmCadPizzaIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DFrmCadPizzaIngredientes dialog = new DFrmCadPizzaIngredientes(frmcad, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("pizza.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTable tblIngrediente;
    private javax.swing.JTextField txtIngrediente;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
