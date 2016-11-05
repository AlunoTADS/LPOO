/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view;

/**
 *
 * @author edenm
 */
public class jifCadastroCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifCadastroCliente
     */
    public jifCadastroCliente() {
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

        tf_Codigo = new javax.swing.JTextField();
        tf_Nome = new javax.swing.JTextField();
        tf_Sobrenome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_Pesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_Endereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_UF = new javax.swing.JComboBox<>();
        tf_RG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_CPF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        btn_Novo = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        btnAlterar = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        btnGravar = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        btnAtualizar = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        btnCancelar = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        btnExcluir = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gerenciamento de Clientes");

        tf_Codigo.setBackground(new java.awt.Color(240, 235, 240));
        tf_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CodigoActionPerformed(evt);
            }
        });

        tf_Nome.setBackground(new java.awt.Color(240, 235, 240));

        tf_Sobrenome.setBackground(new java.awt.Color(240, 235, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Sobrenome");

        jb_Pesquisar.setText("...");
        jb_Pesquisar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Endereço");

        tf_Endereco.setBackground(new java.awt.Color(240, 235, 240));
        tf_Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_EnderecoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("UF");

        cb_UF.setBackground(new java.awt.Color(240, 235, 240));
        cb_UF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));
        cb_UF.setBorder(null);
        cb_UF.setPreferredSize(new java.awt.Dimension(56, 35));
        cb_UF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_UFActionPerformed(evt);
            }
        });

        tf_RG.setBackground(new java.awt.Color(240, 235, 240));
        tf_RG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_RGActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("RG");

        tf_CPF.setBackground(new java.awt.Color(240, 235, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("CPF");

        jScrollPane1.setViewportView(jTextPane1);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(179, 60));

        jMenu2.setText("     ");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/menu40.png"))); // NOI18N
        jMenu3.add(jSeparator1);

        jMenuItem1.setText("Duplicar registro selecionado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Retornar para tela principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Sair do sistema");
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator2);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("     ");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        btn_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/criar25.png"))); // NOI18N
        btn_Novo.setText("NOVO (F2)");
        jMenuBar1.add(btn_Novo);

        jMenu12.setText("     ");
        jMenuBar1.add(jMenu12);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/edit-icon.png"))); // NOI18N
        btnAlterar.setText("ALTERAR (F3)");
        jMenuBar1.add(btnAlterar);

        jMenu4.setText("     ");
        jMenu4.setEnabled(false);
        jMenuBar1.add(jMenu4);

        btnGravar.setIcon(new javax.swing.ImageIcon("D:\\TADS nao sincronizado\\LPOO - trabalho4semestre\\salvar.png")); // NOI18N
        btnGravar.setText("GRAVAR (F4)");
        jMenuBar1.add(btnGravar);

        jMenu6.setText("     ");
        jMenu6.setEnabled(false);
        jMenuBar1.add(jMenu6);

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/atualizar.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR (F5)");
        jMenuBar1.add(btnAtualizar);

        jMenu8.setText("     ");
        jMenu8.setEnabled(false);
        jMenuBar1.add(jMenu8);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/Cancelar25.png"))); // NOI18N
        btnCancelar.setText("CANCELAR (F6)");
        jMenuBar1.add(btnCancelar);

        jMenu10.setText("     ");
        jMenu10.setEnabled(false);
        jMenuBar1.add(jMenu10);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/excluir25.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR (F11)");
        jMenuBar1.add(btnExcluir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tf_Sobrenome))
                        .addGap(18, 18, 18)
                        .addComponent(jb_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(202, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_Endereco)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 904, 728);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_CodigoActionPerformed

    private void tf_EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EnderecoActionPerformed

    private void cb_UFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_UFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_UFActionPerformed

    private void tf_RGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_RGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_RGActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnAlterar;
    private javax.swing.JMenu btnAtualizar;
    private javax.swing.JMenu btnCancelar;
    private javax.swing.JMenu btnExcluir;
    private javax.swing.JMenu btnGravar;
    private javax.swing.JMenu btn_Novo;
    private javax.swing.JComboBox<String> cb_UF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton jb_Pesquisar;
    private javax.swing.JTextField tf_CPF;
    private javax.swing.JTextField tf_Codigo;
    private javax.swing.JTextField tf_Endereco;
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_RG;
    private javax.swing.JTextField tf_Sobrenome;
    // End of variables declaration//GEN-END:variables
}
