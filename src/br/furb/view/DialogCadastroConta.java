package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.facade.ContaPersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(599, 523));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(edtAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(edtSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblAgencia)
                            .addComponent(lblSaldo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addContainerGap(250, Short.MAX_VALUE))
        );

        tabGeral.setViewportView(jPanel1);

        tabView.addTab("Geral", tabGeral);
        tabView.addTab("Servicos", tabServicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabView)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabView)
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
    private javax.swing.JTextField edtAgencia;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtSaldo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JScrollPane tabGeral;
    private javax.swing.JScrollPane tabServicos;
    private javax.swing.JTabbedPane tabView;
    // End of variables declaration//GEN-END:variables
}
