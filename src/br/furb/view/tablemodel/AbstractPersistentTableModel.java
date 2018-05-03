package br.furb.view.tablemodel;

import br.furb.model.AbstractPersistentPojo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruan Schuartz Russi
 * @param <T>
 */
public abstract class AbstractPersistentTableModel<T extends AbstractPersistentPojo> extends DefaultTableModel {
    
    private List<T> data;

    public AbstractPersistentTableModel(List<T> data) {
        this.data = data;
    }
    
    public void updateModel(List<T> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        if (this.data != null)
            return this.data.size();
        return 0;
    }
    
    @Override
    public boolean isCellEditable(int i, int i1) {
        return Boolean.FALSE;
    }
    
    public T getObjectAt(int row) {
        return this.data.get(row);
    }
}
