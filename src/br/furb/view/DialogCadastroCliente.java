package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import br.furb.util.StringUtil;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class DialogCadastroCliente extends javax.swing.JDialog {
    
    private ClientePersistenceFacade facade;
    private IDialogCloseCallback callback;
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
        this.edtTitle.setText("Inclusao de Cliente (Pessoa Fisica)");
        this.edtCpf.setText(null);
        this.edtNome.setText(null);
        this.edtTelCelular.setText(null);
        this.edtTelFixo.setText(null);
        this.idClienteEdicao = null;
        
        configurarCamposVisiveisPessoaFisica();
        
        this.inclusaoPessoaFisica = Boolean.TRUE;
        setVisible(Boolean.TRUE);
    }
    
    public void incluirClientePessoaJuridica() {
        this.edtTitle.setText("Inclusao de Cliente (Pessoa Juridica)");
        this.edtCnpj.setText(null);
        this.edtJms.setText(null);
        this.edtNome.setText(null);
        this.edtTelCelular.setText(null);
        this.edtTelFixo.setText(null);
        this.idClienteEdicao = null;
        
        configurarCamposVisiveisPessoaJuridica();
        
        this.inclusaoPessoaFisica = Boolean.FALSE;
        setVisible(Boolean.TRUE);
    }
    
    public void editarCliente(Cliente cliente) {
        this.edtTitle.setText(cliente.getNome());
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
        
        setVisible(Boolean.TRUE);
    }
    
    private void configurarCamposVisiveisPessoaFisica() {
        this.lblCnpj.setVisible(Boolean.FALSE);
        this.edtCnpj.setVisible(Boolean.FALSE);
        this.lblJMS.setVisible(Boolean.FALSE);
        this.edtJms.setVisible(Boolean.FALSE);
    
        this.lblCpf.setVisible(Boolean.TRUE);
        this.edtCpf.setVisible(Boolean.TRUE);
    }
    
    private void configurarCamposVisiveisPessoaJuridica() {
        this.lblCpf.setVisible(Boolean.FALSE);
        this.edtCpf.setVisible(Boolean.FALSE);
        
        this.lblCnpj.setVisible(Boolean.TRUE);
        this.edtCnpj.setVisible(Boolean.TRUE);
        this.lblJMS.setVisible(Boolean.TRUE);
        this.edtJms.setVisible(Boolean.TRUE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        edtTitle = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtTelCelular = new javax.swing.JTextField();
        lblTelCelular = new javax.swing.JLabel();
        edtTelFixo = new javax.swing.JTextField();
        lblTelFixo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        edtCnpj = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        edtJms = new javax.swing.JTextField();
        lblJMS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 149, 217));

        edtTitle.setForeground(new java.awt.Color(255, 255, 255));
        edtTitle.setText("Inclusao de Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edtTitle)
                .addContainerGap())
        );

        lblNome.setText("Nome");

        lblTelCelular.setText("Telefone Celular");

        lblTelFixo.setText("Telefone Fixo");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCpf.setText("CPF");

        lblCnpj.setText("CNPJ");

        lblJMS.setText("JMS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtNome)
                    .addComponent(edtTelCelular)
                    .addComponent(edtTelFixo)
                    .addComponent(edtCpf)
                    .addComponent(edtCnpj)
                    .addComponent(edtJms)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblTelCelular)
                            .addComponent(lblTelFixo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(lblCpf)
                            .addComponent(lblCnpj)
                            .addComponent(lblJMS))
                        .addGap(0, 293, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCnpj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblJMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtJms, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCnpj;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtJms;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelCelular;
    private javax.swing.JTextField edtTelFixo;
    private javax.swing.JLabel edtTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblJMS;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelCelular;
    private javax.swing.JLabel lblTelFixo;
    // End of variables declaration//GEN-END:variables
}
