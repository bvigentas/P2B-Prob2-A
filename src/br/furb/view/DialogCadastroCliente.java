package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class DialogCadastroCliente extends javax.swing.JDialog {
    
    private final ClientePersistenceFacade facade;
    private final IDialogCloseCallback callback;
    private Long idClienteEdicao;
    private Boolean inclusaoPessoaFisica;
    
    public DialogCadastroCliente(java.awt.Frame parent, boolean modal, IDialogCloseCallback callback) {
        super(parent, modal);
        initComponents();
        this.facade = new ClientePersistenceFacade();
        this.callback = callback;
        this.idClienteEdicao = null;
    }
    
    public void incluirClientePessoaFisica() {
        this.setTitle("Inclusao de Cliente (Pessoa Fisica)");
        this.edtCpf.setText(null);
        this.edtNome.setText(null);
        this.edtTelCelular.setText(null);
        this.edtTelFixo.setText(null);
        this.idClienteEdicao = null;
        
        configurarCamposVisiveisPessoaFisica();
        
        this.inclusaoPessoaFisica = Boolean.TRUE;
        this.btnContas.setVisible(Boolean.FALSE);
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
        this.btnContas.setVisible(Boolean.FALSE);
        setVisible(Boolean.TRUE);
    }
    
    public void editarCliente(Cliente cliente) {
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
            
            this.configurarCamposVisiveisPessoaFisica();
        }
        
        this.btnContas.setVisible(Boolean.TRUE);
        setVisible(Boolean.TRUE);
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
        painelPessoaJuridica = new javax.swing.JPanel();
        edtCnpj = new javax.swing.JTextField();
        edtJms = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        lblJMS = new javax.swing.JLabel();
        btnContas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout painelPessoaFisicaLayout = new javax.swing.GroupLayout(painelPessoaFisica);
        painelPessoaFisica.setLayout(painelPessoaFisicaLayout);
        painelPessoaFisicaLayout.setHorizontalGroup(
            painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPessoaFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCpf)
                    .addGroup(painelPessoaFisicaLayout.createSequentialGroup()
                        .addComponent(lblCpf)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnContas.setBackground(new java.awt.Color(255, 204, 0));
        btnContas.setForeground(new java.awt.Color(255, 255, 255));
        btnContas.setText("Contas");
        btnContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContasActionPerformed(evt);
            }
        });

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
                        .addGap(0, 293, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnContas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnCancelar)
                    .addComponent(btnContas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(Boolean.FALSE);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String cpf = this.edtCpf.getText();
        Cliente cliente;
        
        if (this.inclusaoPessoaFisica) {
            cliente = new ClientePessoaFisica(this.edtNome.getText(), 
                    this.edtTelCelular.getText(), this.edtTelFixo.getText(), cpf);
        } else {
            cliente = new ClientePessoaJuridica(this.edtNome.getText(), 
                    this.edtTelCelular.getText(), this.edtTelFixo.getText(),
                    this.edtCnpj.getText(), this.edtJms.getText());
        }
        
        if (this.idClienteEdicao != null) {
            cliente.setId(this.idClienteEdicao);
        }
        
        this.facade.save(cliente);
        setVisible(Boolean.FALSE);
        this.callback.execute(this.getName());
        
        NotificationCenter.getInstance().showInfoNotification("Sucesso !", 
                String.format("O cliente %s foi salvo com sucesso.", cliente.getNome()));
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContas;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCnpj;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtJms;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelCelular;
    private javax.swing.JTextField edtTelFixo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblJMS;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelFixo;
    private javax.swing.JPanel painelPessoaFisica;
    private javax.swing.JPanel painelPessoaJuridica;
    // End of variables declaration//GEN-END:variables
}
