/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view.veiculo;

import br.ufpr.data.AutomovelDao;
import br.ufpr.data.MotocicletaDao;
import br.ufpr.data.VanDao;
import br.ufpr.data.VeiculoDao;
import br.ufpr.model.Automovel;
import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Marca;
import br.ufpr.model.ModeloAutomovel;
import br.ufpr.model.ModeloMotocicleta;
import br.ufpr.model.ModeloVan;
import br.ufpr.model.Motocicleta;
import br.ufpr.model.Van;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author edenm
 */
public class JIFVender extends javax.swing.JInternalFrame {

    private VeiculoDao veiculoDao = new VeiculoDao();
    private AutomovelDao automovelDao = new AutomovelDao();
    private MotocicletaDao motocicletaDao = new MotocicletaDao();
    private VanDao vanDao = new VanDao();
    private Veiculo veiculo = new Automovel();

    /**
     * Creates new form jif_veiculo
     */
    public JIFVender() {
        initComponents();
        this.marcaVenda.setModel(new DefaultComboBoxModel(Marca.values()));
        this.modeloVenda.setModel(new DefaultComboBoxModel(ModeloAutomovel.values()));
        this.categoriaVenda.setModel(new DefaultComboBoxModel(Categoria.values()));

        table.setClass(Veiculo.class);
        table.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    veiculo = (Veiculo) table
                            .getTableModel()
                            .getDataList()
                            .get(table
                                    .getTable()
                                    .getSelectedRow());
                    refreshForm();
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
        });
        refreshTable();
    }

    private void refreshForm() {
        modeloVenda.getSelectedItem();
    }

    private void refreshTable() {
          List<? extends Veiculo> veiculos = new ArrayList<>();
        try {
            if (cbTipoAutomovelVenda.isSelected()) {
                table.setClass(Automovel.class);
                veiculos = automovelDao.listar(new Automovel(null, (ModeloAutomovel) modeloVenda.getSelectedItem(), (Marca) marcaVenda.getSelectedItem(), Estado.DISPONIVEL, null, (Categoria) categoriaVenda.getSelectedItem(), null, null, null));
            } else if (cbTipoMotoVenda.isSelected()) {
                table.setClass(Motocicleta.class);
                veiculos = motocicletaDao.listar(new Motocicleta(null, (ModeloMotocicleta) modeloVenda.getSelectedItem(), (Marca) marcaVenda.getSelectedItem(), Estado.DISPONIVEL, null, (Categoria) categoriaVenda.getSelectedItem(), null, null, null));
            } else if (cbTipoVanVenda.isSelected()) {
                table.setClass(Van.class);
                veiculos = vanDao.listar(new Van(null, (ModeloVan) modeloVenda.getSelectedItem(),(Marca) marcaVenda.getSelectedItem(), Estado.DISPONIVEL, null, (Categoria) categoriaVenda.getSelectedItem(), null, null, null));
            }
            table.getTableModel().setDataList(veiculos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     private void setaTipoAutomovel() {
        this.modeloVenda.setModel(new DefaultComboBoxModel(ModeloAutomovel.values()));
    }
    
     private void setaTipoMotocicleta(){
        this.modeloVenda.setModel(new DefaultComboBoxModel(ModeloMotocicleta.values())); 
     }
     
     private void setaTipoVan(){
        this.modeloVenda.setModel(new DefaultComboBoxModel(ModeloVan.values()));  
     }

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cbTipoAutomovelVenda = new javax.swing.JCheckBox();
        cbTipoMotoVenda = new javax.swing.JCheckBox();
        cbTipoVanVenda = new javax.swing.JCheckBox();
        marcaVenda = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        modeloVenda = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        table = new br.ufpr.view.util.SimpleReflectTable();
        categoriaVenda = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        filtrarVenda = new javax.swing.JButton();
        venda = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_VoltarTelaPrincipal = new javax.swing.JMenuItem();
        jmi_sair_do_sistema = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu_buscar = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu_alterar = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu_gravar = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu_cancelar = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venda de Veículos");
        setMinimumSize(new java.awt.Dimension(991, 676));
        setPreferredSize(new java.awt.Dimension(991, 676));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        buttonGroupTipo.add(cbTipoAutomovelVenda);
        cbTipoAutomovelVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoAutomovelVenda.setText("Automóvel");
        cbTipoAutomovelVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTipoAutomovelVendaMouseClicked(evt);
            }
        });
        cbTipoAutomovelVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAutomovelVendaActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(cbTipoMotoVenda);
        cbTipoMotoVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoMotoVenda.setText("Motocicleta");
        cbTipoMotoVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTipoMotoVendaMouseClicked(evt);
            }
        });

        buttonGroupTipo.add(cbTipoVanVenda);
        cbTipoVanVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoVanVenda.setText("Van");
        cbTipoVanVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTipoVanVendaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cbTipoAutomovelVenda)
                .addGap(18, 18, 18)
                .addComponent(cbTipoMotoVenda)
                .addGap(18, 18, 18)
                .addComponent(cbTipoVanVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbTipoAutomovelVenda, cbTipoMotoVenda});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoAutomovelVenda)
                    .addComponent(cbTipoMotoVenda)
                    .addComponent(cbTipoVanVenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbTipoAutomovelVenda, cbTipoMotoVenda, cbTipoVanVenda});

        marcaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        marcaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaVendaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marca");

        modeloVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Modelo");

        categoriaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoriaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaVendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Categoria");

        filtrarVenda.setText("Filtrar");
        filtrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarVendaActionPerformed(evt);
            }
        });

        venda.setText("Vender");
        venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
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
        jMenu13.add(jSeparator1);

        jmi_VoltarTelaPrincipal.setText("Voltar para tela principal");
        jmi_VoltarTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_VoltarTelaPrincipalActionPerformed(evt);
            }
        });
        jMenu13.add(jmi_VoltarTelaPrincipal);

        jmi_sair_do_sistema.setText("Sair do sistema");
        jmi_sair_do_sistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_sair_do_sistemaActionPerformed(evt);
            }
        });
        jMenu13.add(jmi_sair_do_sistema);

        jMenuBar1.add(jMenu13);

        jMenu3.setText("     ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/atualizar.png"))); // NOI18N
        jMenu_buscar.setText("BUSCAR (F5)");
        jMenu_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_buscarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_buscar);

        jMenu14.setText("     ");
        jMenuBar1.add(jMenu14);

        jMenu_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/edit-icon.png"))); // NOI18N
        jMenu_alterar.setText("ALTERAR (F3)");
        jMenu_alterar.setEnabled(false);
        jMenu_alterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_alterarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_alterar);

        jMenu5.setText("     ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/salvar.png"))); // NOI18N
        jMenu_gravar.setText("GRAVAR (F4)");
        jMenu_gravar.setEnabled(false);
        jMenu_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_gravarActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu_gravar);

        jMenu7.setText("     ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        jMenu9.setText("     ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jMenu_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/Cancelar25.png"))); // NOI18N
        jMenu_cancelar.setText("CANCELAR (F6)");
        jMenu_cancelar.setEnabled(false);
        jMenuBar1.add(jMenu_cancelar);

        jMenu11.setText("     ");
        jMenuBar1.add(jMenu11);

        jMenu12.setPreferredSize(new java.awt.Dimension(100, 19));
        jMenuBar1.add(jMenu12);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marcaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeloVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(filtrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(categoriaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(table, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(marcaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modeloVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        setBounds(0, 0, 983, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu13ActionPerformed

    private void jmi_VoltarTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_VoltarTelaPrincipalActionPerformed
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_VoltarTelaPrincipalActionPerformed

    private void jmi_sair_do_sistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_sair_do_sistemaActionPerformed

        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_sair_do_sistemaActionPerformed

    private void jMenu_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_buscarMouseClicked
        jMenu_alterar.setEnabled(true);
        jMenu_cancelar.setEnabled(true);
        jMenu_gravar.setEnabled(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_buscarMouseClicked

    private void marcaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaVendaActionPerformed

    }//GEN-LAST:event_marcaVendaActionPerformed

    private void cbTipoVanVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoVanVendaMouseClicked
        setaTipoVan();
        jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoVanVendaMouseClicked

    private void cbTipoMotoVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoMotoVendaMouseClicked
        setaTipoMotocicleta();
        jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoMotoVendaMouseClicked

    private void cbTipoAutomovelVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAutomovelVendaActionPerformed
        setaTipoAutomovel();
    }//GEN-LAST:event_cbTipoAutomovelVendaActionPerformed

    private void cbTipoAutomovelVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTipoAutomovelVendaMouseClicked
        jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoAutomovelVendaMouseClicked

    private void categoriaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaVendaActionPerformed
        refreshForm();
    }//GEN-LAST:event_categoriaVendaActionPerformed

    private void jMenu_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_gravarActionPerformed

    }//GEN-LAST:event_jMenu_gravarActionPerformed

    private void jMenu_alterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_alterarMouseClicked
        jMenu_alterar.setEnabled(true);
        jMenu_cancelar.setEnabled(true);
        jMenu_gravar.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_alterarMouseClicked

    private void filtrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarVendaActionPerformed
        this.refreshTable();
    }//GEN-LAST:event_filtrarVendaActionPerformed

    private void vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaActionPerformed
        veiculo.vender();
        try {
            veiculoDao.editar(veiculo);
             JOptionPane.showMessageDialog(null, "Veículo vendido com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(JIFVender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_vendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JComboBox<String> categoriaVenda;
    private javax.swing.JCheckBox cbTipoAutomovelVenda;
    private javax.swing.JCheckBox cbTipoMotoVenda;
    private javax.swing.JCheckBox cbTipoVanVenda;
    private javax.swing.JButton filtrarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_alterar;
    private javax.swing.JMenu jMenu_buscar;
    private javax.swing.JMenu jMenu_cancelar;
    private javax.swing.JMenu jMenu_gravar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmi_VoltarTelaPrincipal;
    private javax.swing.JMenuItem jmi_sair_do_sistema;
    private javax.swing.JComboBox<String> marcaVenda;
    private javax.swing.JComboBox<String> modeloVenda;
    private br.ufpr.view.util.SimpleReflectTable table;
    private javax.swing.JButton venda;
    // End of variables declaration//GEN-END:variables
}
