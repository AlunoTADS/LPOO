package br.ufpr.view;

import br.ufpr.view.veiculo.JIFVender;
import br.ufpr.view.cliente.JIFClientes;
import br.ufpr.view.locacao.JIFDevolver;
import br.ufpr.view.locacao.JIFLocar;
import br.ufpr.view.veiculo.compra.JIFVeiculo;
import br.ufpr.view.veiculo.devolucao.JIFDevolver;
import br.ufpr.view.veiculo.locacao.JIFLocar;
import br.ufpr.view.veiculo.JIFVeiculo;

/**
 *
 * @author edenm
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jdp_Principal = new javax.swing.JDesktopPane();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        menucadastro = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_CadastroClientes = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jmi_CadastroVeiculosComprar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuLocacao = new javax.swing.JMenu();
        jmi_LocacaoLocar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmi_LocacaoDevolver = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Locadora de Veículos");
        setExtendedState(MAXIMIZED_BOTH);

        jdp_Principal.setBackground(new java.awt.Color(109, 132, 180));
        jdp_Principal.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jdp_Principal, java.awt.BorderLayout.CENTER);

        MenuBarPrincipal.setBackground(new java.awt.Color(153, 153, 0));
        MenuBarPrincipal.setPreferredSize(new java.awt.Dimension(105, 30));

        menucadastro.setBackground(new java.awt.Color(255, 51, 51));
        menucadastro.setText("CADASTRO");
        menucadastro.setBorderPainted(true);
        menucadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucadastroActionPerformed(evt);
            }
        });
        menucadastro.add(jSeparator1);

        jmi_CadastroClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jmi_CadastroClientes.setText("Clientes");
        jmi_CadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_CadastroClientesActionPerformed(evt);
            }
        });
        menucadastro.add(jmi_CadastroClientes);
        menucadastro.add(jSeparator5);

        jmi_CadastroVeiculosComprar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jmi_CadastroVeiculosComprar.setText("Comprar Veículos");
        jmi_CadastroVeiculosComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_CadastroVeiculosComprarActionPerformed(evt);
            }
        });
        menucadastro.add(jmi_CadastroVeiculosComprar);
        menucadastro.add(jSeparator2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem1.setText("Vender Veículo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menucadastro.add(jMenuItem1);
        menucadastro.add(jSeparator4);
        menucadastro.add(jSeparator6);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menucadastro.add(jMenuItem2);

        MenuBarPrincipal.add(menucadastro);

        jMenu2.setText("     ");
        jMenu2.setEnabled(false);
        MenuBarPrincipal.add(jMenu2);

        MenuLocacao.setText("LOCAÇÃO");

        jmi_LocacaoLocar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmi_LocacaoLocar.setText("Locar");
        jmi_LocacaoLocar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmi_LocacaoLocarMouseClicked(evt);
            }
        });
        jmi_LocacaoLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_LocacaoLocarActionPerformed(evt);
            }
        });
        MenuLocacao.add(jmi_LocacaoLocar);
        MenuLocacao.add(jSeparator3);

        jmi_LocacaoDevolver.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jmi_LocacaoDevolver.setText("Devolver");
        jmi_LocacaoDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_LocacaoDevolverActionPerformed(evt);
            }
        });
        MenuLocacao.add(jmi_LocacaoDevolver);

        MenuBarPrincipal.add(MenuLocacao);

        setJMenuBar(MenuBarPrincipal);

        setBounds(0, 0, 1348, 763);
    }// </editor-fold>//GEN-END:initComponents

    private void jmi_LocacaoLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_LocacaoLocarActionPerformed
        JIFLocar obj = new JIFLocar();
        jdp_Principal.add(obj);
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_LocacaoLocarActionPerformed

    private void jmi_LocacaoDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_LocacaoDevolverActionPerformed
        JIFDevolver obj = new JIFDevolver();
        jdp_Principal.add(obj);
        obj.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_LocacaoDevolverActionPerformed

    private void menucadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucadastroActionPerformed
        

        // TODO add your handling code here:
    }//GEN-LAST:event_menucadastroActionPerformed

    private void jmi_CadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_CadastroClientesActionPerformed
        JIFClientes obj = new JIFClientes();
        jdp_Principal.add(obj);
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_CadastroClientesActionPerformed

    private void jmi_LocacaoLocarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmi_LocacaoLocarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_LocacaoLocarMouseClicked

    private void jmi_CadastroVeiculosComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_CadastroVeiculosComprarActionPerformed
        JIFVeiculo obj = new JIFVeiculo();
        jdp_Principal.add(obj);
        obj.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_CadastroVeiculosComprarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JIFVender obj = new JIFVender();
        jdp_Principal.add(obj);
        obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenu MenuLocacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JDesktopPane jdp_Principal;
    private javax.swing.JMenuItem jmi_CadastroClientes;
    private javax.swing.JMenuItem jmi_CadastroVeiculosComprar;
    private javax.swing.JMenuItem jmi_LocacaoDevolver;
    private javax.swing.JMenuItem jmi_LocacaoLocar;
    private javax.swing.JMenu menucadastro;
    // End of variables declaration//GEN-END:variables
}
