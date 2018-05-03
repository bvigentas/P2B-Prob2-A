package br.furb.view;

import br.furb.facade.ClientePersistenceFacade;
import br.furb.persistence.filter.ClienteFilter;
import br.furb.view.tablemodel.ClienteTableModel;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class PesquisaClientes extends javax.swing.JFrame implements IDialogCloseCallback {

    private final DialogCadastroCliente dialogManutencao;
    private final ClientePersistenceFacade facade;
    private final ClienteFilter filter;
    
    public PesquisaClientes() {
        super("Clientes");
        this.filter = new ClienteFilter();
        this.facade = new ClientePersistenceFacade();
        initComponents();
        this.dialogManutencao = new DialogCadastroCliente(this, Boolean.TRUE, this); 
        atualizarTabelaClientes();
    }
    
    private void atualizarTabelaClientes() {
        ClienteTableModel tableModel = (ClienteTableModel) this.tabelaClientes.getModel();
        this.filter.setFilter(this.edtBusca.getText());
        tableModel.updateModel(this.facade.search(this.filter));
        tableModel.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        logoFurb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovaPessoaFisica = new javax.swing.JButton();
        btnNovoPessoaJuridica = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTop.setBackground(new java.awt.Color(0, 149, 217));

        logoFurb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/logo-furb.gif"))); // NOI18N
        logoFurb.setText("jLabel1");

        jPanel1.setBackground(new java.awt.Color(0, 95, 164));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busca");

        btnBuscar.setBackground(new java.awt.Color(0, 95, 164));
        btnBuscar.setForeground(new java.awt.Color(0, 95, 164));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/loupe.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnNovaPessoaFisica.setBackground(new java.awt.Color(0, 149, 217));
        btnNovaPessoaFisica.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaPessoaFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/add (1).png"))); // NOI18N
        btnNovaPessoaFisica.setText("Fisica");
        btnNovaPessoaFisica.setBorder(null);
        btnNovaPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPessoaFisicaActionPerformed(evt);
            }
        });

        btnNovoPessoaJuridica.setBackground(new java.awt.Color(0, 149, 217));
        btnNovoPessoaJuridica.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoPessoaJuridica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/furb/view/icons/add (1).png"))); // NOI18N
        btnNovoPessoaJuridica.setText("Juridica");
        btnNovoPessoaJuridica.setBorder(null);
        btnNovoPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPessoaJuridicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addComponent(logoFurb, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovaPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoPessoaJuridica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoFurb)
                    .addGroup(panelTopLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelTopLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaPessoaFisica)
                    .addComponent(btnNovoPessoaJuridica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 95, 164));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelaClientes.setModel(new ClienteTableModel(
            facade.search(null)));
    tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaClientesMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tabelaClientes);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 1, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPessoaFisicaActionPerformed
        this.dialogManutencao.incluirClientePessoaFisica();
    }//GEN-LAST:event_btnNovaPessoaFisicaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabelaClientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        int linha = this.tabelaClientes.rowAtPoint(evt.getPoint());
        this.dialogManutencao.editarCliente((((ClienteTableModel) this.tabelaClientes.getModel()).getObjectAt(linha)));
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnNovoPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPessoaJuridicaActionPerformed
        this.dialogManutencao.incluirClientePessoaJuridica();
    }//GEN-LAST:event_btnNovoPessoaJuridicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovaPessoaFisica;
    private javax.swing.JButton btnNovoPessoaJuridica;
    private javax.swing.JTextField edtBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoFurb;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void execute(String idDialog) {
        atualizarTabelaClientes();
    }
}
