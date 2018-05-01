package br.furb.persistence.memory;

import br.furb.model.Cliente;
import br.furb.util.StringUtil;

/**
 *
 * @author Ruan Schuartz Russi
 */
public class ClienteMemoryPersistence extends AbstractMemoryPersistence<Cliente> {

    @Override
    protected Boolean respectFilter(Cliente t, String filter) {
        if (StringUtil.isNull(filter)) {
            return Boolean.TRUE;
        }
        
        return StringUtil.possuemPartesIguais(t.getNome(), filter);
    }
      
}
