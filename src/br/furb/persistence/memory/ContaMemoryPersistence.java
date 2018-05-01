package br.furb.persistence.memory;

import br.furb.model.ContaCorrente;
import br.furb.util.StringUtil;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaMemoryPersistence extends AbstractMemoryPersistence<ContaCorrente> {

    @Override
    protected Boolean respectFilter(ContaCorrente t, String filter) {
        if (StringUtil.isNull(filter)) {
            return Boolean.TRUE;
        }
        
        return t.getNumero() == Integer.valueOf(filter);
    }
    
}
