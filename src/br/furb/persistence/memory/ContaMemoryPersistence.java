package br.furb.persistence.memory;

import br.furb.model.ContaCorrente;
import br.furb.persistence.filter.ContaCorrenteFilter;
import br.furb.util.StringUtil;
import java.util.Objects;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ContaMemoryPersistence extends AbstractMemoryPersistence<ContaCorrente, ContaCorrenteFilter> {

    @Override
    protected Boolean respectFilter(ContaCorrente t, ContaCorrenteFilter filter) {
        if (filter == null) {
            return Boolean.TRUE;
        }
        
        if (filter.getCliente() != null) {
            if (!Objects.equals(t.getCliente().getId(), filter.getCliente().getId())) {
                return Boolean.FALSE;
            }
        }
        
        if (!StringUtil.isNull(filter.getFilter())) {
            return StringUtil.possuemPartesIguais(String.valueOf(t.getNumero()), filter.getFilter()) ||
                   StringUtil.possuemPartesIguais(String.valueOf(t.getAgencia()), filter.getFilter()) ||
                   StringUtil.possuemPartesIguais(String.valueOf(t.getNumero()), filter.getFilter());
        }
        
        return Boolean.TRUE;
    }
    
}
