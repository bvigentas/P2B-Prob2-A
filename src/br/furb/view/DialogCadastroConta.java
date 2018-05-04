package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.facade.ContaPersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;
import br.furb.model.ServicoAnaliseFluxo;
import br.furb.model.ServicoBaixaAutomatica;
import br.furb.model.ServicoNotificacao;
import br.furb.model.ServicoOperacao;
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
        this.edtSaldo.setText(null);
        this.chkServicoAnaliseFluxo.setSelected(Boolean.FALSE);
        this.chkServicoBaixaAutomatica.setSelected(Boolean.FALSE);
        this.chkServicoOperacaoRealizada.setSelected(Boolean.FALSE);
        
        this.tabView.setEnabledAt(1, Boolean.FALSE);
        this.tabView.setSelectedIndex(0);
        setVisible(Boolean.TRUE);
    }
    
    public void editarConta(ContaCorrente contaCorrente) {
        this.cliente = contaCorrente.getCliente();
        this.idContaEdicao = contaCorrente.getId();
        this.edtAgencia.setText(String.valueOf(contaCorrente.getAgencia()));
        this.edtNumero.setText(String.valueOf(contaCorrente.getNumero()));
        this.edtSaldo.setText(String.valueOf(contaCorrente.getSaldo()));
        
        this.chkServicoAnaliseFluxo.setSelected(Boolean.FALSE);
        this.chkServicoBaixaAutomatica.setSelected(Boolean.FALSE);
        this.chkServicoOperacaoRealizada.setSelected(Boolean.FALSE);
        
        if (contaCorrente.getServicosConfigurados() != null) {
            for (ServicoOperacao servico : contaCorrente.getServicosConfigurados()) {
                if (servico instanceof ServicoAnaliseFluxo) {
                    this.chkServicoAnaliseFluxo.setSelected(Boolean.TRUE);
                }
                
                if (servico instanceof ServicoBaixaAutomatica) {
                    this.chkServicoBaixaAutomatica.setSelected(Boolean.TRUE);
                }
                
                if (servico instanceof ServicoNotificacao) {
                    this.chkServicoOperacaoRealizada.setSelected(Boolean.TRUE);
                }
            }
        }
        
        this.tabView.setEnabledAt(1, Boolean.TRUE);
        this.tabView.setSelectedIndex(1);
        setVisible(Boolean.TRUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabView = new javax.swing.JTabbedPane();
        tabGeral = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        edtAgencia = new javax.swing.JTextField();
        lblAgencia = new javax.swing.JLabel();
        edtSaldo = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tabServicos = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        chkServicoOperacaoRealizada = new javax.swing.JCheckBox();
        chkServicoAnaliseFluxo = new javax.swing.JCheckBox();
        chkServicoBaixaAutomatica = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNumero.setText("Numero");

        lblAgencia.setText("Agencia");

        lblSaldo.setText("Saldo");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(edtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(edtAgencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAgencia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSaldo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))
                        .addComponent(edtNumero, javax.swing.GroupLayout.Alignment.LEADING)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        tabGeral.setViewportView(jPanel1);

        tabView.addTab("Geral", tabGeral);

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

        tabView.addTab("Servicos", tabServicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabView, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabView, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ContaCorrente contaCorrente = 
                new ContaCorrente(Integer.parseInt(this.edtNumero.getText()),
                                  Integer.parseInt(this.edtAgencia.getText()));
        
        this.cliente.addConta(contaCorrente);
        
        if (this.idContaEdicao != null) {
            contaCorrente.setId(this.idContaEdicao);
        }
        
        List<ServicoOperacao> servicos = new ArrayList<>();
        if (this.chkServicoAnaliseFluxo.isSelected()) {
            servicos.add(new ServicoAnaliseFluxo());
        }
        
        if (this.chkServicoBaixaAutomatica.isSelected()) {
            servicos.add(new ServicoBaixaAutomatica());
        }
        
        if (this.chkServicoOperacaoRealizada.isSelected()) {
            servicos.add(new ServicoNotificacao());
        }
        
        contaCorrente.setServicosConfigurados(servicos);
        
        this.contaFacade.save(contaCorrente);
        this.clienteFacade.save(cliente);
        setVisible(Boolean.FALSE);
        this.callback.execute(this.getName());
        
        NotificationCenter.getInstance().showInfoNotification("Sucesso !", 
                String.format("A conta %s foi salva com sucesso.", 
                        String.valueOf(contaCorrente.getNumero())));
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(Boolean.FALSE);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkServicoAnaliseFluxo;
    private javax.swing.JCheckBox chkServicoBaixaAutomatica;
    private javax.swing.JCheckBox chkServicoOperacaoRealizada;
    private javax.swing.JTextField edtAgencia;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtSaldo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JScrollPane tabGeral;
    private javax.swing.JScrollPane tabServicos;
    private javax.swing.JTabbedPane tabView;
    // End of variables declaration//GEN-END:variables
}
