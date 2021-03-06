package br.ufpr.view.cliente;

import br.ufpr.data.ClienteDao;
import br.ufpr.model.Cliente;
import br.ufpr.model.UnidadeFederativa;
import br.ufpr.view.util.ComponentUtil;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.postgresql.util.PSQLException;

/**
 *
 * @author edenm
 */
public class JIFClientes extends javax.swing.JInternalFrame {

    private ClienteDao clienteDao = new ClienteDao();
    private Cliente cliente = new Cliente();
    private List<Component> camposEditaveis;

    /**
     * Creates new form jifClientes
     */
    public JIFClientes() {
        initComponents();

        camposEditaveis = Arrays.asList(jtf_nome, jtf_sobrenome, jtf_endereco, jtf_rg, jcb_rgSiglaUf, jtf_cpf);
        disableForm();
        refreshForm();
        refreshTable();

        table.setClass(Cliente.class);

        table.getTable()
                .getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        try {
                            cliente = (Cliente) table
                                    .getTableModel()
                                    .getDataList()
                                    .get(table.getTable().getSelectedRow());
                            refreshForm();
                        } catch (Exception ex) {
                        }
                    }
                });
    }

    private void enableForm() {
        for (Component c : camposEditaveis) {
            ComponentUtil.enable(c);
        }
    }

    private void disableForm() {
        for (Component c : camposEditaveis) {
            ComponentUtil.disable(c);
        }
    }

    private void refreshForm() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        jtf_idCliente.setText(cliente.getIdCliente() == null ? "" : cliente.getIdCliente().toString());
        jtf_nome.setText(cliente.getNome() == null ? "" : cliente.getNome());
        jtf_sobrenome.setText(cliente.getSobrenome() == null ? "" : cliente.getSobrenome());
        jtf_rg.setText(cliente.getRg() == null ? "" : cliente.getRg());
        jcb_rgSiglaUf.setSelectedItem(cliente.getRgUF());
        jtf_cpf.setText(cliente.getCpf() == null ? "" : cliente.getCpf());
        jtf_endereco.setText(cliente.getEndereco() == null ? "" : cliente.getEndereco());
    }

    private void refreshTable() {
        try {
            table.getTableModel()
                    .setDataList(clienteDao.listar(null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void alterar() {
        enableForm();
    }

    private void gravar() {
        try {
            cliente.setNome(jtf_nome.getText());
            cliente.setSobrenome(jtf_sobrenome.getText());
            cliente.setEndereco(jtf_endereco.getText());
            cliente.setRg(jtf_rg.getText());
            cliente.setRgUF((UnidadeFederativa) jcb_rgSiglaUf.getSelectedItem());
            cliente.setCpf(jtf_cpf.getText());

            if (cliente.getIdCliente() != null) {
                clienteDao.editar(cliente);
            } else {
                cliente.setIdCliente(clienteDao.getNextId());
                clienteDao.inserir(cliente);
            }
            JOptionPane.showMessageDialog(null, "Gravado com sucesso");
            cliente = new Cliente();
            disableForm();
            refreshForm();
            refreshTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void incluir() {
        cliente = new Cliente();
        jtf_nome.requestFocus();
        enableForm();
        refreshForm();
    }

    private void buscar() {
        refreshTable();
    }

    private void cancelar() {
        cliente = new Cliente();
        refreshTable();
        refreshForm();
        disableForm();
    }

    private void excluir() {
        try {
            clienteDao.excluir(cliente);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            cliente = new Cliente();
            refreshTable();
            refreshForm();
            disableForm();
        } catch (PSQLException ex) {
            JOptionPane.showMessageDialog(null, "O cliente selecionado possui veículo(s) locado(s) e não pode ser excluído.");
        } catch (Exception ex) {
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

        jtf_idCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtf_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_sobrenome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcb_rgSiglaUf = new javax.swing.JComboBox<>();
        jtf_endereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_rg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_cpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        table = new br.ufpr.view.util.SimpleReflectTable();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jm_menuprincipalclientes = new javax.swing.JMenu();
        jm_duplicarregistro = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jm_voltatelaprincipal = new javax.swing.JMenuItem();
        jm_sairdosistema = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jb_incluir = new javax.swing.JMenu();
        jm_espaco3 = new javax.swing.JMenu();
        jb_alterar = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jb_gravar = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jb_buscar = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jb_cancelar = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jb_excluir = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciamento de Clientes");
        setAutoscrolls(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_idCliente.setEditable(false);
        jtf_idCliente.setBackground(new java.awt.Color(204, 204, 204));
        jtf_idCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_idCliente.setPreferredSize(new java.awt.Dimension(59, 35));
        getContentPane().add(jtf_idCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jtf_nome.setBackground(new java.awt.Color(240, 235, 240));
        jtf_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 300, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jtf_sobrenome.setBackground(new java.awt.Color(240, 235, 240));
        jtf_sobrenome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_sobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_sobrenomeActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 448, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Sobrenome");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jcb_rgSiglaUf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcb_rgSiglaUf.setModel(new DefaultComboBoxModel(UnidadeFederativa.values()));
        getContentPane().add(jcb_rgSiglaUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 40));

        jtf_endereco.setBackground(new java.awt.Color(240, 235, 240));
        jtf_endereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_endereco.setPreferredSize(new java.awt.Dimension(59, 35));
        jtf_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 842, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Endereço");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jtf_rg.setBackground(new java.awt.Color(240, 235, 240));
        jtf_rg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_rgActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("RG");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jtf_cpf.setBackground(new java.awt.Color(240, 235, 240));
        jtf_cpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_cpfActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 200, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("CPF");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        table.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(table, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 920, 190));
        getContentPane().add(filler3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("UF");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

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

        jb_incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/criar25.png"))); // NOI18N
        jb_incluir.setText("NOVO (F2)");
        jb_incluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_incluirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jb_incluir);

        jm_espaco3.setText("     ");
        jm_espaco3.setEnabled(false);
        jMenuBar1.add(jm_espaco3);

        jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/edit-icon.png"))); // NOI18N
        jb_alterar.setText("ALTERAR (F3)");
        jb_alterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_alterarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jb_alterar);

        jMenu7.setText("     ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        jb_gravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/salvar.png"))); // NOI18N
        jb_gravar.setText("GRAVAR (F4)");
        jb_gravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_gravarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jb_gravar);

        jMenu9.setText("     ");
        jMenu9.setEnabled(false);
        jMenuBar1.add(jMenu9);

        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/atualizar.png"))); // NOI18N
        jb_buscar.setText("BUSCAR (F5)");
        jb_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_buscarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jb_buscar);

        jMenu11.setText("     ");
        jMenu11.setEnabled(false);
        jMenuBar1.add(jMenu11);

        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/Cancelar25.png"))); // NOI18N
        jb_cancelar.setText("CANCELAR (F6)");
        jb_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jb_cancelar);

        jMenu13.setText("                                       ");
        jMenu13.setEnabled(false);
        jMenuBar1.add(jMenu13);

        jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufpr/view/imagens/excluir25.png"))); // NOI18N
        jb_excluir.setText("EXCLUIR (F12)");
        jb_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_excluirMouseClicked(evt);
            }
        });
        jb_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_excluirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jb_excluir);

        setJMenuBar(jMenuBar1);
    }// </editor-fold>//GEN-END:initComponents

    private void jm_duplicarregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_duplicarregistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_duplicarregistroActionPerformed

    private void jm_voltatelaprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_voltatelaprincipalActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_voltatelaprincipalActionPerformed

    private void jtf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nomeActionPerformed

    private void jtf_sobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_sobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_sobrenomeActionPerformed

    private void jm_sairdosistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_sairdosistemaActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_sairdosistemaActionPerformed

    private void jtf_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cpfActionPerformed

    private void jm_menuprincipalclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_menuprincipalclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_menuprincipalclientesActionPerformed

    private void jtf_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_enderecoActionPerformed

    private void jtf_rgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_rgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_rgActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluir();
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jb_incluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_incluirMouseClicked
        incluir(); // TODO add your handling code here:
    }//GEN-LAST:event_jb_incluirMouseClicked

    private void jb_alterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_alterarMouseClicked
        alterar();// TODO add your handling code here:
    }//GEN-LAST:event_jb_alterarMouseClicked

    private void jb_gravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_gravarMouseClicked
        gravar();        // TODO add your handling code here:
    }//GEN-LAST:event_jb_gravarMouseClicked

    private void jb_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_buscarMouseClicked
        buscar();        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscarMouseClicked

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        cancelar();        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jb_excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_excluirMouseClicked
        excluir();        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.Box.Filler filler3;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu11;
    javax.swing.JMenu jMenu13;
    javax.swing.JMenu jMenu3;
    javax.swing.JMenu jMenu7;
    javax.swing.JMenu jMenu9;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JPopupMenu.Separator jSeparator1;
    javax.swing.JMenu jb_alterar;
    javax.swing.JMenu jb_buscar;
    javax.swing.JMenu jb_cancelar;
    javax.swing.JMenu jb_excluir;
    javax.swing.JMenu jb_gravar;
    javax.swing.JMenu jb_incluir;
    javax.swing.JComboBox<UnidadeFederativa> jcb_rgSiglaUf;
    javax.swing.JMenuItem jm_duplicarregistro;
    javax.swing.JMenu jm_espaco3;
    javax.swing.JMenu jm_menuprincipalclientes;
    javax.swing.JMenuItem jm_sairdosistema;
    javax.swing.JMenuItem jm_voltatelaprincipal;
    javax.swing.JTextField jtf_cpf;
    javax.swing.JTextField jtf_endereco;
    javax.swing.JTextField jtf_idCliente;
    javax.swing.JTextField jtf_nome;
    javax.swing.JTextField jtf_rg;
    javax.swing.JTextField jtf_sobrenome;
    br.ufpr.view.util.SimpleReflectTable table;
    // End of variables declaration//GEN-END:variables
}
