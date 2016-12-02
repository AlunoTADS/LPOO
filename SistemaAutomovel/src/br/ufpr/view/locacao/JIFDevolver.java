/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view.locacao;

import br.ufpr.data.VeiculoDao;
import br.ufpr.model.Automovel;
import br.ufpr.model.Estado;
import br.ufpr.model.Motocicleta;
import br.ufpr.model.Van;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author edenm
 */
public class JIFDevolver extends javax.swing.JInternalFrame {
    
    private Veiculo veiculo;
    private VeiculoDao veiculoDao;

    /**
     * Creates new form jif_devolver
     */
    public JIFDevolver() {
        initComponents();
        
        refreshTable();
        table.setClass(Veiculo.class);
        
        table.getTable()
                .getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        try {
                            veiculo = (Veiculo) table
                                    .getTableModel()
                                    .getDataList()
                                    .get(table.getTable().getSelectedRow());
                            refreshForm();
                        } catch (Exception ex) {
                        }
                    }
                });
    }
    
    private void refreshTable() {        
        try {
            List<Veiculo> automoveis = veiculoDao.listar(new Automovel(null, null, Estado.LOCADO, null, null, null, null, null));
            List<Veiculo> motocicletas = veiculoDao.listar(new Motocicleta(null, null, Estado.LOCADO, null, null, null, null, null));
            List<Veiculo> vans = veiculoDao.listar(new Van(null, null, Estado.LOCADO, null, null, null, null, null));
            List<Veiculo> veiculos = new ArrayList<>();
            veiculos.addAll(automoveis);
            veiculos.addAll(motocicletas);
            veiculos.addAll(vans);
            
            table.getTableModel().setDataList(veiculos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void refreshForm() {
        nomeClienteForm.setText(this.veiculo.getLocacao().getCliente() != null && this.veiculo.getLocacao().getCliente().getNome() != null ? this.veiculo.getLocacao().getCliente().getNome() : "");
        placaForm.setText(this.veiculo.getPlaca() != null ? this.veiculo.getPlaca() : "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        table = new br.ufpr.view.util.SimpleReflectTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        placaForm = new javax.swing.JTextField();
        nomeClienteForm = new javax.swing.JTextField();
        devolverForm = new javax.swing.JButton();
        placaForm1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        placaForm2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        placaForm3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        placaForm4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        placaForm5 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jm_menuprincipalclientes = new javax.swing.JMenu();
        jm_duplicarregistro = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jm_voltatelaprincipal = new javax.swing.JMenuItem();
        jm_sairdosistema = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Devolver Veículo");
        setPreferredSize(new java.awt.Dimension(907, 622));

        table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Placa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome do Cliente");

        placaForm.setBackground(new java.awt.Color(240, 235, 240));

        nomeClienteForm.setBackground(new java.awt.Color(240, 235, 240));

        devolverForm.setText("DEVOLVER");
        devolverForm.setEnabled(false);
        devolverForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverFormActionPerformed(evt);
            }
        });

        placaForm1.setBackground(new java.awt.Color(240, 235, 240));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Modelo");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Data Locação");

        placaForm2.setBackground(new java.awt.Color(240, 235, 240));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Preço Diária");

        placaForm3.setBackground(new java.awt.Color(240, 235, 240));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Qtde. Dias Locado");

        placaForm4.setBackground(new java.awt.Color(240, 235, 240));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Valor Locação");

        placaForm5.setBackground(new java.awt.Color(240, 235, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placaForm3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placaForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(placaForm5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(devolverForm))
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeClienteForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placaForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(placaForm2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placaForm2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeClienteForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placaForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placaForm3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placaForm4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(placaForm5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devolverForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 60));

        jMenu1.setText("     ");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        jm_menuprincipalclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/menu40.png"))); // NOI18N
        jm_menuprincipalclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_menuprincipalclientesActionPerformed(evt);
            }
        });

        jm_duplicarregistro.setText("Duplicar registro selecionado");
        jm_duplicarregistro.setEnabled(false);
        jm_duplicarregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_duplicarregistroActionPerformed(evt);
            }
        });
        jm_menuprincipalclientes.add(jm_duplicarregistro);
        jm_menuprincipalclientes.add(jSeparator1);

        jm_voltatelaprincipal.setText("Voltar para tela principal");
        jm_voltatelaprincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_voltatelaprincipalActionPerformed(evt);
            }
        });
        jm_menuprincipalclientes.add(jm_voltatelaprincipal);

        jm_sairdosistema.setText("Sair do sistema");
        jm_sairdosistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_sairdosistemaActionPerformed(evt);
            }
        });
        jm_menuprincipalclientes.add(jm_sairdosistema);

        jMenuBar1.add(jm_menuprincipalclientes);

        jMenu3.setText("     ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu7.setText("     ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        jMenu9.setText("     ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jMenu11.setText("     ");
        jMenu11.setEnabled(false);
        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_duplicarregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_duplicarregistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_duplicarregistroActionPerformed

    private void jm_voltatelaprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_voltatelaprincipalActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_voltatelaprincipalActionPerformed

    private void jm_sairdosistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_sairdosistemaActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_sairdosistemaActionPerformed

    private void jm_menuprincipalclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_menuprincipalclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_menuprincipalclientesActionPerformed

    private void devolverFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_devolverFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton devolverForm;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jm_duplicarregistro;
    private javax.swing.JMenu jm_menuprincipalclientes;
    private javax.swing.JMenuItem jm_sairdosistema;
    private javax.swing.JMenuItem jm_voltatelaprincipal;
    private javax.swing.JTextField nomeClienteForm;
    private javax.swing.JTextField placaForm;
    private javax.swing.JTextField placaForm1;
    private javax.swing.JTextField placaForm2;
    private javax.swing.JTextField placaForm3;
    private javax.swing.JTextField placaForm4;
    private javax.swing.JTextField placaForm5;
    private br.ufpr.view.util.SimpleReflectTable table;
    // End of variables declaration//GEN-END:variables
}
