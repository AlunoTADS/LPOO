package br.ufpr.view.locacao;

import br.ufpr.data.ClienteDao;
import br.ufpr.data.LocacaoDao;
import br.ufpr.data.VeiculoDao;
import br.ufpr.model.Automovel;
import br.ufpr.model.Categoria;
import br.ufpr.model.Cliente;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.Motocicleta;
import br.ufpr.model.Van;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author edenm
 */
public class JIFLocar extends javax.swing.JInternalFrame {

    private ClienteDao clienteDao = new ClienteDao();
    private VeiculoDao veiculoDao = new VeiculoDao();
    private LocacaoDao locacaoDao = new LocacaoDao();
    private Cliente cliente;
    private Veiculo veiculo;
    private Locacao locacao;

    /**
     * Creates new form JIFLocar
     */
    public JIFLocar() {
        initComponents();

        refreshFormCliente();
        refreshTableCliente();

        tableCliente.setClass(Cliente.class);
        tableVeiculo.setClass(Veiculo.class);

        tableCliente.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    cliente = (Cliente) tableCliente.getTableModel().getDataList().get(tableCliente.getTable().getSelectedRow());
                    refreshFormCliente();
                } catch (Exception ex) {
                }
            }
        });

        tableVeiculo.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    veiculo = (Veiculo) tableVeiculo.getTableModel().getDataList().get(tableVeiculo.getTable().getSelectedRow());
                    refreshFormCliente();
                } catch (Exception ex) {
                }
            }
        });

    }

    private void refreshFormCliente() {
        jtf_nome.setText(cliente != null && cliente.getNome() != null ? cliente.getNome() : "");
        jtf_sobrenome.setText(cliente != null && cliente.getSobrenome() != null ? cliente.getSobrenome() : "");
        jtf_cpf.setText(cliente != null && cliente.getCpf() != null ? cliente.getCpf() : "");
    }

    private void refreshFormVeiculo() {
         List<Veiculo> veiculos = new ArrayList<>();
        try {
            if (jcb_automovel.isSelected()) {
                tableVeiculo.setClass(Automovel.class);
                veiculos = veiculoDao.listar(new Automovel(null, (Marca) jcb_marca.getSelectedItem(), Estado.DISPONIVEL, null, null, null, null, null));
                //public Automovel(ModeloAutomovel modelo, Marca marca, Estado estado, Locacao locacao, Categoria categoria, Double valorCompra, String placa, Integer ano) {
            } else if (jcb_motocicleta.isSelected()) {
                tableVeiculo.setClass(Motocicleta.class);
                veiculos = veiculoDao.listar(new Motocicleta(null, (Marca) jcb_marca.getSelectedItem(), Estado.DISPONIVEL, null, null, null, null, null));
            } else if (jcb_van.isSelected()) {
                tableVeiculo.setClass(Van.class);
                veiculos = veiculoDao.listar(new Van(null, (Marca) jcb_marca.getSelectedItem(), Estado.DISPONIVEL, null, null, null, null, null));
            }
            tableVeiculo.getTableModel().setDataList(veiculos);
        } catch (Exception e) {
            e.getMessage();
        }       
    }
    
    private void refreshTableCliente() {
        try {
            tableCliente.getTableModel().setDataList(clienteDao.listar(null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void refreshTableVeiculo() {
        try {
            tableVeiculo.getTableModel().setDataList(veiculoDao.listar(null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void gravar() {

        try {
            cliente.setNome(jtf_nome.getText());
            cliente.setSobrenome(jtf_sobrenome.getText());
            cliente.setCpf(jtf_cpf.getText());

            if (cliente.getIdCliente() != null) {
                clienteDao.editar(cliente);
            } else {
                cliente.setIdCliente(clienteDao.getNextId());
                clienteDao.inserir(cliente);
            }
            cliente = new Cliente();
            refreshFormCliente();
            refreshTableCliente();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void incluir() {
        cliente = new Cliente();
        jtf_nome.requestFocus();
        refreshFormCliente();
    }

    private void buscar() {
        refreshTableCliente();
        refreshTableVeiculo();
    }

    private void cancelar() {
        cliente = null;
        veiculo = null;
        refreshTableCliente();
        refreshTableVeiculo();
        refreshFormCliente();
    }

    private void excluir() {
        try {
            clienteDao.excluir(cliente);
            cliente = new Cliente();
            refreshTableCliente();
            refreshFormCliente();
        } catch (Exception ex) {
            ex.printStackTrace();
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

        bgTipo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jcb_automovel = new javax.swing.JCheckBox();
        jcb_motocicleta = new javax.swing.JCheckBox();
        jcb_van = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jcb_marca = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcb_categoria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtf_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_sobrenome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtf_cpf = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jft_dataLocacao = new javax.swing.JFormattedTextField();
        tableVeiculo = new br.ufpr.view.util.SimpleReflectTable();
        tableCliente = new br.ufpr.view.util.SimpleReflectTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jm_menuprincipalclientes = new javax.swing.JMenu();
        jm_duplicarregistro = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jm_voltatelaprincipal = new javax.swing.JMenuItem();
        jm_sairdosistema = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jb_novo = new javax.swing.JMenu();
        jb_alterar = new javax.swing.JMenu();
        jb_gravar = new javax.swing.JMenu();
        jb_buscar = new javax.swing.JMenu();
        jb_cancelar = new javax.swing.JMenu();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Locar Veiculo");
        setMinimumSize(new java.awt.Dimension(907, 622));
        setName(""); // NOI18N
        setRequestFocusEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        bgTipo.add(jcb_automovel);
        jcb_automovel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcb_automovel.setText("Automóvel");

        bgTipo.add(jcb_motocicleta);
        jcb_motocicleta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcb_motocicleta.setText("Motocicleta");

        bgTipo.add(jcb_van);
        jcb_van.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcb_van.setText("Van");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tipo");

        jcb_marca.setModel(new DefaultComboBoxModel<>(Marca.values()));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Marca");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Categoria");

        jcb_categoria.setModel(new DefaultComboBoxModel<>(Categoria.values()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jcb_automovel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_motocicleta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_van))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_automovel)
                    .addComponent(jcb_motocicleta)
                    .addComponent(jcb_van)
                    .addComponent(jcb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jtf_nome.setBackground(new java.awt.Color(240, 235, 240));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sobrenome");

        jtf_sobrenome.setBackground(new java.awt.Color(240, 235, 240));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("CPF");

        jtf_cpf.setBackground(new java.awt.Color(240, 235, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(140, 140, 140))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data");

        jft_dataLocacao.setBackground(new java.awt.Color(240, 235, 240));
        jft_dataLocacao.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jft_dataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jft_dataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableVeiculo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tableCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/criar25.png"))); // NOI18N
        jb_novo.setText("NOVO (F2)");
        jb_novo.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuBar1.add(jb_novo);

        jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/edit-icon.png"))); // NOI18N
        jb_alterar.setText("ALTERAR (F3)");
        jb_alterar.setEnabled(false);
        jb_alterar.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuBar1.add(jb_alterar);

        jb_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/salvar.png"))); // NOI18N
        jb_gravar.setText("LOCAR (F4)");
        jb_gravar.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuBar1.add(jb_gravar);

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/atualizar.png"))); // NOI18N
        jb_buscar.setText("BUSCAR (F5)");
        jb_buscar.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuBar1.add(jb_buscar);

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/Cancelar25.png"))); // NOI18N
        jb_cancelar.setText("CANCELAR (F6)");
        jb_cancelar.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuBar1.add(jb_cancelar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tableVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tableCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Locação");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jb_alterar;
    private javax.swing.JMenu jb_buscar;
    private javax.swing.JMenu jb_cancelar;
    private javax.swing.JMenu jb_gravar;
    private javax.swing.JMenu jb_novo;
    private javax.swing.JCheckBox jcb_automovel;
    private javax.swing.JComboBox<Categoria> jcb_categoria;
    private javax.swing.JComboBox<Marca> jcb_marca;
    private javax.swing.JCheckBox jcb_motocicleta;
    private javax.swing.JCheckBox jcb_van;
    private javax.swing.JFormattedTextField jft_dataLocacao;
    private javax.swing.JMenuItem jm_duplicarregistro;
    private javax.swing.JMenu jm_menuprincipalclientes;
    private javax.swing.JMenuItem jm_sairdosistema;
    private javax.swing.JMenuItem jm_voltatelaprincipal;
    private javax.swing.JTextField jtf_cpf;
    private javax.swing.JTextField jtf_nome;
    private javax.swing.JTextField jtf_sobrenome;
    private br.ufpr.view.util.SimpleReflectTable tableCliente;
    private br.ufpr.view.util.SimpleReflectTable tableVeiculo;
    // End of variables declaration//GEN-END:variables
}
