/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view.veiculo;

import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Marca;
import br.ufpr.model.Veiculo;
import br.ufpr.view.util.SimpleReflectTableModel;
import java.util.Arrays;

/**
 *
 * @author edenm
 */
public class jif_veiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form jif_veiculo
     */
    public jif_veiculo() {
        initComponents();
        SimpleReflectTableModel simpleReflectTableModel = veiculoTable1.getSimpleReflectTableModel();
        simpleReflectTableModel.setDataList(Arrays.asList(
            new Veiculo(HEIGHT, Marca.HONDA, Estado.DISPONIVEL, null, Categoria.POPULAR, 50.00, "XXXX-0000", ABORT) {
            @Override
            public double getValorDiariaLocacao() {
                return 0;
            }
        }
    ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        veiculoTable1 = new br.ufpr.view.veiculo.VeiculoTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciamento de Veículos");
        setPreferredSize(new java.awt.Dimension(991, 676));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 60));

        jMenu1.setText("     ");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        jMenu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/menu40.png"))); // NOI18N
        jMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu13ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Duplicar veículo selecionado");
        jMenu13.add(jMenuItem1);
        jMenu13.add(jSeparator1);

        jMenuItem2.setText("Voltar para tela principal");
        jMenu13.add(jMenuItem2);

        jMenuItem3.setText("Sair do sistema");
        jMenu13.add(jMenuItem3);

        jMenuBar1.add(jMenu13);

        jMenu14.setText("     ");
        jMenuBar1.add(jMenu14);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/criar25.png"))); // NOI18N
        jMenu2.setText("NOVO (F2)");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("     ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/edit-icon.png"))); // NOI18N
        jMenu4.setText("ALTERAR (F3)");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("     ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/salvar.png"))); // NOI18N
        jMenu6.setText("GRAVAR (F4)");
        jMenuBar1.add(jMenu6);

        jMenu7.setText("     ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/atualizar.png"))); // NOI18N
        jMenu8.setText("BUSCAR (F5)");
        jMenuBar1.add(jMenu8);

        jMenu9.setText("     ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/Cancelar25.png"))); // NOI18N
        jMenu10.setText("CANCELAR (F6)");
        jMenuBar1.add(jMenu10);

        jMenu11.setText("     ");
        jMenuBar1.add(jMenu11);

        jMenu12.setPreferredSize(new java.awt.Dimension(100, 19));
        jMenuBar1.add(jMenu12);

        jMenu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/excluir25.png"))); // NOI18N
        jMenu15.setText("EXCLUIR (F12)");
        jMenuBar1.add(jMenu15);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(veiculoTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(veiculoTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private br.ufpr.view.veiculo.VeiculoTable veiculoTable1;
    // End of variables declaration//GEN-END:variables
}
