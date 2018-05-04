package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.facade.ContaPersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;
import br.furb.model.ServicoAnaliseFluxoObserver;
import br.furb.model.ServicoBaixaAutomaticaObserver;
import br.furb.model.ServicoNotificacaoObserver;
import br.furb.model.ServicoObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class DialogCadastroConta extends javax.swing.JDialog {

    private final ContaPersistenceFacade contaFacade;
    private final ClientePersistenceFacade clienteFacade;
    private final IDialogCloseCallback callback;
    private Long idContaEdicao;
    private Cliente cliente;
    
    public DialogCadastroConta(java.awt.Frame parent, boolean modal, IDialogCloseCallback callback) {
        super(parent, modal);
        this.callback = callback;
        this.contaFacade = new ContaPersistenceFacade();
        this.clienteFacade = new ClientePersistenceFacade();
        initComponents();
    }
    
    public void incluirConta(Cliente cliente) {
        this.cliente = cliente;
        this.idContaEdicao = null;
        this.edtAgencia.setText(null);
        this.edtNumero.setText(null);
        this.chkServicoAnaliseFluxo.setSelected(Boolean.FALSE);
        this.chkServicoBaixaAutomatica.setSelected(Boolean.FALSE);
        this.chkServicoOperacaoRealizada.setSelected(Boolean.FALSE);
        
        this.tabOperacoes.setEnabledAt(1, Boolean.FALSE);
        this.tabOperacoes.setEnabledAt(2, Boolean.FALSE);
        this.tabOperacoes.setSelectedIndex(0);
        setVisible(Boolean.TRUE);
    }
    
    public void editarConta(ContaCorrente contaCorrente) {
        this.cliente = contaCorrente.getCliente();
        this.idContaEdicao = contaCorrente.getId();
        this.edtAgencia.setText(String.valueOf(contaCorrente.getAgencia()));
        this.edtNumero.setText(String.valueOf(contaCorrente.getNumero()));
        
        this.chkServicoAnaliseFluxo.setSelected(Boolean.FALSE);
        this.chkServicoBaixaAutomatica.setSelected(Boolean.FALSE);
        this.chkServicoOperacaoRealizada.setSelected(Boolean.FALSE);
        
        if (contaCorrente.getServicosConfigurados() != null) {
            for (ServicoObserver servico : contaCorrente.getServicosConfigurados()) {
                if (servico instanceof ServicoAnaliseFluxoObserver) {
                    this.chkServicoAnaliseFluxo.setSelected(Boolean.TRUE);
                }
                
                if (servico instanceof ServicoBaixaAutomaticaObserver) {
                    this.chkServicoBaixaAutomatica.setSelected(Boolean.TRUE);
                }
                
                if (servico instanceof ServicoNotificacaoObserver) {
                    this.chkServicoOperacaoRealizada.setSelected(Boolean.TRUE);
                }
            }
        }
        
        this.tabOperacoes.setEnabledAt(1, Boolean.TRUE);
        this.tabOperacoes.setEnabledAt(2, Boolean.TRUE);
        this.tabOperacoes.setSelectedIndex(1);
        setVisible(Boolean.TRUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        tabOperacoes = new javax.swing.JTabbedPane();
        tabGeral = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        edtAgencia = new javax.swing.JTextField();
        lblAgencia = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tabServicos = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        chkServicoOperacaoRealizada = new javax.swing.JCheckBox();
        chkServicoAnaliseFluxo = new javax.swing.JCheckBox();
        chkServicoBaixaAutomatica = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnSacar = new javax.swing.JButton();
        btnDepositar = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        edtNumConta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtValor = new javax.swing.JTextField();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNumero.setText("Numero");

        lblAgencia.setText("Agencia");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero)
                    .addComponent(lblAgencia)
                    .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAgencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(337, Short.MAX_VALUE))
        );

        tabGeral.setViewportView(jPanel1);

        tabOperacoes.addTab("Geral", tabGeral);

        chkServicoOperacaoRealizada.setText("Operação Realizada");

        chkServicoAnaliseFluxo.setText("Análise do Fluxo de Caixa");

        chkServicoBaixaAutomatica.setText("Baixa Automática");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkServicoBaixaAutomatica)
                    .addComponent(chkServicoAnaliseFluxo)
                    .addComponent(chkServicoOperacaoRealizada))
                .addContainerGap(520, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(chkServicoOperacaoRealizada)
                .addGap(18, 18, 18)
                .addComponent(chkServicoAnaliseFluxo)
                .addGap(18, 18, 18)
                .addComponent(chkServicoBaixaAutomatica)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        tabServicos.setViewportView(jPanel2);

        tabOperacoes.addTab("Servicos", tabServicos);

        btnSacar.setBackground(new java.awt.Color(255, 51, 51));
        btnSacar.setText("Sacar");
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });

        btnDepositar.setBackground(new java.awt.Color(51, 255, 51));
        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnTransferir.setBackground(new java.awt.Color(0, 51, 255));
        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        jLabel1.setText("Número da Conta:");

        jLabel2.setText("Valor:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtNumConta)
                    .addComponent(edtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTransferir)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacar)
                    .addComponent(jLabel2)
                    .addComponent(edtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDepositar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferir)
                    .addComponent(jLabel1)
                    .addComponent(edtNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(387, Short.MAX_VALUE))
        );

        tabOperacoes.addTab("Operações", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ContaCorrente contaCorrente = 
                new ContaCorrente(Integer.parseInt(this.edtNumero.getText()),
                                  Integer.parseInt(this.edtAgencia.getText()));
        
        if (this.idContaEdicao != null) {
            contaCorrente.setId(this.idContaEdicao);
        } else {
            this.cliente.addConta(contaCorrente);
        }
        
        List<ServicoObserver> servicos = new ArrayList<>();
        if (this.chkServicoAnaliseFluxo.isSelected()) {
            servicos.add(new ServicoAnaliseFluxoObserver());
        }
        
        if (this.chkServicoBaixaAutomatica.isSelected()) {
            servicos.add(new ServicoBaixaAutomaticaObserver());
        }
        
        if (this.chkServicoOperacaoRealizada.isSelected()) {
            servicos.add(new ServicoNotificacaoObserver());
        }
        
        contaCorrente.setServicosConfigurados(servicos);
        
        this.contaFacade.save(contaCorrente);
        if (this.idContaEdicao != null) {
            this.clienteFacade.save(cliente);
        }
        setVisible(Boolean.FALSE);
        this.callback.execute(this.getName());
        
        NotificationCenter.getInstance().showInfoNotification("Sucesso !", 
                String.format("A conta %s foi salva com sucesso.", 
                        String.valueOf(contaCorrente.getNumero())));
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(Boolean.FALSE);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        executarServicos();
    }//GEN-LAST:event_btnSacarActionPerformed

    private void executarServicos(){
        ContaCorrente contaCorrente = this.contaFacade.findById(this.idContaEdicao);
        contaCorrente.notifyObservers();
    }
    
    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        executarServicos();
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        executarServicos();
    }//GEN-LAST:event_btnTransferirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JCheckBox chkServicoAnaliseFluxo;
    private javax.swing.JCheckBox chkServicoBaixaAutomatica;
    private javax.swing.JCheckBox chkServicoOperacaoRealizada;
    private javax.swing.JTextField edtAgencia;
    private javax.swing.JTextField edtNumConta;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JScrollPane tabGeral;
    private javax.swing.JTabbedPane tabOperacoes;
    private javax.swing.JScrollPane tabServicos;
    // End of variables declaration//GEN-END:variables
}
