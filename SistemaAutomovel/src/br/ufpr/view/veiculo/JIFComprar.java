/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view.veiculo;

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
import br.ufpr.view.util.ComponentUtil;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author edenm
 */
public class JIFComprar extends javax.swing.JInternalFrame {

    private Veiculo veiculo;
    private br.ufpr.view.util.SimpleReflectTable simpleReflectTable1;
    private List<Component> camposDisable, camposEnable;
    
    /**
     * Creates new form jif_veiculo
     */
    public JIFComprar() {
        initComponents();
        
        camposDisable = Arrays.asList(automovelCompra, motocicletaCompra, vanCompra, placaCompra, anoCompra, valorCompra, estadoCompra, marcaCompra, modeloCompra, categoriaCompra);
        camposEnable = Arrays.asList(automovelCompra, motocicletaCompra, vanCompra, placaCompra, anoCompra, valorCompra);
        
        disableForm();
        enableForm();
        
        this.marcaCompra.setModel(new DefaultComboBoxModel(Marca.values()));
        this.categoriaCompra.setModel(new DefaultComboBoxModel(Categoria.values()));
        this.estadoCompra.setModel(new DefaultComboBoxModel(Estado.values()));
        
        try {
            DecimalFormat dFormat = new DecimalFormat("####,###,###,###.00");
            NumberFormatter formatter = new NumberFormatter(dFormat);
            formatter.setFormat(dFormat);
            formatter.setAllowsInvalid(false);
            MaskFormatter maskPlaca = new MaskFormatter("UUU-####");
            maskPlaca.setPlaceholderCharacter('_');
            this.valorCompra.setFormatterFactory(new DefaultFormatterFactory(formatter));
            maskPlaca.install(placaCompra);
        } catch (ParseException ex) {
            Logger.getLogger(JIFComprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refreshForm() {
        this.modeloCompra.setEnabled(true);
        this.marcaCompra.setEnabled(true);
        this.categoriaCompra.setEnabled(true);
        this.estadoCompra.setEnabled(true);
        if (this.automovelCompra.isSelected()) {
            this.modeloCompra.setModel(new DefaultComboBoxModel(ModeloAutomovel.values()));
        } else if (this.motocicletaCompra.isSelected()) {
            this.modeloCompra.setModel(new DefaultComboBoxModel(ModeloMotocicleta.values()));
        } else if (this.vanCompra.isSelected()) {
            this.modeloCompra.setModel(new DefaultComboBoxModel(ModeloVan.values()));
        }
    }
    
    public void save() {
        VeiculoDao veiculoDao = new VeiculoDao();
        Marca marca = (Marca) this.marcaCompra.getSelectedItem();
        Estado estado = (Estado) this.estadoCompra.getSelectedItem();
        Categoria categoria = (Categoria) this.categoriaCompra.getSelectedItem();
        Double valorCompra = new Double(this.valorCompra.getText().replace(".", "").replace(",", "."));
        String placa = this.placaCompra.getText();
        Integer ano = new Integer(this.anoCompra.getText());
        
        if (this.automovelCompra.isSelected()) {
            ModeloAutomovel modelo = (ModeloAutomovel) this.modeloCompra.getSelectedItem();
            this.veiculo = new Automovel(null, modelo, marca, estado, null, categoria, valorCompra, placa, ano);
        } else if (this.motocicletaCompra.isSelected()) {
            ModeloMotocicleta modelo = (ModeloMotocicleta) this.modeloCompra.getSelectedItem();
            this.veiculo = new Motocicleta(null, modelo, marca, estado, null, categoria, valorCompra, placa, ano);
        } else if (this.vanCompra.isSelected()) {
            ModeloVan modelo = (ModeloVan) this.modeloCompra.getSelectedItem();
            this.veiculo = new Van(null, modelo, marca, estado, null, categoria, valorCompra, placa, ano);
        }
        
        try {
            veiculoDao.inserir(this.veiculo);
            JOptionPane.showMessageDialog(null, "Veículo comprado com sucesso.");
            disableForm();            
        } catch (Exception ex) {
            Logger.getLogger(JIFComprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void enableForm() {
        for (Component c : camposEnable) {
            ComponentUtil.enable(c);
        }
    }

    private void disableForm() {
        for (Component c : camposDisable) {
            ComponentUtil.disable(c);
        }
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
        automovelCompra = new javax.swing.JCheckBox();
        motocicletaCompra = new javax.swing.JCheckBox();
        vanCompra = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        placaCompra = new javax.swing.JFormattedTextField();
        anoCompra = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        marcaCompra = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        modeloCompra = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        valorCompra = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        estadoCompra = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        categoriaCompra = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jmi_duplicarveiculo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_VoltarTelaPrincipal = new javax.swing.JMenuItem();
        jmi_sair_do_sistema = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenu_novo = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu_alterar = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu_gravar = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu_buscar = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu_cancelar = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu_excluir = new javax.swing.JMenu();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compra de Veículos");
        setMinimumSize(new java.awt.Dimension(991, 676));
        setPreferredSize(new java.awt.Dimension(991, 676));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        buttonGroupTipo.add(automovelCompra);
        automovelCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        automovelCompra.setText("Automóvel");
        automovelCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                automovelCompraMouseClicked(evt);
            }
        });
        automovelCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automovelCompraActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(motocicletaCompra);
        motocicletaCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        motocicletaCompra.setText("Motocicleta");
        motocicletaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                motocicletaCompraMouseClicked(evt);
            }
        });
        motocicletaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motocicletaCompraActionPerformed(evt);
            }
        });

        buttonGroupTipo.add(vanCompra);
        vanCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        vanCompra.setText("Van");
        vanCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vanCompraMouseClicked(evt);
            }
        });
        vanCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vanCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(automovelCompra)
                .addGap(18, 18, 18)
                .addComponent(motocicletaCompra)
                .addGap(18, 18, 18)
                .addComponent(vanCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {automovelCompra, motocicletaCompra});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(automovelCompra)
                    .addComponent(motocicletaCompra)
                    .addComponent(vanCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {automovelCompra, motocicletaCompra, vanCompra});

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Placa");

        placaCompra.setBackground(new java.awt.Color(240, 240, 240));
        placaCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        placaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placaCompraActionPerformed(evt);
            }
        });

        anoCompra.setBackground(new java.awt.Color(240, 240, 240));
        anoCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ano");

        marcaCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marcaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaCompraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Marca");

        modeloCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Modelo");

        valorCompra.setBackground(new java.awt.Color(240, 240, 240));
        valorCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Valor Compra (R$)");

        estadoCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estadoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoCompraActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Categoria");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Estado");

        categoriaCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        categoriaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaCompraActionPerformed(evt);
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

        jmi_duplicarveiculo.setText("Duplicar veículo selecionado");
        jmi_duplicarveiculo.setEnabled(false);
        jMenu13.add(jmi_duplicarveiculo);
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

        jMenu14.setText("     ");
        jMenuBar1.add(jMenu14);

        jMenu_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/criar25.png"))); // NOI18N
        jMenu_novo.setText("NOVO (F2)");
        jMenu_novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_novoMouseClicked(evt);
            }
        });
        jMenu_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_novoActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu_novo);

        jMenu3.setText("     ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        jMenu_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/edit-icon.png"))); // NOI18N
        jMenu_alterar.setText("ALTERAR (F3)");
        jMenu_alterar.setEnabled(false);
        jMenuBar1.add(jMenu_alterar);

        jMenu5.setText("     ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/salvar.png"))); // NOI18N
        jMenu_gravar.setText("GRAVAR (F4)");
        jMenu_gravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_gravarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_gravar);

        jMenu7.setText("     ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        jMenu_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/atualizar.png"))); // NOI18N
        jMenu_buscar.setText("BUSCAR (F5)");
        jMenu_buscar.setEnabled(false);
        jMenuBar1.add(jMenu_buscar);

        jMenu9.setText("     ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jMenu_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/Cancelar25.png"))); // NOI18N
        jMenu_cancelar.setText("CANCELAR (F6)");
        jMenu_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_cancelarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_cancelar);

        jMenu12.setPreferredSize(new java.awt.Dimension(50, 19));
        jMenuBar1.add(jMenu12);

        jMenu_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/excluir25.png"))); // NOI18N
        jMenu_excluir.setText("EXCLUIR (F12)");
        jMenu_excluir.setEnabled(false);
        jMenuBar1.add(jMenu_excluir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(placaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marcaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(modeloCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(estadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(categoriaCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(placaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(marcaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeloCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 935, 569);
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

    private void jMenu_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_novoActionPerformed
    

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu_novoActionPerformed

    private void jMenu_novoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_novoMouseClicked
           jmi_duplicarveiculo.setEnabled(true);
           jMenu_cancelar.setEnabled(true);
           jMenu_gravar.setEnabled(true);
           this.enableForm();
    }//GEN-LAST:event_jMenu_novoMouseClicked

    private void automovelCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automovelCompraActionPerformed
        this.refreshForm();        
    }//GEN-LAST:event_automovelCompraActionPerformed

    private void automovelCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_automovelCompraMouseClicked
    jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_automovelCompraMouseClicked

    private void motocicletaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_motocicletaCompraMouseClicked
    jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_motocicletaCompraMouseClicked

    private void vanCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vanCompraMouseClicked
    jMenu_cancelar.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_vanCompraMouseClicked

    private void marcaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaCompraActionPerformed

    private void placaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaCompraActionPerformed

    private void motocicletaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motocicletaCompraActionPerformed
        this.refreshForm();
    }//GEN-LAST:event_motocicletaCompraActionPerformed

    private void vanCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vanCompraActionPerformed
        this.refreshForm();
    }//GEN-LAST:event_vanCompraActionPerformed

    private void estadoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoCompraActionPerformed
        this.refreshForm();
    }//GEN-LAST:event_estadoCompraActionPerformed

    private void categoriaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaCompraActionPerformed

    private void jMenu_gravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_gravarMouseClicked
        save();
    }//GEN-LAST:event_jMenu_gravarMouseClicked

    private void jMenu_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_cancelarMouseClicked
        this.disableForm();
        this.placaCompra.setText("");
        this.anoCompra.setText("");
    }//GEN-LAST:event_jMenu_cancelarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField anoCompra;
    private javax.swing.JCheckBox automovelCompra;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JComboBox<Categoria> categoriaCompra;
    private javax.swing.JComboBox<String> estadoCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
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
    private javax.swing.JMenu jMenu_excluir;
    private javax.swing.JMenu jMenu_gravar;
    private javax.swing.JMenu jMenu_novo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmi_VoltarTelaPrincipal;
    private javax.swing.JMenuItem jmi_duplicarveiculo;
    private javax.swing.JMenuItem jmi_sair_do_sistema;
    private javax.swing.JComboBox<Marca> marcaCompra;
    private javax.swing.JComboBox<Object> modeloCompra;
    private javax.swing.JCheckBox motocicletaCompra;
    private javax.swing.JFormattedTextField placaCompra;
    private javax.swing.JFormattedTextField valorCompra;
    private javax.swing.JCheckBox vanCompra;
    // End of variables declaration//GEN-END:variables
}
