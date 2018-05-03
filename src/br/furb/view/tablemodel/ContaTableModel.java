package br.furb.view.tablemodel;

import br.furb.model.Cliente;
import br.furb.model.ContaCorrente;
import java.util.List;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaTableModel extends AbstractPersistentTableModel<ContaCorrente> {
    
    public ContaTableModel(List<ContaCorrente> data) {
        super(data);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        ContaCorrente conta = getObjectAt(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = conta.getNumero();
                break;
            case 1:
                value = conta.getAgencia();
                break;
            case 2:
                value = conta.getSaldo();
                break;
        }
        
        return value;
    }
    
    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Numero";
            case 1:
                return "Agencia";
            case 2:
                return "Saldo";
            default:
                return null;
        }
    }
}
