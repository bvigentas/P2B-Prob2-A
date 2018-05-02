package br.furb.view.tablemodel;

import br.furb.model.Cliente;
import br.furb.model.ClientePessoaFisica;
import br.furb.model.ClientePessoaJuridica;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClienteTableModel extends DefaultTableModel {

    private List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void updateModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        if (this.clientes != null)
            return this.clientes.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return Boolean.FALSE;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Cliente cliente = this.clientes.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = cliente.getNome();
                break;
            case 1:
                value = cliente.getTelCelular();
                break;
            case 2:
                value = cliente.getTelFixo();
                break;
            case 3:
                if (cliente instanceof ClientePessoaFisica) { 
                    value = "CPF: ".concat(((ClientePessoaFisica) cliente).getCpf());
                } else {
                    value = "CNPJ: ".concat(((ClientePessoaJuridica) cliente).getCnpj());
                }
                break;
            case 4:
                if (cliente instanceof ClientePessoaFisica) { 
                    value = "Tel. Celular";
                } else {
                    value = "JMS: ".concat(((ClientePessoaJuridica) cliente).getServidorJMS());
                }
                break;    
        }
        return value;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Nome";
            case 1:
                return "Tel. Celular";
            case 2:
                return "Tel. Fixo";
            case 3:
                return "Identificador";
            case 4:
                return "Canal Notificacao";
        }
        return "??";
    }
    
    
    
    public Cliente getClienteAt(int row) {
        return this.clientes.get(row);
    }
}
