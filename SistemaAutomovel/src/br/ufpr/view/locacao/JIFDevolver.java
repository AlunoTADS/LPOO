package br.ufpr.view.locacao;

import br.ufpr.data.ClienteDao;
import br.ufpr.data.LocacaoDao;
import br.ufpr.data.VeiculoDao;
import br.ufpr.model.Categoria;
import br.ufpr.model.Cliente;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.Veiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author edenm
 */
public class JIFDevolver extends javax.swing.JInternalFrame {

    private Cliente cliente;
    private Locacao locacao;
    private Veiculo veiculo;
    private VeiculoDao veiculoDao = new VeiculoDao();
    private ClienteDao clienteDao = new ClienteDao();
    private LocacaoDao locacaoDao = new LocacaoDao();

    /**
     * Creates new form jif_devolver
     */
    public JIFDevolver() {
        initComponents();

        refreshTable();
        table.setClass(Locacao.class);

        table.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = table.getTable().getSelectedRow();
                    if (row >= 0) {
                        locacao = (Locacao) table.getTableModel().getDataList().get(row);
                        locacao.setCliente(clienteDao.buscar(locacao.getCliente()));
                        cliente = locacao.getCliente();
                        veiculo = veiculoDao.buscar(new Veiculo(locacao.getIdVeiculo(), null, null, null, null, null, null, null) {
                            @Override
                            public double getValorDiariaLocacao() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                    } else {
                        locacao = null;
                    }
                    refreshForm();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void refreshTable() {
        try {
            List<Locacao> locacoes = locacaoDao.listar(new Locacao(null));
            for (Locacao locacao : locacoes) {
                Cliente c = locacao.getCliente();
                c = clienteDao.buscar(c);
                locacao.setCliente(c);
            }
            table.getTableModel().setDataList(locacoes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshForm() {
        nomeClienteForm.setText(locacao != null && locacao.getCliente() != null && locacao.getCliente().getNome() != null ? locacao.getCliente().getNome() : "");
        dataLocacaoForm.setText(locacao != null && locacao.getDataInicioFormatada() != null ? locacao.getDataInicioFormatada() : "");
        precoDiariaForm.setText(locacao != null && locacao.getValor() != null ? String.format("%10.2f", locacao.getValor()) : "");
        qtdeDiasLocadoForm.setText(locacao != null && locacao.getDias() != null ? String.format("%10d", locacao.getDias()) : "");
        valorLocacaoForm.setText(locacao != null && locacao.getValorDiario() != null ? String.format("%10.2f", locacao.getValorDiario()) : "");
        marcaForm.setText(veiculo != null && veiculo.getMarcaDescricao() != null ? veiculo.getMarcaDescricao() : "");
        anoForm.setText(veiculo != null && veiculo.getAno() != 0 ? String.format("%10d", veiculo.getAno()) : "");
        categriaForm.setText(veiculo != null && veiculo.getCategoriaDescricao() != null ? veiculo.getCategoriaDescricao() : "");
        placaForm.setText(veiculo != null && veiculo.getPlaca() != null ? veiculo.getPlaca() : "");

        devolverForm.setEnabled(locacao != null && locacao.getIdVeiculo() != null && veiculo != null && veiculo.getIdVeiculo() != null);

    }

    private void gravar() {
        if (!(locacao != null && locacao.getIdVeiculo() != null && veiculo != null && veiculo.getIdVeiculo() != null)) {
            JOptionPane.showMessageDialog(null, "Selecione uma locação");
            return;
        }

        veiculo.devolver();
        try {
            veiculoDao.editar(veiculo);
            locacaoDao.excluir(locacao);
            JOptionPane.showMessageDialog(null, "Gravado com sucesso");
            veiculo = null;
            cliente = null;
            locacao = null;
            refreshForm();
            refreshTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        table = new br.ufpr.view.util.SimpleReflectTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        placaForm = new javax.swing.JTextField();
        nomeClienteForm = new javax.swing.JTextField();
        devolverForm = new javax.swing.JButton();
        categriaForm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dataLocacaoForm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        precoDiariaForm = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        qtdeDiasLocadoForm = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        valorLocacaoForm = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        marcaForm = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        anoForm = new javax.swing.JTextField();
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
        placaForm.setEnabled(false);

        nomeClienteForm.setBackground(new java.awt.Color(240, 235, 240));
        nomeClienteForm.setEnabled(false);

        devolverForm.setText("DEVOLVER");
        devolverForm.setEnabled(false);
        devolverForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                devolverFormMouseClicked(evt);
            }
        });

        categriaForm.setBackground(new java.awt.Color(240, 235, 240));
        categriaForm.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Modelo");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Data Locação");

        dataLocacaoForm.setBackground(new java.awt.Color(240, 235, 240));
        dataLocacaoForm.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Preço Diária");

        precoDiariaForm.setBackground(new java.awt.Color(240, 235, 240));
        precoDiariaForm.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Qtde. Dias Locado");

        qtdeDiasLocadoForm.setBackground(new java.awt.Color(240, 235, 240));
        qtdeDiasLocadoForm.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Valor Locação");

        valorLocacaoForm.setBackground(new java.awt.Color(240, 235, 240));
        valorLocacaoForm.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Marca");

        marcaForm.setBackground(new java.awt.Color(240, 235, 240));
        marcaForm.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ano");

        anoForm.setBackground(new java.awt.Color(240, 235, 240));
        anoForm.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(precoDiariaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtdeDiasLocadoForm))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(valorLocacaoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(marcaForm, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(anoForm))
                        .addGap(47, 47, 47)
                        .addComponent(devolverForm)
                        .addGap(60, 60, 60))
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
                            .addComponent(categriaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataLocacaoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataLocacaoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeClienteForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categriaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(precoDiariaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qtdeDiasLocadoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(valorLocacaoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(marcaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anoForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devolverForm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.getAccessibleContext().setAccessibleName("Categoria");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void devolverFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolverFormMouseClicked
        gravar();        // TODO add your handling code here:
    }//GEN-LAST:event_devolverFormMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoForm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField categriaForm;
    private javax.swing.JTextField dataLocacaoForm;
    private javax.swing.JButton devolverForm;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField marcaForm;
    private javax.swing.JTextField nomeClienteForm;
    private javax.swing.JTextField placaForm;
    private javax.swing.JTextField precoDiariaForm;
    private javax.swing.JTextField qtdeDiasLocadoForm;
    private br.ufpr.view.util.SimpleReflectTable table;
    private javax.swing.JTextField valorLocacaoForm;
    // End of variables declaration//GEN-END:variables
}
