package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.facade.ContaPersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import br.furb.persistence.filter.ContaCorrenteFilter;
import br.furb.view.tablemodel.ContaTableModel;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class DialogCadastroCliente extends AbstractDialog implements IDialogCloseCallback {
    
    private final ClientePersistenceFacade clienteFacade;
    private final ContaPersistenceFacade contaFacade;
    private final IDialogCloseCallback callback;
    private Long idClienteEdicao;
    private Boolean inclusaoPessoaFisica;
    private ContaCorrenteFilter contaFilter;
    private final DialogCadastroConta dialogManutencaoConta;
    
    public DialogCadastroCliente(java.awt.Frame parent, boolean modal, IDialogCloseCallback callback) {
        super(parent);
        this.dialogManutencaoConta = new DialogCadastroConta(parent, true, this);
        this.clienteFacade = new ClientePersistenceFacade();
        this.contaFacade = new ContaPersistenceFacade();
        this.callback = callback;
        this.idClienteEdicao = null;
        initComponents();
    }
    
    public void incluirClientePessoaFisica() {
        this.setTitle("Inclusao de Cliente (Pessoa Fisica)");
        this.edtCpf.setText(null);
        this.edtNome.setText(null);
        this.edtTelCelular.setText(null);
        this.edtTelFixo.setText(null);
        this.idClienteEdicao = null;
        this.chkSms.setSelected(Boolean.FALSE);
        this.chkWhats.setSelected(Boolean.FALSE);
        
        configurarCamposVisiveisPessoaFisica();
        
        this.inclusaoPessoaFisica = Boolean.TRUE;
        this.tabView.setEnabledAt(1, Boolean.FALSE);
        setVisible(Boolean.TRUE);
    }
    
    public void incluirClientePessoaJuridica() {
        this.setTitle("Inclusao de Cliente (Pessoa Juridica)");
        this.edtCnpj.setText(null);
        this.edtJms.setText(null);
        this.edtNome.setText(null);
        this.edtTelCelular.setText(null);
        this.edtTelFixo.setText(null);
        this.idClienteEdicao = null;
        
        configurarCamposVisiveisPessoaJuridica();
        
        this.inclusaoPessoaFisica = Boolean.FALSE;
        this.tabView.setEnabledAt(1, Boolean.FALSE);
        this.tabView.setSelectedIndex(0);
        setVisible(Boolean.TRUE);
    }
    
    public void editarCliente(Cliente cliente) {
        this.contaFilter = new ContaCorrenteFilter(cliente);
        this.setTitle(cliente.getNome());
        this.idClienteEdicao = cliente.getId();
        
        this.edtNome.setText(cliente.getNome());
        this.edtTelCelular.setText(cliente.getTelCelular());
        this.edtTelFixo.setText(cliente.getTelFixo());
        
        if (cliente instanceof ClientePessoaJuridica) {
            this.inclusaoPessoaFisica = Boolean.FALSE;
            
            this.edtCnpj.setText(((ClientePessoaJuridica) cliente).getCnpj());
            this.edtJms.setText(((ClientePessoaJuridica) cliente).getServidorJMS());
            
            this.configurarCamposVisiveisPessoaJuridica();
        } else {
            this.inclusaoPessoaFisica = Boolean.TRUE;
            
            this.edtCpf.setText(((ClientePessoaFisica) cliente).getCpf());
            this.edtCnpj.setText(null);
            this.edtJms.setText(null);
            
            this.chkSms.setSelected(((ClientePessoaFisica) cliente).getReceberNotificacoesPorSms());
            this.chkWhats.setSelected(((ClientePessoaFisica) cliente).getReceberNotificacoesPorWhatsapp());
            
            this.configurarCamposVisiveisPessoaFisica();
        }
        
        this.tabView.setEnabledAt(1, Boolean.TRUE);
        this.tabView.setSelectedIndex(0);
        
        atualizarTabelaContas();
        setVisible(Boolean.TRUE);
    }
    
    @Override
    public void execute(String idDialog) {
        atualizarTabelaContas();
    }
    
    public void atualizarTabelaContas() {
        ContaTableModel tableModel = (ContaTableModel) this.tabelaContas.getModel();
        this.contaFilter.setFilter(this.edtBuscaConta.getText());
        tableModel.updateModel(this.contaFacade.search(this.contaFilter));
        tableModel.fireTableDataChanged();
    }
    
    private void configurarCamposVisiveisPessoaFisica() {
        this.painelPessoaFisica.setVisible(Boolean.TRUE);
        this.painelPessoaJuridica.setVisible(Boolean.FALSE);
    }
    
    private void configurarCamposVisiveisPessoaJuridica() {
        this.painelPessoaJuridica.setVisible(Boolean.TRUE);
        this.painelPessoaFisica.setVisible(Boolean.FALSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabView = new javax.swing.JTabbedPane();
        tabGeral = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtTelCelular = new javax.swing.JTextField();
        lblTelCelular = new javax.swing.JLabel();
        edtTelFixo = new javax.swing.JTextField();
        lblTelFixo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        painelPessoaFisica = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        chkSms = new javax.swing.JCheckBox();
        chkWhats = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        painelPessoaJuridica = new javax.swing.JPanel();
        edtCnpj = new javax.swing.JTextField();
        edtJms = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        lblJMS = new javax.swing.JLabel();
        tabContas = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        edtBuscaConta = new javax.swing.JTextField();
        btnBuscarConta = new javax.swing.JButton();
        btnNovaConta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabView.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabViewStateChanged(evt);
            }
        });

        lblNome.setText("Nome");

        lblTelCelular.setText("Telefone Celular");

        lblTelFixo.setText("Telefone Fixo");

        btnSalvar.setBackground(new java.awt.Color(0, 149, 217));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCpf.setText("CPF");

        chkSms.setText("SMS");

        chkWhats.setText("WhatsApp");

        jLabel1.setText("Enviar Notificações por");

        javax.swing.GroupLayout painelPessoaFisicaLayout = new javax.swing.GroupLayout(painelPessoaFisica);
        painelPessoaFisica.setLayout(painelPessoaFisicaLayout);
        painelPessoaFisicaLayout.setHorizontalGroup(
            painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCpf)
                    .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                        .addGroup(painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                                .addComponent(chkSms)
                                .addGap(18, 18, 18)
                                .addComponent(chkWhats))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelPessoaFisicaLayout.setVerticalGroup(
            painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSms)
                    .addComponent(chkWhats))
                .addContainerGap())
        );

        lblCnpj.setText("CNPJ");

        lblJMS.setText("JMS");

        javax.swing.GroupLayout painelPessoaJuridicaLayout = new javax.swing.GroupLayout(painelPessoaJuridica);
        painelPessoaJuridica.setLayout(painelPessoaJuridicaLayout);
        painelPessoaJuridicaLayout.setHorizontalGroup(
            painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoaJuridicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCnpj)
                    .addComponent(edtJms)
                    .addGroup(painelPessoaJuridicaLayout.createSequentialGroup()
                        .addGroup(painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCnpj)
                            .addComponent(lblJMS))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelPessoaJuridicaLayout.setVerticalGroup(
            painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoaJuridicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCnpj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblJMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtJms, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPessoaFisica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtNome)
                    .addComponent(edtTelCelular)
                    .addComponent(edtTelFixo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblTelCelular)
                            .addComponent(lblTelFixo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 375, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(painelPessoaJuridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTelFixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTelFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tabGeral.setViewportView(jPanel1);

        tabView.addTab("Geral", tabGeral);

        jPanel3.setBackground(new java.awt.Color(0, 149, 217));

        jPanel4.setBackground(new java.awt.Color(0, 95, 164));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Busca");

        btnBuscarConta.setBackground(new java.awt.Color(0, 95, 164));
        btnBuscarConta.setForeground(new java.awt.Color(0, 95, 164));
        btnBuscarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/loupe.png"))); // NOI18N
        btnBuscarConta.setBorder(null);
        btnBuscarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtBuscaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarConta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtBuscaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnBuscarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnNovaConta.setBackground(new java.awt.Color(0, 149, 217));
        btnNovaConta.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/add (1).png"))); // NOI18N
        btnNovaConta.setBorder(null);
        btnNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovaConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaContas.setModel(new ContaTableModel(
            contaFacade.search(null)));
    tabelaContas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaContasMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tabelaContas);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    tabContas.setViewportView(jPanel2);

    tabView.addTab("Contas", tabContas);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(tabView)
            .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabView)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(Boolean.FALSE);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            String cpf = this.edtCpf.getText();
            Cliente cliente;

            if (this.inclusaoPessoaFisica) {
                cliente = new ClientePessoaFisica(this.edtNome.getText(), 
                        this.edtTelCelular.getText(), this.edtTelFixo.getText(), cpf);
                ((ClientePessoaFisica)cliente).setReceberNotificacoesPorSms(this.chkSms.isSelected());
                ((ClientePessoaFisica)cliente).setReceberNotificacoesPorWhatsapp(this.chkWhats.isSelected());
            } else {
                cliente = new ClientePessoaJuridica(this.edtNome.getText(), 
                        this.edtTelCelular.getText(), this.edtTelFixo.getText(),
                        this.edtCnpj.getText(), this.edtJms.getText());
            }

            if (this.idClienteEdicao != null) {
                cliente.setId(this.idClienteEdicao);
            }

            this.clienteFacade.save(cliente);
            setVisible(Boolean.FALSE);
            this.callback.execute(this.getName());

            NotificationCenter.getInstance().showInfoNotification("Sucesso !", 
                    String.format("O cliente %s foi salvo com sucesso.", cliente.getNome()));
        } catch (Exception e) {
            NotificationCenter.getInstance().showException(e);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarContaActionPerformed
        this.atualizarTabelaContas();
    }//GEN-LAST:event_btnBuscarContaActionPerformed

    private void btnNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaActionPerformed
        this.dialogManutencaoConta.incluirConta(this.clienteFacade.findById(idClienteEdicao));
    }//GEN-LAST:event_btnNovaContaActionPerformed

    private void tabelaContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContasMouseClicked
        int linha = this.tabelaContas.rowAtPoint(evt.getPoint());
        this.dialogManutencaoConta.editarConta((((ContaTableModel) this.tabelaContas.getModel()).getObjectAt(linha)));
    }//GEN-LAST:event_tabelaContasMouseClicked

    private void tabViewStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabViewStateChanged

    }//GEN-LAST:event_tabViewStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarConta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovaConta;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkSms;
    private javax.swing.JCheckBox chkWhats;
    private javax.swing.JTextField edtBuscaConta;
    private javax.swing.JTextField edtCnpj;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtJms;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelCelular;
    private javax.swing.JTextField edtTelFixo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblJMS;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelFixo;
    private javax.swing.JPanel painelPessoaFisica;
    private javax.swing.JPanel painelPessoaJuridica;
    private javax.swing.JScrollPane tabContas;
    private javax.swing.JScrollPane tabGeral;
    private javax.swing.JTabbedPane tabView;
    private javax.swing.JTable tabelaContas;
    // End of variables declaration//GEN-END:variables

}
